common = loadScript('Common.groovy')

customerNum = body.Validate2FATokenRequest.CustomerNumber.text();
twoFACode = body.Validate2FATokenRequest.TwoFACode.text();

if('password'.equalsIgnoreCase(twoFACode)) {
    if ('999022'.equals(customerNum))
    {
        responseStr = """
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
        <soapenv:Header/>
        <soapenv:Body>
            <Validate2FATokenResponse>
                <Identifier UniqueID='${body.Validate2FATokenRequest.Identifier.@UniqueID.text()}'/>
                <CustomerNumber>${customerNum}</CustomerNumber>
                <Status>
                    <Code>SUCCESS</Code>
                    <Message></Message>
                </Status>
                    <sst_inf:InformationSegment xmlns:sst_inf="http://www.sandstone.com.au/information">
                        <sst_inf:Information Subtype="ERROR">
                            <sst_inf:UniqueExceptionIdentifier>VAL_2FA_TOKEN_00001</sst_inf:UniqueExceptionIdentifier>
                            <sst_inf:Text lang="en">This is a Host error from Validate2FAToken.</sst_inf:Text>
                        </sst_inf:Information>
                        <sst_inf:Information Subtype="WARNING">
                            <sst_inf:UniqueExceptionIdentifier>VAL_2FA_TOKEN_00002</sst_inf:UniqueExceptionIdentifier>
                            <sst_inf:Text lang="en_au">This is a Host warning from Validate2FAToken in english au</sst_inf:Text>
                            <sst_inf:Text lang="en_nz">This is a Host warning from Validate2FAToken in english nz</sst_inf:Text>
                        </sst_inf:Information>
                        <sst_inf:Information Subtype="INFORMATION">
                            <sst_inf:UniqueExceptionIdentifier>VAL_2FA_TOKEN_00003</sst_inf:UniqueExceptionIdentifier>
                            <sst_inf:Text lang="en">This is some Host information from Validate2FAToken.</sst_inf:Text>
                        </sst_inf:Information>
                    </sst_inf:InformationSegment>
            </Validate2FATokenResponse>
        </soapenv:Body>
      </soapenv:Envelope>"""
    }
    else {
        responseStr = """
    	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
        <soapenv:Header/>
        <soapenv:Body>
            <Validate2FATokenResponse>
                <Identifier UniqueID='${body.Validate2FATokenRequest.Identifier.@UniqueID.text()}'/>
                <CustomerNumber>${customerNum}</CustomerNumber>
                <Status>
                    <Code>SUCCESS</Code>
                    <Message></Message>
                </Status>
                <sst_inf:InformationSegment xmlns:sst_inf="http://www.sandstone.com.au/information">
                    <sst_inf:Information Subtype="INFORMATION">
                        <sst_inf:UniqueExceptionIdentifier>VAL_2FA_TOKEN_00003</sst_inf:UniqueExceptionIdentifier>
                        <sst_inf:Text lang="en">This is some Host information from Validate2FAToken.</sst_inf:Text>
                    </sst_inf:Information>
                </sst_inf:InformationSegment>
            </Validate2FATokenResponse>
        </soapenv:Body>
      </soapenv:Envelope>
    """;
    }
}
else {
    responseStr = """
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Header/>
    <soapenv:Body>
        <Validate2FATokenResponse>
            <Identifier UniqueID='${body.Validate2FATokenRequest.Identifier.@UniqueID.text()}'/>
            <CustomerNumber>${customerNum}</CustomerNumber>
            <Status>
                <Code>FAILURE</Code>
                <Message></Message>
            </Status>
            <sst_inf:InformationSegment xmlns:sst_inf="http://www.sandstone.com.au/information">
                <sst_inf:Information Subtype="ERROR">
                    <sst_inf:UniqueExceptionIdentifier>VAL_2FA_TOKEN_00004</sst_inf:UniqueExceptionIdentifier>
                    <sst_inf:Text lang="en">This is a FAILURE Host error from Validate2FAToken.</sst_inf:Text>
                </sst_inf:Information>
            </sst_inf:InformationSegment>
        </Validate2FATokenResponse>
    </soapenv:Body>
  </soapenv:Envelope>
""";
}

return responseStr