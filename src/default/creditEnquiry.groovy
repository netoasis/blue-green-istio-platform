String firstName =  requestXml.'BCAservice'.'BCAservice-data'.'request'.'individual'.'individual-name'.'first-given-name'.text();
String familyName =  requestXml.'BCAservice'.'BCAservice-data'.'request'.'individual'.'individual-name'.'family-name'.text();

def responseStr = null;

if ('JESSE'.equals(firstName.toUpperCase()) && 'JANE'.equals(familyName.toUpperCase())) {
responseStr = '''
<BCAmessage type="RESPONSE" service-request-id="00000951742">
  <BCAservices>
    <BCAservice>
      <BCAservice-code>BCA001</BCAservice-code>
      <BCAservice-code-version>V00</BCAservice-code-version>
      <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
      <BCAservice-data>
                <response version="1-36-0">
                    <enquiry-report>
                        <primary-match type="strong">
                            <bureau-reference>165081850</bureau-reference>
                            <individual>
                                <individual-name create-date="2000-08-28">
                                    <family-name>JANE</family-name>
                                    <first-given-name>JESSE</first-given-name>                                  
                                </individual-name>
                                <gender type="female"/>
                                <date-of-birth>1945-06-03</date-of-birth>
                                <drivers-licence-number>864788GH</drivers-licence-number>
                                <address type="residential-current" create-date="2001-06-15">
                                    <unit-number>12</unit-number>
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>NORTH SYDNEY</suburb>
                                    <state>NSW</state>
                                    <postcode>2060</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <address type="residential-previous" create-date="2000-08-28">
                                    <street-number>98</street-number>
                                    <street-name>NORTH</street-name>
                                    <street-type code="RD"/>
                                    <suburb>ABBOTSFORD</suburb>
                                    <state>NSW</state>
                                    <postcode>2046</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <employment create-date="2008-02-21">
                                    <employer>EMPLOYER</employer>
                                </employment>
                            </individual>
                            <individual-consumer-credit-file>
                                <individual-cross-reference create-date="2001-06-15">
                                    <bureau-reference>175664691</bureau-reference>
                                    <individual-name>
                                        <family-name>TEST</family-name>
                                        <first-given-name>MELISSA</first-given-name>
                                        <other-given-name>JANE</other-given-name>
                                    </individual-name>
                                </individual-cross-reference>
                                <default>
                                    <account-details>
                                        <account-type code="RM">Real Property Mortgage</account-type>
                                        <client-reference>165081850</client-reference>
                                        <role type="principal"/>
                                        <default-status>Outstanding</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2008-02-19</date-recorded>
                                        <default-amount>150</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>ANZ BANK TEST CODE</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2008-02-19</date-recorded>
                                        <default-amount>150</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>ANZ BANK TEST CODE</credit-provider>
                                    </current-default>
                                </default>
                                <default>
                                    <account-details>
                                        <account-type code="R">Equipment Hire or Rental</account-type>
                                        <client-reference>000222</client-reference>
                                        <role type="principal"/>
                                        <default-status date="2006-03-16" code="C">Current</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2006-03-16</date-recorded>
                                        <default-amount>630</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>CRAA TEST FILES</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2006-03-16</date-recorded>
                                        <default-amount>630</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>CRAA TEST FILES</credit-provider>
                                    </current-default>
                                </default>
                                <default>
                                    <account-details>
                                        <account-type code="TC">Telecommunications Services</account-type>
                                        <client-reference>9387298175987</client-reference>
                                        <role type="principal"/>
                                        <default-status date="2006-03-16" code="P">P</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2006-01-21</date-recorded>
                                        <default-amount>500</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>TELSTRA</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2006-01-21</date-recorded>
                                        <default-amount>500</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>TELSTRA</credit-provider>
                                    </current-default>
                                </default>
                                <file-note date-recorded="2007-06-15">THIS IS A TEST FILES WITH ALL SEGMENTS</file-note>
                                <file-note date-recorded="2007-06-15">IF I INCLUDE SOME MORE TEXT THEN THIS WILL BE A VERY LONG</file-note>
                                <file-note date-recorded="2007-06-15">NARRATIVE AND THEREFORE BE A VERY LARGE FILE THAT RETURNS</file-note>
                                <file-note date-recorded="2007-06-15">A LOT OF CHARACTERS WHEN REQUESTED.</file-note>
                                <file-note date-recorded="2007-06-15">THIS WILL HAVE A LOT OF NONSENSE IN ORDER TO BE LONGER THAN</file-note>
                                <file-note date-recorded="2007-06-15">NORMAL SO EXPECT OT SEE JUNBK IN HERE THAT DOERSN'T MAKE ANY</file-note>
                                <file-note date-recorded="2007-06-15">SENSE AND SO THEREFORE IT COULD LEAD TO BEING BORED BEFORE YOU</file-note>
                                <file-note date-recorded="2007-06-15">GET TO THE END OF THE TEXT THAT IS WRITTEN HERE.</file-note>
                                <file-note date-recorded="2007-06-15">THE VALUE OF THIS IS IN THE BEHOLDER WHO IS EXPECTING BIG</file-note>
                                <file-note date-recorded="2007-06-15">THINGS FROM LITTLE REQUESTS. CAN THIS BE LONG ENOUGH TO</file-note>
                                <file-note date-recorded="2007-06-15">SATISFY EVEN THE MOST DEMANDING? GOOD QUESTION AND I WILL TRY</file-note>
                                <file-note date-recorded="2007-06-15">TO ANSWER THIS AS BEST I CAN BY TYPING AWAY TO PRODUCE SOME</file-note>
                                <file-note date-recorded="2007-06-15">REALLY CLEVER TEXT THAT WILL BE RETURNED IN THE NEXT RESPONSE</file-note>
                                <file-note date-recorded="2007-06-15">THAT IS SENT OUT TO THE CUSTOMERS.</file-note>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-25">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>19840</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ B2BAY TEST CODE</credit-enquirer>
                                    <client-reference>VEDAAID-006</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-24">
                                    <account-type code="OD">Overdraft</account-type>
                                    <enquiry-amount>3000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>DS TEST 2</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-24">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>200000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>MOBIUS FINANCIAL PROCESSING</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-04-28">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>2500</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>RETAILEASE P/L</credit-enquirer>
                                    <client-reference>CREF1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-12">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>1300</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>PROJECT IMPLEMENTATION TEAM</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-06">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162000 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-05">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162397 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-03">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>1300</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>PROJECT IMPLEMENTATION TEAM</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-27">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162000 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-27">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>0 0</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-26">
                                    <account-type code="TC">Telecommunications Services</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>CRAZY JOHNS</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-22">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161677 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-21">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>FLEXIRENT TEST *</credit-enquirer>
                                    <client-reference>785649-437275</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-20">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>10149</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>POLICE &amp; NURSES C/S SODP</credit-enquirer>
                                    <client-reference>3000381</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-20">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>30222</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>POLICE &amp; NURSES C/S SODP</credit-enquirer>
                                    <client-reference>3000378</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-19">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>100</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ BANK TEST CODE</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>55000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161860 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>200000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161815 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161908 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-13">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>0 0</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161677 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>125000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>CR123 2</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162021 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-11-13">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>42000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ BANK TEST CODE</credit-enquirer>
                                    <client-reference>4604</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-07-20">
                                    <account-type code="T">Terms</account-type>
                                    <enquiry-amount>20000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>DP CORE TEST</credit-enquirer>
                                    <client-reference>200107204267105</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-01-23">
                                    <account-type code="CC">Continuing Credit Contract</account-type>
                                    <enquiry-amount>200</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>VODAFONE NSW</credit-enquirer>
                                    <client-reference>00023229</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="authorised-agent-enquiry" enquiry-date="2001-06-15">
                                    <account-type code="CC">Continuing Credit Contract</account-type>
                                    <enquiry-amount>30000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>PHIL MCCARROLL FORD</credit-enquirer>
                                </credit-enquiry>
                            </individual-consumer-credit-file>
                            <individual-public-data-file>
                                <disqualified-directorship>
                                    <date-disqualified>2008-02-21</date-disqualified>
                                    <date-disqualified-until>2010-02-21</date-disqualified-until>
                                </disqualified-directorship>
                                <file-message>DISQUALIFIED DIRECTOR DETAILS WERE OBTAINED FROM THE ASIC UNDER</file-message>
                                <file-message>SECTION 3 SUB SECTION 243</file-message>
                                <directorship type="current">
                                    <date-appointed>1999-01-01</date-appointed>
                                    <organisation>
                                        <bureau-reference>165968358</bureau-reference>
                                        <organisation-name>MELISSA'S SWEAT SHOP</organisation-name>
                                        <organisation-type code="P/L"/>
                                    </organisation>
                                </directorship>
                                <directorship type="previous">
                                    <date-appointed>2005-01-21</date-appointed>
                                    <date-ceased>2007-03-21</date-ceased>
                                    <date-last-known-as-director>2007-03-21</date-last-known-as-director>
                                    <organisation>
                                        <bureau-reference>166368656</bureau-reference>
                                        <organisation-name>MULLIGANS FOOD</organisation-name>
                                        <organisation-type code="P/L"/>
                                        <organisation-number>000309786</organisation-number>
                                    </organisation>
                                </directorship>
                                <proprietorship>
                                    <date-appointed>2001-03-16</date-appointed>
                                    <business>
                                        <bureau-reference>165289307</bureau-reference>
                                        <business-name>MARYS MAX SHOES</business-name>
                                    </business>
                                </proprietorship>
                                <bankruptcy>
                                    <bankruptcy-type code="D">Arrangement</bankruptcy-type>
                                    <date-declared>2006-03-16</date-declared>
                                    <narrative>FRANKS TRUSTEES</narrative>
                                    <proceedings>
                                        <state>NSW</state>
                                        <year>2000</year>
                                        <number>12356789</number>
                                        <proceedings-status type="part 10"/>
                                    </proceedings>
                                    <discharge-status type="not-discharged-not-completed"/>
                                    <role type="principal"/>
                                </bankruptcy>
                                <bankruptcy>
                                    <bankruptcy-type code="B">Bankruptcy (Debtors Petition)</bankruptcy-type>
                                    <date-declared>2005-01-21</date-declared>
                                    <narrative>DEBTORS PETITION</narrative>
                                    <proceedings>
                                        <state>NSW</state>
                                        <year>2001</year>
                                        <number>47384758</number>
                                    </proceedings>
                                    <discharge-status type="not-discharged-not-completed"/>
                                    <role type="principal"/>
                                </bankruptcy>
                                <bankruptcy>
                                    <bankruptcy-type code="B">Bankruptcy (Debtors Petition)</bankruptcy-type>
                                    <date-declared>2002-06-19</date-declared>
                                    <narrative>DEBTORS PETITION</narrative>
                                    <proceedings>
                                        <state>NSW</state>
                                        <year>2002</year>
                                        <number>13598777</number>
                                    </proceedings>
                                    <discharge-status date="2005-08-12" type="discharged" />
                                    <role type="principal" />
                                </bankruptcy>
                                <bankruptcy>
                                    <bankruptcy-type code="B">Bankruptcy (Debtors Petition)</bankruptcy-type>
                                    <date-declared>2004-07-15</date-declared>
                                    <narrative>DEBTORS PETITION</narrative>
                                    <proceedings>
                                        <state>NSW</state>
                                        <year>2002</year>
                                        <number>13598778</number>
                                    </proceedings>
                                    <discharge-status date="2004-11-27" type="discharged" />
                                    <role type="principal" />
                                </bankruptcy>
                                <court-action type="default-judgement">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>ALLIANZ</creditor>
                                    <court-action-amount>5000</court-action-amount>
                                    <plaint-number>2356897/99/ACTM</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                    <court-action-status date="2005-03-16" code="P">Paid</court-action-status>
                                </court-action>
                                <court-action type="default-judgement">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>BANKERS MAGAZINE</creditor>
                                    <court-action-amount>200</court-action-amount>
                                    <plaint-number>2345783/00/ACTS</plaint-number>
                                    <court-type>Small Court</court-type>
                                    <role type="principal"/>
                                </court-action>
                                <court-action type="court-writ">
                                    <action-date>2006-06-15</action-date>
                                    <creditor>NATIONAL AUSTRALIA BANK</creditor>
                                    <court-action-amount>4000</court-action-amount>
                                    <plaint-number>8475847/01/QATN</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                </court-action>
                            </individual-public-data-file>
                        </primary-match>
                        <possible-match>
                            <bureau-reference>172568458</bureau-reference>
                            <individual>
                                <individual-name create-date="2006-11-02">
                                    <family-name>PETERSEN</family-name>
                                    <first-given-name>LOUISE</first-given-name>
                                    <other-given-name>JULIE</other-given-name>
                                </individual-name>
                                <gender type="female"/>
                                <date-of-birth>1945-06-03</date-of-birth>
                                <drivers-licence-number>864788GH</drivers-licence-number>
                                <address type="residential-current" create-date="2008-06-03">
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>O CONNELL</suburb>
                                    <state>NSW</state>
                                    <postcode>2795</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <address type="residential-previous" create-date="2008-05-09">
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>CAMPSIE</suburb>
                                    <state>NSW</state>
                                    <postcode>2194</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <address type="residential-previous" create-date="2008-05-09">
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>GORDON</suburb>
                                    <state>NSW</state>
                                    <postcode>2072</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <employment create-date="2008-04-30">
                                    <employer>HOLIDAY INN AT SURFERS PARADISE</employer>
                                </employment>
                            </individual>
                        </possible-match>
                        <summary-data>
                            <summary currency-code="AUD" name="enquiry-amount" type="amount">0</summary>
                            <summary name="age-of-file" type="months">0</summary>
                            <summary name="age-of-subject" type="years">24</summary>
                            <summary name="time-at-address" type="months">0</summary>
                            <summary name="time-at-employer" type="months"/>
                            <summary name="defaults" type="count">2</summary>
                            <summary currency-code="AUD" name="total-value-of-outstanding-defaults" type="amount">3500</summary>
                            <summary name="defaults-paid" type="count">3</summary>
                            <summary name="defaults-12" type="count">0</summary>
                            <summary name="defaults-12-paid" type="count">0</summary>
                            <summary name="defaults-12-unpaid" type="count">0</summary>
                            <summary name="defaults-24-paid" type="count">0</summary>
                            <summary name="defaults-24-unpaid" type="count">0</summary>
                            <summary name="defaults-36-paid" type="count">0</summary>
                            <summary name="defaults-36-unpaid" type="count">0</summary>
                            <summary name="time-since-last-default" type="months">275</summary>
                            <summary name="total-enquiries" type="count">0</summary>
                            <summary name="enquiries-1" type="count">1</summary>
                            <summary name="enquiries-3" type="count">1</summary>
                            <summary name="enquiries-6" type="count">1</summary>
                            <summary name="enquiries-12" type="count">1</summary>
                            <summary name="enquiries-60" type="count">4</summary>
                            <summary name="time-since-last-enquiry" type="months">12</summary>
                            <summary name="telco-and-utility-defaults" type="count">0</summary>
                            <summary name="telco-and-utility-defaults-12" type="count">0</summary>
                            <summary name="telco-and-utility-enquiries" type="count">0</summary>
                            <summary name="telco-and-utility-enquiries-6" type="count">0</summary>
                            <summary name="telco-and-utility-enquiries-12" type="count">0</summary>
                            <summary name="authorised-agents-enquiries-12" type="count">0</summary>
                            <summary name="authorised-agents-enquiries-60" type="count">0</summary>
                            <summary name="directorships-current" type="count">1</summary>
                            <summary name="directorships-previous" type="count">0</summary>
                            <summary name="judgements" type="count">1</summary>
                            <summary name="proprietorships" type="count">0</summary>
                            <summary name="adverse-on-file">Yes</summary>
                            <summary name="file-notes">No</summary>
                            <summary name="known-identities" type="count">1</summary>
                            <summary name="bankruptcies" type="count">1</summary>
                            <summary name="writs-and-summons" type="count">1</summary>
                            <summary name="external-administration-director" type="count">0</summary>
                        </summary-data>
                    </enquiry-report>
                </response>
      </BCAservice-data>
    </BCAservice>
  </BCAservices>
</BCAmessage>
'''
}
else if ('WARNER'.equals(firstName.toUpperCase()) && 'BROTHER'.equals(familyName.toUpperCase())) {
    responseStr = '''
<BCAmessage type="RESPONSE" service-request-id="00000951742">
  <BCAservices>
    <BCAservice>
      <BCAservice-code>BCA001</BCAservice-code>
      <BCAservice-code-version>V00</BCAservice-code-version>
      <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
      <BCAservice-data>
                <response version="1-36-0">
                    <enquiry-report>
                        <primary-match type="strong">
                            <bureau-reference>165081850</bureau-reference>
                            <individual>
                                <individual-name create-date="2000-08-28">
                                    <family-name>BROTHER</family-name>
                                    <first-given-name>WARNER</first-given-name>                                  
                                </individual-name>
                                <gender type="female"/>
                                <date-of-birth>1945-06-03</date-of-birth>
                                <drivers-licence-number>864788GH</drivers-licence-number>
                                <address type="residential-current" create-date="2001-06-15">
                                    <unit-number>12</unit-number>
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>NORTH SYDNEY</suburb>
                                    <state>NSW</state>
                                    <postcode>2060</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <address type="residential-previous" create-date="2000-08-28">
                                    <street-number>98</street-number>
                                    <street-name>NORTH</street-name>
                                    <street-type code="RD"/>
                                    <suburb>ABBOTSFORD</suburb>
                                    <state>NSW</state>
                                    <postcode>2046</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <employment create-date="2008-02-21">
                                    <employer>EMPLOYER</employer>
                                </employment>
                            </individual>
                            <individual-consumer-credit-file>
                                <individual-cross-reference create-date="2001-06-15">                                    
                                    <individual-name>
                                        <family-name>TEST</family-name>
                                        <first-given-name>MELISSA</first-given-name>
                                        <other-given-name>JANE</other-given-name>
                                    </individual-name>
                                </individual-cross-reference>
                                <default>
                                    <account-details>
                                        <account-type code="TC">Telecommunications Services</account-type>
                                        <client-reference>9387298175987</client-reference>
                                        <role type="principal"/>
                                        <default-status date="2006-03-16" code="P">P</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2006-01-21</date-recorded>
                                        <default-amount>1500</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>TELSTRA</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2006-01-21</date-recorded>
                                        <default-amount>1500</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>TELSTRA</credit-provider>
                                    </current-default>
                                </default>
                                <file-note date-recorded="2007-06-15">THIS IS A TEST FILES WITH ALL SEGMENTS</file-note>
                                <file-note date-recorded="2007-06-15">IF I INCLUDE SOME MORE TEXT THEN THIS WILL BE A VERY LONG</file-note>
                                <file-note date-recorded="2007-06-15">NARRATIVE AND THEREFORE BE A VERY LARGE FILE THAT RETURNS</file-note>
                                <file-note date-recorded="2007-06-15">A LOT OF CHARACTERS WHEN REQUESTED.</file-note>
                                <file-note date-recorded="2007-06-15">THIS WILL HAVE A LOT OF NONSENSE IN ORDER TO BE LONGER THAN</file-note>
                                <file-note date-recorded="2007-06-15">NORMAL SO EXPECT OT SEE JUNBK IN HERE THAT DOERSN'T MAKE ANY</file-note>
                                <file-note date-recorded="2007-06-15">SENSE AND SO THEREFORE IT COULD LEAD TO BEING BORED BEFORE YOU</file-note>
                                <file-note date-recorded="2007-06-15">GET TO THE END OF THE TEXT THAT IS WRITTEN HERE.</file-note>
                                <file-note date-recorded="2007-06-15">THE VALUE OF THIS IS IN THE BEHOLDER WHO IS EXPECTING BIG</file-note>
                                <file-note date-recorded="2007-06-15">THINGS FROM LITTLE REQUESTS. CAN THIS BE LONG ENOUGH TO</file-note>
                                <file-note date-recorded="2007-06-15">SATISFY EVEN THE MOST DEMANDING? GOOD QUESTION AND I WILL TRY</file-note>
                                <file-note date-recorded="2007-06-15">TO ANSWER THIS AS BEST I CAN BY TYPING AWAY TO PRODUCE SOME</file-note>
                                <file-note date-recorded="2007-06-15">REALLY CLEVER TEXT THAT WILL BE RETURNED IN THE NEXT RESPONSE</file-note>
                                <file-note date-recorded="2007-06-15">THAT IS SENT OUT TO THE CUSTOMERS.</file-note>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-25">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>19840</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ B2BAY TEST CODE</credit-enquirer>
                                    <client-reference>VEDAAID-006</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-24">
                                    <account-type code="OD">Overdraft</account-type>
                                    <enquiry-amount>3000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>DS TEST 2</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-24">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>200000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>MOBIUS FINANCIAL PROCESSING</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-04-28">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>2500</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>RETAILEASE P/L</credit-enquirer>
                                    <client-reference>CREF1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-12">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>1300</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>PROJECT IMPLEMENTATION TEAM</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-06">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162000 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-05">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162397 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-03">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>1300</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>PROJECT IMPLEMENTATION TEAM</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-27">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162000 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-27">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>0 0</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-26">
                                    <account-type code="TC">Telecommunications Services</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>CRAZY JOHNS</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-22">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161677 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-21">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>FLEXIRENT TEST *</credit-enquirer>
                                    <client-reference>785649-437275</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-20">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>10149</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>POLICE &amp; NURSES C/S SODP</credit-enquirer>
                                    <client-reference>3000381</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-20">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>30222</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>POLICE &amp; NURSES C/S SODP</credit-enquirer>
                                    <client-reference>3000378</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-19">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>100</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ BANK TEST CODE</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>55000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161860 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>200000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161815 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161908 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-13">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>0 0</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161677 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>125000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>CR123 2</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162021 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-11-13">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>42000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ BANK TEST CODE</credit-enquirer>
                                    <client-reference>4604</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-07-20">
                                    <account-type code="T">Terms</account-type>
                                    <enquiry-amount>20000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>DP CORE TEST</credit-enquirer>
                                    <client-reference>200107204267105</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-01-23">
                                    <account-type code="CC">Continuing Credit Contract</account-type>
                                    <enquiry-amount>200</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>VODAFONE NSW</credit-enquirer>
                                    <client-reference>00023229</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="authorised-agent-enquiry" enquiry-date="2001-06-15">
                                    <account-type code="CC">Continuing Credit Contract</account-type>
                                    <enquiry-amount>30000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>PHIL MCCARROLL FORD</credit-enquirer>
                                </credit-enquiry>
                            </individual-consumer-credit-file>
                            <individual-public-data-file>
                                <disqualified-directorship>
                                    <date-disqualified>2008-02-21</date-disqualified>
                                    <date-disqualified-until>2010-02-21</date-disqualified-until>
                                </disqualified-directorship>
                                <file-message>DISQUALIFIED DIRECTOR DETAILS WERE OBTAINED FROM THE ASIC UNDER</file-message>
                                <file-message>SECTION 3 SUB SECTION 243</file-message>                                
                                <proprietorship>
                                    <date-appointed>2001-03-16</date-appointed>
                                    <business>
                                        <bureau-reference>165289307</bureau-reference>
                                        <business-name>MARYS MAX SHOES</business-name>
                                    </business>
                                </proprietorship>                                                                                                                               
                            </individual-public-data-file>
                        </primary-match>
                        <summary-data>
                            <summary currency-code="AUD" name="enquiry-amount" type="amount">0</summary>
                            <summary name="age-of-file" type="months">0</summary>
                            <summary name="age-of-subject" type="years">24</summary>
                            <summary name="time-at-address" type="months">0</summary>
                            <summary name="time-at-employer" type="months"/>
                            <summary name="defaults" type="count">1</summary>
                            <summary currency-code="AUD" name="total-value-of-outstanding-defaults" type="amount">3500</summary>
                            <summary name="defaults-paid" type="count">1</summary>
                            <summary name="defaults-12" type="count">0</summary>
                            <summary name="defaults-12-paid" type="count">0</summary>
                            <summary name="defaults-12-unpaid" type="count">0</summary>
                            <summary name="defaults-24-paid" type="count">0</summary>
                            <summary name="defaults-24-unpaid" type="count">0</summary>
                            <summary name="defaults-36-paid" type="count">0</summary>
                            <summary name="defaults-36-unpaid" type="count">0</summary>
                            <summary name="time-since-last-default" type="months">275</summary>
                            <summary name="total-enquiries" type="count">4</summary>
                            <summary name="enquiries-1" type="count">1</summary>
                            <summary name="enquiries-3" type="count">1</summary>
                            <summary name="enquiries-6" type="count">1</summary>
                            <summary name="enquiries-12" type="count">1</summary>
                            <summary name="enquiries-60" type="count">4</summary>
                            <summary name="time-since-last-enquiry" type="months">12</summary>
                            <summary name="telco-and-utility-defaults" type="count">0</summary>
                            <summary name="telco-and-utility-defaults-12" type="count">0</summary>
                            <summary name="telco-and-utility-enquiries" type="count">0</summary>
                            <summary name="telco-and-utility-enquiries-6" type="count">0</summary>
                            <summary name="telco-and-utility-enquiries-12" type="count">0</summary>
                            <summary name="authorised-agents-enquiries-12" type="count">0</summary>
                            <summary name="authorised-agents-enquiries-60" type="count">0</summary>
                            <summary name="directorships-current" type="count">0</summary>
                            <summary name="directorships-previous" type="count">0</summary>
                            <summary name="judgements" type="count">0</summary>
                            <summary name="proprietorships" type="count">0</summary>
                            <summary name="adverse-on-file">Yes</summary>
                            <summary name="file-notes">No</summary>
                            <summary name="known-identities" type="count">1</summary>
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
'''
}
else if ('FNAMEFIVE'.equals(firstName.toUpperCase()) || 'FNAMESEVEN'.equals(firstName.toUpperCase())) {
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
else if ('FNAMEELEVEN'.equals(firstName.toUpperCase())) {
responseStr = '''
<BCAmessage type="RESPONSE" service-request-id="00000951742">
  <BCAservices>
    <BCAservice>
      <BCAservice-code>BCA001</BCAservice-code>
      <BCAservice-code-version>V00</BCAservice-code-version>
      <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
      <BCAservice-data>
                <response version="1-36-0">
                    <enquiry-report>
                        <primary-match type="strong">
                            <bureau-reference>165081850</bureau-reference>
                            <individual>
                                <individual-name create-date="2000-08-28">
                                    <family-name>PETERSEN</family-name>
                                    <first-given-name>LOUISE</first-given-name>
                                    <other-given-name>JULIE</other-given-name>
                                </individual-name>
                                <gender type="female"/>
                                <date-of-birth>1945-06-03</date-of-birth>
                                <drivers-licence-number>864788GH</drivers-licence-number>
                                <address type="residential-current" create-date="2001-06-15">
                                    <unit-number>12</unit-number>
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>NORTH SYDNEY</suburb>
                                    <state>NSW</state>
                                    <postcode>2060</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <address type="residential-previous" create-date="2000-08-28">
                                    <street-number>98</street-number>
                                    <street-name>NORTH</street-name>
                                    <street-type code="RD"/>
                                    <suburb>ABBOTSFORD</suburb>
                                    <state>NSW</state>
                                    <postcode>2046</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <employment create-date="2008-02-21">
                                    <employer>EMPLOYER</employer>
                                </employment>
                            </individual>
                            <individual-consumer-credit-file>
                                <individual-cross-reference create-date="2001-06-15">
                                    <bureau-reference>175664691</bureau-reference>
                                    <individual-name>
                                        <family-name>TEST</family-name>
                                        <first-given-name>MELISSA</first-given-name>
                                        <other-given-name>JANE</other-given-name>
                                    </individual-name>
                                </individual-cross-reference>
                                <default>
                                    <account-details>
                                        <account-type code="RM">Real Property Mortgage</account-type>
                                        <client-reference>165081850</client-reference>
                                        <role type="principal"/>
                                        <default-status>Outstanding</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2008-02-19</date-recorded>
                                        <default-amount>150</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>ANZ BANK TEST CODE</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2008-02-19</date-recorded>
                                        <default-amount>150</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>ANZ BANK TEST CODE</credit-provider>
                                    </current-default>
                                </default>
                                <default>
                                    <account-details>
                                        <account-type code="R">Equipment Hire or Rental</account-type>
                                        <client-reference>000222</client-reference>
                                        <role type="principal"/>
                                        <default-status date="2006-03-16" code="C">Current</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2006-03-16</date-recorded>
                                        <default-amount>630</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>CRAA TEST FILES</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2006-03-16</date-recorded>
                                        <default-amount>630</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>CRAA TEST FILES</credit-provider>
                                    </current-default>
                                </default>
                                <default>
                                    <account-details>
                                        <account-type code="TC">Telecommunications Services</account-type>
                                        <client-reference>9387298175987</client-reference>
                                        <role type="principal"/>
                                        <default-status>Outstanding</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2006-01-21</date-recorded>
                                        <default-amount>500</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>TELSTRA</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2006-01-21</date-recorded>
                                        <default-amount>500</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>TELSTRA</credit-provider>
                                    </current-default>
                                </default>
                                <file-note date-recorded="2007-06-15">THIS IS A TEST FILES WITH ALL SEGMENTS</file-note>
                                <file-note date-recorded="2007-06-15">IF I INCLUDE SOME MORE TEXT THEN THIS WILL BE A VERY LONG</file-note>
                                <file-note date-recorded="2007-06-15">NARRATIVE AND THEREFORE BE A VERY LARGE FILE THAT RETURNS</file-note>
                                <file-note date-recorded="2007-06-15">A LOT OF CHARACTERS WHEN REQUESTED.</file-note>
                                <file-note date-recorded="2007-06-15">THIS WILL HAVE A LOT OF NONSENSE IN ORDER TO BE LONGER THAN</file-note>
                                <file-note date-recorded="2007-06-15">NORMAL SO EXPECT OT SEE JUNBK IN HERE THAT DOERSN'T MAKE ANY</file-note>
                                <file-note date-recorded="2007-06-15">SENSE AND SO THEREFORE IT COULD LEAD TO BEING BORED BEFORE YOU</file-note>
                                <file-note date-recorded="2007-06-15">GET TO THE END OF THE TEXT THAT IS WRITTEN HERE.</file-note>
                                <file-note date-recorded="2007-06-15">THE VALUE OF THIS IS IN THE BEHOLDER WHO IS EXPECTING BIG</file-note>
                                <file-note date-recorded="2007-06-15">THINGS FROM LITTLE REQUESTS. CAN THIS BE LONG ENOUGH TO</file-note>
                                <file-note date-recorded="2007-06-15">SATISFY EVEN THE MOST DEMANDING? GOOD QUESTION AND I WILL TRY</file-note>
                                <file-note date-recorded="2007-06-15">TO ANSWER THIS AS BEST I CAN BY TYPING AWAY TO PRODUCE SOME</file-note>
                                <file-note date-recorded="2007-06-15">REALLY CLEVER TEXT THAT WILL BE RETURNED IN THE NEXT RESPONSE</file-note>
                                <file-note date-recorded="2007-06-15">THAT IS SENT OUT TO THE CUSTOMERS.</file-note>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-25">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>19840</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ B2BAY TEST CODE</credit-enquirer>
                                    <client-reference>VEDAAID-006</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-24">
                                    <account-type code="OD">Overdraft</account-type>
                                    <enquiry-amount>3000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>DS TEST 2</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-24">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>200000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>MOBIUS FINANCIAL PROCESSING</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-04-28">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>2500</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>RETAILEASE P/L</credit-enquirer>
                                    <client-reference>CREF1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-12">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>1300</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>PROJECT IMPLEMENTATION TEAM</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-06">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162000 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-05">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162397 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-03">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>1300</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>PROJECT IMPLEMENTATION TEAM</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-27">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162000 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-27">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>0 0</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-26">
                                    <account-type code="TC">Telecommunications Services</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>CRAZY JOHNS</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-22">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161677 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-21">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>FLEXIRENT TEST *</credit-enquirer>
                                    <client-reference>785649-437275</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-20">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>10149</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>POLICE &amp; NURSES C/S SODP</credit-enquirer>
                                    <client-reference>3000381</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-20">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>30222</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>POLICE &amp; NURSES C/S SODP</credit-enquirer>
                                    <client-reference>3000378</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-19">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>100</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ BANK TEST CODE</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>55000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161860 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>200000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161815 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161908 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-13">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>0 0</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161677 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>125000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>CR123 2</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162021 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-11-13">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>42000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ BANK TEST CODE</credit-enquirer>
                                    <client-reference>4604</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-07-20">
                                    <account-type code="T">Terms</account-type>
                                    <enquiry-amount>20000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>DP CORE TEST</credit-enquirer>
                                    <client-reference>200107204267105</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-01-23">
                                    <account-type code="CC">Continuing Credit Contract</account-type>
                                    <enquiry-amount>200</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>VODAFONE NSW</credit-enquirer>
                                    <client-reference>00023229</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="authorised-agent-enquiry" enquiry-date="2001-06-15">
                                    <account-type code="CC">Continuing Credit Contract</account-type>
                                    <enquiry-amount>30000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>PHIL MCCARROLL FORD</credit-enquirer>
                                </credit-enquiry>
                            </individual-consumer-credit-file>
                            <individual-public-data-file>
                                <disqualified-directorship>
                                    <date-disqualified>2008-02-21</date-disqualified>
                                    <date-disqualified-until>2010-02-21</date-disqualified-until>
                                </disqualified-directorship>
                                <file-message>DISQUALIFIED DIRECTOR DETAILS WERE OBTAINED FROM THE ASIC UNDER</file-message>
                                <file-message>SECTION 3 SUB SECTION 243</file-message>
                                <directorship type="current">
                                    <date-appointed>1999-01-01</date-appointed>
                                    <organisation>
                                        <bureau-reference>165968358</bureau-reference>
                                        <organisation-name>MELISSA'S SWEAT SHOP</organisation-name>
                                        <organisation-type code="P/L"/>
                                    </organisation>
                                </directorship>
                                <directorship type="previous">
                                    <date-appointed>2005-01-21</date-appointed>
                                    <date-ceased>2007-03-21</date-ceased>
                                    <date-last-known-as-director>2007-03-21</date-last-known-as-director>
                                    <organisation>
                                        <bureau-reference>166368656</bureau-reference>
                                        <organisation-name>MULLIGANS FOOD</organisation-name>
                                        <organisation-type code="P/L"/>
                                        <organisation-number>000309786</organisation-number>
                                    </organisation>
                                </directorship>
                                <proprietorship>
                                    <date-appointed>2001-03-16</date-appointed>
                                    <business>
                                        <bureau-reference>165289307</bureau-reference>
                                        <business-name>MARYS MAX SHOES</business-name>
                                    </business>
                                </proprietorship>
                                <bankruptcy>
                                    <bankruptcy-type code="X">Arrangement</bankruptcy-type>
                                    <date-declared>2006-03-16</date-declared>
                                    <narrative>FRANKS TRUSTEES</narrative>
                                    <proceedings>
                                        <state>NSW</state>
                                        <year>2000</year>
                                        <number>12356789</number>
                                        <proceedings-status type="part 10"/>
                                    </proceedings>
                                    <discharge-status type="not-discharged-not-completed"/>
                                    <role type="principal"/>
                                </bankruptcy>
                                <bankruptcy>
                                    <bankruptcy-type code="B">Bankruptcy (Debtors Petition)</bankruptcy-type>
                                    <date-declared>2005-01-21</date-declared>
                                    <narrative>DEBTORS PETITION</narrative>
                                    <proceedings>
                                        <state>NSW</state>
                                        <year>2001</year>
                                        <number>47384758</number>
                                    </proceedings>
                                    <discharge-status type="not-discharged-not-completed"/>
                                    <role type="principal"/>
                                </bankruptcy>
                                <bankruptcy>
                                    <bankruptcy-type code="B">Bankruptcy (Debtors Petition)</bankruptcy-type>
                                    <date-declared>2002-06-19</date-declared>
                                    <narrative>DEBTORS PETITION</narrative>
                                    <proceedings>
                                        <state>NSW</state>
                                        <year>2002</year>
                                        <number>13598777</number>
                                    </proceedings>
                                    <discharge-status date="2002-08-12" type="discharged" />
                                    <role type="principal" />
                                </bankruptcy>
                                <bankruptcy>
                                    <bankruptcy-type code="B">Bankruptcy (Debtors Petition)</bankruptcy-type>
                                    <date-declared>2004-07-15</date-declared>
                                    <narrative>DEBTORS PETITION</narrative>
                                    <proceedings>
                                        <state>NSW</state>
                                        <year>2002</year>
                                        <number>13598778</number>
                                    </proceedings>
                                    <discharge-status date="2004-11-27" type="discharged" />
                                    <role type="principal" />
                                </bankruptcy>
                                <court-action type="default-judgement">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>ALLIANZ</creditor>
                                    <court-action-amount>5000</court-action-amount>
                                    <plaint-number>2356897/99/ACTM</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                    <court-action-status date="2005-03-16" code="P">Paid</court-action-status>
                                </court-action>
                                <court-action type="default-judgement">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>BANKERS MAGAZINE</creditor>
                                    <court-action-amount>200</court-action-amount>
                                    <plaint-number>2345783/00/ACTS</plaint-number>
                                    <court-type>Small Court</court-type>
                                    <role type="principal"/>
                                </court-action>
                                <court-action type="court-writ">
                                    <action-date>2006-06-15</action-date>
                                    <creditor>NATIONAL AUSTRALIA BANK</creditor>
                                    <court-action-amount>4000</court-action-amount>
                                    <plaint-number>8475847/01/QATN</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                </court-action>
                            </individual-public-data-file>
                        </primary-match>
                        <possible-match>
                            <bureau-reference>172568458</bureau-reference>
                            <individual>
                                <individual-name create-date="2006-11-02">
                                    <family-name>PETERSEN</family-name>
                                    <first-given-name>LOUISE</first-given-name>
                                    <other-given-name>JULIE</other-given-name>
                                </individual-name>
                                <gender type="female"/>
                                <date-of-birth>1945-06-03</date-of-birth>
                                <drivers-licence-number>864788GH</drivers-licence-number>
                                <address type="residential-current" create-date="2008-06-03">
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>O CONNELL</suburb>
                                    <state>NSW</state>
                                    <postcode>2795</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <address type="residential-previous" create-date="2008-05-09">
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>CAMPSIE</suburb>
                                    <state>NSW</state>
                                    <postcode>2194</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <address type="residential-previous" create-date="2008-05-09">
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>GORDON</suburb>
                                    <state>NSW</state>
                                    <postcode>2072</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <employment create-date="2008-04-30">
                                    <employer>HOLIDAY INN AT SURFERS PARADISE</employer>
                                </employment>
                            </individual>
                        </possible-match>
                    </enquiry-report>
                </response>
      </BCAservice-data>
    </BCAservice>
  </BCAservices>
</BCAmessage>
''';
}
else if ('Testss'.equals(firstName.toUpperCase())) {
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
                            <error-type code="FR">Validation</error-type>
                            <input-container>File Request</input-container>
                            <error-description code="BANF">File Not Returned - Ban Period In Effect - Initial - 31/03/2014</error-description>
                        </error>
                    </response>
          </BCAservice-data>
        </BCAservice>
      </BCAservices>
    </BCAmessage>
    '''
}
else if ('TESTONE'.equals(firstName.toUpperCase())) {
responseStr = '''
<BCAmessage type="RESPONSE" service-request-id="00000951742">
  <BCAservices>
    <BCAservice>
      <BCAservice-code>BCA001</BCAservice-code>
      <BCAservice-code-version>V00</BCAservice-code-version>
      <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
      <BCAservice-data>
                <response version="1-36-0">
                    <enquiry-report>
                        <primary-match type="strong">
                            <bureau-reference>165081850</bureau-reference>
                            <individual>
                                <individual-name create-date="2000-08-28">
                                    <family-name>PETERSEN</family-name>
                                    <first-given-name>LOUISE</first-given-name>
                                    <other-given-name>JULIE</other-given-name>
                                </individual-name>
                                <gender type="female"/>
                                <date-of-birth>1945-06-03</date-of-birth>
                                <drivers-licence-number>864788GH</drivers-licence-number>
                                <address type="residential-current" create-date="2001-06-15">
                                    <unit-number>12</unit-number>
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>NORTH SYDNEY</suburb>
                                    <state>NSW</state>
                                    <postcode>2060</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <employment create-date="2008-02-21">
                                    <employer>EMPLOYER</employer>
                                </employment>
                            </individual>
                            <individual-consumer-credit-file>
                                <individual-cross-reference create-date="2001-06-15">
                                    <bureau-reference>175664691</bureau-reference>
                                    <individual-name>
                                        <family-name>TEST</family-name>
                                        <first-given-name>MELISSA</first-given-name>
                                        <other-given-name>JANE</other-given-name>
                                    </individual-name>
                                </individual-cross-reference>
                                <file-note date-recorded="2007-06-15">THIS IS A TEST FILES WITH ALL SEGMENTS</file-note>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-25">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>19840</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ B2BAY TEST CODE</credit-enquirer>
                                    <client-reference>VEDAAID-006</client-reference>
                                </credit-enquiry>
                            </individual-consumer-credit-file>
                            <individual-public-data-file>                             
                                <court-action type="default-judgement">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>ALLIANZ</creditor>
                                    <court-action-amount>5000</court-action-amount>
                                    <plaint-number>2356897/99/ACTM</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                    <court-action-status date="2005-03-16" code="P">Paid</court-action-status>
                                </court-action>
                            </individual-public-data-file>
                        </primary-match>
                        <summary-data>
                            <summary name="total-enquiries" type="count">0</summary>                            
                        </summary-data>
                    </enquiry-report>
                </response>
      </BCAservice-data>
    </BCAservice>
  </BCAservices>
</BCAmessage>
'''
}
else if ('TESTTWO'.equals(firstName.toUpperCase())) {
    responseStr = '''
<BCAmessage type="RESPONSE" service-request-id="00000951742">
  <BCAservices>
    <BCAservice>
      <BCAservice-code>BCA001</BCAservice-code>
      <BCAservice-code-version>V00</BCAservice-code-version>
      <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
      <BCAservice-data>
                <response version="1-36-0">
                    <enquiry-report>
                        <primary-match type="strong">
                            <bureau-reference>165081850</bureau-reference>
                            <individual>
                                <individual-name create-date="2000-08-28">
                                    <family-name>PETERSEN</family-name>
                                    <first-given-name>LOUISE</first-given-name>
                                    <other-given-name>JULIE</other-given-name>
                                </individual-name>
                                <gender type="female"/>
                                <date-of-birth>1945-06-03</date-of-birth>
                                <drivers-licence-number>864788GH</drivers-licence-number>
                                <address type="residential-current" create-date="2001-06-15">
                                    <unit-number>12</unit-number>
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>NORTH SYDNEY</suburb>
                                    <state>NSW</state>
                                    <postcode>2060</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <employment create-date="2008-02-21">
                                    <employer>EMPLOYER</employer>
                                </employment>
                            </individual>
                            <individual-public-data-file>     
                                <directorship type="current">
                                    <date-appointed>1999-01-01</date-appointed>
                                    <organisation>
                                        <bureau-reference>165968358</bureau-reference>
                                        <organisation-name>MELISSA'S SWEAT SHOP</organisation-name>
                                        <organisation-type code="P/L"/>
                                    </organisation>
                                </directorship>                        
                                <court-action type="court-writ">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>ALLIANZ</creditor>
                                    <court-action-amount>5000</court-action-amount>
                                    <plaint-number>2356897/99/ACTM</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                    <court-action-status date="2005-03-16" code="P">Paid</court-action-status>
                                </court-action>
                                <court-action type="court-summons">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>ALLIANZ</creditor>
                                    <court-action-amount>5000</court-action-amount>
                                    <plaint-number>2356897/99/ACTM</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                    <court-action-status date="2005-03-16" code="P">Paid</court-action-status>
                                </court-action>
                            </individual-public-data-file>
                        </primary-match>
                        <possible-match>
                            <bureau-reference>172568458</bureau-reference>
                        </possible-match>
                        <summary-data>
                            <summary name="total-enquiries" type="count">0</summary>                            
                        </summary-data>
                    </enquiry-report>
                </response>
      </BCAservice-data>
    </BCAservice>
  </BCAservices>
</BCAmessage>
'''
}
else if ('TESTTHREE'.equals(firstName.toUpperCase())) {
    responseStr = '''
<BCAmessage type="RESPONSE" service-request-id="00000951742">
  <BCAservices>
    <BCAservice>
      <BCAservice-code>BCA001</BCAservice-code>
      <BCAservice-code-version>V00</BCAservice-code-version>
      <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
      <BCAservice-data>
                <response version="1-36-0">
                    <enquiry-report>
                        <primary-match type="strong">
                            <bureau-reference>165081850</bureau-reference>
                            <individual>
                                <individual-name create-date="2000-08-28">
                                    <family-name>PETERSEN</family-name>
                                    <first-given-name>LOUISE</first-given-name>
                                    <other-given-name>JULIE</other-given-name>
                                </individual-name>
                                <gender type="female"/>
                                <date-of-birth>1945-06-03</date-of-birth>
                                <drivers-licence-number>864788GH</drivers-licence-number>
                                <address type="residential-current" create-date="2001-06-15">
                                    <unit-number>12</unit-number>
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>NORTH SYDNEY</suburb>
                                    <state>NSW</state>
                                    <postcode>2060</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <employment create-date="2008-02-21">
                                    <employer>EMPLOYER</employer>
                                </employment>
                            </individual>
                            <individual-public-data-file>
                                <bankruptcy>
                                    <bankruptcy-type code="C">Arrangement</bankruptcy-type>
                                    <date-declared>2006-03-16</date-declared>
                                    <narrative>FRANKS TRUSTEES</narrative>
                                    <proceedings>
                                        <state>NSW</state>
                                        <year>2000</year>
                                        <number>12356789</number>
                                        <proceedings-status type="part 10"/>
                                    </proceedings>
                                    <discharge-status type="not-discharged-not-completed"/>
                                    <role type="principal"/>
                                </bankruptcy>
                                <court-action type="default-judgement">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>ALLIANZ</creditor>
                                    <court-action-amount>5000</court-action-amount>
                                    <plaint-number>2356897/99/ACTM</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                    <court-action-status date="2005-03-16" code="A">Paid</court-action-status>
                                </court-action>                    
                                <court-action type="court-writ">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>ALLIANZ</creditor>
                                    <court-action-amount>5000</court-action-amount>
                                    <plaint-number>2356897/99/ACTM</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                    <court-action-status date="2005-03-16" code="A">Paid</court-action-status>
                                </court-action>
                                <court-action type="court-summons">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>ALLIANZ</creditor>
                                    <court-action-amount>5000</court-action-amount>
                                    <plaint-number>2356897/99/ACTM</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                </court-action>
                            </individual-public-data-file>
                        </primary-match>
                    </enquiry-report>
                </response>
      </BCAservice-data>
    </BCAservice>
  </BCAservices>
</BCAmessage>
'''
}
else if ('TESTFOUR'.equals(firstName.toUpperCase())) {
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
                            <error-type code="FR">Validation</error-type>
                            <input-container>File Request</input-container>
                            <error-description code="BANF">File Not Returned - Ban Period In Effect - Extension - 30/04/2014</error-description>
                        </error>
                    </response>
          </BCAservice-data>
        </BCAservice>
      </BCAservices>
    </BCAmessage>
    '''
}
else if ('TESTFIVE'.equals(firstName.toUpperCase())) {
    responseStr = '''
    <BCAmessage type="RESPONSE" service-request-id="00000951742">
      <BCAservices>
        <BCAservice>
          <BCAservice-code>BCA001</BCAservice-code>
          <BCAservice-code-version>V00</BCAservice-code-version>
          <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
          <BCAservice-data>
                <response version="1-36-0">
                    <enquiry-report>
                        <primary-match type="strong">
                            <bureau-reference>165081850</bureau-reference>
                            <individual>
                                <individual-name create-date="2000-08-28">
                                    <family-name>PETERSEN</family-name>
                                    <first-given-name>LOUISE</first-given-name>
                                    <other-given-name>JULIE</other-given-name>
                                </individual-name>
                                <gender type="female"/>
                                <date-of-birth>1945-06-03</date-of-birth>
                                <drivers-licence-number>864788GH</drivers-licence-number>
                                <address type="residential-current" create-date="2001-06-15">
                                    <unit-number>12</unit-number>
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>NORTH SYDNEY</suburb>
                                    <state>NSW</state>
                                    <postcode>2060</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <employment create-date="2008-02-21">
                                    <employer>EMPLOYER</employer>
                                </employment>
                            </individual>
                            <individual-consumer-credit-file>
                                <individual-cross-reference create-date="2001-06-15">
                                    <bureau-reference>175664691</bureau-reference>
                                    <individual-name>
                                        <family-name>TEST</family-name>
                                        <first-given-name>MELISSA</first-given-name>
                                        <other-given-name>JANE</other-given-name>
                                    </individual-name>
                                </individual-cross-reference>
                                <file-note date-recorded="2007-06-15">THIS IS A TEST FILES WITH ALL SEGMENTS</file-note>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-25">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>19840</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ B2BAY TEST CODE</credit-enquirer>
                                    <client-reference>VEDAAID-006</client-reference>
                                </credit-enquiry>
                            </individual-consumer-credit-file>
                        </primary-match>
                        <summary-data>
                            <summary name="total-enquiries" type="count">0</summary>                            
                        </summary-data>
                    </enquiry-report>
                </response>
          </BCAservice-data>
        </BCAservice>
      </BCAservices>
    </BCAmessage>
    '''
}
else if ('CAASANDRA'.equals(firstName.toUpperCase())) {
    responseStr = '''
    <BCAmessage type="RESPONSE" service-request-id="00000951742">
      <BCAservices>
        <BCAservice>
          <BCAservice-code>BCA001</BCAservice-code>
          <BCAservice-code-version>V00</BCAservice-code-version>
          <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
          <BCAservice-data>
                <response version="1-36-0">
                    <enquiry-report>
                        <primary-match type="strong">
                            <bureau-reference>165081850</bureau-reference>
							<individual-consumer-credit-file>
                                <default>
                                    <account-details>
                                        <account-type code="TC">Telecommunications Services</account-type>
                                        <client-reference>9387298175987</client-reference>
                                        <role type="principal"/>
                                        <default-status date="2006-03-16" code="P">P</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2006-01-21</date-recorded>
                                        <default-amount>5000</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>TELSTRA</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2006-01-21</date-recorded>
                                        <default-amount>500</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>TELSTRA</credit-provider>
                                    </current-default>
                                </default>								
							</individual-consumer-credit-file>
							<individual-public-data-file>							
								<court-action type="default-judgement">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>ALLIANZ</creditor>
                                    <court-action-amount>5000</court-action-amount>
                                    <plaint-number>2356897/99/ACTM</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                    <court-action-status date="2005-03-16" code="P">Paid</court-action-status>
                                </court-action>
								<court-action type="court-writ">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>ALLIANZ</creditor>
                                    <court-action-amount>5000</court-action-amount>
                                    <plaint-number>2356897/99/ACTM</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                    <court-action-status date="2005-03-16" code="U">Paid</court-action-status>
                                </court-action>							
							</individual-public-data-file>
                        </primary-match>
                    </enquiry-report>
                </response>
          </BCAservice-data>
        </BCAservice>
      </BCAservices>
    </BCAmessage>
    '''
}
else if ('PAUL'.equals(firstName.toUpperCase())) {
    responseStr = '''
    <BCAmessage type="RESPONSE" service-request-id="00000951742">
      <BCAservices>
        <BCAservice>
          <BCAservice-code>BCA001</BCAservice-code>
          <BCAservice-code-version>V00</BCAservice-code-version>
          <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
          <BCAservice-data>
                <response version="1-36-0">
                    <enquiry-report>
                        <primary-match type="strong">
                            <bureau-reference>165081850</bureau-reference>
							<individual-public-data-file>							
								<court-action type="default-judgement">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>ALLIANZ</creditor>
                                    <court-action-amount>5000</court-action-amount>
                                    <plaint-number>2356897/99/ACTM</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                    <court-action-status date="2005-03-16" code="U">Paid</court-action-status>
                                </court-action>
								<court-action type="court-writ">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>ALLIANZ</creditor>
                                    <court-action-amount>5000</court-action-amount>
                                    <plaint-number>2356897/99/ACTM</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                    <court-action-status date="2005-03-16" code="P">Paid</court-action-status>
                                </court-action>							
							</individual-public-data-file>
                        </primary-match>
                    </enquiry-report>
                </response>
          </BCAservice-data>
        </BCAservice>
      </BCAservices>
    </BCAmessage>
    '''
}
else if ('HAYLEY-D'.equals(firstName.toUpperCase())) {
    responseStr = '''
    <BCAmessage type="RESPONSE" service-request-id="00000951742">
  <BCAservices>
    <BCAservice>
      <BCAservice-code>BCA001</BCAservice-code>
      <BCAservice-code-version>V00</BCAservice-code-version>
      <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
	  <BCAservice-data>
				<response version="1-36-0">
					<enquiry-report>
						<primary-match type="strong">
							<bureau-reference>165081850</bureau-reference>
							<individual>
								<individual-name create-date="2000-08-28">
									<family-name>PETERSEN</family-name>
									<first-given-name>LOUISE</first-given-name>
									<other-given-name>JULIE</other-given-name>
								</individual-name>
								<gender type="female" />
								<date-of-birth>1945-06-03</date-of-birth>
								<drivers-licence-number>864788GH</drivers-licence-number>
								<address type="residential-current" create-date="2001-06-15">
									<unit-number>12</unit-number>
									<street-number>90</street-number>
									<street-name>ARTHUR</street-name>
									<street-type code="ST" />
									<suburb>NORTH SYDNEY</suburb>
									<state>NSW</state>
									<postcode>2060</postcode>
									<country country-code="AU" />
								</address>
								<address type="residential-previous" create-date="2000-08-28">
									<street-number>98</street-number>
									<street-name>NORTH</street-name>
									<street-type code="RD" />
									<suburb>ABBOTSFORD</suburb>
									<state>NSW</state>
									<postcode>2046</postcode>
									<country country-code="AU" />
								</address>
								<employment create-date="2008-02-21">
									<employer>EMPLOYER</employer>
								</employment>
							</individual>
							count(//individual-consumer-credit-file/default/account-details/default-status[@code = \"P\"])
							<individual-consumer-credit-file>
								<default>
									<account-details>
										<account-type code="RM">Real Property Mortgage</account-type>
										<client-reference>165081850</client-reference>
										<role type="principal" />
										<default-status>Outstanding</default-status>
									</account-details>
									<original-default>
										<date-recorded>2008-02-19</date-recorded>
										<default-amount>150</default-amount>
										<reason-to-report code="PD">Payment Default</reason-to-report>
										<credit-provider>ANZ BANK TEST CODE</credit-provider>
									</original-default>
									<current-default>
										<date-recorded>2008-02-19</date-recorded>
										<default-amount>150</default-amount>
										<reason-to-report code="PD">Payment Default</reason-to-report>
										<credit-provider>ANZ BANK TEST CODE</credit-provider>
									</current-default>
								</default>
								<default>
									<account-details>
										<account-type code="R">Equipment Hire or Rental</account-type>
										<client-reference>000222</client-reference>
										<role type="principal" />
										<default-status date="2006-03-16" code="C">Current</default-status>
									</account-details>
									<original-default>
										<date-recorded>2006-03-16</date-recorded>
										<default-amount>630</default-amount>
										<reason-to-report code="PD">Payment Default</reason-to-report>
										<credit-provider>CRAA TEST FILES</credit-provider>
									</original-default>
									<current-default>
										<date-recorded>2006-03-16</date-recorded>
										<default-amount>630</default-amount>
										<reason-to-report code="PD">Payment Default</reason-to-report>
										<credit-provider>CRAA TEST FILES</credit-provider>
									</current-default>
								</default>
								<default>
									<account-details>
										<account-type code="TC">Telecommunications Services</account-type>
										<client-reference>9387298175987</client-reference>
										<role type="principal" />
										<default-status>Outstanding</default-status>
									</account-details>
									<original-default>
										<date-recorded>2006-01-21</date-recorded>
										<default-amount>500</default-amount>
										<reason-to-report code="PD">Payment Default</reason-to-report>
										<credit-provider>TELSTRA</credit-provider>
									</original-default>
									<current-default>
										<date-recorded>2006-01-21</date-recorded>
										<default-amount>500</default-amount>
										<reason-to-report code="PD">Payment Default</reason-to-report>
										<credit-provider>TELSTRA</credit-provider>
									</current-default>
								</default>
								<default>
									<account-details>
										<account-type code="R">Equipment Hire or Rental</account-type>
										<client-reference>000222</client-reference>
										<role type="principal" />
										<default-status date="2006-03-16" code="D">Disputed</default-status>
									</account-details>
									<original-default>
										<date-recorded>2006-03-16</date-recorded>
										<default-amount>630</default-amount>
										<reason-to-report code="PD">Payment Default</reason-to-report>
										<credit-provider>CRAA TEST FILES</credit-provider>
									</original-default>
									<current-default>
										<date-recorded>2006-03-16</date-recorded>
										<default-amount>630</default-amount>
										<reason-to-report code="PD">Payment Default</reason-to-report>
										<credit-provider>CRAA TEST FILES</credit-provider>
									</current-default>
								</default>
								<default>
									<account-details>
										<account-type code="R">Equipment Hire or Rental</account-type>
										<client-reference>000222</client-reference>
										<role type="principal" />
										<default-status date="2006-03-16" code="S">Settled</default-status>
									</account-details>
									<original-default>
										<date-recorded>2006-03-16</date-recorded>
										<default-amount>630</default-amount>
										<reason-to-report code="PD">Payment Default</reason-to-report>
										<credit-provider>CRAA TEST FILES</credit-provider>
									</original-default>
									<current-default>
										<date-recorded>2006-03-16</date-recorded>
										<default-amount>630</default-amount>
										<reason-to-report code="PD">Payment Default</reason-to-report>
										<credit-provider>CRAA TEST FILES</credit-provider>
									</current-default>
								</default>
								<default>
									<account-details>
										<account-type code="R">Equipment Hire or Rental</account-type>
										<client-reference>000222</client-reference>
										<role type="principal" />
										<default-status date="2006-03-16" code="P">Paid</default-status>
									</account-details>
									<original-default>
										<date-recorded>2006-03-16</date-recorded>
										<default-amount>630</default-amount>
										<reason-to-report code="PD">Payment Default</reason-to-report>
										<credit-provider>CRAA TEST FILES</credit-provider>
									</original-default>
									<current-default>
										<date-recorded>2006-03-16</date-recorded>
										<default-amount>630</default-amount>
										<reason-to-report code="PD">Payment Default</reason-to-report>
										<credit-provider>CRAA TEST FILES</credit-provider>
									</current-default>
								</default>								
								<file-note date-recorded="2007-06-15">THIS IS A TEST FILES WITH ALL SEGMENTS</file-note>
								<file-note date-recorded="2007-06-15">IF I INCLUDE SOME MORE TEXT THEN THIS WILL BE A VERY LONG</file-note>
								<file-note date-recorded="2007-06-15">NARRATIVE AND THEREFORE BE A VERY LARGE FILE THAT RETURNS</file-note>
								<file-note date-recorded="2007-06-15">A LOT OF CHARACTERS WHEN REQUESTED.</file-note>
								<file-note date-recorded="2007-06-15">THIS WILL HAVE A LOT OF NONSENSE IN ORDER TO BE LONGER THAN</file-note>
								<file-note date-recorded="2007-06-15">NORMAL SO EXPECT OT SEE JUNBK IN HERE THAT DOERSN'T MAKE ANY</file-note>
								<file-note date-recorded="2007-06-15">SENSE AND SO THEREFORE IT COULD LEAD TO BEING BORED BEFORE YOU</file-note>
								<file-note date-recorded="2007-06-15">GET TO THE END OF THE TEXT THAT IS WRITTEN HERE.</file-note>
								<file-note date-recorded="2007-06-15">THE VALUE OF THIS IS IN THE BEHOLDER WHO IS EXPECTING BIG</file-note>
								<file-note date-recorded="2007-06-15">THINGS FROM LITTLE REQUESTS. CAN THIS BE LONG ENOUGH TO</file-note>
								<file-note date-recorded="2007-06-15">SATISFY EVEN THE MOST DEMANDING? GOOD QUESTION AND I WILL TRY</file-note>
								<file-note date-recorded="2007-06-15">TO ANSWER THIS AS BEST I CAN BY TYPING AWAY TO PRODUCE SOME</file-note>
								<file-note date-recorded="2007-06-15">REALLY CLEVER TEXT THAT WILL BE RETURNED IN THE NEXT RESPONSE</file-note>
								<file-note date-recorded="2007-06-15">THAT IS SENT OUT TO THE CUSTOMERS.</file-note>
								<credit-enquiry type="credit-application" enquiry-date="2009-02-25">
									<account-type code="LC">Loan Contract</account-type>
									<enquiry-amount>19840</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>ANZ B2BAY TEST CODE</credit-enquirer>
									<client-reference>VEDAAID-006</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2009-02-24">
									<account-type code="OD">Overdraft</account-type>
									<enquiry-amount>3000</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>DS TEST 2</credit-enquirer>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2009-02-24">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>200000</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>MOBIUS FINANCIAL PROCESSING</credit-enquirer>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-04-28">
									<account-type code="UA">Utilities</account-type>
									<enquiry-amount>2500</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>RETAILEASE P/L</credit-enquirer>
									<client-reference>CREF1</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-03-12">
									<account-type code="UA">Utilities</account-type>
									<enquiry-amount>1300</enquiry-amount>
									<role type="joint" />
									<credit-enquirer>PROJECT IMPLEMENTATION TEAM</credit-enquirer>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-03-06">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>250000</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>AFIG WHOLSALE</credit-enquirer>
									<client-reference>1162000 1</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-03-05">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>300000</enquiry-amount>
									<role type="joint" />
									<credit-enquirer>AFIG WHOLSALE</credit-enquirer>
									<client-reference>1162397 1</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-03-03">
									<account-type code="UA">Utilities</account-type>
									<enquiry-amount>1300</enquiry-amount>
									<role type="joint" />
									<credit-enquirer>PROJECT IMPLEMENTATION TEAM</credit-enquirer>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-27">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>250000</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>AFIG WHOLSALE</credit-enquirer>
									<client-reference>1162000 1</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-27">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>0</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>AFIG WHOLSALE</credit-enquirer>
									<client-reference>0 0</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-26">
									<account-type code="TC">Telecommunications Services</account-type>
									<enquiry-amount>0</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>CRAZY JOHNS</credit-enquirer>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-22">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>300000</enquiry-amount>
									<role type="joint" />
									<credit-enquirer>AFIG WHOLSALE</credit-enquirer>
									<client-reference>1161677 1</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-21">
									<account-type code="LC">Loan Contract</account-type>
									<enquiry-amount>0</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>FLEXIRENT TEST *</credit-enquirer>
									<client-reference>785649-437275</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-20">
									<account-type code="LC">Loan Contract</account-type>
									<enquiry-amount>10149</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>POLICE &amp; NURSES C/S SODP</credit-enquirer>
									<client-reference>3000381</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-20">
									<account-type code="LC">Loan Contract</account-type>
									<enquiry-amount>30222</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>POLICE &amp; NURSES C/S SODP</credit-enquirer>
									<client-reference>3000378</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-19">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>100</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>ANZ BANK TEST CODE</credit-enquirer>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-18">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>55000</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>AFIG WHOLSALE</credit-enquirer>
									<client-reference>1161860 1</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-18">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>200000</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>AFIG WHOLSALE</credit-enquirer>
									<client-reference>1161815 1</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-18">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>250000</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>AFIG WHOLSALE</credit-enquirer>
									<client-reference>1161908 1</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-13">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>0</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>AFIG WHOLSALE</credit-enquirer>
									<client-reference>0 0</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-12">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>300000</enquiry-amount>
									<role type="joint" />
									<credit-enquirer>AFIG WHOLSALE</credit-enquirer>
									<client-reference>1161677 1</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-12">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>125000</enquiry-amount>
									<role type="joint" />
									<credit-enquirer>AFIG WHOLSALE</credit-enquirer>
									<client-reference>CR123 2</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2008-02-12">
									<account-type code="RM">Real Property Mortgage</account-type>
									<enquiry-amount>250000</enquiry-amount>
									<role type="joint" />
									<credit-enquirer>AFIG WHOLSALE</credit-enquirer>
									<client-reference>1162021 1</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2001-11-13">
									<account-type code="LC">Loan Contract</account-type>
									<enquiry-amount>42000</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>ANZ BANK TEST CODE</credit-enquirer>
									<client-reference>4604</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2001-07-20">
									<account-type code="T">Terms</account-type>
									<enquiry-amount>20000</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>DP CORE TEST</credit-enquirer>
									<client-reference>200107204267105</client-reference>
								</credit-enquiry>
								<credit-enquiry type="credit-application" enquiry-date="2001-01-23">
									<account-type code="CC">Continuing Credit Contract</account-type>
									<enquiry-amount>200</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>VODAFONE NSW</credit-enquirer>
									<client-reference>00023229</client-reference>
								</credit-enquiry>
								<credit-enquiry type="authorised-agent-enquiry" enquiry-date="2001-06-15">
									<account-type code="CC">Continuing Credit Contract</account-type>
									<enquiry-amount>30000</enquiry-amount>
									<role type="principal" />
									<credit-enquirer>PHIL MCCARROLL FORD</credit-enquirer>
								</credit-enquiry>
							</individual-consumer-credit-file>
							<individual-public-data-file>
								<disqualified-directorship>
									<date-disqualified>2008-02-21</date-disqualified>
									<date-disqualified-until>2010-02-21</date-disqualified-until>
								</disqualified-directorship>
								<file-message>DISQUALIFIED DIRECTOR DETAILS WERE OBTAINED FROM THE ASIC UNDER</file-message>
								<file-message>SECTION 3 SUB SECTION 243</file-message>
								<proprietorship>
									<date-appointed>2001-03-16</date-appointed>
									<business>
										<bureau-reference>165289307</bureau-reference>
										<business-name>MARYS MAX SHOES</business-name>
									</business>
								</proprietorship>																
							</individual-public-data-file>
						</primary-match>
					</enquiry-report>
				</response>
	  </BCAservice-data>
    </BCAservice>
  </BCAservices>
</BCAmessage>
    '''
}
else if (firstName.toUpperCase().equals("RODNEY")) {
responseStr = '''
<BCAmessage type="RESPONSE" service-request-id="00000951742">
  <BCAservices>
    <BCAservice>
      <BCAservice-code>BCA001</BCAservice-code>
      <BCAservice-code-version>V00</BCAservice-code-version>
      <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
      <BCAservice-data>
                <response version="1-36-0">
                    <enquiry-report>
                        <primary-match type="strong">
                            <bureau-reference>165081850</bureau-reference>
                            <individual>
                                <individual-name create-date="2000-08-28">
                                    <family-name>JANE</family-name>
                                    <first-given-name>JESSE</first-given-name>                                  
                                </individual-name>
                                <gender type="female"/>
                                <date-of-birth>1945-06-03</date-of-birth>
                                <drivers-licence-number>864788GH</drivers-licence-number>
                                <address type="residential-current" create-date="2001-06-15">
                                    <unit-number>12</unit-number>
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>NORTH SYDNEY</suburb>
                                    <state>NSW</state>
                                    <postcode>2060</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <address type="residential-previous" create-date="2000-08-28">
                                    <street-number>98</street-number>
                                    <street-name>NORTH</street-name>
                                    <street-type code="RD"/>
                                    <suburb>ABBOTSFORD</suburb>
                                    <state>NSW</state>
                                    <postcode>2046</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <employment create-date="2008-02-21">
                                    <employer>EMPLOYER</employer>
                                </employment>
                            </individual>
                            <individual-consumer-credit-file>
                                <individual-cross-reference create-date="2001-06-15">
                                    <bureau-reference>175664691</bureau-reference>
                                    <individual-name>
                                        <family-name>TEST</family-name>
                                        <first-given-name>MELISSA</first-given-name>
                                        <other-given-name>JANE</other-given-name>
                                    </individual-name>
                                </individual-cross-reference>
                                <default>
                                    <account-details>
                                        <account-type code="RM">Real Property Mortgage</account-type>
                                        <client-reference>165081850</client-reference>
                                        <role type="principal"/>
                                        <default-status>Outstanding</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2008-02-19</date-recorded>
                                        <default-amount>150</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>ANZ BANK TEST CODE</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2008-02-19</date-recorded>
                                        <default-amount>150</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>ANZ BANK TEST CODE</credit-provider>
                                    </current-default>
                                </default>
                                <default>
                                    <account-details>
                                        <account-type code="R">Equipment Hire or Rental</account-type>
                                        <client-reference>000222</client-reference>
                                        <role type="principal"/>
                                        <default-status date="2006-03-16" code="C">Current</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2006-03-16</date-recorded>
                                        <default-amount>630</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>CRAA TEST FILES</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2006-03-16</date-recorded>
                                        <default-amount>630</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>CRAA TEST FILES</credit-provider>
                                    </current-default>
                                </default>
                                <default>
                                    <account-details>
                                        <account-type code="TC">Telecommunications Services</account-type>
                                        <client-reference>9387298175987</client-reference>
                                        <role type="principal"/>
                                        <default-status date="2006-03-16" code="P">P</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2006-01-21</date-recorded>
                                        <default-amount>500</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>TELSTRA</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2006-01-21</date-recorded>
                                        <default-amount>500</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>TELSTRA</credit-provider>
                                    </current-default>
                                </default>
                                <file-note date-recorded="2007-06-15">THIS IS A TEST FILES WITH ALL SEGMENTS</file-note>
                                <file-note date-recorded="2007-06-15">IF I INCLUDE SOME MORE TEXT THEN THIS WILL BE A VERY LONG</file-note>
                                <file-note date-recorded="2007-06-15">NARRATIVE AND THEREFORE BE A VERY LARGE FILE THAT RETURNS</file-note>
                                <file-note date-recorded="2007-06-15">A LOT OF CHARACTERS WHEN REQUESTED.</file-note>
                                <file-note date-recorded="2007-06-15">THIS WILL HAVE A LOT OF NONSENSE IN ORDER TO BE LONGER THAN</file-note>
                                <file-note date-recorded="2007-06-15">NORMAL SO EXPECT OT SEE JUNBK IN HERE THAT DOERSN'T MAKE ANY</file-note>
                                <file-note date-recorded="2007-06-15">SENSE AND SO THEREFORE IT COULD LEAD TO BEING BORED BEFORE YOU</file-note>
                                <file-note date-recorded="2007-06-15">GET TO THE END OF THE TEXT THAT IS WRITTEN HERE.</file-note>
                                <file-note date-recorded="2007-06-15">THE VALUE OF THIS IS IN THE BEHOLDER WHO IS EXPECTING BIG</file-note>
                                <file-note date-recorded="2007-06-15">THINGS FROM LITTLE REQUESTS. CAN THIS BE LONG ENOUGH TO</file-note>
                                <file-note date-recorded="2007-06-15">SATISFY EVEN THE MOST DEMANDING? GOOD QUESTION AND I WILL TRY</file-note>
                                <file-note date-recorded="2007-06-15">TO ANSWER THIS AS BEST I CAN BY TYPING AWAY TO PRODUCE SOME</file-note>
                                <file-note date-recorded="2007-06-15">REALLY CLEVER TEXT THAT WILL BE RETURNED IN THE NEXT RESPONSE</file-note>
                                <file-note date-recorded="2007-06-15">THAT IS SENT OUT TO THE CUSTOMERS.</file-note>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-25">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>19840</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ B2BAY TEST CODE</credit-enquirer>
                                    <client-reference>VEDAAID-006</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-24">
                                    <account-type code="OD">Overdraft</account-type>
                                    <enquiry-amount>3000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>DS TEST 2</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-24">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>200000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>MOBIUS FINANCIAL PROCESSING</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-04-28">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>2500</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>RETAILEASE P/L</credit-enquirer>
                                    <client-reference>CREF1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-12">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>1300</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>PROJECT IMPLEMENTATION TEAM</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-06">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162000 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-05">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162397 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-03">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>1300</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>PROJECT IMPLEMENTATION TEAM</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-27">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162000 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-27">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>0 0</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-26">
                                    <account-type code="TC">Telecommunications Services</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>CRAZY JOHNS</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-22">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161677 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-21">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>FLEXIRENT TEST *</credit-enquirer>
                                    <client-reference>785649-437275</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-20">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>10149</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>POLICE &amp; NURSES C/S SODP</credit-enquirer>
                                    <client-reference>3000381</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-20">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>30222</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>POLICE &amp; NURSES C/S SODP</credit-enquirer>
                                    <client-reference>3000378</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-19">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>100</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ BANK TEST CODE</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>55000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161860 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>200000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161815 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161908 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-13">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>0 0</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161677 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>125000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>CR123 2</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162021 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-11-13">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>42000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ BANK TEST CODE</credit-enquirer>
                                    <client-reference>4604</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-07-20">
                                    <account-type code="T">Terms</account-type>
                                    <enquiry-amount>20000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>DP CORE TEST</credit-enquirer>
                                    <client-reference>200107204267105</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-01-23">
                                    <account-type code="CC">Continuing Credit Contract</account-type>
                                    <enquiry-amount>200</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>VODAFONE NSW</credit-enquirer>
                                    <client-reference>00023229</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="authorised-agent-enquiry" enquiry-date="2001-06-15">
                                    <account-type code="CC">Continuing Credit Contract</account-type>
                                    <enquiry-amount>30000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>PHIL MCCARROLL FORD</credit-enquirer>
                                </credit-enquiry>
                            </individual-consumer-credit-file>
                            <individual-public-data-file>
                                <disqualified-directorship>
                                    <date-disqualified>2008-02-21</date-disqualified>
                                    <date-disqualified-until>2010-02-21</date-disqualified-until>
                                </disqualified-directorship>
                                <file-message>DISQUALIFIED DIRECTOR DETAILS WERE OBTAINED FROM THE ASIC UNDER</file-message>
                                <file-message>SECTION 3 SUB SECTION 243</file-message>
                                <directorship type="current">
                                    <date-appointed>1999-01-01</date-appointed>
                                    <organisation>
                                        <bureau-reference>165968358</bureau-reference>
                                        <organisation-name>MELISSA'S SWEAT SHOP</organisation-name>
                                        <organisation-type code="P/L"/>
                                    </organisation>
                                </directorship>
                                <directorship type="previous">
                                    <date-appointed>2005-01-21</date-appointed>
                                    <date-ceased>2007-03-21</date-ceased>
                                    <date-last-known-as-director>2007-03-21</date-last-known-as-director>
                                    <organisation>
                                        <bureau-reference>166368656</bureau-reference>
                                        <organisation-name>MULLIGANS FOOD</organisation-name>
                                        <organisation-type code="P/L"/>
                                        <organisation-number>000309786</organisation-number>
                                    </organisation>
                                </directorship>
                                <proprietorship>
                                    <date-appointed>2001-03-16</date-appointed>
                                    <business>
                                        <bureau-reference>165289307</bureau-reference>
                                        <business-name>MARYS MAX SHOES</business-name>
                                    </business>
                                </proprietorship>
                                <bankruptcy>
                                    <bankruptcy-type code="D">Arrangement</bankruptcy-type>
                                    <date-declared>2006-03-16</date-declared>
                                    <narrative>FRANKS TRUSTEES</narrative>
                                    <proceedings>
                                        <state>NSW</state>
                                        <year>2000</year>
                                        <number>12356789</number>
                                        <proceedings-status type="part 10"/>
                                    </proceedings>
                                    <discharge-status type="not-discharged-not-completed"/>
                                    <role type="principal"/>
                                </bankruptcy>
                                <bankruptcy>
                                    <bankruptcy-type code="B">Bankruptcy (Debtors Petition)</bankruptcy-type>
                                    <date-declared>2005-01-21</date-declared>
                                    <narrative>DEBTORS PETITION</narrative>
                                    <proceedings>
                                        <state>NSW</state>
                                        <year>2001</year>
                                        <number>47384758</number>
                                    </proceedings>
                                    <discharge-status type="not-discharged-not-completed"/>
                                    <role type="principal"/>
                                </bankruptcy>
                                <bankruptcy>
                                    <bankruptcy-type code="B">Bankruptcy (Debtors Petition)</bankruptcy-type>
                                    <date-declared>2002-06-19</date-declared>
                                    <narrative>DEBTORS PETITION</narrative>
                                    <proceedings>
                                        <state>NSW</state>
                                        <year>2002</year>
                                        <number>13598777</number>
                                    </proceedings>
                                    <discharge-status date="2015-08-12" type="discharged" />
                                    <role type="principal" />
                                </bankruptcy>
                                <bankruptcy>
                                    <bankruptcy-type code="B">Bankruptcy (Debtors Petition)</bankruptcy-type>
                                    <date-declared>2004-07-15</date-declared>
                                    <narrative>DEBTORS PETITION</narrative>
                                    <proceedings>
                                        <state>NSW</state>
                                        <year>2002</year>
                                        <number>13598778</number>
                                    </proceedings>
                                    <discharge-status date="2004-11-27" type="discharged" />
                                    <role type="principal" />
                                </bankruptcy>
                                <court-action type="default-judgement">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>ALLIANZ</creditor>
                                    <court-action-amount>5000</court-action-amount>
                                    <plaint-number>2356897/99/ACTM</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                    <court-action-status date="2005-03-16" code="P">Paid</court-action-status>
                                </court-action>
                                <court-action type="default-judgement">
                                    <action-date>2005-03-16</action-date>
                                    <creditor>BANKERS MAGAZINE</creditor>
                                    <court-action-amount>200</court-action-amount>
                                    <plaint-number>2345783/00/ACTS</plaint-number>
                                    <court-type>Small Court</court-type>
                                    <role type="principal"/>
                                </court-action>
                                <court-action type="court-writ">
                                    <action-date>2006-06-15</action-date>
                                    <creditor>NATIONAL AUSTRALIA BANK</creditor>
                                    <court-action-amount>4000</court-action-amount>
                                    <plaint-number>8475847/01/QATN</plaint-number>
                                    <court-type>District Court</court-type>
                                    <role type="principal"/>
                                </court-action>
                            </individual-public-data-file>
                        </primary-match>
                        <possible-match>
                            <bureau-reference>172568458</bureau-reference>
                            <individual>
                                <individual-name create-date="2006-11-02">
                                    <family-name>PETERSEN</family-name>
                                    <first-given-name>LOUISE</first-given-name>
                                    <other-given-name>JULIE</other-given-name>
                                </individual-name>
                                <gender type="female"/>
                                <date-of-birth>1945-06-03</date-of-birth>
                                <drivers-licence-number>864788GH</drivers-licence-number>
                                <address type="residential-current" create-date="2008-06-03">
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>O CONNELL</suburb>
                                    <state>NSW</state>
                                    <postcode>2795</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <address type="residential-previous" create-date="2008-05-09">
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>CAMPSIE</suburb>
                                    <state>NSW</state>
                                    <postcode>2194</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <address type="residential-previous" create-date="2008-05-09">
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>GORDON</suburb>
                                    <state>NSW</state>
                                    <postcode>2072</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <employment create-date="2008-04-30">
                                    <employer>HOLIDAY INN AT SURFERS PARADISE</employer>
                                </employment>
                            </individual>
                        </possible-match>
                        <summary-data>
                            <summary currency-code="AUD" name="enquiry-amount" type="amount">0</summary>
                            <summary name="age-of-file" type="months">0</summary>
                            <summary name="age-of-subject" type="years">24</summary>
                            <summary name="time-at-address" type="months">0</summary>
                            <summary name="time-at-employer" type="months"/>
                            <summary name="defaults" type="count">2</summary>
                            <summary currency-code="AUD" name="total-value-of-outstanding-defaults" type="amount">3500</summary>
                            <summary name="defaults-paid" type="count">0</summary>
                            <summary name="defaults-12" type="count">0</summary>
                            <summary name="defaults-12-paid" type="count">0</summary>
                            <summary name="defaults-12-unpaid" type="count">0</summary>
                            <summary name="defaults-24-paid" type="count">0</summary>
                            <summary name="defaults-24-unpaid" type="count">0</summary>
                            <summary name="defaults-36-paid" type="count">0</summary>
                            <summary name="defaults-36-unpaid" type="count">0</summary>
                            <summary name="time-since-last-default" type="months">275</summary>
                            <summary name="total-enquiries" type="count">0</summary>
                            <summary name="enquiries-1" type="count">1</summary>
                            <summary name="enquiries-3" type="count">1</summary>
                            <summary name="enquiries-6" type="count">1</summary>
                            <summary name="enquiries-12" type="count">1</summary>
                            <summary name="enquiries-60" type="count">4</summary>
                            <summary name="time-since-last-enquiry" type="months">12</summary>
                            <summary name="telco-and-utility-defaults" type="count">0</summary>
                            <summary name="telco-and-utility-defaults-12" type="count">0</summary>
                            <summary name="telco-and-utility-enquiries" type="count">0</summary>
                            <summary name="telco-and-utility-enquiries-6" type="count">0</summary>
                            <summary name="telco-and-utility-enquiries-12" type="count">0</summary>
                            <summary name="authorised-agents-enquiries-12" type="count">0</summary>
                            <summary name="authorised-agents-enquiries-60" type="count">0</summary>
                            <summary name="directorships-current" type="count">1</summary>
                            <summary name="directorships-previous" type="count">0</summary>
                            <summary name="judgements" type="count">1</summary>
                            <summary name="proprietorships" type="count">0</summary>
                            <summary name="adverse-on-file">Yes</summary>
                            <summary name="file-notes">No</summary>
                            <summary name="known-identities" type="count">1</summary>
                            <summary name="bankruptcies" type="count">1</summary>
                            <summary name="writs-and-summons" type="count">1</summary>
                            <summary name="external-administration-director" type="count">0</summary>
                        </summary-data>
                    </enquiry-report>
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
      <BCAservice-code>BCA001</BCAservice-code>
      <BCAservice-code-version>V00</BCAservice-code-version>
      <BCAservice-client-ref>800020069#1125542397790</BCAservice-client-ref>
      <BCAservice-data>
                <response version="1-36-0">
                    <enquiry-report>
                        <primary-match type="strong">
                            <bureau-reference>165081850</bureau-reference>
                            <individual>
                                <individual-name create-date="2000-08-28">
                                    <family-name>PETERSEN</family-name>
                                    <first-given-name>LOUISE</first-given-name>
                                    <other-given-name>JULIE</other-given-name>
                                </individual-name>
                                <gender type="female"/>
                                <date-of-birth>1945-06-03</date-of-birth>
                                <drivers-licence-number>864788GH</drivers-licence-number>
                                <address type="residential-current" create-date="2001-06-15">
                                    <unit-number>12</unit-number>
                                    <street-number>90</street-number>
                                    <street-name>ARTHUR</street-name>
                                    <street-type code="ST"/>
                                    <suburb>NORTH SYDNEY</suburb>
                                    <state>NSW</state>
                                    <postcode>2060</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <address type="residential-previous" create-date="2000-08-28">
                                    <street-number>98</street-number>
                                    <street-name>NORTH</street-name>
                                    <street-type code="RD"/>
                                    <suburb>ABBOTSFORD</suburb>
                                    <state>NSW</state>
                                    <postcode>2046</postcode>
                                    <country country-code="AU"/>
                                </address>
                                <employment create-date="2008-02-21">
                                    <employer>EMPLOYER</employer>
                                </employment>
                            </individual>
                            <individual-consumer-credit-file>
                                <default>
                                    <account-details>
                                        <account-type code="RM">Real Property Mortgage</account-type>
                                        <client-reference>165081850</client-reference>
                                        <role type="principal"/>
                                        <default-status>Outstanding</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2008-02-19</date-recorded>
                                        <default-amount>150</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>ANZ BANK TEST CODE</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2008-02-19</date-recorded>
                                        <default-amount>150</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>ANZ BANK TEST CODE</credit-provider>
                                    </current-default>
                                </default>
                                <default>
                                    <account-details>
                                        <account-type code="R">Equipment Hire or Rental</account-type>
                                        <client-reference>000222</client-reference>
                                        <role type="principal"/>
                                        <default-status date="2006-03-16" code="C">Outstanding</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2006-03-16</date-recorded>
                                        <default-amount>630</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>CRAA TEST FILES</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2006-03-16</date-recorded>
                                        <default-amount>630</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>CRAA TEST FILES</credit-provider>
                                    </current-default>
                                </default>
                                <default>
                                    <account-details>
                                        <account-type code="TC">Telecommunications Services</account-type>
                                        <client-reference>9387298175987</client-reference>
                                        <role type="principal"/>
                                        <default-status>Outstanding</default-status>
                                    </account-details>
                                    <original-default>
                                        <date-recorded>2006-01-21</date-recorded>
                                        <default-amount>500</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>TELSTRA</credit-provider>
                                    </original-default>
                                    <current-default>
                                        <date-recorded>2006-01-21</date-recorded>
                                        <default-amount>500</default-amount>
                                        <reason-to-report code="PD">Payment Default</reason-to-report>
                                        <credit-provider>TELSTRA</credit-provider>
                                    </current-default>
                                </default>
                                <file-note date-recorded="2007-06-15">THIS IS A TEST FILES WITH ALL SEGMENTS</file-note>
                                <file-note date-recorded="2007-06-15">IF I INCLUDE SOME MORE TEXT THEN THIS WILL BE A VERY LONG</file-note>
                                <file-note date-recorded="2007-06-15">NARRATIVE AND THEREFORE BE A VERY LARGE FILE THAT RETURNS</file-note>
                                <file-note date-recorded="2007-06-15">A LOT OF CHARACTERS WHEN REQUESTED.</file-note>
                                <file-note date-recorded="2007-06-15">THIS WILL HAVE A LOT OF NONSENSE IN ORDER TO BE LONGER THAN</file-note>
                                <file-note date-recorded="2007-06-15">NORMAL SO EXPECT OT SEE JUNBK IN HERE THAT DOERSN'T MAKE ANY</file-note>
                                <file-note date-recorded="2007-06-15">SENSE AND SO THEREFORE IT COULD LEAD TO BEING BORED BEFORE YOU</file-note>
                                <file-note date-recorded="2007-06-15">GET TO THE END OF THE TEXT THAT IS WRITTEN HERE.</file-note>
                                <file-note date-recorded="2007-06-15">THE VALUE OF THIS IS IN THE BEHOLDER WHO IS EXPECTING BIG</file-note>
                                <file-note date-recorded="2007-06-15">THINGS FROM LITTLE REQUESTS. CAN THIS BE LONG ENOUGH TO</file-note>
                                <file-note date-recorded="2007-06-15">SATISFY EVEN THE MOST DEMANDING? GOOD QUESTION AND I WILL TRY</file-note>
                                <file-note date-recorded="2007-06-15">TO ANSWER THIS AS BEST I CAN BY TYPING AWAY TO PRODUCE SOME</file-note>
                                <file-note date-recorded="2007-06-15">REALLY CLEVER TEXT THAT WILL BE RETURNED IN THE NEXT RESPONSE</file-note>
                                <file-note date-recorded="2007-06-15">THAT IS SENT OUT TO THE CUSTOMERS.</file-note>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-25">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>19840</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ B2BAY TEST CODE</credit-enquirer>
                                    <client-reference>VEDAAID-006</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-24">
                                    <account-type code="OD">Overdraft</account-type>
                                    <enquiry-amount>3000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>DS TEST 2</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2009-02-24">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>200000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>MOBIUS FINANCIAL PROCESSING</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-04-28">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>2500</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>RETAILEASE P/L</credit-enquirer>
                                    <client-reference>CREF1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-12">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>1300</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>PROJECT IMPLEMENTATION TEAM</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-06">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162000 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-05">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162397 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-03-03">
                                    <account-type code="UA">Utilities</account-type>
                                    <enquiry-amount>1300</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>PROJECT IMPLEMENTATION TEAM</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-27">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162000 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-27">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>0 0</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-26">
                                    <account-type code="TC">Telecommunications Services</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>CRAZY JOHNS</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-22">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161677 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-21">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>FLEXIRENT TEST *</credit-enquirer>
                                    <client-reference>785649-437275</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-20">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>10149</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>POLICE &amp; NURSES C/S SODP</credit-enquirer>
                                    <client-reference>3000381</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-20">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>30222</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>POLICE &amp; NURSES C/S SODP</credit-enquirer>
                                    <client-reference>3000378</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-19">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>100</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ BANK TEST CODE</credit-enquirer>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>55000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161860 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>200000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161815 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-18">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161908 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-13">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>0</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>0 0</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>300000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1161677 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>125000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>CR123 2</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2008-02-12">
                                    <account-type code="RM">Real Property Mortgage</account-type>
                                    <enquiry-amount>250000</enquiry-amount>
                                    <role type="joint"/>
                                    <credit-enquirer>AFIG WHOLSALE</credit-enquirer>
                                    <client-reference>1162021 1</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-11-13">
                                    <account-type code="LC">Loan Contract</account-type>
                                    <enquiry-amount>42000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>ANZ BANK TEST CODE</credit-enquirer>
                                    <client-reference>4604</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-07-20">
                                    <account-type code="T">Terms</account-type>
                                    <enquiry-amount>20000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>DP CORE TEST</credit-enquirer>
                                    <client-reference>200107204267105</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="credit-application" enquiry-date="2001-01-23">
                                    <account-type code="CC">Continuing Credit Contract</account-type>
                                    <enquiry-amount>200</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>VODAFONE NSW</credit-enquirer>
                                    <client-reference>00023229</client-reference>
                                </credit-enquiry>
                                <credit-enquiry type="authorised-agent-enquiry" enquiry-date="2001-06-15">
                                    <account-type code="CC">Continuing Credit Contract</account-type>
                                    <enquiry-amount>30000</enquiry-amount>
                                    <role type="principal"/>
                                    <credit-enquirer>PHIL MCCARROLL FORD</credit-enquirer>
                                </credit-enquiry>
                            </individual-consumer-credit-file>
                            <individual-public-data-file>
                                <disqualified-directorship>
                                    <date-disqualified>2008-02-21</date-disqualified>
                                    <date-disqualified-until>2010-02-21</date-disqualified-until>
                                </disqualified-directorship>
                                <file-message>DISQUALIFIED DIRECTOR DETAILS WERE OBTAINED FROM THE ASIC UNDER</file-message>
                                <file-message>SECTION 3 SUB SECTION 243</file-message>
                                <proprietorship>
                                    <date-appointed>2001-03-16</date-appointed>
                                    <business>
                                        <bureau-reference>165289307</bureau-reference>
                                        <business-name>MARYS MAX SHOES</business-name>
                                    </business>
                                </proprietorship>                                                               
                            </individual-public-data-file>
                        </primary-match>
                    </enquiry-report>
                </response>
      </BCAservice-data>
    </BCAservice>
  </BCAservices>
</BCAmessage>
'''
}
return responseStr
