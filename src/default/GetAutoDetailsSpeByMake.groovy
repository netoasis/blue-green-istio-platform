def responseStr = null;

def model = body.'**'
    .find { it.name() == 'model' }
    ?.text()

log.fine ("[Glass Search] GetAutoDetailsSpeByMake::model: " + model);

if (model == 'A7-' ) {
    responseStr = '''
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <soap:Body>
      <GetAutoDetailsSpeByMakeResponse xmlns="http://microsoft.com/webservices/">
         <GetAutoDetailsSpeByMakeResult>
            <xs:schema id="NewDataSet" xmlns="" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:msdata="urn:schemas-microsoft-com:xml-msdata">
               <xs:element name="NewDataSet" msdata:IsDataSet="true" msdata:UseCurrentLocale="true">
                  <xs:complexType>
                     <xs:choice minOccurs="0" maxOccurs="unbounded">
                        <xs:element name="Table">
                           <xs:complexType>
                              <xs:sequence>
                                 <xs:element name="NVIC_CUR" type="xs:string" minOccurs="0"/>
                                 <xs:element name="NVIC_MODEL" type="xs:string" minOccurs="0"/>
                                 <xs:element name="RRP" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="YearCreate" type="xs:int" minOccurs="0"/>
                                 <xs:element name="TradeLow" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="Trade" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="Retail" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="ClassCode" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ClassName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ModelName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ReleaseDate" type="xs:dateTime" minOccurs="0"/>
                                 <xs:element name="DiscontinueDate" type="xs:dateTime" minOccurs="0"/>
                                 <xs:element name="AVERAGEKM" type="xs:int" minOccurs="0"/>
                                 <xs:element name="AVERAGEKMFOR" type="xs:int" minOccurs="0"/>
                                 <xs:element name="AVERAGEKMTHEN" type="xs:int" minOccurs="0"/>
                                 <xs:element name="CategoryCode" type="xs:string" minOccurs="0"/>
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
                     <NVIC_CUR>G1Z06I</NVIC_CUR>
                     <NVIC_MODEL>G1Z</NVIC_MODEL>
                     <RRP>85700.0000</RRP>
                     <YearCreate>2006</YearCreate>
                     <TradeLow>7500.0000</TradeLow>
                     <Trade>8400.0000</Trade>
                     <Retail>11900.0000</Retail>
                     <ClassCode>LCV</ClassCode>
                     <ClassName>LIGHT COMMERCIAL VEHICLE</ClassName>
                     <ModelName>AUDI A7 55 TFSI QUATTRO MHEV 4K MY24 4D SPORTBACK TURBO V6 2995 cc TDFI 7 SP AUTO S-TRONIC</ModelName>
                     <ReleaseDate>2006-09-01T00:00:00+10:00</ReleaseDate>
                     <DiscontinueDate>2007-06-30T00:00:00+10:00</DiscontinueDate>
                     <AVERAGEKM>12</AVERAGEKM>
                     <AVERAGEKMFOR>3</AVERAGEKMFOR>
                     <AVERAGEKMTHEN>14</AVERAGEKMTHEN>
                     <CategoryCode>G</CategoryCode>
                  </Table>
               </NewDataSet>
            </diffgr:diffgram>
         </GetAutoDetailsSpeByMakeResult>
      </GetAutoDetailsSpeByMakeResponse>
   </soap:Body>
</soap:Envelope>
''';
} else if (model == 'A8-') {
    responseStr = '''
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <soap:Body>
      <GetAutoDetailsSpeByMakeResponse xmlns="http://microsoft.com/webservices/">
         <GetAutoDetailsSpeByMakeResult>
            <xs:schema id="NewDataSet" xmlns="" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:msdata="urn:schemas-microsoft-com:xml-msdata">
               <xs:element name="NewDataSet" msdata:IsDataSet="true" msdata:UseCurrentLocale="true">
                  <xs:complexType>
                     <xs:choice minOccurs="0" maxOccurs="unbounded">
                        <xs:element name="Table">
                           <xs:complexType>
                              <xs:sequence>
                                 <xs:element name="NVIC_CUR" type="xs:string" minOccurs="0"/>
                                 <xs:element name="NVIC_MODEL" type="xs:string" minOccurs="0"/>
                                 <xs:element name="RRP" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="YearCreate" type="xs:int" minOccurs="0"/>
                                 <xs:element name="TradeLow" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="Trade" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="Retail" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="ClassCode" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ClassName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ModelName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ReleaseDate" type="xs:dateTime" minOccurs="0"/>
                                 <xs:element name="DiscontinueDate" type="xs:dateTime" minOccurs="0"/>
                                 <xs:element name="AVERAGEKM" type="xs:int" minOccurs="0"/>
                                 <xs:element name="AVERAGEKMFOR" type="xs:int" minOccurs="0"/>
                                 <xs:element name="AVERAGEKMTHEN" type="xs:int" minOccurs="0"/>
                                 <xs:element name="CategoryCode" type="xs:string" minOccurs="0"/>
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
                     <NVIC_CUR>G1Z06I</NVIC_CUR>
                     <NVIC_MODEL>G1Z</NVIC_MODEL>
                     <RRP>85700.0000</RRP>
                     <YearCreate>2006</YearCreate>
                     <TradeLow>7500.0000</TradeLow>
                     <Trade>8400.0000</Trade>
                     <Retail>11900.0000</Retail>
                     <ClassCode>LCV</ClassCode>
                     <ClassName>LIGHT COMMERCIAL VEHICLE</ClassName>
                     <ModelName>AUDI A8 50 TDI QUATTRO LWB MHEV 4N MY19 4D SEDAN DIESEL TURBO V6 2967 cc TCDI 8 SP AUTOMATIC TIPTRONIC</ModelName>
                     <ReleaseDate>2006-09-01T00:00:00+10:00</ReleaseDate>
                     <DiscontinueDate>2007-06-30T00:00:00+10:00</DiscontinueDate>
                     <AVERAGEKM>12</AVERAGEKM>
                     <AVERAGEKMFOR>3</AVERAGEKMFOR>
                     <AVERAGEKMTHEN>14</AVERAGEKMTHEN>
                     <CategoryCode>G</CategoryCode>
                  </Table>
                  <Table diffgr:id="Table2" msdata:rowOrder="1">
                     <NVIC_CUR>G2006I</NVIC_CUR>
                     <NVIC_MODEL>G20</NVIC_MODEL>
                     <RRP>84900.0000</RRP>
                     <YearCreate>2006</YearCreate>
                     <TradeLow>11200.0000</TradeLow>
                     <Trade>12800.0000</Trade>
                     <Retail>16800.0000</Retail>
                     <ClassCode>LCV</ClassCode>
                     <ClassName>LIGHT COMMERCIAL VEHICLE</ClassName>
                     <ModelName>AUDI A8 3.0 TDI QUATTRO 4H MY17 4D SEDAN DIESEL TURBO V6 2976 cc DTFI 8 SP AUTOMATIC TIPTRONIC</ModelName>
                     <ReleaseDate>2006-09-01T00:00:00+10:00</ReleaseDate>
                     <DiscontinueDate>2007-06-30T00:00:00+10:00</DiscontinueDate>
                     <AVERAGEKM>12</AVERAGEKM>
                     <AVERAGEKMFOR>3</AVERAGEKMFOR>
                     <AVERAGEKMTHEN>14</AVERAGEKMTHEN>
                     <CategoryCode>G</CategoryCode>
                  </Table>
               </NewDataSet>
            </diffgr:diffgram>
         </GetAutoDetailsSpeByMakeResult>
      </GetAutoDetailsSpeByMakeResponse>
   </soap:Body>
</soap:Envelope>
''';
} else if (model == 'CIVIC') {
    responseStr = '''
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <soap:Body>
    <GetAutoDetailsSpeByMakeResponse xmlns="http://microsoft.com/webservices/">
      <GetAutoDetailsSpeByMakeResult>
        <xs:schema id="NewDataSet"
                   xmlns=""
                   xmlns:xs="http://www.w3.org/2001/XMLSchema"
                   xmlns:msdata="urn:schemas-microsoft-com:xml-msdata">
          <xs:element name="NewDataSet"
                      msdata:IsDataSet="true"
                      msdata:UseCurrentLocale="true">
            <xs:complexType>
              <xs:choice minOccurs="0" maxOccurs="unbounded">
                <xs:element name="Table">
                  <xs:complexType>
                    <xs:sequence>
                      <xs:element name="NVIC_CUR" type="xs:string" minOccurs="0"/>
                      <xs:element name="NVIC_MODEL" type="xs:string" minOccurs="0"/>
                      <xs:element name="RRP" type="xs:decimal" minOccurs="0"/>
                      <xs:element name="YearCreate" type="xs:int" minOccurs="0"/>
                      <xs:element name="TradeLow" type="xs:decimal" minOccurs="0"/>
                      <xs:element name="Trade" type="xs:decimal" minOccurs="0"/>
                      <xs:element name="Retail" type="xs:decimal" minOccurs="0"/>
                      <xs:element name="ClassCode" type="xs:string" minOccurs="0"/>
                      <xs:element name="ClassName" type="xs:string" minOccurs="0"/>
                      <xs:element name="ModelName" type="xs:string" minOccurs="0"/>
                      <xs:element name="ReleaseDate" type="xs:dateTime" minOccurs="0"/>
                      <xs:element name="DiscontinueDate" type="xs:dateTime" minOccurs="0"/>
                      <xs:element name="AVERAGEKM" type="xs:int" minOccurs="0"/>
                      <xs:element name="AVERAGEKMFOR" type="xs:int" minOccurs="0"/>
                      <xs:element name="AVERAGEKMTHEN" type="xs:int" minOccurs="0"/>
                      <xs:element name="CategoryCode" type="xs:string" minOccurs="0"/>
                    </xs:sequence>
                  </xs:complexType>
                </xs:element>
              </xs:choice>
            </xs:complexType>
          </xs:element>
        </xs:schema>

        <diffgr:diffgram xmlns:msdata="urn:schemas-microsoft-com:xml-msdata"
                          xmlns:diffgr="urn:schemas-microsoft-com:xml-diffgram-v1">
          <NewDataSet xmlns="">
            <Table diffgr:id="Table1" msdata:rowOrder="0">
              <NVIC_CUR>HNC23CIV</NVIC_CUR>
              <NVIC_MODEL>HNC</NVIC_MODEL>
              <RRP>35990.0000</RRP>
              <YearCreate>2023</YearCreate>
              <TradeLow>18000.0000</TradeLow>
              <Trade>20000.0000</Trade>
              <Retail>24500.0000</Retail>
              <ClassCode>PSV</ClassCode>
              <ClassName>PASSENGER VEHICLE</ClassName>
              <ModelName>HONDA CIVIC VTi-L MY23 4D SEDAN TURBO 4CYL 1.5L CVT</ModelName>
              <ReleaseDate>2022-08-01T00:00:00+10:00</ReleaseDate>
              <DiscontinueDate xsi:nil="true"/>
              <AVERAGEKM>15</AVERAGEKM>
              <AVERAGEKMFOR>3</AVERAGEKMFOR>
              <AVERAGEKMTHEN>45</AVERAGEKMTHEN>
              <CategoryCode>C</CategoryCode>
            </Table>
          </NewDataSet>
        </diffgr:diffgram>
      </GetAutoDetailsSpeByMakeResult>
    </GetAutoDetailsSpeByMakeResponse>
  </soap:Body>
</soap:Envelope>
''';
} else if (model == 'ACCORD') {
responseStr = '''
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns:xsd="http://www.w3.org/2001/XMLSchema">
    <soap:Body>
        <GetAutoDetailsSpeByMakeResponse xmlns="http://microsoft.com/webservices/">
        <GetAutoDetailsSpeByMakeResult>
            <xs:schema id="NewDataSet"
                    xmlns=""
                    xmlns:xs="http://www.w3.org/2001/XMLSchema"
                    xmlns:msdata="urn:schemas-microsoft-com:xml-msdata">
            <xs:element name="NewDataSet"
                        msdata:IsDataSet="true"
                        msdata:UseCurrentLocale="true">
                <xs:complexType>
                <xs:choice minOccurs="0" maxOccurs="unbounded">
                    <xs:element name="Table">
                    <xs:complexType>
                        <xs:sequence>
                        <xs:element name="NVIC_CUR" type="xs:string" minOccurs="0"/>
                        <xs:element name="NVIC_MODEL" type="xs:string" minOccurs="0"/>
                        <xs:element name="RRP" type="xs:decimal" minOccurs="0"/>
                        <xs:element name="YearCreate" type="xs:int" minOccurs="0"/>
                        <xs:element name="TradeLow" type="xs:decimal" minOccurs="0"/>
                        <xs:element name="Trade" type="xs:decimal" minOccurs="0"/>
                        <xs:element name="Retail" type="xs:decimal" minOccurs="0"/>
                        <xs:element name="ClassCode" type="xs:string" minOccurs="0"/>
                        <xs:element name="ClassName" type="xs:string" minOccurs="0"/>
                        <xs:element name="ModelName" type="xs:string" minOccurs="0"/>
                        <xs:element name="ReleaseDate" type="xs:dateTime" minOccurs="0"/>
                        <xs:element name="DiscontinueDate" type="xs:dateTime" minOccurs="0"/>
                        <xs:element name="AVERAGEKM" type="xs:int" minOccurs="0"/>
                        <xs:element name="AVERAGEKMFOR" type="xs:int" minOccurs="0"/>
                        <xs:element name="AVERAGEKMTHEN" type="xs:int" minOccurs="0"/>
                        <xs:element name="CategoryCode" type="xs:string" minOccurs="0"/>
                        </xs:sequence>
                    </xs:complexType>
                    </xs:element>
                </xs:choice>
                </xs:complexType>
            </xs:element>
            </xs:schema>

            <diffgr:diffgram xmlns:msdata="urn:schemas-microsoft-com:xml-msdata"
                            xmlns:diffgr="urn:schemas-microsoft-com:xml-diffgram-v1">
            <NewDataSet xmlns="">
                <Table diffgr:id="Table1" msdata:rowOrder="0">
                <NVIC_CUR>HNA23ACC</NVIC_CUR>
                <NVIC_MODEL>HNA</NVIC_MODEL>
                <RRP>52990.0000</RRP>
                <YearCreate>2023</YearCreate>
                <TradeLow>24000.0000</TradeLow>
                <Trade>27000.0000</Trade>
                <Retail>32500.0000</Retail>
                <ClassCode>PSV</ClassCode>
                <ClassName>PASSENGER VEHICLE</ClassName>
                <ModelName>HONDA ACCORD VTi-LX MY23 4D SEDAN TURBO 4CYL 1.5L CVT</ModelName>
                <ReleaseDate>2022-06-01T00:00:00+10:00</ReleaseDate>
                <DiscontinueDate xsi:nil="true"/>
                <AVERAGEKM>15</AVERAGEKM>
                <AVERAGEKMFOR>3</AVERAGEKMFOR>
                <AVERAGEKMTHEN>45</AVERAGEKMTHEN>
                <CategoryCode>C</CategoryCode>
                </Table>
            </NewDataSet>
            </diffgr:diffgram>
        </GetAutoDetailsSpeByMakeResult>
        </GetAutoDetailsSpeByMakeResponse>
    </soap:Body>
</soap:Envelope>
''';
} else {
    responseStr = '''
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <soap:Body>
      <GetAutoDetailsSpeByMakeResponse xmlns="http://microsoft.com/webservices/">
         <GetAutoDetailsSpeByMakeResult>
            <xs:schema id="NewDataSet" xmlns="" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:msdata="urn:schemas-microsoft-com:xml-msdata">
               <xs:element name="NewDataSet" msdata:IsDataSet="true" msdata:UseCurrentLocale="true">
                  <xs:complexType>
                     <xs:choice minOccurs="0" maxOccurs="unbounded">
                        <xs:element name="Table">
                           <xs:complexType>
                              <xs:sequence>
                                 <xs:element name="NVIC_CUR" type="xs:string" minOccurs="0"/>
                                 <xs:element name="NVIC_MODEL" type="xs:string" minOccurs="0"/>
                                 <xs:element name="RRP" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="YearCreate" type="xs:int" minOccurs="0"/>
                                 <xs:element name="TradeLow" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="Trade" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="Retail" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="ClassCode" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ClassName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ModelName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ReleaseDate" type="xs:dateTime" minOccurs="0"/>
                                 <xs:element name="DiscontinueDate" type="xs:dateTime" minOccurs="0"/>
                                 <xs:element name="AVERAGEKM" type="xs:int" minOccurs="0"/>
                                 <xs:element name="AVERAGEKMFOR" type="xs:int" minOccurs="0"/>
                                 <xs:element name="AVERAGEKMTHEN" type="xs:int" minOccurs="0"/>
                                 <xs:element name="CategoryCode" type="xs:string" minOccurs="0"/>
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
         </GetAutoDetailsSpeByMakeResult>
      </GetAutoDetailsSpeByMakeResponse>
   </soap:Body>
</soap:Envelope>
''';
}


return responseStr
