def valuationMessage = body.'**'.find { it.name().equals('valuationMessage') }
def xmlParser = new XmlParser().parseText(valuationMessage.text())
def address = xmlParser.Message.ValuationType.FullRegistered.RealEstate.Location.Address

def streetNo = address.StreetNo.text()
def street = address.Street.text()
def city = address.City.text()
def state = address.State.@Name[0]

def fullAddress = "${streetNo} ${street} ${city} ${state}".toUpperCase()

def responseStatus = "InProgress"

if (fullAddress.trim() == "NULL") {
    log.fine"Sending Ack response"
    return """
<SOAP-ENV:Envelope SOAP-ENV:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns1="https://ws.valex.com.au/soap/lixi/1.3/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:SOAP-ENC="http://schemas.xmlsoap.org/soap/encoding/">
   <SOAP-ENV:Body>
      <ns1:subscribeResponse>
         <result xsi:type="xsd:int">0</result>
      </ns1:subscribeResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
"""
} else if (fullAddress == "4 LA LA WARBURTON VIC" || fullAddress == "4 FAIRFIELD CAMBERWELL VIC" || fullAddress == "5 GRANT MEREDITH VIC") {
    log.fine"Sending previous job not found response"
    return """
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Body>
      <SOAP-ENV:Fault>
         <faultcode>SOAP-ENV:Client</faultcode>
         <faultstring>Previous job not found</faultstring>
      </SOAP-ENV:Fault>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
    """
} else if (fullAddress == "23 FERGUSON AVENEL VIC" || fullAddress == "2 WALKER EDGECLIFF NSW") {
    log.fine "Sending completed status response"
    responseStatus = "ValuationCompleted"

} else if (fullAddress == "8 LA LA WARBURTON VIC") {
    log.fine "Sending cancelled status response"
    responseStatus = "Cancelled"

} else {
    log.fine "Sending in progress status response"
}

return """
<SOAP-ENV:Envelope SOAP-ENV:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns1="https://ws.valex.com.au/soap/lixi/1.3/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:SOAP-ENC="http://schemas.xmlsoap.org/soap/encoding/">
   <SOAP-ENV:Body>
      <ns1:findResponse>
         <responseXml xsi:type="xsd:string"><![CDATA[<?xml version="1.0" encoding="utf-8"?>
<!--Generated ValEx XML Valuation Transaction-->
<ValuationTransaction ProductionData="No"><RevisionNumber LIXIVersion="1.4" LenderVersion="1.0" UserVersion="1.0" UserType="Valuer"/><Identifier UniqueID="VXJ-000001687180" Type="VPMAssigned" Description="Valex Reference Number"/><Identifier UniqueID="26691.4698" Type="LenderAssigned"/><Date>2024-08-02</Date><Time>16:20:50+09:30</Time><Publisher><RelatedEntityRef RelatedID="VXV-000001"/></Publisher><Audience><RelatedEntityRef RelatedID="VXCL-012407"/></Audience><Message><Identifier UniqueID="Dummy_Value" Type="VPMAssigned"/><MessageRelatesTo><Identifier UniqueID="VXJ-000001687180" Type="VPMAssigned"/><Identifier UniqueID="26691.4698" Type="BrokerAssigned"/></MessageRelatesTo><MessageBody Type="Information"><Status Name="${responseStatus}"><Date>2024-08-02</Date><Time>16:50:50+10:00</Time></Status></MessageBody><MessageBody Type="Information"><Event Name="ValReport"><Date>1970-01-01</Date><Time>10:00:00+10:00</Time></Event></MessageBody><ValuationType><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><FullRegistered InterestInProperty="Other" ValSubType="Standard"><SubTypeNote>AVM</SubTypeNote><RealEstate Status="Established" Construction="No" MortgageInsurance="No" Occupancy="OwnerPrimary" LandAreaHectares="0" Transaction="Refinancing"><Identifier UniqueID="13721086" Type="VPMAssigned" Description="RP ID"/><Residential Type="FullyDetachedHouse"/><EstimatedValue EstimateBasis="CertifiedValuation">0</EstimatedValue><Location><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo>4</StreetNo><Street Type="Avenue">La la</Street><City>WARBURTON</City><State Name="VIC"/><Postcode>3799</Postcode><Country>AU</Country></Address><Title TorrensLot="0" TorrensPlan="0" TorrensVolumeFolio="0" IsPrimaryTitle="Yes" OtherTitleDescription="0"/></Location></RealEstate><RequestDate><Date>2024-07-11</Date></RequestDate><DetailedComment><RelatedEntityRef RelatedID="Dummy_value"/><Comment/></DetailedComment><RequestedPriority Indicator="Normal"><Date>2024-07-19</Date><Time>12:30:00</Time></RequestedPriority><FeeSegment><Fee Amount="0" Description="Valuation" Class="Valuer"><Identifier UniqueID="1661783" Type="ValuerAssigned" Description="InvoiceNumber"/></Fee></FeeSegment><InspectionAppointment><Date>2024-07-02</Date><Time>11:00:00+10:00</Time></InspectionAppointment><ResponseSupportingDoc DocAttached="Yes" RequestorToSight="No" DocType="Image"><Identifier UniqueID="VXD-0006413764" Type="VPMAssigned"/><Description>Photo</Description></ResponseSupportingDoc><CarAccomodation NumberOfVehicles="0"/><RiskAnalysis Marketability="" OverallRiskAnalysis=""><RiskRating RatingType="LocationNeighbourhood" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="Land" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="Environmental" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="Improvements" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="MarketVolatility" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="LocalEconomy" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="MarketSegment" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><RiskRating RatingType="ReducedValue" Rating="0-NotKnown"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><Comment/></RiskRating><Securitisation/></RiskAnalysis><ValueComponent LandValue="0" ImprovementsValue="0" RecommendedSecurity="Yes" LikelyWeeklyUnfRental="0"><MarketValueAsIfComplete Type="SinglePoint" ValueFloor="1400000" ValueCeiling="1550000"><Description>Existing Property</Description></MarketValueAsIfComplete><EstimatedSettlement><Duration Units="Months"/></EstimatedSettlement><Comment>Value Component</Comment><ExpectedSellingPeriodComment/></ValueComponent><Zoning ZoningType="Residential" OtherDescription="LDRZ - Low Density Residential Zone" LocalGovtAuthority="Yarra Ranges" ZoningEffect=""/><SiteDetailResponse TitleSearched="No"><SiteArea Size="2527" UnitOfMeasurement="SquareMeters"/><Neighbourhood>The subject property is located in a   area, comprising predominately  of .</Neighbourhood><PropertyCharacteristics CurrentUse="Residential" EssentialRepairs="" ExternalCondition="Unknown" InternalCondition="Unknown" InternalLayout="Unknown" MainBuilding="Yes" MineSubsidence="Yes" PCItems="Refer Fixtures And Features" SiteArea="2527" SiteAreaUnits="SquareMeters" StreetAppeal="Unknown" YearBuilt="1917" YearModified=""/></SiteDetailResponse><AncillaryFeature/><CompletionDetails LendersCautionComment="This Valuation has been instructed by the party shown at the top of this report. It may be relied upon by any of the following parties if so nominated by the instructing party: Helia Insurance Pty Limited"><ValuationValidFrom><Date>2024-07-02</Date></ValuationValidFrom><DateOfInspection><Date>2024-07-02</Date></DateOfInspection></CompletionDetails></FullRegistered></ValuationType></Message><RelatedPartySegment><RelatedParty RelPartyType="ValuationPanelManager"><Identifier UniqueID="VXV-000001" Type="VPMAssigned"/><CompanyName BusinessName="CoreLogic"/><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo/><Street/><City/><State Name="Other"/><Postcode/><Country/></Address><WorkPhone><Phone><Fax/></Phone><Phone><FixedPhone AreaCode="08">83735522</FixedPhone></Phone></WorkPhone><Email Type="Work">corelogicvalfirm@valex.com.au</Email></RelatedParty><RelatedParty RelPartyType="ValuationFirm"><Identifier UniqueID="VXV-001048" Type="VPMAssigned"/><CompanyName BusinessName="Wide Bay Test Valfirm"/><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo/><Street/><City>Unknown Suburb</City><State Name="Other"/><Postcode>9999</Postcode><Country/></Address><WorkPhone><Phone><Fax/></Phone><Phone><FixedPhone>0400000000</FixedPhone></Phone></WorkPhone><Email Type="Work"/></RelatedParty><RelatedParty RelPartyType="Lender" RelPartyDescription="Helia Insurance Pty Limited"><Identifier UniqueID="VXCL-012407" Type="VPMAssigned"/><CompanyName BusinessName="Access All WG"/><PersonName><FirstName>Sandy</FirstName><Surname>Stone</Surname></PersonName><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo/><Street/><City>Unknown Suburb</City><State Name="Other"/><Postcode>9999</Postcode><Country/></Address><WorkPhone><Phone><Fax/></Phone><Phone><FixedPhone AreaCode="08">00000000</FixedPhone></Phone></WorkPhone></RelatedParty><RelatedParty RelPartyType="Lender"><Identifier UniqueID="VXF-000130" Type="VPMAssigned"/><CompanyName BusinessName="MyState Financial Limited (MyState)"/><Address><BuildingName/><FloorNo/><UnitNo/><StreetNo>137</StreetNo><Street Type="Street">Harrington</Street><City>HOBART</City><State Name="TAS"/><Postcode>7000</Postcode><Country>AU</Country></Address><WorkPhone><Phone><Fax/></Phone><Phone><FixedPhone>0400000000</FixedPhone></Phone></WorkPhone></RelatedParty><RelatedParty RelPartyType="Valuer"><Identifier UniqueID="VXVLR-004268" Type="VPMAssigned"/><PersonName><FirstName>Wide Bay Test Valfirm</FirstName><Surname>Test Valuer 1</Surname></PersonName><WorkPhone><Phone><FixedPhone/></Phone><Phone><Fax/></Phone><Phone><Mobile/></Phone></WorkPhone><ProfessionalInfrastructure><Accreditation Type="Licence" AccreditationID="67633"><Identifier UniqueID="VXVLR-004268" Type="ValuerAssigned"/></Accreditation></ProfessionalInfrastructure></RelatedParty></RelatedPartySegment><AttachmentSegment><Attachment SourceDomain="https://vxtest.valex.com.au/utils/getdoc.php?doc_id=6413764&amp;md5=d613980570802bb9d7e782851265feb4" Filename="Screenshot(1).png"><Identifier UniqueID="Dummy_Value" Type="ValuerAssigned"/><RelatedEntityRef RelatedID="VXD-0006413764"/></Attachment></AttachmentSegment></ValuationTransaction>]]></responseXml>
      </ns1:findResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
"""