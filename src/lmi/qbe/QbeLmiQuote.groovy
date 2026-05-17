senderId = body.LMIServices_Request.DocHeader.Identification.SenderIdentifier.text()
senderDocId = body.LMIServices_Request.DocHeader.Identification.SenderDocumentIdentifier.text()
appId = body.LMIServices_Request.Document.PremiumRequest.Application.Identifier.@UniqueID.text()

log.info "ApplicationNumber:"+appId

filter = [:]
if (appId) filter.ApplicationNumber = appId
quoteResults = load('QbeQuoteResponseData', filter, true)
log.info "Quote result search using ${filter} returned ${quoteResults.size()} results"

def result
if (quoteResults.size() > 0) {
    result = quoteResults.get(0)
} else {
    // use default if the Application number has not been added to the QuoteResponseData.csv
    result = [:]
    result.TotalPayable = '1684.99'
    result.Premium = '1499.09'
    result.StampDuty = '148.41'
    result.GST = '37.48'
    result.CustInsurancePremium = '1530.25'
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
        <soapenv:Header />
        <soapenv:Body>
            <LMIServices_Response xmlns="http://qbelmi.com.au/lmiServices/premiumCalculator/2">
                <DocHeader>
                    <Identification xmlns="http://qbelmi.com.au/lmiServices/common/1">
                        <Sender>DEMO TEST</Sender>
                        <SenderIdentifier>${senderId}</SenderIdentifier>
                        <SenderDocumentIdentifier>${senderDocId}</SenderDocumentIdentifier>
                        <LenderName>SANDSTONE</LenderName>
                    </Identification>
                    <Service xmlns="http://qbelmi.com.au/lmiServices/common/1">PremiumCalculator</Service>
                </DocHeader>
                <Document>
                    <res:PremiumResponse xmlns:res="http://qbelmi.com.au/lmiServices/premiumCalculator/premiumCalculatorResponse/2">
                        <res:RequestReference ReferenceID="${appId}"/>
                        <res:PersonName>
                            <res:FirstName>Michael</res:FirstName>
                            <res:OtherName/>
                            <res:Surname>Jackson</res:Surname>
                        </res:PersonName>
                        <res:LMIFees>
                            <res:LoanLMIFee>
                                <res:LoanReferenceID>ResultantLoan-11</res:LoanReferenceID>
                                <res:Premium>${result.Premium}</res:Premium>
                                <res:GST>${result.GST}</res:GST>
                                <res:StampDuty>${result.StampDuty}</res:StampDuty>
                                <res:TotalPremium>${result.TotalPayable}</res:TotalPremium>
                                <res:CustomerInsurancePremiumAmount>${result.CustInsurancePremium}</res:CustomerInsurancePremiumAmount>
                            </res:LoanLMIFee>
                            <res:ApplicationLMIFee>
                                <res:Premium>${result.Premium}</res:Premium>
                                <res:GST>${result.GST}</res:GST>
                                <res:StampDuty>${result.StampDuty}</res:StampDuty>
                                <res:PremiumPlusGST>1010.10</res:PremiumPlusGST>
                                <res:TotalPremium>${result.TotalPayable}</res:TotalPremium>
                                <res:CustomerInsurancePremiumAmount>${result.CustInsurancePremium}</res:CustomerInsurancePremiumAmount>
                            </res:ApplicationLMIFee>
                            <res:LoanDetails>
                                <res:InsuredLoanAmount>${result.TotalInsuredAmount}</res:InsuredLoanAmount>
                            </res:LoanDetails>
                        </res:LMIFees>
                    </res:PremiumResponse>
                </Document>
            </LMIServices_Response>
            </soapenv:Body>
    </soapenv:Envelope>"""
}
else {
    // ******************* REJECTED response **********************
    responseStr = """
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
        <soapenv:Header/ >
        <soapenv:Body>
            <LMIServices_Response xmlns="http://qbelmi.com.au/lmiServices/premiumCalculator/2">
                <DocHeader>
                    <Identification xmlns="http://qbelmi.com.au/lmiServices/common/1">
                        <Sender>DEMO TEST</Sender>
                        <SenderIdentifier>${senderId}</SenderIdentifier>
                        <SenderDocumentIdentifier>${senderDocId}</SenderDocumentIdentifier>
                        <LenderName>SANDSTONE</LenderName>
                    </Identification>
                    <Service xmlns="http://qbelmi.com.au/lmiServices/common/1">PremiumCalculator</Service>
                </DocHeader>
                <Document>
                    <res:PremiumResponse
                        xmlns:res="http://qbelmi.com.au/lmiServices/premiumCalculator/premiumCalculatorResponse/2"
                        xmlns:cmn="http://qbelmi.com.au/lmiServices/common/1">
                        <res:RequestReference ReferenceID="${appId}" />
                        <res:Error>
                            <res:MessageBody Type="DataError">
                                <cmn:MessageAnnotation Type="Code">D101</cmn:MessageAnnotation>
                                <cmn:MessageAnnotation Type="Message">Fee cannot be calculated.</cmn:MessageAnnotation>
                            </res:MessageBody>
                        </res:Error>
                    </res:PremiumResponse>
                </Document>
            </LMIServices_Response>
        </soapenv:Body>
    </soapenv:Envelope>"""
}

return responseStr