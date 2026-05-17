appBatchId = body.PremiumRequest.ApplicationBatch.Identifier.@UniqueID.text()
appId = body.PremiumRequest.ApplicationBatch.Application.Identifier.@UniqueID.text()
rowAppId = appId.tokenize('.').first()
log.info "ApplicationNumber:"+rowAppId

filter = [:]
if (rowAppId) filter.ApplicationNumber = rowAppId
quoteResults = load('QuoteResponseData', filter, true)
log.info "Quote result search using ${filter} returned ${quoteResults.size()} results"

def result
if (quoteResults.size() > 0) {
	result = quoteResults.get(0)
} else {
	// use default if the Application number has not been added to the QuoteResponseData.csv
	result = [:]
	result.TotalPayable = '1684.98'
	result.Premium = '1499.09'
	result.StampDuty = '148.41'
	result.GST = '37.48'
	result.TotalInsuredAmount = '170000.00'
	result.Status = 'QUOTED'
}

dateNow = new java.util.Date()
dateAEDT = dateNow.format("yyyy-MM-dd", TimeZone.getTimeZone("GMT+11"))
timeAEDT = dateNow.format("HH:mm:ss:SSS'+1100'", TimeZone.getTimeZone("GMT+11"))

// ******************* QUOTED response **********************
def responseStr = ""
if ("QUOTED".equals(result.Status)) {
	responseStr = """
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
	   <soapenv:Header>
	      <wsse:Security soapenv:mustUnderstand="1" xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">
		 <wsu:Timestamp wsu:Id="TS-151">
			<wsu:Created>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone('UTC'))}</wsu:Created>
			<wsu:Expires>${(dateNow + 1).format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone('UTC'))}</wsu:Expires>
		 </wsu:Timestamp>
	      </wsse:Security>
	   </soapenv:Header>
	   <soapenv:Body>
		<PremiumResponse encoding="UTF-8" version="1.0">
			<MessageBatch NumberOfMessages="1" ProductionData="Yes">
				<Identifier Type="MIAssigned" UniqueID="${new Random().nextInt(900000)}"/>
				<Identifier Type="LenderAssigned" UniqueID="${appBatchId}"/>
				<Date>${dateAEDT}</Date>
				<Time>${timeAEDT}</Time>
				<Publisher>
					<RelatedEntityRef RelatedID="2" />
				</Publisher>
				<Message>
					<MessageRelatesTo>
						<Application>
							<Identifier Type="LenderAssigned" UniqueID="${appId}" />
							<PartySegment>
								<Party Type="Applicant">
									<Identifier Type="LenderAssigned" UniqueID="" />
									<Person FirstHomeBuyer="No">
										<PersonName>
											<FirstName>Jordan</FirstName>
											<Surname>Clarkson</Surname>
										</PersonName>
									</Person>
								</Party>
							</PartySegment>
							<LoanDetailSegment>
								<LoanDetails>
									<Identifier Type="LenderAssigned" UniqueID="" />
									<LoanTerm Units="Months">180</LoanTerm>
									<CurrentAmount>170000.00</CurrentAmount>
									<LoanPurpose>
										<LendingPurposeCode>ERL</LendingPurposeCode>
									</LoanPurpose>
								</LoanDetails>
							</LoanDetailSegment>
							<AddressSegment>
								<AddressWrapper>
									<Identifier Type="LenderAssigned" UniqueID="" />
									<Address>
										<UnitNo>76</UnitNo>
										<StreetNo>5</StreetNo>
										<Street Type="RD">BERESFORD</Street>
										<City>STRATHFIELD</City>
										<State Name="NSW" />
										<Postcode>2135</Postcode>
										<Country>AUS</Country>
									</Address>
								</AddressWrapper>
							</AddressSegment>
							<MIApplicationSegment>
								<MIApplication CustCode="SANDSTONE" LendingProgram="SANDSTONE STANDARD PROGRAM" ProductCode="0" TransactionType="PremiumQuotation" />
							</MIApplicationSegment>
						</Application>
					</MessageRelatesTo>
					<MessageBody Type="Information">
						<Status Name="QUOTED">
							<Date>${dateAEDT}</Date>
							<Time>${timeAEDT}</Time>
						</Status>
					</MessageBody>
					<MICommunication>
						<ResponseType>PQ</ResponseType>
						<ApplicationProcessedTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss.SSS'+11:00'", TimeZone.getTimeZone('GMT+11'))}</ApplicationProcessedTime>
						<TotalInsuredAmount>${result.TotalInsuredAmount}</TotalInsuredAmount>
						<BaseLVR>85.00</BaseLVR>
						<OutstandingBalanceUninsured>0.00</OutstandingBalanceUninsured>
						<MICosts>
							<MICostsType>PremiumQuotation</MICostsType>
							<QuotationNumber>${new Random().nextInt(9000000)}</QuotationNumber>
							<QuotationExpiryDate>${(dateNow + 90).format("yyyy-MM-dd'+11:00'", TimeZone.getTimeZone('GMT+11'))}</QuotationExpiryDate>
							<MICost>
								<TotalPayable>1797.41</TotalPayable>
								<Premium>1499.09</Premium>
								<StampDuty>148.41</StampDuty>
								<GST>149.91</GST>
								<PremiumBeforeCredit>1499.09</PremiumBeforeCredit>
								<PayableBy>Lender</PayableBy>
							</MICost>
							<MICost>
								<TotalPayable>${result.TotalPayable}</TotalPayable>
								<Premium>${result.Premium}</Premium>
								<StampDuty>${result.StampDuty}</StampDuty>
								<GST>${result.GST}</GST>
								<PremiumBeforeCredit>1499.09</PremiumBeforeCredit>
								<PayableBy>Borrower</PayableBy>
							</MICost>
						</MICosts>
					</MICommunication>
				</Message>
				<RelatedPartySegment>
					<RelatedParty RelPartyType="Insurer">
						<Identifier UniqueID="2" />
						<Company>
							<CompanyName BusinessName="Genworth" />
							<CompanyNumber ABN="60 106 974 305" />
						</Company>
					</RelatedParty>
				</RelatedPartySegment>
			</MessageBatch>
		</PremiumResponse>
	   </soapenv:Body>
	</soapenv:Envelope>"""
} else {
	// ******************* REJECTED response **********************
	responseStr = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
	   <soapenv:Header>
	      <wsse:Security soapenv:mustUnderstand="1" xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">
		 <wsu:Timestamp wsu:Id="TS-296">
			<wsu:Created>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone('UTC'))}</wsu:Created>
			<wsu:Expires>${(dateNow + 1).format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone('UTC'))}</wsu:Expires>
		 </wsu:Timestamp>
	      </wsse:Security>
	   </soapenv:Header>
	   <soapenv:Body>
	      <PremiumResponse encoding="UTF-8" version="1.0">
		 <MessageBatch NumberOfMessages="1" ProductionData="Yes">
			<Identifier Type="MIAssigned" UniqueID="${new Random().nextInt(900000)}"/>
			<Identifier Type="LenderAssigned" UniqueID="${appBatchId}"/>
			<Date>${dateAEDT}</Date>
			<Time>${timeAEDT}</Time>
		    <Message>
		       <MessageBody Type="DataError">
			  <MessageAnnotation MessageCode="DATA_ERROR" MessageRefPath="//MortgageInsuranceSegment/MortgageInsurance/@CustomerCode">Dummy data error from LMI fakehost</MessageAnnotation>
		       </MessageBody>
		       <MessageBody Type="Information">
			  <Status Name="REJECTED">
				<Date>${dateAEDT}</Date>
				<Time>${timeAEDT}</Time>
			  </Status>
		       </MessageBody>
		       <MICommunication>
			  <ResponseType>VA</ResponseType>
			  <ApplicationProcessedTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss.SSS'+11:00'", TimeZone.getTimeZone('GMT+11'))}</ApplicationProcessedTime>
		       </MICommunication>
		    </Message>
		 </MessageBatch>
	      </PremiumResponse>
	   </soapenv:Body>
	</soapenv:Envelope>"""
}

return responseStr