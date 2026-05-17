// get account number from request
accountNumber = body.TopUpLoanAccountDetailsRequest.AccountNumber.@AcctNbr.toString()
assert (accountNumber) : 'Invalid account number'

TOPUP_ERROR = 'TOPUP_NOT_FOUND'

account = load('Account', [AccountNumber:accountNumber])[0]
if(!account) return soapFault('Account number entered is invalid or cannot be topped up.',TOPUP_ERROR)

product = load('Products', [ProductCode:account.ProductCode], false)[0]
if(!product) return soapFault('No product code found for Account entered.',TOPUP_ERROR)
// find first customer with that account
owners = load('CustomerAccount', [AccountNumber:accountNumber])
if(!owners) return soapFault('No owners found for Account number entered.',TOPUP_ERROR)
// load the account
    
mb.TopUpLoanAccountDetailsResponse(xmlns:'http://www.sandstone.com.au/lending') {
    Identifier(UniqueID:random())
    RevisionNumber(LenderVersion:'1.0')
    PartySegment {
        owners.each {
            accountOwner ->
            customer = load('Customer', [CustomerNumber:accountOwner.CustomerNumber])[0]
            Party(Type:'Applicant') {
                Identifier(Type:customer.Type, UniqueID:accountOwner.CustomerNumber)
            }
        }
    }
    LoanDetailSegment {
        LoanDetails(LinkedSavingsAccountNumber:account.LinkedSavingsAccountNumber,
        ProductType:product.ProductType,
        ProductCode:account.ProductCode,
        ) {
               Identifier(UniqueID:'LoanAccount-1')
               OriginalAmount(Amount:account.OriginalAmount)
               LoanTerm(Type:product.InterestType, PaymentType:account.PaymentMethod, account.RemainingTerm)
               CurrentAmount(Amount:account.CurrentAmount)
               InterestRate(RatePercent:account.InterestRate)
               AccountNumber(AcctNbr: accountNumber)
        }
        LoanRepaymentDetails(RemainingTerm:account.RemainingTerm, RepaymentAmount:account.RepaymentAmount,
        NumberOfRepayments:account.NumberOfRepayments,
        OriginalTerm:account.OriginalTerm,
        PaymentMethod:account.PaymentMethod
        ) {
                RelatedEntityRef(RelatedID:'LoanAccount-1')
                RepaymentPeriod {
                    Period(Unit:account.Period)
                }
        }            
    }
    
}

return wrap()
