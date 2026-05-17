
def responseStr = """
<mb:MessageBatch xmlns:mb="http://www.lixi.org.au/schema/cal1.5/MessageBatch" ProductionData="No">
  <mb:Identifier UniqueID="MessageBatch-1"/>
  <mb:RevisionNumber LIXIVersion="MessageBatch/1.5" LenderVersion="MessageBatch/1.5"/>
  <mb:Date>2019-11-11</mb:Date>
  <mb:Time>16:33:49</mb:Time>
  <mb:Publisher>
    <mb:RelatedEntityRef RelatedID="Lender-1"/>
  </mb:Publisher>
  <mb:Message>
    <mb:Identifier UniqueID="Message-1"/>
    <mb:MessageRelatesTo>
      <mb:Application>
        <mb:Identifier UniqueID="Not specified" Type="BrokerAssigned"/>
        <mb:Identifier UniqueID="130" Type="LenderAssigned"/>
        <mb:SalesChannel>
          <mb:Identifier UniqueID="lfapply"/>
          <mb:Company>
            <mb:CompanyName BusinessName="Direct Application System (Work Group)"/>
          </mb:Company>
        </mb:SalesChannel>
        <mb:PartySegment>
          <mb:Party InternetBankingId="">
            <mb:Identifier UniqueID="LoanParty-273"/>
            <mb:Person>
              <mb:PersonName>
                <mb:NameTitle Value="Mr"/>
                <mb:FirstName>David</mb:FirstName>
                <mb:OtherName/>
                <mb:Surname>Smith</mb:Surname>
              </mb:PersonName>
              <mb:DateOfBirth>
                <mb:Date>1940-02-08</mb:Date>
              </mb:DateOfBirth>
            </mb:Person>
          </mb:Party>
        </mb:PartySegment>
      </mb:Application>
    </mb:MessageRelatesTo>
    <mb:MessageBody Type="Information">
      <mb:Status Name="Referred" StatusOwner="">
        <mb:Date>2019-11-11</mb:Date>
        <mb:Time>16:33:49</mb:Time>
      </mb:Status>
    </mb:MessageBody>
    <mb:MessageBody Type="Information">
      <mb:MessageAnnotation Type="EndUserMessage">LMI is not required for your application</mb:MessageAnnotation>
    </mb:MessageBody>
    <mb:MessageBody Type="Information">
      <mb:MessageAnnotation Type="EndUserMessage">
For property at 9 WILLAI STREET BOLTON POINT NSW 2283, no external valuation is required
      </mb:MessageAnnotation>
    </mb:MessageBody>
  </mb:Message>
  <mb:RelatedPartySegment>
    <mb:RelatedParty RelPartyType="Lender">
      <mb:Identifier UniqueID="Lender-1"/>
      <mb:Company>
        <mb:CompanyName BusinessName="DEMO"/>
      </mb:Company>
    </mb:RelatedParty>
  </mb:RelatedPartySegment>
</mb:MessageBatch>
"""

return responseStr