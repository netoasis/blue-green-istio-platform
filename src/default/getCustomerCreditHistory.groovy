party = body.GetCustomerCreditHistoryRequest.PartySegment.Party

// customer number used for both company and person
CustomerNumber = party.Identifier.@UniqueID.text()

assert (CustomerNumber?.trim())  : "Doesn't have unique identifier ID"
filter = [:]
if (CustomerNumber) filter.CustomerNumber = CustomerNumber

if(filter.CustomerNumber.equalsIgnoreCase('99990001')) {
    return soapFault('No credit history found.', 'CREDIT_HISTORY_NOT_FOUND')
}

// get account numbers base from customer number
accounts = load('CustomerAccount', filter, false)
accountDetails = []

accounts.each{
    account ->
    accountDetails << load('Account', [AccountNumber:account.AccountNumber], false)
}
// Populate liability accounts list
liabAccounts = accountDetails.findAll {
       ['INSTITUTION_LOAN', 'PROPERTY', 'CREDIT_CARD', 'PERSONAL_LOAN', 'LINE_OF_CREDIT', 'OVERDRAFT', 'SECURED_OVERDRAFT'].contains(it[0].AccountType)
}

//assert (accounts) : 'No account numbers are associated with this customer number'
common = loadScript('Common.groovy')

mb.GetCustomerCreditHistoryResponse(xmlns:'http://www.sandstone.com.au/lending') {
    Identifier(UniqueID:'CustomerCreditHistory-1')
    RevisionNumber(LenderVersion:'1.0')
    if (filter.CustomerNumber.equalsIgnoreCase('18121140')) {
        PartySegment {
            Party {
                Identifier(UniqueID:CustomerNumber)
                Person {
                    CreditHistory(RecentDishonour:'No') {
                        MissedPayments(NbrOfArrearsPaymentsDue:11)
                    }
                }
            }
        }
    }
    FinancialSegment {
        liabAccounts.eachWithIndex{
            account, accountIndex ->
                addExistingAccount(mb, account[0], accountIndex+1)
        }
    }
}

def addExistingAccount(builder, loan, index) {
    builder.ValueItem(Value:loan.CurrentAmount) {
        Identifier(UniqueID:"LoanLiabilty-${index}")
        Liability() {
            AccountNumber(AcctNbr:loan.AccountNumber)
            AccountHistory(CurrentArrears:loan.CurrentArrears, PreviousArrears:loan.PreviousArrears)
        }
    }
}

return wrap()