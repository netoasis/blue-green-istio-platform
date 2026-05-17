/**
 * This script will be called by the server for each fake host request. It can
 * be edited without restarting the server.
 * 
 * The SoapAction header is used to determine which specific handler script
 * should be run. If no SoapAction header is defined, then the url (with '/'
 * characters replaced by '_') will be used instead.
 * 
 * Methods added to this script are also made available to handler scripts, so
 * any common or utility methods can be defined here.
 * 
 * Main is in class format to allow static variables to be used
 */

import groovy.json.JsonSlurper
import groovy.xml.XmlUtil
import groovy.xml.MarkupBuilder
import groovy.util.slurpersupport.GPathResult

import java.util.logging.Level

import org.codehaus.groovy.runtime.InvokerHelper

class Main extends Script {
    /**
     * Map the CSV file to the list of entries to avoid parsing again
     */
    static Map<File, List> cachedEntries = [:]

    /**
     * Store the timestamp of the last file load so the file contents can be
     * reloaded if changed.
     */
    static Map<File, Long> loaded = [:]

    static Map<String, String> fileMapping = [:]

    static GroovyScriptEngine engine

    StringWriter writer = new StringWriter() // used by markup builder

    /**
     * Execute the script assuming that 'httpExchange' has been loaded in the
     * binding before this script is called
     */
    def run() {
        // create the script engine used to execute and reload scripts
        if (!engine) engine = new GroovyScriptEngine(profiles as String[])

        //get available groovy files if not yet populated
        if (!fileMapping) {
            profiles.collect {
                new File(it)
            }.each {
                it.eachFileMatch(~/.*\.groovy$/) {
                    String fileName = it.name
                    String actionKey = fileName.toLowerCase().replace(".groovy", "");
                    fileMapping[actionKey] = fileName
                    log.fine "Groovy File Key: ${actionKey}"
                    log.fine "Groovy File : ${fileName}"
                };
            }
        }

        log.fine "Request headers: ${httpExchange.requestHeaders}"
        log.fine "Request URI: ${httpExchange.requestURI}"
        handleRequest()
    }

    def handleRequest() {
        body = httpExchange.requestBody.text
        if (isRestRequest(httpExchange.requestHeaders)) {
            doHandleRestRequest(body)
        } else {
            doHandleSOAPRequest(body)
        }
    }

    def isRestRequest(headers) {
        return (headers.containsKey("Content-Type")
                && headers.getFirst("Content-Type").toLowerCase().contains("application/json")) || "GET".equals(httpExchange.requestMethod) || "DELETE".equals(httpExchange.requestMethod)
    }

    def doHandleRestRequest(requestBody) {
        requestBody = requestBody == "" ? "{}" : requestBody
        payload = new JsonSlurper().parseText(requestBody)

        String uri = httpExchange.requestURI
        uri = (uri =~ /\/.+/) ? uri[1..-1] : uri // strip leading slash
        def pathArray = uri.split("/")
        def action = pathArray[0]
        def result = null

        String groovyFile = "";
        if (action != null && action != "")
        {
            groovyFile = fileMapping[action.toLowerCase()]
        }

        log.info "Executing: ${groovyFile}"
        if (groovyFile != null && groovyFile != "")
        {
            result = engine.run(groovyFile, new Binding([uri:uri, header:httpExchange.requestHeaders, body:payload, log:log]))
        }
        log.fine "Response: ${result.responseStr}"

        httpExchange.getResponseHeaders().set('Content-Type', 'text/html')

        if (action == 'loqateaddresscapture') {
            httpExchange.getResponseHeaders().set('Content-Type', 'application/json')
        }

        httpExchange.sendResponseHeaders(result.responseCode, 0)
        httpExchange.responseBody << result.responseStr
    }

    def doHandleSOAPRequest(requestBody) {
        // use SoapAction header to determine script to be run
        String action = httpExchange.requestHeaders.getFirst("SoapAction")
        action = action?.replaceAll(/(^")|("$)/, '') // strip speech marks
        log.fine "SoapAction: ${action}"
        if (!action || action?.startsWith("urn:anonOutInOpResponse")) {
            log.info 'no soap action, using request uri instead'
            String uri = httpExchange.requestURI
            uri = (uri =~ /\/.+/) ? uri[1..-1] : uri // strip leading slash
            action = uri
            action = action.replace("/", "_")
            log.fine "Action from URI: ${action}"
        }

        // execute the handler script and return the response
        request = requestBody
        GPathResult requestXml = null
        try {
            requestXml = new XmlSlurper(false, true).parseText(request)
            requestXml.declareNamespace(soapenv: 'http://schemas.xmlsoap.org/soap/envelope/')
            body = requestXml.'soapenv:Body'
        } catch (Exception e) {
            // ignore, only provide slurped xml if slurpable
            throw e // uncomment to return the parse error in the response
        }

        def response = ""

        log.fine ("Action: " + action);
        // Fake Glass search
        if (action.startsWith('glass'))
        {
            body = requestXml.'**'
                    .find { it.name() == 'Body' }

            if (!body) {
                throw new IllegalStateException("Glass Request SOAP Body not found")
            }

            if (request.indexOf('GetListOfMakes')>-1){
                log.fine ("Glass request GetListOfMakes");
                response =  execute("GetListOfMakes.groovy", [request:request, requestXml:requestXml, body:body])
            }
            else if (request.indexOf('GetListOfModels')>-1){
                log.fine ("Glass request GetListOfModels");
                response =  execute("GetListOfModels.groovy", [request:request, requestXml:requestXml, body:body])
            }
            else if (request.indexOf('GetAutoDetailsSpeByMake')>-1){
                log.fine ("Glass request GetAutoDetailsSpeByMake");
                response =  execute("GetAutoDetailsSpeByMake.groovy", [request:request, requestXml:requestXml, body:body])
            }
            else if (request.indexOf('GetAutoDetailsSpecification')>-1){
                log.fine ("Glass request GetAutoDetailsSpecification");
                response =  execute("GetDetailsSpecificationAll.groovy", [request:request, requestXml:requestXml, body:body])
            }
        }

        // Veda Id Matrix verification
        if (request.indexOf('idm') >-1)
        {
            response =  execute("idVerification.groovy", [request:request, requestXml:requestXml, body:body])
        } else if (request.indexOf('BCA001') > -1)
        {
            // Bureau checks on individual details
            response =  execute("creditEnquiry.groovy", [request:request, requestXml:requestXml, body:body])
        } else if (request.indexOf('VSS001') > -1)
        {
            // fraud checks on individual details
            response =  execute("fraudCheck.groovy", [request:request, requestXml:requestXml, body:body])
        } else if (request.indexOf('bureau-reference role')!=-1)
        {
            // Bureau checks on individual cross reference
            response =  execute("creditEnquiryBureauReference.groovy", [request:request, requestXml:requestXml, body:body])
        } else if (request.contains('&session_id=')) {
            logFile << ("ThreatMetrixRequest data: $requestXml\n");
            response =  execute("threatMetrixEnquiry.groovy", [request:request, requestXml:requestXml, body:body])
        }

        if (action.startsWith("\"") || action.contains("urn:anonOutInOpResponse"))
        {
            action = body.childNodes().next().name()
            log.info "Trim Request Ending: ${action}.groovy"
            action = action.endsWith("Request") ? action.substring(0, action.length() - 7) : action
        }

        String groovyFile = "";
        if (action != null && action != "")
        {
            groovyFile = fileMapping[action.toLowerCase()]
        }

        log.info "Executing: ${groovyFile}"
        log.fine "Request: ${request}"
        if (groovyFile != null && groovyFile != "")
        {
            response = execute(groovyFile, [request:request, requestXml:requestXml, body:body])
        }
        log.fine "Response: ${response}"

        if (action.startsWith('glass')) {
            httpExchange.getResponseHeaders().set('Content-Type', 'application/soap+xml')
        }
        else {
            httpExchange.getResponseHeaders().set('Content-Type', 'text/xml')
        }

        if (response.getClass().getName() == 'java.util.LinkedHashMap')
        {
            httpExchange.sendResponseHeaders(response.responseCode ? response.responseCode : 200, 0)
            httpExchange.responseBody << response.responseStr
        }
        else
        {
            httpExchange.sendResponseHeaders(200, 0)
            httpExchange.responseBody << response
        }

        // Note: if a handler script throws an exception then a SOAP fault will be
        // returned with the stack trace details (see Server.groovy)
    }
    
    /**
     * Execute a groovy script, redirecting method requests to this class so
     * common behaviour can be defined here
     */
    def execute(String scriptName, Map variables = [:]) {
        loadScript(scriptName, variables).run()
    }
    
    /**
     * @return the first matching script with the given name
     */
    Script loadScript(String name, Map variables = [:]) {
        log.fine "Loading ${name}"
        Script script = engine.loadScriptByName(name).newInstance()
        if (!script) throw new Exception("Unable to load script: ${name}")

        // add references to make them available to scripts
        Binding binding = new Binding(variables)
        binding.log = log // make logging easy for scripts
        binding.body = body // script access to request body
        MarkupBuilder mb = new MarkupBuilder(writer) // create for scripts to use
        mb.omitEmptyAttributes = true
        mb.omitNullAttributes = true
        binding.mb = mb
        script.setBinding(binding)

        // make some methods from this class available in scripts            
        ['load', 'loadScript', 'execute', 'wrap', 'soapFault', 'random', 'randomCustomerNumber', 'lookup'].each {
            binding.setVariable(it, InvokerHelper.getMethodPointer(this, it))
        }
        log.fine "Loaded ${name} successfully, bindings: ${script.binding.variables.keySet()}"
        return script
    }
    
    /**
     * Just throw an exception if the method can't be found.
     */
    def methodMissing(String name, args) {
        throw new Exception("No method named '${name}' found for arguments ${args}")
    }
    
    /**
     * @return the first file matching the given name found when searching
     *         the profile folders in order
     */
    File lookup(String name) {
        String profile = profiles.find { new File(it, name).exists() }
        if (profile) return new File(profile, name)
        throw new Exception("File ${name} not found in ${profiles}")
    }
    
    /**
     * Load values from a CSV file
     *
     * @param name the name of the CSV e.g. "Customer" for "Customer.csv"
     * @param filter map of column -> value used to match results
     * @param exactMatch set to false to match substrings
     * @return a list of all rows or matching rows if filter supplied where each row
     *         is a map of values by column name
     */
    def load(String name, Map filter = [:], boolean exactMatch = true) {
        // load CSV rows
        File csv = lookup("${name}.csv")
        def entries = readCsv(csv)
        
        // return all if no filter specified
        if (!filter) return entries
        
        // filter the entries
        return entries.findAll { entry ->
            return filter.findAll { it.value }.every {
                String field = entry[it.key].toUpperCase()
                String match = it.value.toUpperCase()
                return (exactMatch) ? field == match : field.contains(match)
            }
        }
    }

    /**
     * Wrap the underlying string writer in a soap envelope, format it nicely
     * and return the XML string.
     */
    String wrap(String content = writer) {
        String envelope = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">'
        XmlUtil.serialize "${envelope}<soapenv:Header /><soapenv:Body>${content}</soapenv:Body></soapenv:Envelope>"
    }
    
    /**
     * @return a Soap fault message using the given information
     */
    String soapFault(String msg, String uniqueId = '') {
        return wrap("""<soapenv:Fault>
            <faultcode>soapenv:Client</faultcode>
            <faultstring>${msg}</faultstring>
            <detail>
                <sst_inf:InformationSegment xmlns:sst_inf="http://www.sandstone.com.au/information">
                    <sst_inf:Information Subtype="warning">
                        <sst_inf:UniqueExceptionIdentifier>${uniqueId}</sst_inf:UniqueExceptionIdentifier>
                        <sst_inf:Text lang="en_AU">${msg}</sst_inf:Text>
                    </sst_inf:Information>
                </sst_inf:InformationSegment>
            </detail>
        </soapenv:Fault>""")
    }
    
    /**
     * @return a random string identifier of the form "FAKE-YYYYYYYYYY" where
     *         each Y will be a random capital letter.
     */
    String random(int length = 10) {
        Random r = new Random()
        (1..length).inject('FAKE-') {a,b -> a += ('A'..'Z')[r.nextInt(26)] }
    }

    /**
     * @return a random customer number of the form "9XXXXXXXXX" where
     *         each X will be a random digit from 0-9.
     */
    String randomCustomerNumber(int length = 10) {
        Random r = new Random()
        (1..length-1).inject('9') {a,b -> a += ('0'..'9')[r.nextInt(9)] }
    }
    
    /**
     * @return the CSV data from the cache if already loaded and the file has
     * not been modified, otherwise reload from the file
     */
    static synchronized List<Map> readCsv(File csvFile) {
        List<Map> result = cachedEntries[csvFile]
        if (result) {
            // discard cached values if recently modified
            if (csvFile.lastModified() > loaded[csvFile]) result = null
        }
        if (!result) {
            result = readFromFile(csvFile)
            cachedEntries[csvFile] = result
            loaded[csvFile] = System.currentTimeMillis()
        }
        return result
    }
    
    /**
     * Read the contents of a CSV file. Assume the first line is a header
     * containing the column names.
     * @return a list of rows where each row is a map of column name -> value
     */
    static List<Map> readFromFile(File csvFile) {
        List rows = [];
        csvFile.eachLine { rows << tokenise(it) }
        List header = rows.remove(0)
    
        // turn each row into a map
        List<Map> result = []
        rows.each { row ->
            Map rowMap = [:]
            header.eachWithIndex { col, index ->
                rowMap[col] = (index < row.size()) ? row[index] : null
            }
            result << rowMap
        }
        return result
    }
    
    /**
     * Split a line from the CSV file. Values in speech marks can contain commas,
     * they must not be split and the speech marks must be removed.
     */
    static String[] tokenise(String line) {
        def result = []
        boolean expectComma = false
        (line =~ '\"[^\"]+\"|,|[^,]+').each { token ->
            if (token == ',') {
                if (expectComma) expectComma = false
                else result << '' // empty column value
            } else {
                String value = token
                if (token ==~ '\"[^\"]+\"') value = token[1..-2] // remove speech marks
                
                /*
                 * Excel will automatically reformat numbers like "02" to "2"
                 * and dates like "1920-04-07" to "7/4/1920". This code allows
                 * these values to be written in the CSV as "TEXT-02" and
                 * "TEXT-1920-04-07" so that the values will be loaded correctly
                 * and can survive open/save from Excel.
                 */
                if (token ==~ 'TEXT-.+') value = token.minus('TEXT-')
                
                result << value
                expectComma = true
            }
        }
        return result
    }
}
