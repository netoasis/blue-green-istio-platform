accountNumber = body.CalculatePayoutFigureRequest.LoanDetailSegment.LoanDetails.AccountNumber.@AcctNbr.text();

mb.CalculatePayoutFigureResponse(xmlns:'http://www.sandstone.com.au/lending') {
    Identifier(UniqueID:random())
    RevisionNumber(LenderVersion:'1.0')
    LoanDetailSegment {
        LoanDetails {
            Identifier(UniqueID:'LoanAccount-01')
            AccountNumber(AcctNbr:"${accountNumber}")
            DailyInterestAccrual(Value:'1000')
            RepaymentTrackingAmount(Value:'1500')
            RepaymentTrackingToleranceAmount(Value:'1250')
            MoneyBreakDown(Payout:'10000.00') {
                BreakDownItem(Type:'PRINCIPAL_DUE', Value:'7000')
                BreakDownItem(Type:'INTEREST_DUE', Value:'800')
                BreakDownItem(Type:'LOAN_ADMINISTRATION_FEE', Value:'300')
                BreakDownItem(Type:'EARLY_REPAYMENT_ADMIN_FEE', Value:'200')
                BreakDownItem(Type:'EARLY_REPAYMENT_COST', Value:'500')
                BreakDownItem(Type:'ENFORCEMENT_CHARGES', Value:'400')
                BreakDownItem(Type:'DEFAULT_CHARGES', Value:'300')
                BreakDownItem(Type:'INTEREST_REBATE', Value:'200')
                BreakDownItem(Type:'INSURANCE_REBATE', Value:'100')
            }
        }
    }
}
return wrap()