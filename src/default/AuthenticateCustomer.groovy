import groovy.xml.MarkupBuilder;
import java.text.SimpleDateFormat;
import java.util.Random;

def responseStr = null;

def customerNum = body.AuthenticateCustomerRequest.CustomerNumber.text();
def twoFAToken =  body.AuthenticateCustomerRequest.TwoFACode.text();

if('654321'.equals(customerNum)) {
    responseStr = """
	<soapenv:Envelope
  xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
  xmlns:xsi="http://www.w3.org/1999/XMLSchema-instance"
  xmlns:xsd="http://www.w3.org/1999/XMLSchema"
  xmlns:h="http://www.sandstone.com.au/ib/host/200907/">
   <soapenv:Body>
     <soapenv:Fault>
     <faultcode xsi:type="xsd:string">soapenv:Client</faultcode>
     <faultstring xsi:type="xsd:string">Transaction Failed</faultstring>
	 <detail>
		<h:FaultDetail>
			<h:code>0099</h:code>
			<h:reason>Max authentication attempts exhausted. Account Locked.</h:reason>
		</h:FaultDetail>
        <sst_inf:InformationSegment xmlns:sst_inf="http://www.sandstone.com.au/information">
            <sst_inf:Information Subtype="ERROR">
                <sst_inf:UniqueExceptionIdentifier>HOST_AUTH_00099</sst_inf:UniqueExceptionIdentifier>
                <sst_inf:Text xml:lang="en">This is a Host error from AuthenticateExistingCustomerService. Max authentication attempts exhausted. Account Locked.</sst_inf:Text>
            </sst_inf:Information>
        </sst_inf:InformationSegment>
	 </detail>
     </soapenv:Fault>
  </soapenv:Body>
</soapenv:Envelope>
""";
}
else if('111111'.equals(customerNum) 
    || '916792'.equals(customerNum) || '929514'.equals(customerNum) || '986020'.equals(customerNum) 
    || '986022'.equals(customerNum) || '986023'.equals(customerNum) || '986030'.equals(customerNum)    
    || '986031'.equals(customerNum) || '986040'.equals(customerNum) || '986041'.equals(customerNum) 
    || '986042'.equals(customerNum) || '986043'.equals(customerNum) || '986044'.equals(customerNum)
    || '986045'.equals(customerNum) || '986046'.equals(customerNum) || '986047'.equals(customerNum)
    || '986048'.equals(customerNum) || '986049'.equals(customerNum) || '986051'.equals(customerNum)
    || '986052'.equals(customerNum) || '986054'.equals(customerNum) || '986055'.equals(customerNum)
    || '986056'.equals(customerNum) || '986057'.equals(customerNum) || '986058'.equals(customerNum)
    || '986116'.equals(customerNum) || '986808'.equals(customerNum) || '987001'.equals(customerNum)
    || '987002'.equals(customerNum) || '987003'.equals(customerNum) || '987004'.equals(customerNum)
    || '987005'.equals(customerNum) || '987006'.equals(customerNum) || '987007'.equals(customerNum)
    || '987008'.equals(customerNum) || '987009'.equals(customerNum) || '987010'.equals(customerNum)
    || '999023'.equals(customerNum) || '301797'.equals(customerNum) || '988201'.equals(customerNum)
    || '988101'.equals(customerNum) || '987009'.equals(customerNum) || '986021'.equals(customerNum)
	|| '986025'.equals(customerNum) || '986024'.equals(customerNum) || '986075'.equals(customerNum)
	|| '986076'.equals(customerNum) || '986077'.equals(customerNum) || '987654'.equals(customerNum)
	|| '987689'.equals(customerNum) || '987722'.equals(customerNum) || '987725'.equals(customerNum)
	|| '987723'.equals(customerNum) || '987724'.equals(customerNum) || '987726'.equals(customerNum)
	|| '987727'.equals(customerNum) || '987755'.equals(customerNum) || '987756'.equals(customerNum)
	|| '987765'.equals(customerNum) || '987766'.equals(customerNum) || '986027'.equals(customerNum)
    || '18121140'.equals(customerNum) || '11986021'.equals(customerNum) || '11986024'.equals(customerNum)
    || '11986025'.equals(customerNum) || '11986075'.equals(customerNum) || '11986076'.equals(customerNum)
    || '11986077'.equals(customerNum) || '11987654'.equals(customerNum) || '11987689'.equals(customerNum)
    || '11987722'.equals(customerNum) || '11987725'.equals(customerNum) || '11987723'.equals(customerNum)
    || '11987724'.equals(customerNum) || '11987726'.equals(customerNum) || '11987727'.equals(customerNum)
    || '11987755'.equals(customerNum) || '11987756'.equals(customerNum) || '11987765'.equals(customerNum)
    || '11987766'.equals(customerNum) || '11886076'.equals(customerNum) || '999999'.equals(customerNum)) {
    responseStr = """
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Header/>
    <soapenv:Body>
        <AuthenticateCustomerResponse xmlns="http://www.sandstone.com.au/lending">
            <IsAuthenticationSuccess>true</IsAuthenticationSuccess>
        </AuthenticateCustomerResponse>
    </soapenv:Body>
  </soapenv:Envelope>
""";
}
else if('999022'.equals(customerNum)) {
        responseStr = """
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Header/>
    <soapenv:Body>
        <AuthenticateCustomerResponse xmlns="http://www.sandstone.com.au/lending">
            <IsAuthenticationSuccess>true</IsAuthenticationSuccess>
            <sst_inf:InformationSegment xmlns:sst_inf="http://www.sandstone.com.au/information">
                <sst_inf:Information Subtype="Error">
                    <sst_inf:UniqueExceptionIdentifier>HOST_AUTH_00001</sst_inf:UniqueExceptionIdentifier>
                    <sst_inf:Text xml:lang="en">This is a Host error from AuthenticateExistingCustomerService.</sst_inf:Text>
                </sst_inf:Information>
                <sst_inf:Information Subtype="WARNING">
                    <sst_inf:UniqueExceptionIdentifier>HOST_AUTH_00002</sst_inf:UniqueExceptionIdentifier>
                    <sst_inf:Text xml:lang="en_au">This is a Host warning from AuthenticateExistingCustomerService in english au</sst_inf:Text>
                    <sst_inf:Text xml:lang="en_nz">This is a Host warning from AuthenticateExistingCustomerService in english nz</sst_inf:Text>
                </sst_inf:Information>
                <sst_inf:Information Subtype="INFORMATION">
                    <sst_inf:UniqueExceptionIdentifier>HOST_AUTH_00003</sst_inf:UniqueExceptionIdentifier>
                    <sst_inf:Text xml:lang="en">This is some Host information from AuthenticateExistingCustomerService.</sst_inf:Text>
                </sst_inf:Information>
            </sst_inf:InformationSegment>
        </AuthenticateCustomerResponse>
    </soapenv:Body>
  </soapenv:Envelope>
""";
}
else if('987018'.equals(customerNum)) {
		if(twoFAToken == null || twoFAToken.trim() == '')
		{
						responseStr = """
				<soapenv:Envelope
			  xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
			  xmlns:xsi="http://www.w3.org/1999/XMLSchema-instance"
			  xmlns:xsd="http://www.w3.org/1999/XMLSchema"
			  xmlns:h="http://www.sandstone.com.au/ib/host/200907/">
			   <soapenv:Body>
				 <soapenv:Fault>
				 <faultcode xsi:type="xsd:string">soapenv:Client</faultcode>
				 <faultstring xsi:type="xsd:string">Transaction Failed</faultstring>
				 <detail>
					<h:FaultDetail>
						<h:code>0097</h:code>
						<h:reason>Missing Token.</h:reason>
					</h:FaultDetail>
                    <sst_inf:InformationSegment xmlns:sst_inf="http://www.sandstone.com.au/information">
                        <sst_inf:Information Subtype="ERROR">
                            <sst_inf:UniqueExceptionIdentifier>HOST_AUTH_00097</sst_inf:UniqueExceptionIdentifier>
                            <sst_inf:Text xml:lang="en">This is a Host error from AuthenticateExistingCustomerService. Missing Token.</sst_inf:Text>
                        </sst_inf:Information>
                    </sst_inf:InformationSegment>
				</detail>
				  </soapenv:Fault>
			  </soapenv:Body>
			</soapenv:Envelope>
			""";
		}
		else
		{
			responseStr = """
				<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
				<soapenv:Header/>
				<soapenv:Body>
					<AuthenticateCustomerResponse xmlns="http://www.sandstone.com.au/lending">
						<IsAuthenticationSuccess>true</IsAuthenticationSuccess>
					</AuthenticateCustomerResponse>
				</soapenv:Body>
			  </soapenv:Envelope>
			""";		
		}        
}
else {
    responseStr = """
<soapenv:Envelope
xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
xmlns:xsi="http://www.w3.org/1999/XMLSchema-instance"
xmlns:xsd="http://www.w3.org/1999/XMLSchema"
xmlns:h="http://www.sandstone.com.au/ib/host/200907/">
<soapenv:Body>
<soapenv:Fault>
<faultcode xsi:type="xsd:string">soapenv:Client</faultcode>
   <faultstring xsi:type="xsd:string">Transaction Failed</faultstring>
   <detail>
        <h:FaultDetail>
            <h:code>0098</h:code>
            <h:reason>Invalid authentication details</h:reason>
        </h:FaultDetail>
        <sst_inf:InformationSegment xmlns:sst_inf="http://www.sandstone.com.au/information">
            <sst_inf:Information Subtype="ERROR">
                <sst_inf:UniqueExceptionIdentifier>HOST_AUTH_00098</sst_inf:UniqueExceptionIdentifier>
                <sst_inf:Text xml:lang="en">This is a Host error from AuthenticateExistingCustomerService. Invalid authentication details</sst_inf:Text>
            </sst_inf:Information>
        </sst_inf:InformationSegment>
   </detail>
</soapenv:Fault>
</soapenv:Body>
</soapenv:Envelope>
""";
}

return responseStr