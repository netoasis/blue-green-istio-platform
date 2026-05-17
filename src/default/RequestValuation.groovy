vms = loadScript('Vms.groovy')
vms.run() // initialise fields

// check if a fake code has been supplied in the other details field
String otherDetails = body.depthFirst().find{it.name() == 'PreferredContactTimes'}?.@Details?.text()
vms.setOrderCode(otherDetails)

// create an order code based on the amount in the request
if (!vms.orderCode) vms.createOrderCode()

// need to check if request should return an error here...
if (vms.orderCode && vms.isError()) {
    throw new Exception('Error handling not implemented yet')
}


mb.'l:ValuationTransaction'('xmlns:l':'http://www.lixi.org.au/schema/cal1.3/ValuationTransaction', ProductionData:'No') {
    'l:RevisionNumber'(UserType:'Lender', LIXIVersion:'1.0')
    'l:Identifier'(Description='VMS', Type:'ThirdPartyAssigned', UniqueID:(msgId = random()))
    'l:Date'((now = new Date()).format('yyyy-MM-dd'))
    'l:Time'(now.format('hh:mm:ss'))
    'l:Comment'()
    'l:Publisher' {
        'l:RelatedEntityRef'(RelatedID:(pubId = random()))
    }
    'l:Message' {
        'l:Identifier'(Description:'VMS', Type:'ThirdPartyAssigned', UniqueID:msgId)
        'l:MessageRelatesTo' {
            'l:Identifier'(Type:'LenderAssigned', UniqueID:random())
            
            // This one is returning the VMS code used to updated the valuation later
            'l:Identifier'(Description:'VMS', Type:'ThirdPartyAssigned', UniqueID:vms.orderCode)
        }
        'l:MessageBody'(Type:'Information') {
            'l:Status'(Name:'Initial') {
                'l:Date'(now.format('yyyy-MM-dd'))
                'l:Time'(now.format('hh:mm:ss'))
            }
        }
        'l:ValuationType' {
            "l:${vms.valuationType}"()
        }
    }
    'l:RelatedPartySegment' {
        'l:RelatedParty'(RelPartyType:'ServiceCentre', RelPartyDescription:'Sandstone VMS') {
            'l:Identifier'(Type:'Sequential', UniqueID:pubId)
        }
        'l:RelatedParty'(RelPartyType:'ValuationFirm') {
            'l:Identifier'(Type:'Sequential', UniqueID:random())
            'l:Identifier'(Description:'Vendor ID', Type:'LenderAssigned', UniqueID:random())
            'l:CompanyName'(BusinessName:'SST Valuer')
            'l:Address' {
                'l:NonStdAddress'('123 Walker Street')
                'l:City'('PERTH')
                'l:State'(Name:'WA')
                'l:Postcode'('6000')
                'l:Country'('Australia')
            }
            'l:WorkPhone' {
                'l:Phone' {
                    'l:FixedPhone'('99117100')
                }
            }
            'l:WorkPhone' {
                'l:Phone' {
                    'l:Fax'('03 4444 5555')
                }
            }
            'l:Email'('vmssupport@dev-test.com')
        }
    }
}
return wrap()