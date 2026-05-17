def responseStr = null;

def manufacturerCode = body.'**'
    .find { it.name() == 'ManufacturerCode' }
    ?.text()

log.fine ("[Glass Search] GetListOfModels::ManufacturerCode: " + manufacturerCode);

if (manufacturerCode == 'AUD') {
    responseStr = '''
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <soap:Body>
      <GetListOfModelsResponse xmlns="http://microsoft.com/webservices/">
         <GetListOfModelsResult>
            <xs:schema id="NewDataSet" xmlns="" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:msdata="urn:schemas-microsoft-com:xml-msdata">
               <xs:element name="NewDataSet" msdata:IsDataSet="true" msdata:UseCurrentLocale="true">
                  <xs:complexType>
                     <xs:choice minOccurs="0" maxOccurs="unbounded">
                        <xs:element name="Table">
                           <xs:complexType>
                              <xs:sequence>
                                 <xs:element name="Code" type="xs:string" minOccurs="0"/>
                                 <xs:element name="Name" type="xs:string" minOccurs="0"/>
                              </xs:sequence>
                           </xs:complexType>
                        </xs:element>
                     </xs:choice>
                  </xs:complexType>
               </xs:element>
            </xs:schema>
            <diffgr:diffgram xmlns:msdata="urn:schemas-microsoft-com:xml-msdata" xmlns:diffgr="urn:schemas-microsoft-com:xml-diffgram-v1">
               <NewDataSet xmlns="">
                  <Table diffgr:id="Table1" msdata:rowOrder="0">
                     <Code>A3-</Code>
                     <Name>A3</Name>
                  </Table>
                  <Table diffgr:id="Table2" msdata:rowOrder="1">
                     <Code>A4-</Code>
                     <Name>A4</Name>
                  </Table>
                  <Table diffgr:id="Table3" msdata:rowOrder="2">
                     <Code>A6-</Code>
                     <Name>A6</Name>
                  </Table>
                  <Table diffgr:id="Table4" msdata:rowOrder="3">
                     <Code>A7-</Code>
                     <Name>A7</Name>
                  </Table>
                  <Table diffgr:id="Table5" msdata:rowOrder="4">
                     <Code>A8-</Code>
                     <Name>A8</Name>
                  </Table>
                  <Table diffgr:id="Table6" msdata:rowOrder="5">
                     <Code>ARQ</Code>
                     <Name>ALLROAD QUATTRO</Name>
                  </Table>
                  <Table diffgr:id="Table7" msdata:rowOrder="6">
                     <Code>Q7-</Code>
                     <Name>Q7</Name>
                  </Table>
                  <Table diffgr:id="Table8" msdata:rowOrder="7">
                     <Code>RS4</Code>
                     <Name>RS 4</Name>
                  </Table>
                  <Table diffgr:id="Table9" msdata:rowOrder="8">
                     <Code>S4-</Code>
                     <Name>S4</Name>
                  </Table>
                  <Table diffgr:id="Table10" msdata:rowOrder="9">
                     <Code>S6-</Code>
                     <Name>S6</Name>
                  </Table>
                  <Table diffgr:id="Table11" msdata:rowOrder="10">
                     <Code>S8-</Code>
                     <Name>S8</Name>
                  </Table>
                  <Table diffgr:id="Table12" msdata:rowOrder="11">
                     <Code>TT-</Code>
                     <Name>TT</Name>
                  </Table>
               </NewDataSet>
            </diffgr:diffgram>
         </GetListOfModelsResult>
      </GetListOfModelsResponse>
   </soap:Body>
</soap:Envelope>
    ''';
} else if (manufacturerCode == 'HON') {
responseStr = '''
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <soap:Body>
      <GetListOfModelsResponse xmlns="http://microsoft.com/webservices/">
         <GetListOfModelsResult>
            <xs:schema id="NewDataSet" xmlns="" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:msdata="urn:schemas-microsoft-com:xml-msdata">
               <xs:element name="NewDataSet" msdata:IsDataSet="true" msdata:UseCurrentLocale="true">
                  <xs:complexType>
                     <xs:choice minOccurs="0" maxOccurs="unbounded">
                        <xs:element name="Table">
                           <xs:complexType>
                              <xs:sequence>
                                 <xs:element name="Code" type="xs:string" minOccurs="0"/>
                                 <xs:element name="Name" type="xs:string" minOccurs="0"/>
                              </xs:sequence>
                           </xs:complexType>
                        </xs:element>
                     </xs:choice>
                  </xs:complexType>
               </xs:element>
            </xs:schema>
            <diffgr:diffgram xmlns:msdata="urn:schemas-microsoft-com:xml-msdata" xmlns:diffgr="urn:schemas-microsoft-com:xml-diffgram-v1">
               <NewDataSet xmlns="">
                  <Table diffgr:id="Table1" msdata:rowOrder="0">
                     <Code>ACCORD</Code>
                     <Name>ACCORD</Name>
                  </Table>
                  <Table diffgr:id="Table2" msdata:rowOrder="1">
                     <Code>CIVIC</Code>
                     <Name>CIVIC</Name>
                  </Table>
               </NewDataSet>
            </diffgr:diffgram>
         </GetListOfModelsResult>
      </GetListOfModelsResponse>
   </soap:Body>
</soap:Envelope>
    ''';
} else {
    // No model found
    responseStr = '''
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
    <soap:Body>
        <GetListOfModelsResponse xmlns="http://microsoft.com/webservices/">
            <GetListOfModelsResult>
                <xs:schema id="NewDataSet" xmlns="" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:msdata="urn:schemas-microsoft-com:xml-msdata">
                <xs:element name="NewDataSet" msdata:IsDataSet="true" msdata:UseCurrentLocale="true">
                    <xs:complexType>
                        <xs:choice minOccurs="0" maxOccurs="unbounded">
                            <xs:element name="Table">
                            <xs:complexType>
                                <xs:sequence>
                                    <xs:element name="Code" type="xs:string" minOccurs="0"/>
                                    <xs:element name="Name" type="xs:string" minOccurs="0"/>
                                </xs:sequence>
                            </xs:complexType>
                            </xs:element>
                        </xs:choice>
                    </xs:complexType>
                </xs:element>
                </xs:schema>
                <diffgr:diffgram xmlns:msdata="urn:schemas-microsoft-com:xml-msdata" xmlns:diffgr="urn:schemas-microsoft-com:xml-diffgram-v1">
                <NewDataSet xmlns="">
                </NewDataSet>
                </diffgr:diffgram>
            </GetListOfModelsResult>
        </GetListOfModelsResponse>
    </soap:Body>
</soap:Envelope>
    ''';
}


return responseStr
