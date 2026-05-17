def responseStr = null;

def party = body.UpdateCrmRequest.PartySegment.Party;
def CustomerNumber = party.Identifier.@UniqueID.text();

responseStr = """
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
<soapenv:Header/>
<soapenv:Body>
    <crm:UpdateCrmResponse xmlns:crm="http://www.sandstone.com.au/UpdateCrm">
     <Identifier UniqueID="5febfb96-10fb-4034-8d6f-f674a5c4776f"/>
     <PartySegment>
       <Party>
         <Identifier UniqueID="${CustomerNumber}"/>
         <CrmIdentifier/>
       </Party>
     </PartySegment>
    </crm:UpdateCrmResponse>
</soapenv:Body>
</soapenv:Envelope>
               """;

return responseStr;