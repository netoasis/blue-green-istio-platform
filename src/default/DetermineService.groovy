/**
 * Mock the "DeterminService" service from Valex which is responsible for determining the expected valuation type.
 */
def element = new XmlSlurper().parseText(body.text())
def postcode = element.Message.ValuationType.FullRegistered.RealEstate.Location.Address.Postcode.text()

// Use AVM as default expected valuation type.
def expectedValuationType = "AVM"
// Hard-coded postcodes below were artbitrary selected for returning different valuation types.
if (postcode.equals("2222")) {
    expectedValuationType = "Shortform"
} else if (postcode.equals("3333")) {
    expectedValuationType = 'Construction'
}

return """
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Header/>
    <soapenv:Body>
        <ns1:determineServiceResponse
            xmlns:ns1="https://ws.valex.com.au/soap/lixi/1.3/">
            <responseXml
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema" xsi:type="xsd:string">&lt;?xml version="1.0"?>
                &lt;rulesResponse>&lt;service>${expectedValuationType}&lt;/service>&lt;ruleTrackingId>3&lt;/ruleTrackingId>&lt;rulesVersion>2023102403&lt;/rulesVersion>&lt;coreCSVRow>36&lt;/coreCSVRow>&lt;/rulesResponse>
            </responseXml>
        </ns1:determineServiceResponse>
    </soapenv:Body>
</soapenv:Envelope>
"""