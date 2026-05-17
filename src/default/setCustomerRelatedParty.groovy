import java.util.ArrayList;
import groovy.xml.XmlUtil;
import groovy.xml.StreamingMarkupBuilder;
import groovy.util.slurpersupport.GPathResult;
def slurper = new XmlSlurper();
def requestBodyNode = body

requestBodyNode.SetCustomerRelatedPartyRequest.LendingOrganisation.replaceNode({});
requestBodyNode.SetCustomerRelatedPartyRequest.FundingInstitution.replaceNode({});
requestBodyNode.SetCustomerRelatedPartyRequest.Sender.replaceNode({});
requestBodyNode.SetCustomerRelatedPartyRequest.AddressSegment.replaceNode({});

ArrayList tempRelatedPartyList = new ArrayList();
requestBodyNode.SetCustomerRelatedPartyRequest.RelatedPartySegment.RelatedParty.findAll{parties -> parties.@RelPartyType.text() != 'Lender' && parties.'*'.RelatedEntityRef?.@RelatedID?.size() == 0}.each(){party ->
    def uniqueId = party.Identifier.@UniqueID.text() + "-customerCode";
    def temp = null
    if (party.Person != null) {
	    party.Person.replaceNode({
		'Person'() {
			'RelatedEntityRef'(RelatedID:uniqueId)
			mkp.yield party.Person."*"
		}
	    });
    } 
    if (party.Company != null) {
	    party.Company.replaceNode({
		'Company'() {
			'RelatedEntityRef'(RelatedID:uniqueId)
			mkp.yield party.Company."*"
		}
	    });
    }
    
    Random random =  new Random();                    
    custNumber = random.nextInt(100000).toString();
    def generatedRelParty = """<RelatedParty RelPartyType="Lender">
                                <Identifier UniqueID="${uniqueId}"/>
                                <Company>
                                    <CompanyName BusinessName="Sandstone Technology"/>
                                </Company>
                                <Lender ExistingCustomer="Yes" LenderStaff="No">
                                    <CustomerNumber>${custNumber}</CustomerNumber>
                                </Lender>
                            </RelatedParty>"""
    def generatedRelPartyNode = slurper.parseText(generatedRelParty);
    tempRelatedPartyList.add(generatedRelPartyNode);
}

tempRelatedPartyList.each { eachNode ->
	requestBodyNode.SetCustomerRelatedPartyRequest.RelatedPartySegment << eachNode;
}

def responseStr = """<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/'><soapenv:Header/><soapenv:Body><SetCustomerRelatedPartyResponse xmlns='http://www.sandstone.com.au/lending'></SetCustomerRelatedPartyResponse></soapenv:Body></soapenv:Envelope>""";
def responseNode = slurper.parseText(responseStr);
responseNode.Body.SetCustomerRelatedPartyResponse << requestBodyNode.SetCustomerRelatedPartyRequest.children();

//Serialization method
def String serializeXml(GPathResult xml){
    def defaultNamespace = xml.lookupNamespace('')

    if (defaultNamespace) {
        def docWithNamespace = {
            mkp.declareNamespace("": defaultNamespace)
            out << xml
        }
        return XmlUtil.serialize(new StreamingMarkupBuilder().bind(docWithNamespace))
    } else {
        return XmlUtil.serialize(xml as GPathResult)
    }
}

return serializeXml(responseNode);