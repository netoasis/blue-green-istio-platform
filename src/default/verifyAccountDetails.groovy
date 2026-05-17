accountNumber = body.VerifyAccountDetailsRequest.AccountNumber.@AcctNbr.text();

mb.VerifyAccountDetailsResponse(xmlns:'http://www.sandstone.com.au/lending') {
    Identifier(UniqueID:random())
    RevisionNumber(LenderVersion:'1.0')
    FinancialSegment {
        ValueItem(Value:'5000') {
            Identifier(UniqueID:'DepositAccountAsset-01')
            Asset {
                NonRealEstate {
                    DepositAccount(DepositAccountType:'SAVINGS') {
                        AccountNumber(AcctName:'Savings Account', AcctNbr:"${accountNumber}")
                    }
                }
            }
        }
    }
    Status('OK')
}    
return wrap()