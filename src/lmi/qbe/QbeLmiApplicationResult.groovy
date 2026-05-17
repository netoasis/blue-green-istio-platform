referenceId = requestXml.DocumentID.text()
dateNow = new Date()

filter = [:]
if (referenceId) filter.ReferenceId = referenceId
appResults = load('QbeApplicationResponseData', filter, true)
log.info "Application result search using ${filter} returned ${appResults.size()} results"

def result
if (appResults.size() > 0) {
    result = appResults.get(0)
} else {
    // use default if the Application number has not been added to the ApplicationResponseData.csv
    result = [:]
    result.ReferenceId = '1037658276'
    result.TotalInsuredAmount = '200000.00'
    result.LmiFee = '194.65'
    result.LmiTax = '30.00'
    result.LmiDuty = '17.25'
    result.Status = 'NODOCUMENT'
}
def responseStr = ""
if("APPROVED".equals(result.Status)) {
responseStr = """
<ePMIXMLResponse>
   <DocHeader>
      <Identification>
         <Sender>DEMO TEST</Sender>
         <SenderGuid>12345678-90AB-CDEF-1234-567890ABCDEF</SenderGuid>
         <SenderDocumentIdentifier/>
         <LenderName/>
         <ReceiveDateTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone('GMT+10'))}</ReceiveDateTime>
         <SourceIP>203.152.10.52</SourceIP>
         <DocumentID>${referenceId}</DocumentID>
      </Identification>
      <State>
         <AcceptStatus>
            <Status>ACCEPTED</Status>
            <StatusDateTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone('GMT+10'))}</StatusDateTime>
            <StatusMessage/>
         </AcceptStatus>
         <DocStatus>
            <Status>SUCCESS</Status>
            <StatusDateTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone('GMT+10'))}</StatusDateTime>
            <StatusMessage/>
         </DocStatus>
      </State>
   </DocHeader>
   <Document><![CDATA[<?xml version="1.0"?>
<MessageBatch>
    <Identifier Type="Sequential" UniqueID="1035190064"/>
    <RevisionNumber LIXIVersion="1.2" LenderVersion="1.0"/>
    <Submission>
        <Date Year="${dateNow.format("yyyy")}" Month="${dateNow.format("MM")}" Day="${dateNow.format("dd")}"/>
        <Time Hour="${dateNow.format("HH")}" Minute="${dateNow.format("mm")}" Second="${dateNow.format("ss")}"/>
    </Submission>
    <Message>
        <Identifier Type="Sequential" UniqueID="1035190064"/>
        <MessageRelatesTo>
            <Identifier Type="Sequential" UniqueID="1035190064"/>
            <Identifier Type="MIAssigned" UniqueID="IDA1IOJ"/>
            <Identifier Type="SenderAssigned" UniqueID="MySenderRef"/>
            <Identifier Type="LenderAssigned" UniqueID="LenderRef"/>
            <Submission>
                <Date Year="${dateNow.format("yyyy")}" Month="${dateNow.format("MM")}" Day="${dateNow.format("dd")}"/>
                <Time Hour="${dateNow.format("HH")}" Minute="${dateNow.format("mm")}" Second="${dateNow.format("ss")}"/>
            </Submission>
        </MessageRelatesTo>
        <MessageBody Type="Status" Content="Approved">
            <MessageXPath>ApplicationResult</MessageXPath>
        </MessageBody>
        <MessageBody Type="Status" Content="Standard">
            <MessageXPath>UnderWritingType</MessageXPath>
        </MessageBody>
        <MessageBody Type="Status" Content="Approved">
            <MessageXPath>eAssurance</MessageXPath>
        </MessageBody>
        <MessageBody Type="Status" Content="${result.LmiFee}">
            <MessageXPath>LMIFee</MessageXPath>
        </MessageBody>
        <MessageBody Type="Status" Content="${result.LmiTax}">
            <MessageXPath>LMITax</MessageXPath>
        </MessageBody>
        <MessageBody Type="Status" Content="${result.LmiDuty}">
            <MessageXPath>LMIDuty</MessageXPath>
        </MessageBody>
        <MessageBody Type="Status" Content="pmiGOLD">
            <MessageXPath>ProductCode </MessageXPath>
        </MessageBody>
        <MessageBody Type="Status" Content="${result.TotalInsuredAmount}">
            <MessageXPath>InsuredLoanAmount</MessageXPath>
        </MessageBody>
        <MessageBody Type="Status" Content="100.00 ">
            <MessageXPath>ExtentofCover</MessageXPath>
        </MessageBody>
        <MessageBody Type="Status" Content="2018-12-31 ">
            <MessageXPath>ExpiryDate</MessageXPath>
        </MessageBody>
        <MessageBody Type="Status" Content="Congratulations!!!">
            <MessageXPath>Comments</MessageXPath>
        </MessageBody>
    </Message>
</MessageBatch>]]></Document>
</ePMIXMLResponse>"""
}
else if("ERROR".equals(result.Status)) {
responseStr = """
<ePMIXMLResponse>
    <DocHeader>
        <Identification>
            <Sender>DEMO TEST</Sender>
            <SenderGuid>12345678-90AB-CDEF-1234-567890ABCDEF</SenderGuid>
            <SenderDocumentIdentifier />
            <LenderName />
            <ReceiveDateTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone('GMT+10'))}</ReceiveDateTime>
            <SourceIP>203.152.10.52</SourceIP>
            <DocumentID>${referenceId}</DocumentID>
        </Identification>
        <State>
            <AcceptStatus>
                <Status>ACCEPTED</Status>
                <StatusDateTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone('GMT+10'))}</StatusDateTime>
                <StatusMessage />
            </AcceptStatus>
            <DocStatus>
                <Status>SUCCESS</Status>
                <StatusDateTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone('GMT+10'))}</StatusDateTime>
                <StatusMessage />
            </DocStatus>
        </State>
    </DocHeader>
    <Document><![CDATA[<?xml version="1.0"?>
        <MessageBatch>
            <Identifier Type="Sequential" UniqueID="1035190064" />
            <RevisionNumber LIXIVersion="1.2" LenderVersion="1.0"></RevisionNumber>
            <Submission>
                <Date Year="${dateNow.format("yyyy")}" Month="${dateNow.format("MM")}" Day="${dateNow.format("dd")}" />
                <Time Hour="${dateNow.format("HH")}" Minute="${dateNow.format("mm")}" Second="${dateNow.format("ss")}" />
            </Submission>
            <Message>
                <Identifier Type="Sequential" UniqueID="1035190064" />
                <MessageRelatesTo>
                    <Identifier Type="Sequential" UniqueID="1035190064"></Identifier>
                    <Identifier Type="MIAssigned" UniqueID=""></Identifier>
                    <Identifier Type="SenderAssigned" UniqueID="MySenderRef"></Identifier>
                    <Identifier Type="LenderAssigned" UniqueID="LenderRef"></Identifier>
                    <Submission>
                        <Date Year="${dateNow.format("yyyy")}" Month="${dateNow.format("MM")}" Day="${dateNow.format("dd")}" />
                        <Time Hour="${dateNow.format("HH")}" Minute="${dateNow.format("mm")}" Second="${dateNow.format("ss")}" />
                    </Submission>
                </MessageRelatesTo>
                <MessageBody Type="Status" Content="Error">
                    <MessageXPath>ApplicationResult</MessageXPath>
                </MessageBody>
                <MessageBody Type="Status" Content="[3.35] The application cannot be processed because no primary security has been defined.">
                    <MessageXPath>Comments</MessageXPath>
                </MessageBody>
                <MessageBody Type="Status" Content="[1.3] The application cannot be processed because no information has been defined to indicate whether REBEKAH MAREE LONGHURST is employed on a probationary basis.">
                    <MessageXPath>Comments</MessageXPath>
                </MessageBody>
                <MessageBody Type="Status" Content="[3.28] The application cannot be processed because the defined start of the AUSTRALIAN BANK PTY LTD for REBEKAH MAREE LONGHURST is before the borrower's date of birth (start of employment [Sat Aug 08 12:50:50 EST 2009] before DOB [Mon Nov 25 00:00:00 EST 2013]).">
                    <MessageXPath>Comments</MessageXPath>
                </MessageBody>
                <MessageBody Type="Status" Content="[3.15] The application cannot be processed because REBEKAH MAREE LONGHURST's age, calculated from the date of birth, is less than the minimum allowed (18 years).">
                    <MessageXPath>Comments</MessageXPath>
                </MessageBody>
                <MessageBody Type="Status" Content="[1.30] The application cannot be processed because the type of repayment has not been defined for the loan of 350000.">
                    <MessageXPath>Comments</MessageXPath>
                </MessageBody>
            </Message>
        </MessageBatch>]]>
    </Document>
</ePMIXMLResponse>"""
}
else {
responseStr = """
<ePMIXMLResponse>
    <DocHeader>
        <Identification>
            <Sender>DEMO TEST</Sender>
            <SenderGuid>12345678-90AB-CDEF-1234-567890ABCDEF</SenderGuid>
            <SenderDocumentIdentifier/>
            <LenderName/>
            <ReceiveDateTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone('GMT+10'))}</ReceiveDateTime>
            <SourceIP>203.152.10.52</SourceIP>
            <DocumentID>${referenceId}</DocumentID>
        </Identification>
        <State>
            <AcceptStatus>
                <Status>ACCEPTED</Status>
                <StatusDateTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone('GMT+10'))}</StatusDateTime>
                <StatusMessage/>
            </AcceptStatus>
            <DocStatus>
                <Status>NO DOCUMENT</Status>
                <StatusDateTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone('GMT+10'))}</StatusDateTime>
                <StatusMessage>No response document found for the search criteria</StatusMessage>
            </DocStatus>
        </State>
    </DocHeader>
    <Document/>
</ePMIXMLResponse>"""
}

return responseStr