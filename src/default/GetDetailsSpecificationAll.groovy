def responseStr = null;

def nvic = body.'**'
    .find { it.name() == 'NVIC' }
    ?.text()

log.fine ("[Glass Search] GetDetailsSpecificationAll::nvic: " + nvic);


responseStr = '''
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <soap:Body>
      <GetAutoDetailsSpecificationResponse xmlns="http://microsoft.com/webservices/">
         <GetAutoDetailsSpecificationResult>
            <xs:schema id="NewDataSet" xmlns="" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:msdata="urn:schemas-microsoft-com:xml-msdata">
               <xs:element name="NewDataSet" msdata:IsDataSet="true" msdata:UseCurrentLocale="true">
                  <xs:complexType>
                     <xs:choice minOccurs="0" maxOccurs="unbounded">
                        <xs:element name="Table">
                           <xs:complexType>
                              <xs:sequence>
                                 <xs:element name="ModelTypeCode" type="xs:string" minOccurs="0"/>
                                 <xs:element name="NVIC_Model" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ManufacturerCode" type="xs:string" minOccurs="0"/>
                                 <xs:element name="FamilyCode" type="xs:string" minOccurs="0"/>
                                 <xs:element name="VariantCode" type="xs:string" minOccurs="0"/>
                                 <xs:element name="SeriesCode" type="xs:string" minOccurs="0"/>
                                 <xs:element name="SegmentCode" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ClassCode" type="xs:string" minOccurs="0"/>
                                 <xs:element name="CountryCode" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ReleaseDate" type="xs:dateTime" minOccurs="0"/>
                                 <xs:element name="DiscontinueDate" type="xs:dateTime" minOccurs="0"/>
                                 <xs:element name="MarketingModelCode" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ManufacturerName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ClassName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="SegmentName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="FamilyName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="VariantName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="SeriesName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="CountryName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="BodyName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="Engine_ConfigName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="CCName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="EngineName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="TransmissionName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ModelName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="AVERAGEKM" type="xs:int" minOccurs="0"/>
                                 <xs:element name="AVERAGEKMFOR" type="xs:int" minOccurs="0"/>
                                 <xs:element name="AVERAGEKMTHEN" type="xs:int" minOccurs="0"/>
                                 <xs:element name="Ident" type="xs:string" minOccurs="0"/>
                                 <xs:element name="NVIC_CUR" type="xs:string" minOccurs="0"/>
                                 <xs:element name="RRP" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="YearCreate" type="xs:int" minOccurs="0"/>
                                 <xs:element name="TradeLow" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="Trade" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="Retail" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="ValveGearName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="NumberOfValves" type="xs:int" minOccurs="0"/>
                                 <xs:element name="CompressionRatio" type="xs:string" minOccurs="0"/>
                                 <xs:element name="Bore" type="xs:string" minOccurs="0"/>
                                 <xs:element name="Stroke" type="xs:string" minOccurs="0"/>
                                 <xs:element name="KW" type="xs:int" minOccurs="0"/>
                                 <xs:element name="KWRpm" type="xs:int" minOccurs="0"/>
                                 <xs:element name="Torque" type="xs:int" minOccurs="0"/>
                                 <xs:element name="TorqueRpm" type="xs:int" minOccurs="0"/>
                                 <xs:element name="FuelName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="Capacity" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="CityConsumption" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="HighwayConsumption" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="DrivenWheelsName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="GearFinalRatio" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="WheelRimsfront" type="xs:string" minOccurs="0"/>
                                 <xs:element name="WheelRimsRear" type="xs:string" minOccurs="0"/>
                                 <xs:element name="TyresFront" type="xs:string" minOccurs="0"/>
                                 <xs:element name="TyresRear" type="xs:string" minOccurs="0"/>
                                 <xs:element name="VINLocationName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="VINNumber" type="xs:string" minOccurs="0"/>
                                 <xs:element name="VINCompPlateCode" type="xs:string" minOccurs="0"/>
                                 <xs:element name="NoOfDoors" type="xs:int" minOccurs="0"/>
                                 <xs:element name="Height" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="Length" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="Width" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="GroundClearance" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="WheelBase" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="GCM" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="GVM" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="KerbWeight" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="TurningCircle" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="TrackFront" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="TrackRear" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="TowCapBraked" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="TowCapUnBraked" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="NoOfSeats" type="xs:int" minOccurs="0"/>
                                 <xs:element name="PayLoad" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="SteeringName" type="xs:string" minOccurs="0"/>
                                 <xs:element name="FrontBrakes" type="xs:string" minOccurs="0"/>
                                 <xs:element name="RearBrakes" type="xs:string" minOccurs="0"/>
                                 <xs:element name="SuspensionFront" type="xs:string" minOccurs="0"/>
                                 <xs:element name="SuspensionRear" type="xs:string" minOccurs="0"/>
                                 <xs:element name="Service_Months" type="xs:int" minOccurs="0"/>
                                 <xs:element name="Service_KMS" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="CO2Emission" type="xs:string" minOccurs="0"/>
                                 <xs:element name="ANCAP" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="OverAllRating" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="GreenHouse" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="AirPollution" type="xs:decimal" minOccurs="0"/>
                                 <xs:element name="MTH" type="xs:int" minOccurs="0"/>
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
                     <ModelTypeCode>A</ModelTypeCode>
                     <NVIC_Model>${nvic}</NVIC_Model>
                     <ManufacturerCode>AUD</ManufacturerCode>
                     <FamilyCode>Q7-</FamilyCode>
                     <VariantCode>36</VariantCode>
                     <SeriesCode>--</SeriesCode>
                     <SegmentCode>SUVLUX</SegmentCode>
                     <ClassCode>LCV</ClassCode>
                     <CountryCode>DEU</CountryCode>
                     <ReleaseDate>2006-09-01T00:00:00+10:00</ReleaseDate>
                     <DiscontinueDate>2007-06-30T00:00:00+10:00</DiscontinueDate>
                     <MarketingModelCode>4LB0DL</MarketingModelCode>
                     <ManufacturerName>AUDI</ManufacturerName>
                     <ClassName>LIGHT COMMERCIAL VEHICLE</ClassName>
                     <SegmentName>SUV LUXURY</SegmentName>
                     <FamilyName>Q7</FamilyName>
                     <VariantName>3.6 FSI QUATTRO</VariantName>
                     <SeriesName/>
                     <CountryName>GERMANY</CountryName>
                     <BodyName>4D WAGON</BodyName>
                     <Engine_ConfigName>V6</Engine_ConfigName>
                     <CCName>3597 cc</CCName>
                     <EngineName>MULTI POINT F/INJ</EngineName>
                     <TransmissionName>6 SP AUTOMATIC TIPTRONIC</TransmissionName>
                     <ModelName>AUDI Q7 3.6 FSI QUATTRO  4D WAGON V6 3597 cc MPFI 6 SP AUTOMATIC TIPTRONIC</ModelName>
                     <AVERAGEKM>12</AVERAGEKM>
                     <AVERAGEKMFOR>3</AVERAGEKMFOR>
                     <AVERAGEKMTHEN>14</AVERAGEKMTHEN>
                     <Ident>(Sep)</Ident>
                     <NVIC_CUR>G2006I</NVIC_CUR>
                     <RRP>84900.0000</RRP>
                     <YearCreate>2006</YearCreate>
                     <TradeLow>11200.0000</TradeLow>
                     <Trade>12800.0000</Trade>
                     <Retail>16800.0000</Retail>
                     <ValveGearName>VARIABLE DOUBLE OVERHEAD CAM</ValveGearName>
                     <NumberOfValves>24</NumberOfValves>
                     <CompressionRatio>12.0</CompressionRatio>
                     <Bore>89</Bore>
                     <Stroke>96.4</Stroke>
                     <KW>206</KW>
                     <KWRpm>6200</KWRpm>
                     <Torque>360</Torque>
                     <TorqueRpm>2500</TorqueRpm>
                     <FuelName>PREMIUM UNLEADED PETROL</FuelName>
                     <Capacity>100.00</Capacity>
                     <CityConsumption>12.70</CityConsumption>
                     <HighwayConsumption>0.00</HighwayConsumption>
                     <DrivenWheelsName>ALL WHEEL DRIVE</DrivenWheelsName>
                     <GearFinalRatio>4.5560</GearFinalRatio>
                     <WheelRimsfront>7.5x18</WheelRimsfront>
                     <WheelRimsRear>7.5x18</WheelRimsRear>
                     <TyresFront>235/60 R18</TyresFront>
                     <TyresRear>235/60 R18</TyresRear>
                     <VINLocationName>Rear Lug Comp on S/Wheel Well</VINLocationName>
                     <VINNumber>WAUZZZ4LX7D123456</VINNumber>
                     <VINCompPlateCode>Rear Pass Side Quarter Panel</VINCompPlateCode>
                     <NoOfDoors>4</NoOfDoors>
                     <Height>1772.0000</Height>
                     <Length>5086.0000</Length>
                     <Width>2000.0000</Width>
                     <GroundClearance>204.0000</GroundClearance>
                     <WheelBase>3002.0000</WheelBase>
                     <GCM>0.0000</GCM>
                     <GVM>2900.0000</GVM>
                     <KerbWeight>2205.0000</KerbWeight>
                     <TurningCircle>12.0000</TurningCircle>
                     <TrackFront>1651.0000</TrackFront>
                     <TrackRear>1676.0000</TrackRear>
                     <TowCapBraked>3500.0000</TowCapBraked>
                     <TowCapUnBraked>750.0000</TowCapUnBraked>
                     <NoOfSeats>5</NoOfSeats>
                     <PayLoad>695.0000</PayLoad>
                     <SteeringName>RACK &amp; PINION - POWER ASSISTED</SteeringName>
                     <FrontBrakes>DISC - VENTILATED</FrontBrakes>
                     <RearBrakes>DISC - VENTILATED</RearBrakes>
                     <SuspensionFront>DWB;CS;GD;ARB;</SuspensionFront>
                     <SuspensionRear>DWB;CS;GD;ARB;</SuspensionRear>
                     <Service_Months>12</Service_Months>
                     <Service_KMS>15.00</Service_KMS>
                     <CO2Emission/>
                     <ANCAP>9.0</ANCAP>
                     <OverAllRating>0.00</OverAllRating>
                     <GreenHouse>0.00</GreenHouse>
                     <AirPollution>0.00</AirPollution>
                     <MTH>9</MTH>
                  </Table>
               </NewDataSet>
            </diffgr:diffgram>
         </GetAutoDetailsSpecificationResult>
      </GetAutoDetailsSpecificationResponse>
   </soap:Body>
</soap:Envelope>
''';

return responseStr
