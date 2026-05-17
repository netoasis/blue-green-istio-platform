def responseStr = null;

responseStr = '''
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <soap:Body>
      <GetListOfMakesResponse xmlns="http://microsoft.com/webservices/">
         <GetListOfMakesResult>
            <xs:schema id="NewDataSet" xmlns="" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:msdata="urn:schemas-microsoft-com:xml-msdata">
               <xs:element name="NewDataSet" msdata:IsDataSet="true" msdata:UseCurrentLocale="true">
                  <xs:complexType>
                     <xs:choice minOccurs="0" maxOccurs="unbounded">
                        <xs:element name="Table">
                           <xs:complexType>
                              <xs:sequence>
                                 <xs:element name="code" type="xs:string" minOccurs="0"/>
                                 <xs:element name="name" type="xs:string" minOccurs="0"/>
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
                     <code>ALF</code>
                     <name>ALFA ROMEO</name>
                  </Table>
                  <Table diffgr:id="Table2" msdata:rowOrder="1">
                     <code>AST</code>
                     <name>ASTON MARTIN</name>
                  </Table>
                  <Table diffgr:id="Table3" msdata:rowOrder="2">
                     <code>AUD</code>
                     <name>AUDI</name>
                  </Table>
                  <Table diffgr:id="Table4" msdata:rowOrder="3">
                     <code>BEN</code>
                     <name>BENTLEY</name>
                  </Table>
                  <Table diffgr:id="Table5" msdata:rowOrder="4">
                     <code>BMW</code>
                     <name>BMW</name>
                  </Table>
                  <Table diffgr:id="Table6" msdata:rowOrder="5">
                     <code>CHR</code>
                     <name>CHRYSLER</name>
                  </Table>
                  <Table diffgr:id="Table7" msdata:rowOrder="6">
                     <code>CIT</code>
                     <name>CITROEN</name>
                  </Table>
                  <Table diffgr:id="Table8" msdata:rowOrder="7">
                     <code>DAI</code>
                     <name>DAIHATSU</name>
                  </Table>
                  <Table diffgr:id="Table9" msdata:rowOrder="8">
                     <code>DOD</code>
                     <name>DODGE</name>
                  </Table>
                  <Table diffgr:id="Table10" msdata:rowOrder="9">
                     <code>FER</code>
                     <name>FERRARI</name>
                  </Table>
                  <Table diffgr:id="Table11" msdata:rowOrder="10">
                     <code>FIA</code>
                     <name>FIAT</name>
                  </Table>
                  <Table diffgr:id="Table12" msdata:rowOrder="11">
                     <code>FOR</code>
                     <name>FORD</name>
                  </Table>
                  <Table diffgr:id="Table13" msdata:rowOrder="12">
                     <code>FRE</code>
                     <name>FREIGHTLINER</name>
                  </Table>
                  <Table diffgr:id="Table14" msdata:rowOrder="13">
                     <code>HIN</code>
                     <name>HINO</name>
                  </Table>
                  <Table diffgr:id="Table15" msdata:rowOrder="14">
                     <code>HOL</code>
                     <name>HOLDEN</name>
                  </Table>
                  <Table diffgr:id="Table16" msdata:rowOrder="15">
                     <code>HON</code>
                     <name>HONDA</name>
                  </Table>
                  <Table diffgr:id="Table17" msdata:rowOrder="16">
                     <code>HSV</code>
                     <name>HSV</name>
                  </Table>
                  <Table diffgr:id="Table18" msdata:rowOrder="17">
                     <code>HYU</code>
                     <name>HYUNDAI</name>
                  </Table>
                  <Table diffgr:id="Table19" msdata:rowOrder="18">
                     <code>ISU</code>
                     <name>ISUZU</name>
                  </Table>
                  <Table diffgr:id="Table20" msdata:rowOrder="19">
                     <code>IVE</code>
                     <name>IVECO</name>
                  </Table>
                  <Table diffgr:id="Table21" msdata:rowOrder="20">
                     <code>JAG</code>
                     <name>JAGUAR</name>
                  </Table>
                  <Table diffgr:id="Table22" msdata:rowOrder="21">
                     <code>JEE</code>
                     <name>JEEP</name>
                  </Table>
                  <Table diffgr:id="Table23" msdata:rowOrder="22">
                     <code>KEN</code>
                     <name>KENWORTH</name>
                  </Table>
                  <Table diffgr:id="Table24" msdata:rowOrder="23">
                     <code>KIA</code>
                     <name>KIA</name>
                  </Table>
                  <Table diffgr:id="Table25" msdata:rowOrder="24">
                     <code>LAM</code>
                     <name>LAMBORGHINI</name>
                  </Table>
                  <Table diffgr:id="Table26" msdata:rowOrder="25">
                     <code>LEX</code>
                     <name>LEXUS</name>
                  </Table>
                  <Table diffgr:id="Table27" msdata:rowOrder="26">
                     <code>LOT</code>
                     <name>LOTUS</name>
                  </Table>
                  <Table diffgr:id="Table28" msdata:rowOrder="27">
                     <code>LRO</code>
                     <name>LAND ROVER</name>
                  </Table>
                  <Table diffgr:id="Table29" msdata:rowOrder="28">
                     <code>MAC</code>
                     <name>MACK</name>
                  </Table>
                  <Table diffgr:id="Table30" msdata:rowOrder="29">
                     <code>MAN</code>
                     <name>MAN</name>
                  </Table>
                  <Table diffgr:id="Table31" msdata:rowOrder="30">
                     <code>MAS</code>
                     <name>MASERATI</name>
                  </Table>
                  <Table diffgr:id="Table32" msdata:rowOrder="31">
                     <code>MAY</code>
                     <name>MAYBACH</name>
                  </Table>
                  <Table diffgr:id="Table33" msdata:rowOrder="32">
                     <code>MAZ</code>
                     <name>MAZDA</name>
                  </Table>
                  <Table diffgr:id="Table34" msdata:rowOrder="33">
                     <code>MER</code>
                     <name>MERCEDES-BENZ</name>
                  </Table>
                  <Table diffgr:id="Table35" msdata:rowOrder="34">
                     <code>MGN</code>
                     <name>MORGAN</name>
                  </Table>
                  <Table diffgr:id="Table36" msdata:rowOrder="35">
                     <code>MIF</code>
                     <name>MITSUBISHI FUSO</name>
                  </Table>
                  <Table diffgr:id="Table37" msdata:rowOrder="36">
                     <code>MIN</code>
                     <name>MINI</name>
                  </Table>
                  <Table diffgr:id="Table38" msdata:rowOrder="37">
                     <code>MIT</code>
                     <name>MITSUBISHI</name>
                  </Table>
                  <Table diffgr:id="Table39" msdata:rowOrder="38">
                     <code>NIS</code>
                     <name>NISSAN</name>
                  </Table>
                  <Table diffgr:id="Table40" msdata:rowOrder="39">
                     <code>OKA</code>
                     <name>OKA</name>
                  </Table>
                  <Table diffgr:id="Table41" msdata:rowOrder="40">
                     <code>PEU</code>
                     <name>PEUGEOT</name>
                  </Table>
                  <Table diffgr:id="Table42" msdata:rowOrder="41">
                     <code>POR</code>
                     <name>PORSCHE</name>
                  </Table>
                  <Table diffgr:id="Table43" msdata:rowOrder="42">
                     <code>PRO</code>
                     <name>PROTON</name>
                  </Table>
                  <Table diffgr:id="Table44" msdata:rowOrder="43">
                     <code>RAN</code>
                     <name>RANGE ROVER</name>
                  </Table>
                  <Table diffgr:id="Table45" msdata:rowOrder="44">
                     <code>REN</code>
                     <name>RENAULT</name>
                  </Table>
                  <Table diffgr:id="Table46" msdata:rowOrder="45">
                     <code>RFW</code>
                     <name>RFW</name>
                  </Table>
                  <Table diffgr:id="Table47" msdata:rowOrder="46">
                     <code>ROL</code>
                     <name>ROLLS-ROYCE</name>
                  </Table>
                  <Table diffgr:id="Table48" msdata:rowOrder="47">
                     <code>SAA</code>
                     <name>SAAB</name>
                  </Table>
                  <Table diffgr:id="Table49" msdata:rowOrder="48">
                     <code>SCA</code>
                     <name>SCANIA</name>
                  </Table>
                  <Table diffgr:id="Table50" msdata:rowOrder="49">
                     <code>SMA</code>
                     <name>SMART</name>
                  </Table>
                  <Table diffgr:id="Table51" msdata:rowOrder="50">
                     <code>SSA</code>
                     <name>SSANGYONG</name>
                  </Table>
                  <Table diffgr:id="Table52" msdata:rowOrder="51">
                     <code>STE</code>
                     <name>STERLING</name>
                  </Table>
                  <Table diffgr:id="Table53" msdata:rowOrder="52">
                     <code>SUB</code>
                     <name>SUBARU</name>
                  </Table>
                  <Table diffgr:id="Table54" msdata:rowOrder="53">
                     <code>SUZ</code>
                     <name>SUZUKI</name>
                  </Table>
                  <Table diffgr:id="Table55" msdata:rowOrder="54">
                     <code>TOY</code>
                     <name>TOYOTA</name>
                  </Table>
                  <Table diffgr:id="Table56" msdata:rowOrder="55">
                     <code>UD-</code>
                     <name>UD</name>
                  </Table>
                  <Table diffgr:id="Table57" msdata:rowOrder="56">
                     <code>VOL</code>
                     <name>VOLVO</name>
                  </Table>
                  <Table diffgr:id="Table58" msdata:rowOrder="57">
                     <code>VWN</code>
                     <name>VOLKSWAGEN</name>
                  </Table>
                  <Table diffgr:id="Table59" msdata:rowOrder="58">
                     <code>WES</code>
                     <name>WESTERN STAR</name>
                  </Table>
               </NewDataSet>
            </diffgr:diffgram>
         </GetListOfMakesResult>
      </GetListOfMakesResponse>
   </soap:Body>
</soap:Envelope>
''';

return responseStr
