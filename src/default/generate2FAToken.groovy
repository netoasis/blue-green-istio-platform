common = loadScript('Common.groovy')

def applicationNum = body.Generate2FATokenRequest.Identifier.@UniqueID.text()
def customerNumber = body.Generate2FATokenRequest.CustomerNumber.text();
def contactNumber = body.Generate2FATokenRequest.ContactNumber.text();


if(customerNumber?.size() > 0
&& contactNumber?.size() > 0 ) {
    if ('999022'.equals(customerNumber))
    {
        responseStr = """
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
            <soapenv:Header/>
            <soapenv:Body>
                <Generate2FATokenResponse>
                    <Identifier UniqueId='${body.Generate2FATokenRequest.Identifier.@UniqueID.text()}' />
                    <CustomerNumber>${customerNumber}</CustomerNumber>
                    <Status>
                        <Code>SUCCESS</Code>
                        <Message></Message>
                    </Status>
                    <sst_inf:InformationSegment xmlns:sst_inf="http://www.sandstone.com.au/information">
                        <sst_inf:Information Subtype="ERROR">
                            <sst_inf:UniqueExceptionIdentifier>GEN_2FA_TOKEN_00001</sst_inf:UniqueExceptionIdentifier>
                            <sst_inf:Text lang="en">This is a Host error from Generate2FAToken.</sst_inf:Text>
                        </sst_inf:Information>
                        <sst_inf:Information Subtype="WARNING">
                            <sst_inf:UniqueExceptionIdentifier>GEN_2FA_TOKEN_00002</sst_inf:UniqueExceptionIdentifier>
                            <sst_inf:Text lang="en_au">This is a Host warning from Generate2FAToken in english au</sst_inf:Text>
                            <sst_inf:Text lang="en_nz">This is a Host warning from Generate2FAToken in english nz</sst_inf:Text>
                        </sst_inf:Information>
                        <sst_inf:Information Subtype="INFORMATION">
                            <sst_inf:UniqueExceptionIdentifier>GEN_2FA_TOKEN_00003</sst_inf:UniqueExceptionIdentifier>
                            <sst_inf:Text lang="en">This is some Host information from Generate2FAToken.</sst_inf:Text>
                        </sst_inf:Information>
                    </sst_inf:InformationSegment>
                </Generate2FATokenResponse>
            </soapenv:Body>
          </soapenv:Envelope>"""
    } 
    else {
        responseStr = """
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
            <soapenv:Header/>
            <soapenv:Body>
                <Generate2FATokenResponse>
                    <Identifier UniqueId='${body.Generate2FATokenRequest.Identifier.@UniqueID.text()}' />
                    <CustomerNumber>${customerNumber}</CustomerNumber>
                    <Status>
                        <Code>SUCCESS</Code>
                        <Message></Message>
                    </Status>
                    <sst_inf:InformationSegment xmlns:sst_inf="http://www.sandstone.com.au/information">
                        <sst_inf:Information Subtype="INFORMATION">
                            <sst_inf:UniqueExceptionIdentifier>GEN_2FA_TOKEN_00003</sst_inf:UniqueExceptionIdentifier>
                            <sst_inf:Text lang="en">This is some Host information from Generate2FAToken.</sst_inf:Text>
                        </sst_inf:Information>
                    </sst_inf:InformationSegment>
                </Generate2FATokenResponse>
            </soapenv:Body>
          </soapenv:Envelope>"""
    }
}
else {
    responseStr = """
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
        <soapenv:Header/>
        <soapenv:Body>
            <Generate2FATokenResponse>
                <Identifier UniqueId='${body.Generate2FATokenRequest.Identifier.@UniqueID.text()}' />
                <CustomerNumber>${customerNumber}</CustomerNumber>
                <Status>
                    <Code>FAILURE</Code>
                    <Message></Message>
                </Status>
                <sst_inf:InformationSegment xmlns:sst_inf="http://www.sandstone.com.au/information">
                    <sst_inf:Information Subtype="ERROR">
                        <sst_inf:UniqueExceptionIdentifier>GEN_2FA_TOKEN_00004</sst_inf:UniqueExceptionIdentifier>
                        <sst_inf:Text lang="en">This is a FAILURE Host error from Generate2FAToken.</sst_inf:Text>
                    </sst_inf:Information>
                </sst_inf:InformationSegment>
            </Generate2FATokenResponse>
        </soapenv:Body>
    </soapenv:Envelope>"""
}


return responseStr