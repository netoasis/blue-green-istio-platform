dateNow = new Date()

def responseStr = """
<ePMIXMLResponse>
   <DocHeader>
      <Identification>
         <Sender>DEMO TEST</Sender>
         <SenderGuid>12345678-90AB-CDEF-1234-567890ABCDEF</SenderGuid>
         <SenderDocumentIdentifier/>
         <LenderName>SANDSTONE</LenderName>
         <ReceiveDateTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone('GMT+10'))}</ReceiveDateTime>
         <SourceIP>203.152.10.52</SourceIP>
         <DocumentID>${new Random().nextInt(90000000)+1000000000}</DocumentID>
      </Identification>
      <State>
         <AcceptStatus>
            <Status>ACCEPTED</Status>
            <StatusDateTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone('GMT+10'))}</StatusDateTime>
         </AcceptStatus>
         <DocStatus>
            <Status>VALID</Status>
            <StatusDateTime>${dateNow.format("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone('GMT+10'))}</StatusDateTime>
         </DocStatus>
      </State>
   </DocHeader>
   <Document><![CDATA[<ApplicationBatch/>]]></Document>
</ePMIXMLResponse>"""

return responseStr