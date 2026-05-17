// Check if request is order full valuation
def valuationMessage = body.'**'.find { it.name().equals('valuationMessage') }

// Handle retrieving valuation by id request if is not order full valuation
if (!valuationMessage)
{
    def valexId = body.'**'.find { it.name().equals('valexId') }
    def responseBody = lookup("orderValuationByIdResponse.txt").text
    def responsePayload =
            """<SOAP-ENV:Envelope SOAP-ENV:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns1="https://ws.valex.com.au/soap/lixi/1.3/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:SOAP-ENC="http://schemas.xmlsoap.org/soap/encoding/">
   <SOAP-ENV:Body>
      ${responseBody}
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>"""
    return responsePayload
}

def xmlParser = new XmlParser().parseText(valuationMessage.text().replaceAll("l:", ""))

def identifier = xmlParser.'**'.find { it.name() == 'Identifier' && it.@UniqueID }

// The number here before the . refers to the application id, and the number after the . refers to the valuation id.
def valuationUniqueID = identifier?.@UniqueID

// Get valudation report
def reportFile = new File('default/valuationReport.pdf')
log.info 'Loading Valuation report at: ' + reportFile.absolutePath
def reportFileBase64Encoded = reportFile.bytes.encodeBase64().toString()

def valuationStatusUpdateRequestBody = """
    <soapenv:Envelope
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
	xmlns:len="http://www.sandstone.com.au/lending">
	<soapenv:Header>
		<wsse:Security
			xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd">
			<wsse:UsernameToken>
				<wsse:Username>Valex</wsse:Username>
				<wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText">0316e31b69fcd7b312a341522c561b4a</wsse:Password>
			</wsse:UsernameToken>
		</wsse:Security>
	</soapenv:Header>
	<soapenv:Body>
		<len:response>
			<valuationMessage xsi:type="xsd:string">
				<![CDATA[<ValuationTransaction ProductionData="No"><RevisionNumber LIXIVersion="1.4" LenderVersion="1.0" UserVersion="1.0" UserType="Valuer"/><Identifier UniqueID="VXJ-000007007749" Type="VPMAssigned" Description="Valex Reference Number"/><Identifier UniqueID="${valuationUniqueID}" Type="LenderAssigned"/><Identifier UniqueID="686675" Type="ValuerAssigned" Description="Valuer's File Reference"/><Date>2024-08-14</Date><Time>12:35:23+09:30</Time><Publisher><RelatedEntityRef RelatedID="VXV-000001"/></Publisher><Audience><RelatedEntityRef RelatedID="VXCL-012810"/></Audience><Message><Identifier UniqueID="Dummy_Value" Type="VPMAssigned"/><MessageRelatesTo><Identifier UniqueID="VXJ-000007007749" Type="VPMAssigned"/><Identifier UniqueID="${valuationUniqueID}" Type="BrokerAssigned"/></MessageRelatesTo><MessageBody Type="Information"><Status Name="ValuationCompleted"><Date>2024-08-14</Date><Time>13:04:53+10:00</Time></Status></MessageBody><MessageBody Type="Information"><Event Name="ValReport"><Date>2024-08-14</Date><Time>13:04:54+10:00</Time></Event></MessageBody><ValuationType><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><FullRegistered InterestInProperty="FeeSimpleInPossession" ValSubType="Standard"><SubTypeNote>AVM</SubTypeNote><RealEstate Status="Established" Construction="No" MortgageInsurance="No" Occupancy="OwnerPrimary" LandAreaHectares="0" Transaction="Purchasing"><Identifier UniqueID="1394046" Type="VPMAssigned" Description="RP ID"/><Residential Type="FullyDetachedHouse"/><EstimatedValue EstimateBasis="CertifiedValuation">1550000</EstimatedValue><Location><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo>1</StreetNo><Street Type="Street">Spencer</Street><City>BERALA</City><State Name="NSW"/><Postcode>2141</Postcode><Country>AU</Country></Address><Title IsPrimaryTitle="Yes"/></Location></RealEstate><RequestDate><Date>2024-08-14</Date></RequestDate><DetailedComment><RelatedEntityRef RelatedID="Dummy_value"/><Comment/></DetailedComment><RequestedPriority Indicator="Normal"><Date>2024-08-16</Date><Time>12:34:13</Time></RequestedPriority><FeeSegment><Fee Amount="20.35" Description="Valuation" Class="Valuer"><Identifier UniqueID="1680435" Type="ValuerAssigned" Description="InvoiceNumber"/></Fee></FeeSegment><InspectionAppointment><Date>2024-08-14</Date><Time>13:04:33+10:00</Time></InspectionAppointment><ResponseSupportingDoc DocAttached="Yes" RequestorToSight="No" DocType="Other"><Identifier UniqueID="1680435" Type="ValuerAssigned" Description="InvoiceNumber"/></ResponseSupportingDoc><ResponseSupportingDoc DocAttached="Yes" RequestorToSight="No" DocType="Report"><Identifier UniqueID="VXDR-0000686675" Type="VPMAssigned"/><Description>Valuation Report</Description></ResponseSupportingDoc><CarAccomodation NumberOfVehicles="0"/><ImprovementAreas AreaType="Living"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><SiteArea Size="100" UnitOfMeasurement="SquareMeters"/><Description>Living Area</Description></ImprovementAreas><RiskAnalysis Marketability="" OverallRiskAnalysis=""><RiskRating RatingType="LocationNeighbourhood" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="Land" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="Environmental" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="Improvements" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="MarketVolatility" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="LocalEconomy" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="MarketSegment" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="ReducedValue" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><Securitisation/></RiskAnalysis><ValueComponent LandValue="0" ImprovementsValue="0" RecommendedSecurity="Yes"><MarketValueAsIfComplete Type="SinglePoint" ValueFloor="1034741" ValueCeiling="1600000"><Description>Existing Property</Description></MarketValueAsIfComplete><EstimatedSettlement><Duration Units="Months"/></EstimatedSettlement><Comment>Value Component</Comment><ExpectedSellingPeriodComment/></ValueComponent><Zoning ZoningType="Other" OtherDescription="" LocalGovtAuthority="AUBURN" ZoningEffect=""/><SiteDetailResponse TitleSearched="No"><SiteArea Size="373" UnitOfMeasurement="SquareMeters"/><Neighbourhood/><PropertyCharacteristics CurrentUse="Residential" ExternalCondition="Unknown" InternalCondition="Unknown" InternalLayout="Unknown" MainBuilding="Yes" MineSubsidence="Yes" PCItems="" SiteArea="373" SiteAreaUnits="SquareMeters" StreetAppeal="Unknown" YearBuilt="1950" YearModified=""/></SiteDetailResponse><AncillaryFeature/><SalesEvidence SalePrice="1262000" OverallComparability="Comparable" OtherSimilarity=""><Location><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo>170</StreetNo><Street Type="Road">Nottinghill</Street><City>BERALA</City><State Name="NSW"/><Postcode>2141</Postcode><Country>AU</Country></Address></Location><Date>2024-02-24</Date><Comment/><Comment/></SalesEvidence><SalesEvidence SalePrice="1152000" OverallComparability="Comparable" OtherSimilarity=""><Location><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo>33</StreetNo><Street Type="Avenue">Second</Street><City>BERALA</City><State Name="NSW"/><Postcode>2141</Postcode><Country>AU</Country></Address></Location><Date>2024-03-16</Date><Comment/><Comment/></SalesEvidence><SalesEvidence SalePrice="1125000" OverallComparability="Comparable" OtherSimilarity=""><Location><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo>1</StreetNo><Street Type="Street">Greenlee</Street><City>BERALA</City><State Name="NSW"/><Postcode>2141</Postcode><Country>AU</Country></Address></Location><Date>2023-12-06</Date><Comment/><Comment/></SalesEvidence><SalesEvidence SalePrice="1300000" OverallComparability="Comparable" OtherSimilarity=""><Location><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo>66</StreetNo><Street Type="Avenue">Second</Street><City>BERALA</City><State Name="NSW"/><Postcode>2141</Postcode><Country>AU</Country></Address></Location><Date>2023-11-25</Date><Comment/><Comment/></SalesEvidence><SalesEvidence SalePrice="1100000" OverallComparability="Comparable" OtherSimilarity=""><Location><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo>30</StreetNo><Street Type="Avenue">Seventh</Street><City>BERALA</City><State Name="NSW"/><Postcode>2141</Postcode><Country>AU</Country></Address></Location><Date>2024-03-22</Date><Comment/><Comment/></SalesEvidence><SalesEvidence SalePrice="1340000" OverallComparability="Comparable" OtherSimilarity=""><Location><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo>33</StreetNo><Street Type="Road">Clucas</Street><City>REGENTS PARK</City><State Name="NSW"/><Postcode>2143</Postcode><Country>AU</Country></Address></Location><Date>2023-11-22</Date><Comment/><Comment/></SalesEvidence><CompletionDetails LendersCautionComment="This Valuation has been instructed by the party shown at the top of this report. It may be relied upon by any of the following parties if so nominated by the instructing party: Credit Union Australia Limited, Great Southern Bank, Helia Insurance Pty Limited, Helia Insurance Pty Limited, QBE Lenders Mortgage Insurance Limited"><ValuationValidFrom><Date>2024-08-14</Date></ValuationValidFrom><DateOfInspection><Date>2024-08-14</Date></DateOfInspection></CompletionDetails></FullRegistered></ValuationType></Message><RelatedPartySegment><RelatedParty RelPartyType="ValuationPanelManager"><Identifier UniqueID="VXV-000001" Type="VPMAssigned"/><CompanyName BusinessName="CoreLogic"/><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo/><Street/><City/><State Name="Other"/><Postcode/><Country/></Address><WorkPhone><Phone><Fax/></Phone><Phone><FixedPhone AreaCode="08">83735522</FixedPhone></Phone></WorkPhone><Email Type="Work">corelogicvalfirm@valex.com.au</Email></RelatedParty><RelatedParty RelPartyType="ValuationFirm"><Identifier UniqueID="VXV-005006" Type="VPMAssigned"/><CompanyName BusinessName="Intellival"/><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo/><Street/><City>Unknown Suburb</City><State Name="Other"/><Postcode>9999</Postcode><Country/></Address><WorkPhone><Phone><Fax/></Phone><Phone><FixedPhone>0400000000</FixedPhone></Phone></WorkPhone><Email Type="Work"/></RelatedParty><RelatedParty RelPartyType="Lender" RelPartyDescription="Credit Union Australia Limited, Great Southern Bank, Helia Insurance Pty Limited, Helia Insurance Pty Limited, QBE Lenders Mortgage Insurance Limited"><Identifier UniqueID="VXCL-012810" Type="VPMAssigned"/><CompanyName BusinessName="Access All WG"/><PersonName><FirstName>Sandy</FirstName><Surname>Stone</Surname></PersonName><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo>145</StreetNo><Street Type="Street">Ann</Street><City>BRISBANE</City><State Name="QLD"/><Postcode>4000</Postcode><Country>AU</Country></Address><WorkPhone><Phone><Fax/></Phone><Phone><FixedPhone>133282</FixedPhone></Phone></WorkPhone></RelatedParty><RelatedParty RelPartyType="Lender"><Identifier UniqueID="VXF-000135" Type="VPMAssigned"/><CompanyName BusinessName="Great Southern Bank"/><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo>145</StreetNo><Street Type="Street">Ann</Street><City>BRISBANE</City><State Name="QLD"/><Postcode>4000</Postcode><Country>AU</Country></Address><WorkPhone><Phone><Fax/></Phone><Phone><FixedPhone>1300660051</FixedPhone></Phone></WorkPhone></RelatedParty><RelatedParty RelPartyType="Valuer"><Identifier UniqueID="VXVLR-004661" Type="VPMAssigned"/><PersonName><FirstName>Intellival</FirstName><Surname>AVM</Surname></PersonName><WorkPhone><Phone><FixedPhone/></Phone><Phone><Fax/></Phone><Phone><Mobile/></Phone></WorkPhone><ProfessionalInfrastructure><Accreditation Type="Licence" AccreditationID=""><Identifier UniqueID="VXVLR-004661" Type="ValuerAssigned"/></Accreditation></ProfessionalInfrastructure></RelatedParty></RelatedPartySegment><AttachmentSegment><Attachment Filename="invoice_standard_1680435.pdf"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><RelatedEntityRef RelatedID="1680435"/><InlineAttachment>${reportFileBase64Encoded}</InlineAttachment></Attachment><Attachment Filename="intellival_avm.pdf"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><RelatedEntityRef RelatedID="VXDR-0000686675"/><InlineAttachment>${reportFileBase64Encoded}</InlineAttachment></Attachment></AttachmentSegment><vx:Job Purpose="Mortgage"
				xmlns:vx="https://vx.valex.com.au/lixi/schema/vx/0.1/#"><vx:FSD>13</vx:FSD><vx:Property Type="Dwelling"><vx:Builder><vx:Builder/><vx:OwnerBuilder>No</vx:OwnerBuilder><vx:ContractTenderPrice/><vx:ContractTenderDate>1970/01/01</vx:ContractTenderDate><vx:CheckCost ExpertAdviceRecommended="No"/><vx:OutOfContractItems TotalPrice="">No</vx:OutOfContractItems></vx:Builder></vx:Property><vx:Valuer ValuerID="VXVLR-004661" APIStatus="" APINumber="" CertifiedPracticingValuer="No" CurrentMemberOfAPIVLimited="No" ExcludedFromCappedLiabilityScheme="No"><vx:NSWRegisteredValuer RegistrationNumber="" DateOfExpiry="0"/><vx:QLDRegisteredValuer RegistrationNumber="" DateOfExpiry="0"/><vx:WALicence RegistrationNumber="" DateOfExpiry="0"/><vx:QualificationOnReport Description=""/></vx:Valuer><vx:TimeOfInspection Time="13:04:33+10:00"/></vx:Job></ValuationTransaction>
]]>
			</valuationMessage>
		</len:response>
	</soapenv:Body>
</soapenv:Envelope>
    """

String sendAsyncResponse(String asyncRequestStr) {
    try {
        def urlToPush = 'http://lendfast:8080/lendfast/services/ValExService'
        def url = urlToPush.toURL()
        def conn = url.openConnection()
        conn.doOutput = true
        conn.requestMethod = 'POST'
        conn.setRequestProperty('Content-Type', 'text/xml; charset=utf-8')
        conn.setRequestProperty('SOAPAction', 'response')
        conn.outputStream.withWriter { it << asyncRequestStr }

        log.info 'response: ' + conn.content.text
    } catch (Exception ex) {
        log.log java.util.logging.Level.SEVERE, ex.toString(), ex
    }
    return null
}

def initialResponse = """
<SOAP-ENV:Envelope SOAP-ENV:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns1="https://ws.valex.com.au/soap/lixi/1.3/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:SOAP-ENC="http://schemas.xmlsoap.org/soap/encoding/">
   <SOAP-ENV:Body>
      <ns1:valuationRequestResponse xmlns:ns1="https://ws.valex.com.au/soap/lixi/1.3/"><responseCode xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xsi:type="xsd:int">0</responseCode></ns1:valuationRequestResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
"""

// Create a new thread for status update
Thread statusUpdateThread = new Thread({
    // Sleep for 10 seconds before sending valuation status update to LF
    Thread.sleep(10000)
    log.info "Sending completed status update"
    sendAsyncResponse(valuationStatusUpdateRequestBody)
})

// Start the status update thread
statusUpdateThread.start()

// Log and return the initial response
log.info "Sending Ack response"
return initialResponse