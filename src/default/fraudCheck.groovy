String firstName =  requestXml.'BCAservice'.'BCAservice-data'.'request'.'individual'.'individual-name'.'first-given-name'.text();

def responseStr = null;

if ('FNAMESIX'.equals(firstName.toUpperCase()) || 'FNAMESEVEN'.equals(firstName.toUpperCase()) || 'FNAMEEIGHT'.equals(firstName.toUpperCase())) {
responseStr = '''
<BCAmessage type="RESPONSE" service-request-id="00000951742">
  <BCAservices>
    <BCAservice>
      <BCAservice-code>BCA001</BCAservice-code>
      <BCAservice-code-version>V00</BCAservice-code-version>
      <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
	  <BCAservice-data>
				<response version="1-36-0">
					<error>  
						<error-type code="AD">validation</error-type>  
						<input-container>address</input-container>  
						<error-description code="2223">STATE MUST BE ENTERED</error-description> 
					</error> 
				</response>
	  </BCAservice-data>
    </BCAservice>
  </BCAservices>
</BCAmessage>
'''
}
else if ('FAILEDVSS'.equals(firstName.toUpperCase())) {
responseStr = '''
<BCAmessage type="RESPONSE" service-request-id="00000951742">
  <BCAservices>
    <BCAservice>
      <BCAservice-code>VSS001</BCAservice-code>
      <BCAservice-code-version>V00</BCAservice-code-version>
      <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>

      <BCAservice-data>
        <response version="1-21-0">
        
          <verification-suite-summary>
            <vericheck-indicator result="successful" />
            <fraudcheck-indicator result="successful" />            
            <birth-certificate-verification-indicator result="not-requested" />
            <ftra-bureau-check-indicator result="not-requested" />
            <dfat-verification-indicator result="successful" />
            <ofac-verification-indicator result="successful" />
          </verification-suite-summary>
          
          <vericheck-report>
            <report-summary code="10">IDENTITY VERIFIED. PHONE NUMBER NOT LISTED OR NOT PROVIDED.</report-summary>
            <phone-listing-result type="latest" match-summary="no-match">
              <phone-indicator match="no-match" />
              <family-name-indicator match="no-match" />
              <initials-indicator match="no-match" />
              <address-indicator type="residential-current" match="no-match">
                <unit-number-indicator match="no-match" />
                <street-number-indicator match="no-match" />
                <property-indicator match="no-match" />
                <street-name-indicator match="no-match" />
                <street-type-indicator match="no-match" />
                <suburb-indicator match="no-match" />
                <state-indicator match="no-match" />
                <postcode-indicator match="no-match" />
              </address-indicator>
            </phone-listing-result>
            <electoral-roll-result type="latest" match-summary="exact">
              <address-indicator type="residential-current" match="exact">
                <unit-number-indicator match="absent" />
                <street-number-indicator match="exact" />
                <property-indicator match="absent" />
                <street-name-indicator match="exact" />
                <street-type-indicator match="exact" />
                <suburb-indicator match="exact" />
                <state-indicator match="exact" />
                <postcode-indicator match="exact" />
              </address-indicator>
              <individual-name-indicator match="exact">
                <first-given-name-indicator match="exact" match-initial="exact" />
                <other-given-name-indicator match="absent" match-initial="absent" />
                <family-name-indicator match="exact" />
              </individual-name-indicator>
            </electoral-roll-result>
            <drivers-licence-result match-summary="exact">
              <number-indicator match="exact" />
              <name-indicator match="exact" />
            </drivers-licence-result>
          </vericheck-report>
          

          <dfat-verification verification-result="match" />          
          <ofat-verification verification-result="match" />          
        
          <general-message>NO FRAUD MATCHES RETURNED</general-message>
        </response>
      </BCAservice-data>

    </BCAservice>
  </BCAservices>
</BCAmessage>
'''
}
else
{
responseStr = '''
<BCAmessage type="RESPONSE" service-request-id="00000951742">
  <BCAservices>
    <BCAservice>
      <BCAservice-code>VSS001</BCAservice-code>
      <BCAservice-code-version>V00</BCAservice-code-version>
      <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>

	  <BCAservice-data>
        <response version="1-21-0">
        
          <verification-suite-summary>
            <vericheck-indicator result="successful" />            
            <birth-certificate-verification-indicator result="not-requested" />
            <ftra-bureau-check-indicator result="not-requested" />
            <dfat-verification-indicator result="successful" />
            <ofac-verification-indicator result="successful" />
          </verification-suite-summary>
          <fraudcheck-report>
			<fraudcheck-result>
				<fraudcheck-result-details>
					<date-fraud-occurred>2001-01-31</date-fraud-occurred>
				</fraudcheck-result-details>	
			</fraudcheck-result>
		  </fraudcheck-report>
          <vericheck-report>
            <report-summary code="10">IDENTITY VERIFIED. PHONE NUMBER NOT LISTED OR NOT PROVIDED.</report-summary>
            <phone-listing-result type="latest" match-summary="no-match">
              <phone-indicator match="no-match" />
              <family-name-indicator match="no-match" />
              <initials-indicator match="no-match" />
              <address-indicator type="residential-current" match="no-match">
                <unit-number-indicator match="no-match" />
                <street-number-indicator match="no-match" />
                <property-indicator match="no-match" />
                <street-name-indicator match="no-match" />
                <street-type-indicator match="no-match" />
                <suburb-indicator match="no-match" />
                <state-indicator match="no-match" />
                <postcode-indicator match="no-match" />
              </address-indicator>
            </phone-listing-result>
            <electoral-roll-result type="latest" match-summary="exact">
              <address-indicator type="residential-current" match="exact">
                <unit-number-indicator match="absent" />
                <street-number-indicator match="exact" />
                <property-indicator match="absent" />
                <street-name-indicator match="exact" />
                <street-type-indicator match="exact" />
                <suburb-indicator match="exact" />
                <state-indicator match="exact" />
                <postcode-indicator match="exact" />
              </address-indicator>
              <individual-name-indicator match="exact">
                <first-given-name-indicator match="exact" match-initial="exact" />
                <other-given-name-indicator match="absent" match-initial="absent" />
                <family-name-indicator match="exact" />
              </individual-name-indicator>
            </electoral-roll-result>
            <drivers-licence-result match-summary="exact">
              <number-indicator match="exact" />
              <name-indicator match="exact" />
            </drivers-licence-result>
          </vericheck-report>
          

          <dfat-verification verification-result="match" />          
          <ofat-verification verification-result="match" />          
        
          <general-message>NO FRAUD MATCHES RETURNED</general-message>
        </response>
	  </BCAservice-data>

    </BCAservice>
  </BCAservices>
</BCAmessage>
'''
}
return responseStr
