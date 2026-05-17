def application = body.UploadLoanApplicationRequest.Application
def applicantFirstName=application.PartySegment.Party[0].Person.PersonName.FirstName.text()
def applicantSurname=application.PartySegment.Party[0].Person.PersonName.Surname.text()

if ('HOSTFAULT'.equalsIgnoreCase(applicantFirstName))
{
    def responseStr = '<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">\n' +
            '  <soap:Body>\n' +
            '    <soap:Fault>\n' +
            '      <faultcode>soap:Server</faultcode>\n' +
            '      <faultstring>Server Error</faultstring>\n' +
            '      <detail>\n' +
            '        <sst:InformationSegment xmlns:sst="\n' +
            'http://www.sandstone.com.au/information">\n' +
            '          <Information Subtype="error">\n' +
            '            <UniqueExceptionIdentifier>UPLOAD_HOST_ERROR_0</UniqueExceptionIdentifier>\n' +
            '            <Parameter Index="1">An internal error has occurred. Please try again and contact the IT\n' +
            '              Service desk if problem persists</Parameter>\n' +
            '            <Text lang="en">Unable to complete your request at this time. Please contact the IT\n' +
            '              Service Desk. An internal error has occurred. Please try again and contact the IT\n' +
            '              Service desk if problem persists</Text>\n' +
            '          </Information>\n' +
            '        </sst:InformationSegment>\n' +
            '      </detail>\n' +
            '    </soap:Fault>\n' +
            '  </soap:Body>\n' +
            '</soap:Envelope>';
    return [responseStr: responseStr];
}

if ('HOSTFAULTWARNING'.equalsIgnoreCase(applicantFirstName))
{
    def responseStr = '<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">\n' +
            '  <soap:Body>\n' +
            '    <soap:Fault xmlns:SOAP="http://schemas.xmlsoap.org/soap/envelope/">\n' +
            '      <faultcode>SOAP:Server</faultcode>\n' +
            '      <faultstring>Server Error</faultstring>\n' +
            '      <detail>\n' +
            '        <sst:InformationSegment xmlns:sst="http://www.sandstone.com.au/information">\n' +
            '          <sst:Information Subtype="warning">\n' +
            '            <sst:UniqueExceptionIdentifier>CUST_SEARCH_00002</sst:UniqueExceptionIdentifier>\n' +
            '            <sst:Parameter Index="1">Warning at Funding status</sst:Parameter>\n' +
            '            <sst:Text xml:lang="EN">Warning at Funding status</sst:Text>\n' +
            '          </sst:Information>\n' +
            '        </sst:InformationSegment>\n' +
            '      </detail>\n' +
            '    </soap:Fault>\n' +
            '  </soap:Body>\n' +
            '</soap:Envelope>';
    return [responseStr: responseStr];
}

if ('UPLOADTIMEOUT'.equalsIgnoreCase(applicantFirstName))
{
	Random random = new Random();
	int randomNumber = random.nextInt(61 - 60) + 60;
	sleep randomNumber * 1000 //65 seconds
	return null;
}

boolean isLoanApplication = false
//there will be multiple LoanDetails identifiers extract only ResultantLoan
for (identifier in application.LoanDetailSegment.LoanDetails[0].Identifier) {
    String id = identifier.@UniqueID.text()
    if (id.startsWith("ResultantLoan")) {
        isLoanApplication = true
    }
}

if(isLoanApplication)
{
	// a deposit account doesn't have loan details in its request
	// so assigned default value if request doesn't have any loan details
	int accountNumber = 10098743
	
	int hostSecurityNumber = 100;
	
	if("Jimmy".equalsIgnoreCase(applicantFirstName) && "Fox".equalsIgnoreCase(applicantSurname))
	{
		hostSecurityNumber = 5555;
		accountNumber = 999999900;
	}

	mb.UploadLoanApplicationResponse(xmlns:'http://www.sandstone.com.au/lending') {
		Identifier(UniqueID:random())
		RevisionNumber(LenderVersion:'1.0')
		FinancialSegment {
			for (valueItem in application.FinancialSegment.ValueItem) {
				String addressId = valueItem.Asset?.RealEstate?.Location?.RelatedEntityRef?.@RelatedID?.text();
				String depositAccountType = valueItem.Asset?.NonRealEstate?.DepositAccount?.@DepositAccountType?.text();
				String securityType = valueItem.Asset?.@Class?.text();
				if ('FutureSecurity'.equalsIgnoreCase(securityType) && (addressId || depositAccountType)) {
					String valueItemIdentifier = valueItem.Identifier.@UniqueID
					ValueItem {
						Identifier(UniqueID:valueItemIdentifier)
						Asset(SecurityNo:hostSecurityNumber) {
							if (addressId) {
								hostSecurityNumber++
							}
							else if (depositAccountType) {
								hostSecurityNumber++
							}
						}
					}
				}
			}
		}
		LoanDetailSegment {
			for (loanDetails in application.LoanDetailSegment.LoanDetails)
			{
				String resultantLoanId = ""
				def loanDetailIdentifiers = loanDetails.Identifier
				for (identifier in loanDetailIdentifiers) {
					String id = identifier.@UniqueID.text()
					if (id.startsWith("ResultantLoan")) {
						resultantLoanId = id
                        break
					}
				}
				LoanDetails {
					Identifier(UniqueID:resultantLoanId)
					AccountNumber(AcctNbr:accountNumber)
				}
				accountNumber++
			}
		}
		'sst_inf:InformationSegment'('xmlns:sst_inf':'http://www.sandstone.com.au/information') {
            if ('HOSTSUCCESSWARNING'.equalsIgnoreCase(applicantFirstName))
            {
                'sst_inf:Information'(Subtype: 'warning') {
                    'sst_inf:UniqueExceptionIdentifier'('CUST_SEARCH_00002') {}
                    'sst_inf:Text'('lang': 'en', 'This is some Host warning from uploadLoanApplication.')
                }
            }
            else if ('HOSTSUCCESSERROR'.equalsIgnoreCase(applicantFirstName))
            {
                'sst_inf:Information'(Subtype: 'error') {
                    'sst_inf:UniqueExceptionIdentifier'('UPLOAD_HOST_ERROR_0') {}
                    'sst_inf:Text'('lang': 'en', 'This is some Host error from uploadLoanApplication.')
                }
            }
            else
            {
                'sst_inf:Information'(Subtype:'information') {
                    'sst_inf:UniqueExceptionIdentifier'('UPLOAD_HOST_INFO_1'){}
                    'sst_inf:Text'('lang':'en', 'This is some Host information from uploadLoanApplication.')
                }
            }
		}
	}
}
else
{
    String resultantDepositId = application.DepositAccountDetailSegment.DepositAccountDetails[0].Identifier.@UniqueID.text();
    def partySegment = application.PartySegment.Party[0];

    String firstname = partySegment.Person?.PersonName?.FirstName?.text();
    String othername = partySegment.Person?.PersonName?.OtherName?.text();
    String surname = partySegment.Person?.PersonName?.Surname?.text();
    String dob = partySegment.Person?.DateOfBirth?.Date?.text();

	String companyName = partySegment.Company?.CompanyName?.@BusinessName?.text();
	
    String partyIdentifier = partySegment.Identifier?.@UniqueID?.text();
    int accountNumber = 10098743;

    mb.UploadLoanApplicationResponse(xmlns:'http://www.sandstone.com.au/lending') {
        Identifier(UniqueID:random())
        PartySegment {
            Party( InternetBankingId:'5511263') {
                Identifier(UniqueID:partyIdentifier)
				if (dob)
				{
					Person {
						PersonName {
							FirstName { mkp.yield(firstname) }
							OtherName { mkp.yield(othername) }
							Surname { mkp.yield(surname) }
						}
						DateOfBirth {
							Date { mkp.yield(dob) }
						}
					}
				}
				if (companyName)
				{
					Company {
						CompanyName(BusinessName:companyName)
					}
				}

            }
        }
        DepositAccountDetailSegment {			
			for (depositAccountDetails in application.DepositAccountDetailSegment.DepositAccountDetails)
			{
				String depositAccountId = ""
				def depositAccountDetailIdentifier = depositAccountDetails.Identifier
				for (identifier in depositAccountDetailIdentifier) {
					String id = identifier.@UniqueID.text()
					if (id.startsWith("ResultantDepositAccount")) {
						depositAccountId = id
                        break
					}
				}

				DepositAccountDetails {
					Identifier(UniqueID:depositAccountId)
					DepositAccount(DepositAccountType:depositAccountDetails.DepositAccount?.@DepositAccountType?.text(),Description:depositAccountDetails.@ProductName?.text()) {
                    AccountNumber(AcctNbr:accountNumber) {
						BSB { mkp.yield('023432') }
						}
					}
				}
				accountNumber++
			}
        }
    }
}

return wrap()

