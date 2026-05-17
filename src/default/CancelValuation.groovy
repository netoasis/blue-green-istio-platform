vms = loadScript('Vms.groovy')
vms.run() // initialise fields

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
            'l:Identifier'(Description:'VMS', Type:'ThirdPartyAssigned', UniqueID:vms.requestCode)
        }
        'l:MessageBody'(Type:'Information') {
            'l:Status'(Name:'Cancelled') {
                'l:Date'(now.format('yyyy-MM-dd'))
                'l:Time'(now.format('hh:mm:ss'))
            }
        }
    }
    'l:RelatedPartySegment' {
        'l:RelatedParty'(RelPartyDescription:'Sandstone VMS', RelPartyType:'ServiceCentre') {
            'l:Identifier'(Type:'Sequential', UniqueID:pubId)
        }
    }        
}
return wrap()