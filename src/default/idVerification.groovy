String firstName =  body.'request'.'individual-name'.'first-given-name'.text();


def responseStr = null;

if ('IDTIMEOUT'.equals(firstName.toUpperCase())) {

    Random random = new Random();
	int randomNumber = random.nextInt(61 - 60) + 60;
	sleep randomNumber * 1000 //65 seconds    
}
else if ('JESSE'.equals(firstName.toUpperCase())) {

    responseStr = '''
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:vh="http://vedaxml.com/soap/header/v-header-v1-8.xsd" xmlns:wsa="http://www.w3.org/2005/08/addressing" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
   <soapenv:Header>
      <wsa:MessageID>140522-V5TF9-0DYVR</wsa:MessageID>
      <wsa:RelatesTo>Test_Request_1</wsa:RelatesTo>
      <wsa:To>http://www.w3.org/2005/08/addressing/anonymous</wsa:To>
      <wsa:From>
         <wsa:Address>https://ctaau.vedaxml.com:8443/cta/sys2/idmatrix-v4</wsa:Address>
      </wsa:From>
      <wsa:Action>{http://schemas.xmlsoap.org/wsdl/http/}//vedaxml.com/idmatrix/VerifyIdentityResult</wsa:Action>
   </soapenv:Header>
   <soapenv:Body xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
      <ns5:response client-reference="Connect Guide Ref" enquiry-id="140522-V5TF9-0DYVR" profile-name="KYC-Bendigo_OAO" profile-version="1" xmlns:ns5="http://vedaxml.com/vxml2/idmatrix-v4-0.xsd">
         <ns5:response-outcome>
            <ns5:overall-outcome>REJECT</ns5:overall-outcome>
         </ns5:response-outcome>
         <ns5:component-responses>
            <ns5:verification-response>
               <ns5:verification-outcome>
                  <ns5:indicator>REJECT_ON_EXCLUSION</ns5:indicator>
                  <ns5:total-points>20</ns5:total-points>
                  <ns5:self-verification-url>https://www.idmatrix.com.au/cta/ev/?token=caZdP5kF0k%2FJt6hBXzK9T%2BmVQZryMGNUQLGA6uVRuuBcbvW7oao686PKKc6PVNo6VIcJ2zwYLfX0gGmGms6jmyqwxPjqNGqdSFcGaLUBTMZ5iWcxnMSUSUlHx4hO5cLwiy6shztO7%2B8%3D</ns5:self-verification-url>
               </ns5:verification-outcome>
               <ns5:rules-results>
                 <ns5:rule-result name="OVERALL">
                     <ns5:indicator>REJECT_ON_EXCLUSION</ns5:indicator>
                     <ns5:reason>Overall Decision</ns5:reason>
                  </ns5:rule-result>
                  <ns5:rule-result name="TOTALPOINTS">
                     <ns5:indicator>20.0</ns5:indicator>
                     <ns5:reason>Overall Points</ns5:reason>
                  </ns5:rule-result>
                  <ns5:rule-result name="Date-of-birth not verified">
                     <ns5:indicator>MATCH</ns5:indicator>
                     <ns5:reason>Date-of-birth not verified</ns5:reason>
                  </ns5:rule-result>
                  <ns5:rule-result name="Address not verified">
                     <ns5:indicator>MATCH</ns5:indicator>
                     <ns5:reason>Address not verified</ns5:reason>
                  </ns5:rule-result>
                  <ns5:rule-result name="IDMatrix Exclusion">
                     <ns5:indicator>MATCH</ns5:indicator>
                     <ns5:reason>IDMatrix Exclusion</ns5:reason>
                  </ns5:rule-result>
               </ns5:rules-results>
               <ns5:analysis-results>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCONS-0050</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.60</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCONS-0050::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCONS-0058</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCONS-0058::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCONS-0066</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCONS-0066::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-NTD-0054</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.25</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-NTD-0054::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-NTD-0061</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-NTD-0061::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-NTD-0069</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-NTD-0069::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCOMM-0051</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.60</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCOMM-0051::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCOMM-0059</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCOMM-0059::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCOMM-0067</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCOMM-0067::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>NSW-DL-0071</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>100</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.60</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>ACC-PEPS-0048</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>ACC-COMPLINK-0021</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-IRS-0053</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.25</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-IRS-0053::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-IRS-0084</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-IRS-0084::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-IRS-0070</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-IRS-0070::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>MIRUS-HER-0057</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>MIRUS-HER-0057::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-SFDADDR-0023</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-SFDDL-0024</ns5:search-name>
                     <ns5:raw-score>100</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>100</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-SFDPASSPORT-0025</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-SFDPHONE-0022</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>AEC-ER-0049</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.60</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>AEC-ER-0049::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>MEDICARE-CARD-0081</ns5:search-name>
                     <ns5:raw-score>100</ns5:raw-score>
                     <ns5:minimum-value>100</ns5:minimum-value>
                     <ns5:filtered-score>100</ns5:filtered-score>
                     <ns5:weight>0.20</ns5:weight>
                     <ns5:points>20</ns5:points>
                     <ns5:contributing-factors>
                        <ns5:name-match>Y</ns5:name-match>
                        <ns5:document-identifier-match>Y</ns5:document-identifier-match>
                     </ns5:contributing-factors>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-EVVELOCITY-0026</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-PND-0043</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.15</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-PND-0043::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>DFAT-AP-0079</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>100</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.60</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>MIRUS-SPD-0056</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>MIRUS-SPD-0056::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBPR-0052</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.60</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBPR-0052::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBPR-0060</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBPR-0060::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBPR-0068</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBPR-0068::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
               </ns5:analysis-results>
               <ns5:search-results>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCONS-0050" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCONS-0050" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCONS-0058" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCONS-0058" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCONS-0066" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                    </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>''' +
                  '''
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCONS-0066" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0054" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0054" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                       <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0061" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0061" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0069" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                       <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0069" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0051" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                       <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0051" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0059" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0059" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0067" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0067" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                       <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="NSW-DL-0071" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="NO MATCH" search-name="ACC-PEPS-0048" search-type="exclusion" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="NO MATCH" search-name="ACC-COMPLINK-0021" search-type="exclusion" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0053" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0053" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0084" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0084" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0070" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>''' +
                  '''
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0070" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="MIRUS-HER-0057" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="MIRUS-HER-0057" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                       <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="NO MATCH" match-score="0" search-name="VEDA-SFDADDR-0023" search-type="exclusion" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="MATCH" match-score="100" search-name="VEDA-SFDDL-0024" search-type="exclusion" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="NO MATCH" match-score="0" search-name="VEDA-SFDPASSPORT-0025" search-type="exclusion" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="NO MATCH" match-score="0" search-name="VEDA-SFDPHONE-0022" search-type="exclusion" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="AEC-ER-0049" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                    </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="AEC-ER-0049" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="PASS" match-score="100" search-name="MEDICARE-CARD-0081" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="J"/>
                     </ns5:individual-name>
                     <ns5:medicare>
                        <ns5:card-number search-value="**********"/>
                        <ns5:reference-number search-value="**********"/>
                        <ns5:expiry-date search-value="**********"/>
                        <ns5:card-colour search-value="**********"/>
                     </ns5:medicare>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="NO MATCH" search-name="VEDA-EVVELOCITY-0026" search-type="exclusion" service-result-code="0" service-result-detail="Applicant is not banned or repeatedly searched" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-PND-0043" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                     </ns5:phone-numbers>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-PND-0043" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                       <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                     </ns5:phone-numbers>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="ERROR" search-name="DFAT-AP-0079" search-type="verification" service-result-code="99" service-result-detail="Internal Error (from client)" service-result-string="Unknown Error">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="MIRUS-SPD-0056" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="MIRUS-SPD-0056" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0052" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                       <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0052" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                       <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0060" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0060" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0068" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0068" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
               </ns5:search-results>
               <ns5:records>
                  <ns5:fraud-file-record>
                     <ns5:fraud-file-number>157062</ns5:fraud-file-number>
                     <ns5:date-fraud-occured>2010-08-04</ns5:date-fraud-occured>
                     <ns5:reporting-subscriber/>
                     <ns5:reference-number>7010213101721,CC,N02</ns5:reference-number>
                     <ns5:product code=""/>
                     <ns5:fraud-type code="41"/>
                     <ns5:fraud-subtype/>
                     <ns5:employment-status/>
                     <ns5:fraud-subject-role>A</ns5:fraud-subject-role>
                     <ns5:other-comment/>
                     <ns5:employer/>
                     <ns5:drivers-licence-number>123456789</ns5:drivers-licence-number>
                     <ns5:passport-number/>
                     <ns5:addresses>
                        <ns5:address>
                           <ns5:street-number>2</ns5:street-number>
                           <ns5:street-name>SMITH</ns5:street-name>
                           <ns5:street-type/>
                           <ns5:suburb>SOUTH MORANG</ns5:suburb>
                           <ns5:state>VIC</ns5:state>
                           <ns5:postcode>3752</ns5:postcode>
                           <ns5:country>AU</ns5:country>
                        </ns5:address>
                     </ns5:addresses>
                  </ns5:fraud-file-record>
               </ns5:records>
            </ns5:verification-response>
            <ns5:fraud-assessment-response>
               <ns5:score>30.0</ns5:score>
               <ns5:threshold>60.0</ns5:threshold>
               <ns5:result>PASS</ns5:result>
               <ns5:assessment-factors>
                  <ns5:assessment-factor>
                     <ns5:type>KYC_SFD</ns5:type>
                     <ns5:score>0.0</ns5:score>
                     <ns5:weight>0.70</ns5:weight>
                     <ns5:threshold>50.0</ns5:threshold>
                     <ns5:result>FAIL</ns5:result>
                  </ns5:assessment-factor>
                  <ns5:assessment-factor>
                     <ns5:type>KYC_SNC</ns5:type>
                     <ns5:score>100.0</ns5:score>
                     <ns5:weight>0.10</ns5:weight>
                     <ns5:threshold>50.0</ns5:threshold>
                     <ns5:result>PASS</ns5:result>
                  </ns5:assessment-factor>
                  <ns5:assessment-factor>
                     <ns5:type>KYC_VLC</ns5:type>
                     <ns5:score>100.0</ns5:score>
                     <ns5:weight>0.10</ns5:weight>
                     <ns5:threshold>50.0</ns5:threshold>
                     <ns5:result>PASS</ns5:result>
                  </ns5:assessment-factor>
                  <ns5:assessment-factor>
                     <ns5:type>KYC_PEP</ns5:type>
                     <ns5:score>100.0</ns5:score>
                     <ns5:weight>0.10</ns5:weight>
                     <ns5:threshold>50.0</ns5:threshold>
                     <ns5:result>PASS</ns5:result>
                  </ns5:assessment-factor>
               </ns5:assessment-factors>
            </ns5:fraud-assessment-response>
         </ns5:component-responses>
      </ns5:response>
   </soapenv:Body>
</soapenv:Envelope>
''';
}
else if ('SUZY'.equals(firstName.toUpperCase())) {

    responseStr = '''
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:vh="http://vedaxml.com/soap/header/v-header-v1-8.xsd" xmlns:wsa="http://www.w3.org/2005/08/addressing" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
   <soapenv:Header>
      <wsa:MessageID>140522-V5TF9-0DYVR</wsa:MessageID>
      <wsa:RelatesTo>Test_Request_1</wsa:RelatesTo>
      <wsa:To>http://www.w3.org/2005/08/addressing/anonymous</wsa:To>
      <wsa:From>
         <wsa:Address>https://ctaau.vedaxml.com:8443/cta/sys2/idmatrix-v4</wsa:Address>
      </wsa:From>
      <wsa:Action>{http://schemas.xmlsoap.org/wsdl/http/}//vedaxml.com/idmatrix/VerifyIdentityResult</wsa:Action>
   </soapenv:Header>
   <soapenv:Body xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
      <ns5:response client-reference="Connect Guide Ref" enquiry-id="140522-V5TF9-0DYVR" profile-name="KYC-Bendigo_OAO" profile-version="1" xmlns:ns5="http://vedaxml.com/vxml2/idmatrix-v4-0.xsd">
         <ns5:response-outcome>
            <ns5:overall-outcome>REJECT</ns5:overall-outcome>
         </ns5:response-outcome>
         <ns5:component-responses>
            <ns5:verification-response>
               <ns5:verification-outcome>
                  <ns5:indicator>REJECT_ON_EXCLUSION</ns5:indicator>
                  <ns5:total-points>20</ns5:total-points>
                  <ns5:self-verification-url>https://www.idmatrix.com.au/cta/ev/?token=caZdP5kF0k%2FJt6hBXzK9T%2BmVQZryMGNUQLGA6uVRuuBcbvW7oao686PKKc6PVNo6VIcJ2zwYLfX0gGmGms6jmyqwxPjqNGqdSFcGaLUBTMZ5iWcxnMSUSUlHx4hO5cLwiy6shztO7%2B8%3D</ns5:self-verification-url>
               </ns5:verification-outcome>
               <ns5:rules-results>
                 <ns5:rule-result name="OVERALL">
                     <ns5:indicator>REJECT_ON_EXCLUSION</ns5:indicator>
                     <ns5:reason>Overall Decision</ns5:reason>
                  </ns5:rule-result>
                  <ns5:rule-result name="TOTALPOINTS">
                     <ns5:indicator>20.0</ns5:indicator>
                     <ns5:reason>Overall Points</ns5:reason>
                  </ns5:rule-result>
                  <ns5:rule-result name="Date-of-birth not verified">
                     <ns5:indicator>MATCH</ns5:indicator>
                     <ns5:reason>Date-of-birth not verified</ns5:reason>
                  </ns5:rule-result>
                  <ns5:rule-result name="Address not verified">
                     <ns5:indicator>MATCH</ns5:indicator>
                     <ns5:reason>Address not verified</ns5:reason>
                  </ns5:rule-result>
                  <ns5:rule-result name="IDMatrix Exclusion">
                     <ns5:indicator>MATCH</ns5:indicator>
                     <ns5:reason>IDMatrix Exclusion</ns5:reason>
                  </ns5:rule-result>
               </ns5:rules-results>
               <ns5:analysis-results>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCONS-0050</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.60</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCONS-0050::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCONS-0058</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCONS-0058::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCONS-0066</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCONS-0066::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-NTD-0054</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.25</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-NTD-0054::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-NTD-0061</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-NTD-0061::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-NTD-0069</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-NTD-0069::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCOMM-0051</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.60</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCOMM-0051::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCOMM-0059</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCOMM-0059::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCOMM-0067</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBCOMM-0067::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>NSW-DL-0071</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>100</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.60</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>ACC-PEPS-0048</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>ACC-COMPLINK-0021</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-IRS-0053</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.25</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-IRS-0053::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-IRS-0084</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-IRS-0084::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-IRS-0070</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-IRS-0070::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>MIRUS-HER-0057</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>MIRUS-HER-0057::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-SFDADDR-0023</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-SFDDL-0024</ns5:search-name>
                     <ns5:raw-score>100</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>100</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-SFDPASSPORT-0025</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-SFDPHONE-0022</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>AEC-ER-0049</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.60</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>AEC-ER-0049::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>MEDICARE-CARD-0081</ns5:search-name>
                     <ns5:raw-score>100</ns5:raw-score>
                     <ns5:minimum-value>100</ns5:minimum-value>
                     <ns5:filtered-score>100</ns5:filtered-score>
                     <ns5:weight>0.20</ns5:weight>
                     <ns5:points>20</ns5:points>
                     <ns5:contributing-factors>
                        <ns5:name-match>Y</ns5:name-match>
                        <ns5:document-identifier-match>Y</ns5:document-identifier-match>
                     </ns5:contributing-factors>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-EVVELOCITY-0026</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-PND-0043</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.15</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-PND-0043::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>DFAT-AP-0079</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>100</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.60</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>MIRUS-SPD-0056</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>MIRUS-SPD-0056::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBPR-0052</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>90</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.60</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBPR-0052::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBPR-0060</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBPR-0060::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBPR-0068</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
                  <ns5:analysis-result>
                     <ns5:category/>
                     <ns5:search-name>VEDA-CBPR-0068::previous-address</ns5:search-name>
                     <ns5:raw-score>0</ns5:raw-score>
                     <ns5:minimum-value>0</ns5:minimum-value>
                     <ns5:filtered-score>0</ns5:filtered-score>
                     <ns5:weight>0.00</ns5:weight>
                     <ns5:points>0</ns5:points>
                     <ns5:contributing-factors/>
                  </ns5:analysis-result>
               </ns5:analysis-results>
               <ns5:search-results>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCONS-0050" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCONS-0050" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCONS-0058" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCONS-0058" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCONS-0066" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                    </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>''' +
                  '''
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCONS-0066" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0054" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0054" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                       <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0061" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0061" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0069" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                       <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0069" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0051" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                       <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0051" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0059" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0059" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0067" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0067" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                       <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="NSW-DL-0071" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="NO MATCH" search-name="ACC-PEPS-0048" search-type="exclusion" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="NO MATCH" search-name="ACC-COMPLINK-0021" search-type="exclusion" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0053" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0053" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0084" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0084" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0070" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>''' +
                  '''
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0070" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="MIRUS-HER-0057" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="MIRUS-HER-0057" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                       <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="NO MATCH" match-score="0" search-name="VEDA-SFDADDR-0023" search-type="exclusion" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="MATCH" match-score="100" search-name="VEDA-SFDDL-0024" search-type="exclusion" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="NO MATCH" match-score="0" search-name="VEDA-SFDPASSPORT-0025" search-type="exclusion" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="NO MATCH" match-score="0" search-name="VEDA-SFDPHONE-0022" search-type="exclusion" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="AEC-ER-0049" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                    </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="AEC-ER-0049" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="PASS" match-score="100" search-name="MEDICARE-CARD-0081" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="J"/>
                     </ns5:individual-name>
                     <ns5:medicare>
                        <ns5:card-number search-value="**********"/>
                        <ns5:reference-number search-value="**********"/>
                        <ns5:expiry-date search-value="**********"/>
                        <ns5:card-colour search-value="**********"/>
                     </ns5:medicare>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="NO MATCH" search-name="VEDA-EVVELOCITY-0026" search-type="exclusion" service-result-code="0" service-result-detail="Applicant is not banned or repeatedly searched" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-PND-0043" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                     </ns5:phone-numbers>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-PND-0043" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                       <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                     </ns5:phone-numbers>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="ERROR" search-name="DFAT-AP-0079" search-type="verification" service-result-code="99" service-result-detail="Internal Error (from client)" service-result-string="Unknown Error">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="MIRUS-SPD-0056" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="MIRUS-SPD-0056" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0052" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                       <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0052" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                       <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0060" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0060" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0068" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:current-address>
                        <ns5:unit-number search-value="3"/>
                        <ns5:street-number search-value="4"/>
                        <ns5:street-name search-value="Privet"/>
                        <ns5:street-type search-value="Drive"/>
                        <ns5:suburb search-value="Little Whinging"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2999"/>
                        <ns5:unformatted-address search-value="Potter Manor 3/4 Privet Drive Little Whinging NSW 2999"/>
                     </ns5:current-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
                  <ns5:search-result match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0068" search-type="verification" service-result-code="0" service-result-detail="" service-result-string="OK">
                     <ns5:individual-name>
                        <ns5:family-name search-value="Potter"/>
                        <ns5:first-given-name search-value="Harry"/>
                        <ns5:other-given-name search-value="James"/>
                     </ns5:individual-name>
                     <ns5:date-of-birth search-value="1980-07-31"/>
                     <ns5:gender search-value="male"/>
                     <ns5:previous-address>
                        <ns5:unit-number search-value="15"/>
                        <ns5:street-number search-value="100"/>
                        <ns5:street-name search-value="Arthur"/>
                        <ns5:street-type search-value="Street"/>
                        <ns5:suburb search-value="North Sydney"/>
                        <ns5:state search-value="NSW"/>
                        <ns5:postcode search-value="2060"/>
                        <ns5:unformatted-address search-value="Veda House 15/100 Arthur Street North Sydney NSW 2060"/>
                     </ns5:previous-address>
                     <ns5:phone-numbers>
                        <ns5:home-phone-number search-value="0312345678"/>
                        <ns5:mobile-phone-number search-value="0487654321"/>
                     </ns5:phone-numbers>
                     <ns5:drivers-licence-details>
                        <ns5:number search-value="1234567890"/>
                        <ns5:card-number search-value="1234567890"/>
                     </ns5:drivers-licence-details>
                     <ns5:passport-details>
                        <ns5:country-code search-value="AUS"/>
                        <ns5:number search-value="**********"/>
                        <ns5:family-name-at-birth search-value="Potter"/>
                        <ns5:name-at-citizenship>
                           <ns5:family-name search-value="Potter"/>
                        </ns5:name-at-citizenship>
                        <ns5:place-of-birth search-value="Little Whinging"/>
                        <ns5:country-of-birth search-value="AUS"/>
                     </ns5:passport-details>
                  </ns5:search-result>
               </ns5:search-results>
               <ns5:records>
                  <ns5:fraud-file-record>
                     <ns5:fraud-file-number>157062</ns5:fraud-file-number>
                     <ns5:date-fraud-occured>2010-08-04</ns5:date-fraud-occured>
                     <ns5:reporting-subscriber/>
                     <ns5:reference-number>7010213101721,CC,N02</ns5:reference-number>
                     <ns5:product code=""/>
                     <ns5:fraud-type code="41"/>
                     <ns5:fraud-subtype/>
                     <ns5:employment-status/>
                     <ns5:fraud-subject-role>A</ns5:fraud-subject-role>
                     <ns5:other-comment/>
                     <ns5:employer/>
                     <ns5:drivers-licence-number>123456789</ns5:drivers-licence-number>
                     <ns5:passport-number/>
                     <ns5:addresses>
                        <ns5:address>
                           <ns5:street-number>2</ns5:street-number>
                           <ns5:street-name>SMITH</ns5:street-name>
                           <ns5:street-type/>
                           <ns5:suburb>SOUTH MORANG</ns5:suburb>
                           <ns5:state>VIC</ns5:state>
                           <ns5:postcode>3752</ns5:postcode>
                           <ns5:country>AU</ns5:country>
                        </ns5:address>
                     </ns5:addresses>
                  </ns5:fraud-file-record>
               </ns5:records>
            </ns5:verification-response>
            <ns5:fraud-assessment-response>
               <ns5:score>30.0</ns5:score>
               <ns5:threshold>60.0</ns5:threshold>
               <ns5:result>FAIL</ns5:result>
               <ns5:assessment-factors>
                  <ns5:assessment-factor>
                     <ns5:type>KYC_SFD</ns5:type>
                     <ns5:score>0.0</ns5:score>
                     <ns5:weight>0.70</ns5:weight>
                     <ns5:threshold>50.0</ns5:threshold>
                     <ns5:result>FAIL</ns5:result>
                  </ns5:assessment-factor>
                  <ns5:assessment-factor>
                     <ns5:type>KYC_SNC</ns5:type>
                     <ns5:score>100.0</ns5:score>
                     <ns5:weight>0.10</ns5:weight>
                     <ns5:threshold>50.0</ns5:threshold>
                     <ns5:result>PASS</ns5:result>
                  </ns5:assessment-factor>
                  <ns5:assessment-factor>
                     <ns5:type>KYC_VLC</ns5:type>
                     <ns5:score>100.0</ns5:score>
                     <ns5:weight>0.10</ns5:weight>
                     <ns5:threshold>50.0</ns5:threshold>
                     <ns5:result>PASS</ns5:result>
                  </ns5:assessment-factor>
                  <ns5:assessment-factor>
                     <ns5:type>KYC_PEP</ns5:type>
                     <ns5:score>100.0</ns5:score>
                     <ns5:weight>0.10</ns5:weight>
                     <ns5:threshold>50.0</ns5:threshold>
                     <ns5:result>PASS</ns5:result>
                  </ns5:assessment-factor>
               </ns5:assessment-factors>
            </ns5:fraud-assessment-response>
         </ns5:component-responses>
      </ns5:response>
   </soapenv:Body>
</soapenv:Envelope>
''';
}
else if ('FNAMENINE'.equals(firstName.toUpperCase())) {
    responseStr = '''
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
        <soapenv:Body>
            <soapenv:Fault>
                <faultcode>soapenv:Server</faultcode>
                <faultstring>Policy Falsified</faultstring>
                <faultactor>http://127.0.0.1:8080/sys2/ping-v1</faultactor>
                <detail>
                    <l7:policyResult status="Bad Request" xmlns:l7="http://www.layer7tech.com/ws/policy/fault"/>
                </detail>
            </soapenv:Fault>
        </soapenv:Body>
    </soapenv:Envelope>
    ''';
}
else if ('FNAMETEN'.equals(firstName.toUpperCase())) {
    responseStr = '''
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
        <soapenv:Body>
            <soapenv:Fault>
                <faultcode>soapenv:Server</faultcode>
                <faultstring>Policy Falsified</faultstring>
                <faultactor>http://127.0.0.1:8080/sys2/ping-v1</faultactor>
                <detail>
                    <l7:policyResult status="Authentication Failed" xmlns:l7="http://www.layer7tech.com/ws/policy/fault"/>
                </detail>
            </soapenv:Fault>
        </soapenv:Body>
    </soapenv:Envelope>
    ''';    
}
else if ('FNAMESIXTEEN'.equals(firstName.toUpperCase())) {
    responseStr = '''
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
    xmlns:ns5="http://vedaxml.com/vxml2/idmatrix-v3-0.xsd" xmlns:vh="http://vedaxml.com/soap/header/v-header-v1-4.xsd"
    xmlns:wsa="http://www.w3.org/2005/08/addressing" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <soapenv:Header>
        <wsa:MessageID>111111-A1A1A-A1A1A</wsa:MessageID>
        <wsa:RelatesTo>Test_Request_123</wsa:RelatesTo>
        <wsa:To>http://www.w3.org/2005/08/addressing/anonymous</wsa:To>
        <wsa:From>
            <wsa:Address>http://vedaxml.com/sys2/idmatrix-v2</wsa:Address>
        </wsa:From>
        <wsa:Action>http://vedaxml.com/idmatrix/VerifyIdentityResult
        </wsa:Action>
    </soapenv:Header>
    <soapenv:Body xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/"
        xmlns:xsd="http://www.w3.org/2001/XMLSchema">
<ns5:response enquiry-id="140505-V5TF9-0C42G" profile-name="KYC-HOMESTART_AP"
    profile-version="1" xmlns:ns5="http://vedaxml.com/vxml2/idmatrix-v3-0.xsd">
    <ns5:verification-outcome>
        <ns5:indicator>ACCEPT</ns5:indicator>
        <ns5:total-points>120</ns5:total-points>
        <ns5:self-verification-url>https://www.idmatrix.com.au/cta/ev/?token=S0kjDr1nTIbhdAIZ46trfHDQZ5CgX%2BHSQLGA6uVRuuCnfkH2FItb0waXuGo4Q6%2Fbh1pzPx2X7Fv6z1gcGrtwzabLEjnZjTQ%2FJkac%2BES4pQc%3D</ns5:self-verification-url>
    </ns5:verification-outcome>
    <ns5:rules-results>
        <ns5:rule-result name="OVERALL">
            <ns5:indicator>REJECT</ns5:indicator>
            <ns5:reason>Overall Decision</ns5:reason>
        </ns5:rule-result>
        <ns5:rule-result name="TOTALPOINTS">
            <ns5:indicator>59.0</ns5:indicator>
            <ns5:reason>Overall Points</ns5:reason>
        </ns5:rule-result>
        <ns5:rule-result name="IDMatrix Minimum Requirements Verification">
            <ns5:indicator>MATCH</ns5:indicator>
            <ns5:reason>IDMatrix Minimum Requirements Verification</ns5:reason>
        </ns5:rule-result>
    </ns5:rules-results>
    <ns5:analysis-results>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCONS-0032</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCONS-0032::previous-address</ns5:search-name>
            <ns5:raw-score>98</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>98</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>59</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-NTD-0036</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.25</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-NTD-0036::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCOMM-0033</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCOMM-0033::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VIC-DL-0020</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>100</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>ACC-COMPLINK-0021</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-IRS-0035</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.25</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-IRS-0035::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-HER-0047</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-HER-0047::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>AEC-ER-0031</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>AEC-ER-0031::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MEDICARE-CARD-0007</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>100</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.20</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-EVVELOCITY-0026</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>AP</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>SENSIS-EWP-0045</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>NSW-POAC-0009</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-SPD-0046</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.15</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-SPD-0046::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBPR-0034</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBPR-0034::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
    </ns5:analysis-results>
    <ns5:search-results>
        <ns5:search-result id="VEDA-CBCONS-0032-1"
            match-indicator="PASS" match-score="97" search-name="VEDA-CBCONS-0032"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name match-score-weight="12">
                <ns5:family-name match-indicator="Surname"
                    match-score-weight="4" search-value="Aurva" />
                <ns5:first-given-name match-indicator="First_Name"
                    match-score-weight="4" search-value="Dushyant" />
                <ns5:other-given-name match-indicator="Middle_Names"
                    match-score-weight="4" search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth match-indicator="Date"
                match-score-weight="5" search-value="1976-01-27" />
            <ns5:current-address match-score-weight="24">
                <ns5:unit-number match-indicator="Unit_Number_Noalpha"
                    match-score-weight="4" search-value="4" />
                <ns5:street-number match-indicator="Street_Number_Noalpha"
                    match-score-weight="4" search-value="10" />
                <ns5:street-name match-indicator="Address_Part1"
                    match-score-weight="4" search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb match-indicator="Address_Part2"
                    match-score-weight="4" search-value="BRUNSWICK WEST" />
                <ns5:state match-indicator="State" match-score-weight="4"
                    search-value="VIC" />
                <ns5:postcode match-indicator="Postal_Area"
                    match-score-weight="4" search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBCONS-0032-2-prev-addr"
            match-indicator="PASS" match-score="98" search-name="VEDA-CBCONS-0032"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name match-score-weight="12">
                <ns5:family-name match-indicator="Surname"
                    match-score-weight="4" search-value="Aurva" />
                <ns5:first-given-name match-indicator="First_Name"
                    match-score-weight="4" search-value="Dushyant" />
                <ns5:other-given-name match-indicator="Middle_Names"
                    match-score-weight="4" search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth match-indicator="Date"
                match-score-weight="5" search-value="1976-01-27" />
            <ns5:previous-address match-score-weight="24">
                <ns5:unit-number match-indicator="Unit_Number_Noalpha"
                    match-score-weight="4" search-value="2" />
                <ns5:street-number match-indicator="Street_Number_Noalpha"
                    match-score-weight="4" search-value="52" />
                <ns5:street-name match-indicator="Address_Part1"
                    match-score-weight="4" search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb match-indicator="Address_Part2"
                    match-score-weight="4" search-value="BRUNSWICK" />
                <ns5:state match-indicator="State" match-score-weight="4"
                    search-value="VIC" />
                <ns5:postcode match-indicator="Postal_Area"
                    match-score-weight="4" search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-NTD-0036-3"
            match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0036"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-NTD-0036-4-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0036"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBCOMM-0033-5"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0033"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBCOMM-0033-6-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0033"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VIC-DL-0020-7"
            match-indicator="FAIL" match-score="0" search-name="VIC-DL-0020"
            search-type="verification" service-result-code="0"
            service-result-detail="Invalid reCAPTCHA request. Missing challenge value."
            service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="ACC-COMPLINK-0021-8"
            match-indicator="MATCH" search-name="ACC-COMPLINK-0021"
            search-type="exclusion" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
        </ns5:search-result>
        <ns5:search-result id="VEDA-IRS-0035-9"
            match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0035"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-IRS-0035-10-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0035"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MIRUS-HER-0047-11"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-HER-0047"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MIRUS-HER-0047-12-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-HER-0047"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="AEC-ER-0031-13"
            match-indicator="FAIL" match-score="0" search-name="AEC-ER-0031"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="AEC-ER-0031-14-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="AEC-ER-0031"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MEDICARE-CARD-0007-15"
            match-indicator="FAIL" match-score="0" search-name="MEDICARE-CARD-0007"
            search-type="verification" service-result-code="0"
            service-result-detail="Your Medicare card number could have been entered incorrectly. Please try again. If the details you have entered are correct contact your local Medicare Office or call Medicare on 132 011."
            service-result-string="OK">
            <ns5:date-of-birth search-value="1976-01-27" />
        </ns5:search-result>
        <ns5:search-result id="VEDA-EVVELOCITY-0026-16"
            match-indicator="NO MATCH" search-name="VEDA-EVVELOCITY-0026"
            search-type="exclusion" service-result-code="0"
            service-result-detail="Applicant is not banned or repeatedly searched"
            service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
        </ns5:search-result>
        <ns5:search-result id="AP-17" match-indicator="NULL-NS"
            search-name="AP" search-type="verification" service-result-code="0"
            service-result-detail="No search performed" service-result-string="OK" />
        <ns5:search-result id="SENSIS-EWP-0045-18"
            match-indicator="TIMEOUT" search-name="SENSIS-EWP-0045" search-type="verification"
            service-result-code="0"
            service-result-detail="Search failed to complete within the required time and so was cancelled."
            service-result-string="OK" />
        <ns5:search-result id="NSW-POAC-0009-19"
            match-indicator="NULL-NS" search-name="NSW-POAC-0009" search-type="verification"
            service-result-code="0"
            service-result-detail="Request missing mandatory value :  proofOfAgeCard.  "
            service-result-string="OK" />
        <ns5:search-result id="MIRUS-SPD-0046-20"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-SPD-0046"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MIRUS-SPD-0046-21-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-SPD-0046"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBPR-0034-22"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0034"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBPR-0034-23-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0034"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
    </ns5:search-results>
    <ns5:records />
</ns5:response>
    </soapenv:Body>
</soapenv:Envelope>
''';
}
else if ('TESTREJECT'.equals(firstName.toUpperCase())) {
    responseStr = '''
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:vh="http://vedaxml.com/soap/header/v-header-v1-4.xsd"
    xmlns:wsa="http://www.w3.org/2005/08/addressing" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <soapenv:Header>
        <wsa:MessageID>111111-A1A1A-A1A1A</wsa:MessageID>
        <wsa:RelatesTo>Test_Request_123</wsa:RelatesTo>
        <wsa:To>http://www.w3.org/2005/08/addressing/anonymous</wsa:To>
        <wsa:From>
            <wsa:Address>http://vedaxml.com/sys2/idmatrix-v4</wsa:Address>
        </wsa:From>
        <wsa:Action>http://vedaxml.com/idmatrix/VerifyIdentityResult
        </wsa:Action>
    </soapenv:Header>
    <soapenv:Body xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/"
        xmlns:xsd="http://www.w3.org/2001/XMLSchema">
<ns5:response enquiry-id="120727-V2A4F-05QNF" profile-name="KYC-PNCS"
    profile-version="1" xmlns:ns5="http://vedaxml.com/vxml2/idmatrix-v4-0.xsd">
         <ns5:response-outcome>
            <ns5:overall-outcome>REJECT</ns5:overall-outcome>
         </ns5:response-outcome>
         <ns5:component-responses>
            <ns5:verification-response>
    <ns5:verification-outcome>
        <ns5:indicator>REJECT</ns5:indicator>
        <ns5:total-points>120</ns5:total-points>
        <ns5:self-verification-url>https://www.idmatrix.com.au/cta?token=JMQegBajwnNSn%2Fjf95uKEarcoJCJkoZbVvv0B3Pz9YGJGJLN75JtY%2FqmBj5e7zrxrJTFItvd99sv1jr8N8IRE5fVk9PLOvviJkac%2BES4pQc%3D</ns5:self-verification-url>
    </ns5:verification-outcome>
    <ns5:rules-results>
        <ns5:rule-result name="OVERALL">
            <ns5:indicator>REJECT</ns5:indicator>
            <ns5:reason>Overall Decision</ns5:reason>
        </ns5:rule-result>
        <ns5:rule-result name="TOTALPOINTS">
            <ns5:indicator>59.0</ns5:indicator>
            <ns5:reason>Overall Points</ns5:reason>
        </ns5:rule-result>
        <ns5:rule-result name="IDMatrix Minimum Requirements Verification">
            <ns5:indicator>MATCH</ns5:indicator>
            <ns5:reason>IDMatrix Minimum Requirements Verification</ns5:reason>
        </ns5:rule-result>
    </ns5:rules-results>
    <ns5:analysis-results>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCONS-0032</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCONS-0032::previous-address</ns5:search-name>
            <ns5:raw-score>98</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>98</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>59</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-NTD-0036</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.25</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-NTD-0036::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCOMM-0033</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCOMM-0033::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VIC-DL-0020</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>100</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>ACC-COMPLINK-0021</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-IRS-0035</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.25</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-IRS-0035::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-HER-0047</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-HER-0047::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>AEC-ER-0031</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>AEC-ER-0031::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MEDICARE-CARD-0007</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>100</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.20</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-EVVELOCITY-0026</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>AP</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>SENSIS-EWP-0045</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>NSW-POAC-0009</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-SPD-0046</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.15</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-SPD-0046::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBPR-0034</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBPR-0034::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
    </ns5:analysis-results>
    <ns5:search-results>
        <ns5:search-result id="VEDA-CBCONS-0032-1"
            match-indicator="PASS" match-score="97" search-name="VEDA-CBCONS-0032"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name match-score-weight="12">
                <ns5:family-name match-indicator="Surname"
                    match-score-weight="4" search-value="Aurva" />
                <ns5:first-given-name match-indicator="First_Name"
                    match-score-weight="4" search-value="Dushyant" />
                <ns5:other-given-name match-indicator="Middle_Names"
                    match-score-weight="4" search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth match-indicator="Date"
                match-score-weight="5" search-value="1976-01-27" />
            <ns5:current-address match-score-weight="24">
                <ns5:unit-number match-indicator="Unit_Number_Noalpha"
                    match-score-weight="4" search-value="4" />
                <ns5:street-number match-indicator="Street_Number_Noalpha"
                    match-score-weight="4" search-value="10" />
                <ns5:street-name match-indicator="Address_Part1"
                    match-score-weight="4" search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb match-indicator="Address_Part2"
                    match-score-weight="4" search-value="BRUNSWICK WEST" />
                <ns5:state match-indicator="State" match-score-weight="4"
                    search-value="VIC" />
                <ns5:postcode match-indicator="Postal_Area"
                    match-score-weight="4" search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBCONS-0032-2-prev-addr"
            match-indicator="PASS" match-score="98" search-name="VEDA-CBCONS-0032"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name match-score-weight="12">
                <ns5:family-name match-indicator="Surname"
                    match-score-weight="4" search-value="Aurva" />
                <ns5:first-given-name match-indicator="First_Name"
                    match-score-weight="4" search-value="Dushyant" />
                <ns5:other-given-name match-indicator="Middle_Names"
                    match-score-weight="4" search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth match-indicator="Date"
                match-score-weight="5" search-value="1976-01-27" />
            <ns5:previous-address match-score-weight="24">
                <ns5:unit-number match-indicator="Unit_Number_Noalpha"
                    match-score-weight="4" search-value="2" />
                <ns5:street-number match-indicator="Street_Number_Noalpha"
                    match-score-weight="4" search-value="52" />
                <ns5:street-name match-indicator="Address_Part1"
                    match-score-weight="4" search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb match-indicator="Address_Part2"
                    match-score-weight="4" search-value="BRUNSWICK" />
                <ns5:state match-indicator="State" match-score-weight="4"
                    search-value="VIC" />
                <ns5:postcode match-indicator="Postal_Area"
                    match-score-weight="4" search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-NTD-0036-3"
            match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0036"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-NTD-0036-4-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0036"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBCOMM-0033-5"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0033"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBCOMM-0033-6-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0033"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VIC-DL-0020-7"
            match-indicator="FAIL" match-score="0" search-name="VIC-DL-0020"
            search-type="verification" service-result-code="0"
            service-result-detail="Invalid reCAPTCHA request. Missing challenge value."
            service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="ACC-COMPLINK-0021-8"
            match-indicator="NO MATCH" search-name="ACC-COMPLINK-0021"
            search-type="exclusion" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
        </ns5:search-result>
        <ns5:search-result id="VEDA-IRS-0035-9"
            match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0035"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-IRS-0035-10-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0035"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MIRUS-HER-0047-11"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-HER-0047"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MIRUS-HER-0047-12-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-HER-0047"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="AEC-ER-0031-13"
            match-indicator="FAIL" match-score="0" search-name="AEC-ER-0031"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="AEC-ER-0031-14-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="AEC-ER-0031"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MEDICARE-CARD-0007-15"
            match-indicator="FAIL" match-score="0" search-name="MEDICARE-CARD-0007"
            search-type="verification" service-result-code="0"
            service-result-detail="Your Medicare card number could have been entered incorrectly. Please try again. If the details you have entered are correct contact your local Medicare Office or call Medicare on 132 011."
            service-result-string="OK">
            <ns5:date-of-birth search-value="1976-01-27" />
        </ns5:search-result>
        <ns5:search-result id="VEDA-EVVELOCITY-0026-16"
            match-indicator="NO MATCH" search-name="VEDA-EVVELOCITY-0026"
            search-type="exclusion" service-result-code="0"
            service-result-detail="Applicant is not banned or repeatedly searched"
            service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
        </ns5:search-result>
        <ns5:search-result id="AP-17" match-indicator="NULL-NS"
            search-name="AP" search-type="verification" service-result-code="0"
            service-result-detail="No search performed" service-result-string="OK" />
        <ns5:search-result id="SENSIS-EWP-0045-18"
            match-indicator="TIMEOUT" search-name="SENSIS-EWP-0045" search-type="verification"
            service-result-code="0"
            service-result-detail="Search failed to complete within the required time and so was cancelled."
            service-result-string="OK" />
        <ns5:search-result id="NSW-POAC-0009-19"
            match-indicator="NULL-NS" search-name="NSW-POAC-0009" search-type="verification"
            service-result-code="0"
            service-result-detail="Request missing mandatory value :  proofOfAgeCard.  "
            service-result-string="OK" />
        <ns5:search-result id="MIRUS-SPD-0046-20"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-SPD-0046"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MIRUS-SPD-0046-21-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-SPD-0046"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBPR-0034-22"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0034"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBPR-0034-23-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0034"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
    </ns5:search-results>
    <ns5:records />
    </ns5:verification-response>
         </ns5:component-responses>
</ns5:response>
    </soapenv:Body>
</soapenv:Envelope>
''';
}
else if ('TESTEXCLUSION'.equals(firstName.toUpperCase())) {
    responseStr = '''
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:vh="http://vedaxml.com/soap/header/v-header-v1-4.xsd"
    xmlns:wsa="http://www.w3.org/2005/08/addressing" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <soapenv:Header>
        <wsa:MessageID>111111-A1A1A-A1A1A</wsa:MessageID>
        <wsa:RelatesTo>Test_Request_123</wsa:RelatesTo>
        <wsa:To>http://www.w3.org/2005/08/addressing/anonymous</wsa:To>
        <wsa:From>
            <wsa:Address>http://vedaxml.com/sys2/idmatrix-v4</wsa:Address>
        </wsa:From>
        <wsa:Action>http://vedaxml.com/idmatrix/VerifyIdentityResult
        </wsa:Action>
    </soapenv:Header>
    <soapenv:Body xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/"
        xmlns:xsd="http://www.w3.org/2001/XMLSchema">
<ns5:response enquiry-id="120727-V2A4F-05QNF" profile-name="KYC-PNCS"
    profile-version="1" xmlns:ns5="http://vedaxml.com/vxml2/idmatrix-v4-0.xsd">
         <ns5:response-outcome>
            <ns5:overall-outcome>REJECT</ns5:overall-outcome>
         </ns5:response-outcome>
         <ns5:component-responses>
            <ns5:verification-response>
    <ns5:verification-outcome>
        <ns5:indicator>REJECT_ON_EXCLUSION</ns5:indicator>
        <ns5:total-points>120</ns5:total-points>
        <ns5:self-verification-url>https://www.idmatrix.com.au/cta?token=JMQegBajwnNSn%2Fjf95uKEarcoJCJkoZbVvv0B3Pz9YGJGJLN75JtY%2FqmBj5e7zrxrJTFItvd99sv1jr8N8IRE5fVk9PLOvviJkac%2BES4pQc%3D</ns5:self-verification-url>
    </ns5:verification-outcome>
    <ns5:rules-results>
        <ns5:rule-result name="OVERALL">
            <ns5:indicator>REJECT_ON_EXCLUSION</ns5:indicator>
            <ns5:reason>Overall Decision</ns5:reason>
        </ns5:rule-result>
        <ns5:rule-result name="TOTALPOINTS">
            <ns5:indicator>59.0</ns5:indicator>
            <ns5:reason>Overall Points</ns5:reason>
        </ns5:rule-result>
        <ns5:rule-result name="IDMatrix Minimum Requirements Verification">
            <ns5:indicator>MATCH</ns5:indicator>
            <ns5:reason>IDMatrix Minimum Requirements Verification</ns5:reason>
        </ns5:rule-result>
    </ns5:rules-results>
    <ns5:analysis-results>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCONS-0032</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCONS-0032::previous-address</ns5:search-name>
            <ns5:raw-score>98</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>98</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>59</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-NTD-0036</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.25</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-NTD-0036::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCOMM-0033</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCOMM-0033::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VIC-DL-0020</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>100</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>ACC-COMPLINK-0021</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-IRS-0035</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.25</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-IRS-0035::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-HER-0047</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-HER-0047::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>AEC-ER-0031</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>AEC-ER-0031::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MEDICARE-CARD-0007</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>100</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.20</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-EVVELOCITY-0026</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>AP</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>SENSIS-EWP-0045</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>NSW-POAC-0009</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-SPD-0046</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.15</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-SPD-0046::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBPR-0034</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBPR-0034::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
    </ns5:analysis-results>
    <ns5:search-results>
        <ns5:search-result id="VEDA-CBCONS-0032-1"
            match-indicator="PASS" match-score="97" search-name="VEDA-CBCONS-0032"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name match-score-weight="12">
                <ns5:family-name match-indicator="Surname"
                    match-score-weight="4" search-value="Aurva" />
                <ns5:first-given-name match-indicator="First_Name"
                    match-score-weight="4" search-value="Dushyant" />
                <ns5:other-given-name match-indicator="Middle_Names"
                    match-score-weight="4" search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth match-indicator="Date"
                match-score-weight="5" search-value="1976-01-27" />
            <ns5:current-address match-score-weight="24">
                <ns5:unit-number match-indicator="Unit_Number_Noalpha"
                    match-score-weight="4" search-value="4" />
                <ns5:street-number match-indicator="Street_Number_Noalpha"
                    match-score-weight="4" search-value="10" />
                <ns5:street-name match-indicator="Address_Part1"
                    match-score-weight="4" search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb match-indicator="Address_Part2"
                    match-score-weight="4" search-value="BRUNSWICK WEST" />
                <ns5:state match-indicator="State" match-score-weight="4"
                    search-value="VIC" />
                <ns5:postcode match-indicator="Postal_Area"
                    match-score-weight="4" search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBCONS-0032-2-prev-addr"
            match-indicator="PASS" match-score="98" search-name="VEDA-CBCONS-0032"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name match-score-weight="12">
                <ns5:family-name match-indicator="Surname"
                    match-score-weight="4" search-value="Aurva" />
                <ns5:first-given-name match-indicator="First_Name"
                    match-score-weight="4" search-value="Dushyant" />
                <ns5:other-given-name match-indicator="Middle_Names"
                    match-score-weight="4" search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth match-indicator="Date"
                match-score-weight="5" search-value="1976-01-27" />
            <ns5:previous-address match-score-weight="24">
                <ns5:unit-number match-indicator="Unit_Number_Noalpha"
                    match-score-weight="4" search-value="2" />
                <ns5:street-number match-indicator="Street_Number_Noalpha"
                    match-score-weight="4" search-value="52" />
                <ns5:street-name match-indicator="Address_Part1"
                    match-score-weight="4" search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb match-indicator="Address_Part2"
                    match-score-weight="4" search-value="BRUNSWICK" />
                <ns5:state match-indicator="State" match-score-weight="4"
                    search-value="VIC" />
                <ns5:postcode match-indicator="Postal_Area"
                    match-score-weight="4" search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-NTD-0036-3"
            match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0036"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-NTD-0036-4-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0036"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBCOMM-0033-5"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0033"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBCOMM-0033-6-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0033"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VIC-DL-0020-7"
            match-indicator="FAIL" match-score="0" search-name="VIC-DL-0020"
            search-type="verification" service-result-code="0"
            service-result-detail="Invalid reCAPTCHA request. Missing challenge value."
            service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="ACC-COMPLINK-0021-8"
            match-indicator="NO MATCH" search-name="ACC-COMPLINK-0021"
            search-type="exclusion" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
        </ns5:search-result>
        <ns5:search-result id="VEDA-IRS-0035-9"
            match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0035"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-IRS-0035-10-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0035"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MIRUS-HER-0047-11"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-HER-0047"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MIRUS-HER-0047-12-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-HER-0047"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="AEC-ER-0031-13"
            match-indicator="FAIL" match-score="0" search-name="AEC-ER-0031"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="AEC-ER-0031-14-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="AEC-ER-0031"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MEDICARE-CARD-0007-15"
            match-indicator="FAIL" match-score="0" search-name="MEDICARE-CARD-0007"
            search-type="verification" service-result-code="0"
            service-result-detail="Your Medicare card number could have been entered incorrectly. Please try again. If the details you have entered are correct contact your local Medicare Office or call Medicare on 132 011."
            service-result-string="OK">
            <ns5:date-of-birth search-value="1976-01-27" />
        </ns5:search-result>
        <ns5:search-result id="VEDA-EVVELOCITY-0026-16"
            match-indicator="NO MATCH" search-name="VEDA-EVVELOCITY-0026"
            search-type="exclusion" service-result-code="0"
            service-result-detail="Applicant is not banned or repeatedly searched"
            service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
        </ns5:search-result>
        <ns5:search-result id="AP-17" match-indicator="NULL-NS"
            search-name="AP" search-type="verification" service-result-code="0"
            service-result-detail="No search performed" service-result-string="OK" />
        <ns5:search-result id="SENSIS-EWP-0045-18"
            match-indicator="TIMEOUT" search-name="SENSIS-EWP-0045" search-type="verification"
            service-result-code="0"
            service-result-detail="Search failed to complete within the required time and so was cancelled."
            service-result-string="OK" />
        <ns5:search-result id="NSW-POAC-0009-19"
            match-indicator="NULL-NS" search-name="NSW-POAC-0009" search-type="verification"
            service-result-code="0"
            service-result-detail="Request missing mandatory value :  proofOfAgeCard.  "
            service-result-string="OK" />
        <ns5:search-result id="MIRUS-SPD-0046-20"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-SPD-0046"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MIRUS-SPD-0046-21-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-SPD-0046"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBPR-0034-22"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0034"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBPR-0034-23-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0034"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
    </ns5:search-results>
    <ns5:records />
    </ns5:verification-response>
         </ns5:component-responses>
</ns5:response>
    </soapenv:Body>
</soapenv:Envelope>
''';
}
else {
    responseStr = '''
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:vh="http://vedaxml.com/soap/header/v-header-v1-4.xsd"
    xmlns:wsa="http://www.w3.org/2005/08/addressing" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <soapenv:Header>
        <wsa:MessageID>111111-A1A1A-A1A1A</wsa:MessageID>
        <wsa:RelatesTo>Test_Request_123</wsa:RelatesTo>
        <wsa:To>http://www.w3.org/2005/08/addressing/anonymous</wsa:To>
        <wsa:From>
            <wsa:Address>http://vedaxml.com/sys2/idmatrix-v4</wsa:Address>
        </wsa:From>
        <wsa:Action>http://vedaxml.com/idmatrix/VerifyIdentityResult
        </wsa:Action>
    </soapenv:Header>
    <soapenv:Body xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/"
        xmlns:xsd="http://www.w3.org/2001/XMLSchema">
<ns5:response enquiry-id="120727-V2A4F-05QNF" profile-name="KYC-PNCS"
    profile-version="1" xmlns:ns5="http://vedaxml.com/vxml2/idmatrix-v4-0.xsd">
     <ns5:response-outcome>
        <ns5:overall-outcome>ACCEPT</ns5:overall-outcome>
     </ns5:response-outcome>
     <ns5:component-responses>
        <ns5:verification-response>
    <ns5:verification-outcome>
        <ns5:indicator>ACCEPT</ns5:indicator>
        <ns5:total-points>120</ns5:total-points>
        <ns5:self-verification-url>https://www.idmatrix.com.au/cta?token=JMQegBajwnNSn%2Fjf95uKEarcoJCJkoZbVvv0B3Pz9YGJGJLN75JtY%2FqmBj5e7zrxrJTFItvd99sv1jr8N8IRE5fVk9PLOvviJkac%2BES4pQc%3D</ns5:self-verification-url>
    </ns5:verification-outcome>
    <ns5:rules-results>
        <ns5:rule-result name="OVERALL">
            <ns5:indicator>ACCEPT</ns5:indicator>
            <ns5:reason>Overall Decision</ns5:reason>
        </ns5:rule-result>
        <ns5:rule-result name="TOTALPOINTS">
            <ns5:indicator>59.0</ns5:indicator>
            <ns5:reason>Overall Points</ns5:reason>
        </ns5:rule-result>
        <ns5:rule-result name="IDMatrix Minimum Requirements Verification">
            <ns5:indicator>MATCH</ns5:indicator>
            <ns5:reason>IDMatrix Minimum Requirements Verification</ns5:reason>
        </ns5:rule-result>
    </ns5:rules-results>
    <ns5:analysis-results>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCONS-0032</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCONS-0032::previous-address</ns5:search-name>
            <ns5:raw-score>98</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>98</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>59</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-NTD-0036</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.25</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-NTD-0036::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCOMM-0033</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBCOMM-0033::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VIC-DL-0020</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>100</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>ACC-COMPLINK-0021</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-IRS-0035</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.25</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-IRS-0035::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-HER-0047</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-HER-0047::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>AEC-ER-0031</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>AEC-ER-0031::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MEDICARE-CARD-0007</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>100</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.20</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-EVVELOCITY-0026</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>AP</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>SENSIS-EWP-0045</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>NSW-POAC-0009</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-SPD-0046</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.15</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>MIRUS-SPD-0046::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBPR-0034</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>90</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.60</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
        <ns5:analysis-result>
            <ns5:category />
            <ns5:search-name>VEDA-CBPR-0034::previous-address</ns5:search-name>
            <ns5:raw-score>0</ns5:raw-score>
            <ns5:minimum-value>0</ns5:minimum-value>
            <ns5:filtered-score>0</ns5:filtered-score>
            <ns5:weight>0.00</ns5:weight>
            <ns5:points>0</ns5:points>
            <ns5:contributing-factors />
        </ns5:analysis-result>
    </ns5:analysis-results>
    <ns5:search-results>
        <ns5:search-result id="VEDA-CBCONS-0032-1"
            match-indicator="PASS" match-score="97" search-name="VEDA-CBCONS-0032"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name match-score-weight="12">
                <ns5:family-name match-indicator="Surname"
                    match-score-weight="4" search-value="Aurva" />
                <ns5:first-given-name match-indicator="First_Name"
                    match-score-weight="4" search-value="Dushyant" />
                <ns5:other-given-name match-indicator="Middle_Names"
                    match-score-weight="4" search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth match-indicator="Date"
                match-score-weight="5" search-value="1976-01-27" />
            <ns5:current-address match-score-weight="24">
                <ns5:unit-number match-indicator="Unit_Number_Noalpha"
                    match-score-weight="4" search-value="4" />
                <ns5:street-number match-indicator="Street_Number_Noalpha"
                    match-score-weight="4" search-value="10" />
                <ns5:street-name match-indicator="Address_Part1"
                    match-score-weight="4" search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb match-indicator="Address_Part2"
                    match-score-weight="4" search-value="BRUNSWICK WEST" />
                <ns5:state match-indicator="State" match-score-weight="4"
                    search-value="VIC" />
                <ns5:postcode match-indicator="Postal_Area"
                    match-score-weight="4" search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBCONS-0032-2-prev-addr"
            match-indicator="PASS" match-score="98" search-name="VEDA-CBCONS-0032"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name match-score-weight="12">
                <ns5:family-name match-indicator="Surname"
                    match-score-weight="4" search-value="Aurva" />
                <ns5:first-given-name match-indicator="First_Name"
                    match-score-weight="4" search-value="Dushyant" />
                <ns5:other-given-name match-indicator="Middle_Names"
                    match-score-weight="4" search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth match-indicator="Date"
                match-score-weight="5" search-value="1976-01-27" />
            <ns5:previous-address match-score-weight="24">
                <ns5:unit-number match-indicator="Unit_Number_Noalpha"
                    match-score-weight="4" search-value="2" />
                <ns5:street-number match-indicator="Street_Number_Noalpha"
                    match-score-weight="4" search-value="52" />
                <ns5:street-name match-indicator="Address_Part1"
                    match-score-weight="4" search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb match-indicator="Address_Part2"
                    match-score-weight="4" search-value="BRUNSWICK" />
                <ns5:state match-indicator="State" match-score-weight="4"
                    search-value="VIC" />
                <ns5:postcode match-indicator="Postal_Area"
                    match-score-weight="4" search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-NTD-0036-3"
            match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0036"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-NTD-0036-4-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-NTD-0036"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBCOMM-0033-5"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0033"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBCOMM-0033-6-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBCOMM-0033"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VIC-DL-0020-7"
            match-indicator="FAIL" match-score="0" search-name="VIC-DL-0020"
            search-type="verification" service-result-code="0"
            service-result-detail="Invalid reCAPTCHA request. Missing challenge value."
            service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="ACC-COMPLINK-0021-8"
            match-indicator="NO MATCH" search-name="ACC-COMPLINK-0021"
            search-type="exclusion" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
        </ns5:search-result>
        <ns5:search-result id="VEDA-IRS-0035-9"
            match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0035"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-IRS-0035-10-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-IRS-0035"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MIRUS-HER-0047-11"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-HER-0047"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MIRUS-HER-0047-12-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-HER-0047"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="AEC-ER-0031-13"
            match-indicator="FAIL" match-score="0" search-name="AEC-ER-0031"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="AEC-ER-0031-14-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="AEC-ER-0031"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MEDICARE-CARD-0007-15"
            match-indicator="FAIL" match-score="0" search-name="MEDICARE-CARD-0007"
            search-type="verification" service-result-code="0"
            service-result-detail="Your Medicare card number could have been entered incorrectly. Please try again. If the details you have entered are correct contact your local Medicare Office or call Medicare on 132 011."
            service-result-string="OK">
            <ns5:date-of-birth search-value="1976-01-27" />
        </ns5:search-result>
        <ns5:search-result id="VEDA-EVVELOCITY-0026-16"
            match-indicator="NO MATCH" search-name="VEDA-EVVELOCITY-0026"
            search-type="exclusion" service-result-code="0"
            service-result-detail="Applicant is not banned or repeatedly searched"
            service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
        </ns5:search-result>
        <ns5:search-result id="AP-17" match-indicator="NULL-NS"
            search-name="AP" search-type="verification" service-result-code="0"
            service-result-detail="No search performed" service-result-string="OK" />
        <ns5:search-result id="SENSIS-EWP-0045-18"
            match-indicator="TIMEOUT" search-name="SENSIS-EWP-0045" search-type="verification"
            service-result-code="0"
            service-result-detail="Search failed to complete within the required time and so was cancelled."
            service-result-string="OK" />
        <ns5:search-result id="NSW-POAC-0009-19"
            match-indicator="NULL-NS" search-name="NSW-POAC-0009" search-type="verification"
            service-result-code="0"
            service-result-detail="Request missing mandatory value :  proofOfAgeCard.  "
            service-result-string="OK" />
        <ns5:search-result id="MIRUS-SPD-0046-20"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-SPD-0046"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="MIRUS-SPD-0046-21-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="MIRUS-SPD-0046"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBPR-0034-22"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0034"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:current-address>
                <ns5:unit-number search-value="4" />
                <ns5:street-number search-value="10" />
                <ns5:street-name search-value="Dalgety" />
                <ns5:street-type search-value="ST" />
                <ns5:suburb search-value="BRUNSWICK WEST" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3055" />
            </ns5:current-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
        <ns5:search-result id="VEDA-CBPR-0034-23-prev-addr"
            match-indicator="FAIL" match-score="0" search-name="VEDA-CBPR-0034"
            search-type="verification" service-result-code="0"
            service-result-detail="" service-result-string="OK">
            <ns5:individual-name>
                <ns5:family-name search-value="Aurva" />
                <ns5:first-given-name search-value="Dushyant" />
                <ns5:other-given-name search-value="Reddy" />
            </ns5:individual-name>
            <ns5:date-of-birth search-value="1976-01-27" />
            <ns5:previous-address>
                <ns5:unit-number search-value="2" />
                <ns5:street-number search-value="52" />
                <ns5:street-name search-value="Austral" />
                <ns5:street-type search-value="AVE" />
                <ns5:suburb search-value="BRUNSWICK" />
                <ns5:state search-value="VIC" />
                <ns5:postcode search-value="3056" />
            </ns5:previous-address>
            <ns5:phone-numbers>
                <ns5:home-phone-number search-value="93882509" />
                <ns5:mobile-phone-number search-value="0401691193" />
            </ns5:phone-numbers>
            <ns5:drivers-licence-details>
                <ns5:number search-value="059579641" />
                <ns5:card-number search-value="123456789" />
            </ns5:drivers-licence-details>
        </ns5:search-result>
    </ns5:search-results>
    <ns5:records />
</ns5:verification-response>
</ns5:component-responses>
</ns5:response>
    </soapenv:Body>
</soapenv:Envelope>
''';
}

return responseStr
