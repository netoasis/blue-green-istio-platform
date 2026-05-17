/**
 * Receive HTTP requests and forward them to the Main.groovy script to be
 * handled. In case of error, a soap fault will be returned with stack trace
 * information. If changes are made to this script the server must be restarted.
 */
import com.sun.net.httpserver.*

import java.util.Map
import java.util.concurrent.*
import java.util.logging.Level
import java.util.logging.LogManager
import java.util.logging.Logger

import org.codehaus.groovy.control.CompilerConfiguration

PORT = 7361

// init java log framework (no dependencies required)
LogManager.getLogManager().readConfiguration(new FileInputStream('logging.properties'))
log = Logger.getLogger 'Fakehost'

/*
 * Take the list of folders as command line arguments. When looking for a
 * script or data file the engine will go through the folders in
 * order and use the first matching file it finds.
 */
def profiles = []
int portNumberIdx = -1;
args.eachWithIndex { item, index ->
	if ("-p".equals(item)) {
		portNumberIdx = index+1
		PORT = Integer.parseInt(args[portNumberIdx])
	} else if (item) {
		if (index != portNumberIdx)
			profiles << item
	}
}
if (!profiles) profiles << 'default'
log.info "Profiles: ${profiles}"

// create the http server to respond to fakehost requests
engine = new GroovyScriptEngine('.') // only for loading Main.groovy
def httpServer = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(PORT), 0)
log.info "Listening on port ${PORT}"
httpServer.createContext('/', [handle:{ httpExchange ->
    try {
        engine.run('Main.groovy', new Binding([httpExchange:httpExchange, log:log, profiles:profiles]))
    } catch (Throwable t) {
        errorResponse(httpExchange, t)
    }
    httpExchange.close()
}] as HttpHandler)

// start the server
httpServer.setExecutor(Executors.newCachedThreadPool())
httpServer.start()

def errorResponse(httpExchange, Throwable t) {
    log.log Level.SEVERE, 'Error Response', t
    StringWriter sw = new StringWriter()
    t.printStackTrace(new PrintWriter(sw))
    errorResponse(httpExchange, t.toString(), sw.toString())
}

def errorResponse(httpExchange, String faultstring, String detail) {
    httpExchange.getResponseHeaders().set('Content-Type', 'text/xml')
	httpExchange.sendResponseHeaders(200, 0)
    httpExchange.responseBody << """
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
        <soapenv:Header />
        <soapenv:Body>
            <soapenv:Fault>
                <faultcode>FakeHostError</faultcode>
                <faultstring>${faultstring}</faultstring>
                <detail>${detail}</detail>
            </soapenv:Fault>
        </soapenv:Body>
    </soapenv:Envelope>
    """
}
