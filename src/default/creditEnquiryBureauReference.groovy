def responseStr = """
<BCAmessage type="RESPONSE" service-request-id="00000951742">
  <BCAservices>
    <BCAservice>
      <BCAservice-code>BCA001</BCAservice-code>
      <BCAservice-code-version>V00</BCAservice-code-version>
      <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
	  <BCAservice-data>
		<response version="Dev1.2">
			<enquiry-report>
				<primary-match type="strong">
					<bureau-reference>320403</bureau-reference>
					<individual>
						<individual-name create-date="2002-05-29">
							<family-name>Aurva</family-name>
							<first-given-name>Sridevi</first-given-name>
							<other-given-name>Reddy</other-given-name>
						</individual-name>
						<gender type="unknown" />
						<date-of-birth>1950-10-10</date-of-birth>
						<drivers-licence-number>DL1236</drivers-licence-number>
						<address type="residential-current" create-date="1998-11-13">
							<unit-number />
							<street-number>10</street-number>
							<property />
							<street-name>Dalgety</street-name>
							<street-type code="STR" />
							<suburb>BRUNSWICK WEST</suburb>
							<state>VIC</state>
							<postcode>3055</postcode>
						</address>
					</individual>
					<individual-consumer-credit-file>
						<individual-cross-reference create-date="2010-06-08">
							<bureau-reference>341838126</bureau-reference> 
							<individual-name>
								<family-name>YOUNG</family-name>
								<first-given-name>Sridevi</first-given-name>
							</individual-name>
						</individual-cross-reference>
					</individual-consumer-credit-file>
					<individual-public-data-file>
						<directorship type="current">
							<date-appointed>2000-03-22</date-appointed>
							<organisation>
								<bureau-reference>24168</bureau-reference>
								<organisation-name>SOUTH NORTHERN</organisation-name>
								<organisation-type code="P/L" />
								<australian-organisation-number>001123345 </australian-organisation-number>
								<australian-business-number>11001123345 </australian-business-number>
							</organisation>
						</directorship>
					</individual-public-data-file>
				</primary-match>
          		<summary-data>
					<summary name="enquiry-amount" type="amount" currency-code="AUD">295000</summary>
					<summary name="age-of-file" type="months">6</summary>
					<summary name="age-of-subject" type="years" />
					<summary name="time-at-address" type="months">6</summary>
					<summary name="time-at-employer" type="months" />
					<summary name="defaults" type="count">0</summary>
					<summary name="defaults-value" type="amount" currency-code="AUD">0</summary>
					<summary name="defaults-paid" type="count">0</summary>
					<summary name="defaults-12" type="count">0</summary>
					<summary name="defaults-12-paid" type="count">0</summary>
					<summary name="defaults-12-unpaid" type="count">0</summary>
					<summary name="defaults-24-paid" type="count">0</summary>
					<summary name="defaults-24-unpaid" type="count">0</summary>
					<summary name="defaults-36-paid" type="count">0</summary>
					<summary name="defaults-36-unpaid" type="count">0</summary>
					<summary name="time-since-last-default" type="months">0</summary>
					<summary name="total-enquiries" type="count">0</summary>
					<summary name="enquiries-1" type="count">0</summary>
					<summary name="enquiries-3" type="count">0</summary>
					<summary name="enquiries-6" type="count">0</summary>
					<summary name="enquiries-12" type="count">0</summary>
					<summary name="time-since-last-enquiry" type="months">0</summary>
					<summary name="telco-and-utility-defaults" type="count">0</summary>
					<summary name="telco-and-utility-defaults-12" type="count">0</summary>
					<summary name="telco-and-utility-enquiries" type="count">0</summary>
					<summary name="telco-and-utility-enquiries-6" type="count">0</summary>
					<summary name="telco-and-utility-enquiries-12" type="count">0</summary>
					<summary name="directorships" type="count">0</summary>
					<summary name="judgements" type="count">0</summary>
					<summary name="bankruptcies" type="count">0</summary>
					<summary name="writs-and-summons" type="count">0</summary>
					<summary name="external-administration-director" type="count">0</summary>
				</summary-data>
			</enquiry-report>
		</response>
	  </BCAservice-data>
    </BCAservice>
  </BCAservices>
</BCAmessage>
"""

return responseStr
