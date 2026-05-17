urlToPush = 'http://lendfast:8080/lendfast/services/GenworthService'

appBatchId = body.PolicyRequest.ApplicationBatch.Identifier.@UniqueID.text()
appId = body.PolicyRequest.ApplicationBatch.Application.Identifier.@UniqueID.text()

rowAppId = appId.tokenize('.').first()
log.info "ApplicationNumber:"+rowAppId

dateNow = new Date()
dateAEDT = dateNow.format("yyyy-MM-dd", TimeZone.getTimeZone("GMT+11"))
timeAEDT = dateNow.format("HH:mm:ss:SSS'+1100'", TimeZone.getTimeZone("GMT+11"))
asyncCreated = dateNow.format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone('UTC'))
asyncExpires = (dateNow + 5).format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone('UTC'))
 
filter = [:]
if (rowAppId) filter.ApplicationNumber = rowAppId
appResults = load('ApplicationResponseData', filter, true)
log.info "Application result search using ${filter} returned ${appResults.size()} results"

def result
if (appResults.size() > 0) {
	result = appResults.get(0)
} else {
	// use default if the Application number has not been added to the ApplicationResponseData.csv
	result = [:]
	result.TotalInsuredAmount = '354291.63'
	result.TotalPayable = '1684.98'
	result.Premium = '1499.09'
	result.StampDuty = '3542.00'
	result.GST = '148.41'
	result.FirstResponseStatus = 'RECEIVED'
	result.FinalStatus = 'APPROVED'
}

def responseStr

if ("REJECTED".equals(result.FirstResponseStatus)) {
	// ******************* REJECTED response **********************
	responseStr = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
		   <soapenv:Header>
		      <wsse:Security soapenv:mustUnderstand="1" xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">
			 <wsu:Timestamp wsu:Id="TS-302">
				<wsu:Created>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone('UTC'))}</wsu:Created>
				<wsu:Expires>${(dateNow + 1).format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone('UTC'))}</wsu:Expires>
			 </wsu:Timestamp>
		      </wsse:Security>
		   </soapenv:Header>
		   <soapenv:Body>
		      <PolicyResponse encoding="UTF-8" version="1.0">
			 <MessageBatch NumberOfMessages="1" ProductionData="Yes">
				<Identifier Type="MIAssigned" UniqueID="${new Random().nextInt(900000)}"/>
				<Identifier Type="LenderAssigned" UniqueID="${appBatchId}"/>
				<Date>${dateAEDT}</Date>
				<Time>${timeAEDT}</Time>
			    <Message>
			       <MessageBody Type="DataError">
				  <MessageAnnotation MessageCode="DATA_ERROR" MessageRefPath="//MortgageInsuranceSegment/MortgageInsurance/@CustomerCode">//MortgageInsuranceSegment/MortgageInsurance/CustomerCode contains invalid domain value (SANDSTONE_2)</MessageAnnotation>
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
		      </PolicyResponse>
		   </soapenv:Body>
		</soapenv:Envelope>"""
} else {
	// ******************* RECEIVED response **********************
	responseStr = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
	   <soapenv:Header>
	      <wsse:Security soapenv:mustUnderstand="1" xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">
		 <wsu:Timestamp wsu:Id="TS-151">
		    <wsu:Created>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone('UTC'))}</wsu:Created>
		    <wsu:Expires>${(dateNow + 1).format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone('UTC'))}</wsu:Expires>
		 </wsu:Timestamp>
	      </wsse:Security>
	   </soapenv:Header>
	   <soapenv:Body>
	      <PolicyResponse version="1.0">
		 <MessageBatch>
		    <Identifier Type="LenderAssigned" UniqueID="${appBatchId}"/>
		    <Identifier Type="MIAssigned" UniqueID="${new Random().nextInt(900000)}"/>
		    <Message>
		       <MessageBody Type="Information">
			  <Status Name="RECEIVED">
				<Date>${dateAEDT}</Date>
				<Time>${timeAEDT}</Time>
			  </Status>
		       </MessageBody>
		       <MICommunication>
			  <ResponseType>ACK</ResponseType>
			  <ApplicationProcessedTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss.SSS'+11:00'", TimeZone.getTimeZone('GMT+11'))}</ApplicationProcessedTime>
		       </MICommunication>
		    </Message>
		 </MessageBatch>
	      </PolicyResponse>
	   </soapenv:Body>
	</soapenv:Envelope>"""

	// ******************* the first async response - IN_PROGRESS response **********************
	def timer = new Timer()
	def task = timer.runAfter(10000) {
		println "Sending In Progress response ${new Date()}."

		String requestStrFromFile = readFromFile("inprogress");
		sendAsyncResponse(updateCommonFields(requestStrFromFile))
	}

	// ******************* the second async response which contains the final decision **********************
	def task2 = timer.runAfter(20000) {
		println "Sending Async response ${new Date()}."

		String requestStrFromFile = null;
		if ("REJECTED".equals(result.FinalStatus)) {
			requestStrFromFile = readFromFile("validationerror");
		} else {
			requestStrFromFile = readFromFile("approved");
			requestStrFromFile = requestStrFromFile.replace('[TotalInsuredAmount]', result.TotalInsuredAmount)
			requestStrFromFile = requestStrFromFile.replace('[TotalPayable]', result.TotalPayable)
			requestStrFromFile = requestStrFromFile.replace('[Premium]', result.Premium)
			requestStrFromFile = requestStrFromFile.replace('[StampDuty]', result.StampDuty)
			requestStrFromFile = requestStrFromFile.replace('[GST]', result.GST)
		}
		sendAsyncResponse(updateCommonFields(requestStrFromFile))
	}
}

return responseStr

String readFromFile(String filename) {
	return new File("lmi/genworth/${filename}.xml").text
}

String updateCommonFields(String aysncRequestStr) {
	aysncRequestStr = aysncRequestStr.replace('[ApplicationId]', appId)
	aysncRequestStr = aysncRequestStr.replace('[AsyncCreated]', asyncCreated)
	aysncRequestStr = aysncRequestStr.replace('[AsyncExpires]', asyncExpires)
	return aysncRequestStr;
}

String sendAsyncResponse(String aysncRequestStr) {
	try {
		url = urlToPush.toURL()
		conn = url.openConnection()
		conn.doOutput = true
		conn.requestMethod = 'POST'
		conn.setRequestProperty('SOAPAction', '"receiveLMIResponse"')
		conn.setRequestProperty('Content-Type', 'text/xml; charset=utf-8')
		
		// withWriter will automatically flush and close
		conn.outputStream.withWriter { it << aysncRequestStr }

		// groovy adds text attribute to make reading easier
		log.info 'response: ' + conn.content.text
	} catch (Exception ex) {
		log.log java.util.logging.Level.SEVERE, ex.toString(), ex
	}
	return null;
}