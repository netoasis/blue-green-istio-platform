def appID = body.Package.Content.Application.Overview.@LenderApplicationReferenceNumber.text()
if(!appID) return soapFault('No application ID', 'MISSING_APPLICATION_ID')

log.info "Processing InteflowService request for application '$appID'"

boolean error = body.Package.@UniqueID.text().contains('error')

def cdi = body.Package.Instructions.CreditDecisionInstructions
String requestType = cdi.Submit ? 'Submit' : cdi.Update ? 'Update' : null

mb.Package('xmlns:xsi': 'http://www.w3.org/2001/XMLSchema-instance', UniqueID: random()) {
    if (error) {
        Instructions {
            ErrorInstructions(
                    ErrorSource: 'Proprietary',
                    ErrorSourceVersion: '0.0.1',
                    Type: 'Data Error',
                    UniqueID: 'error-1',
                    XPath: '/Package/Content/Application/Summary/Applicants/@AreAllApplicantsIndividuals') {
                        Annotation(Details: 'Annotation 1 details', Type: 'Message', UniqueID: 'annotation-1')
                        Annotation(Details: 'Annotation 2 details', Type: 'Technical', UniqueID: 'annotation-2')
                    }
            ErrorInstructions(Type: 'Information') { Annotation(Details: 'Annotation 3 details') }
        }
    } else {
        Attachment(UniqueID: random()) { InlineAttachment('TG9yZW0gaXBzdW0=') }
        Content {
            CreditAssessment(/*ProcessStatus: '??'*/) {
                DecisionScore(Score: '12.34', Determined: 'Pre Bureau', RiskGrade: '1'/*, x_Security: '??', x_Party: '??'*/)
                PolicyException(Category: 'Score', Description: 'desc', Code: 'code')
                Recommendation(OverallRecommendation: 'Approve', Reason: 'reason')
                Report(Source: 'Bureau', Type: 'reportType', RequestDateTime: '2016-01-06T00:00:00', FormatVersion: '!FormatVersion'/*, x_Party: '??'*/) {
                    Content(Type: 'XML', x_Attachment: 'AttachmentUniqueID')
                    RelatedSearch(ReferenceType: 'Name cross reference') {
                        PersonName(MiddleNames: 'middlenames', FirstName: 'firstname', Surname: 'surname')
                    }
                }
            }
        }
    }
    if (requestType) Instructions {
        CreditDecisionInstructions { "$requestType"() }
    }
    Publisher(LIXICode: 'Fake Host (CDE)')
    Recipient(LIXICode: 'LendFast/Apply')
    SchemaVersion(LIXITransactionType: 'CAL', LIXIVersion: '0.0.1')
}

return wrap()