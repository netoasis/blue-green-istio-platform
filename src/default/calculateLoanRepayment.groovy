productCode = body.CalculateLoanRepaymentRequest.LoanDetailSegment.LoanDetails.@ProductCode.text();
loanTermType = body.CalculateLoanRepaymentRequest.LoanDetailSegment.LoanDetails.LoanTerm.@Type.text();
loanPaymentType = body.CalculateLoanRepaymentRequest.LoanDetailSegment.LoanDetails.LoanTerm.@PaymentType.text();
amountRequested = body.CalculateLoanRepaymentRequest.LoanDetailSegment.LoanDetails.AmountRequested.@Amount.text();
interestRate = body.CalculateLoanRepaymentRequest.LoanDetailSegment.LoanDetails.InterestRate.@RatePercent.text();
originalTerm = body.CalculateLoanRepaymentRequest.LoanDetailSegment.LoanRepaymentDetails.@OriginalTerm.text();
numOfRepayments = body.CalculateLoanRepaymentRequest.LoanDetailSegment.LoanRepaymentDetails.@NumberOfRepayments.text();
repaymentPeriod = body.CalculateLoanRepaymentRequest.LoanDetailSegment.LoanRepaymentDetails.RepaymentPeriod.Period.@Unit.text();

mb.CalculateLoanRepaymentResponse(xmlns:'http://www.sandstone.com.au/lending') {
    Identifier(UniqueID:random())
    RevisionNumber(LenderVersion:'1.0')
    LoanDetailSegment {
        LoanDetails(ProductCode:"${productCode}") {
            Identifier(UniqueID:'LoanDetail-1')
            LoanTerm(Type: "${loanTermType}", PaymentType: "${loanPaymentType}")
            AmountRequested(Amount: "${amountRequested}")
            InterestRate(RatePercent: "${interestRate}")
        }
        LoanRepaymentDetails(RemainingTerm:'0', OriginalTerm:"${originalTerm}", TotalInterestCharged:'21924.28', FinalRepaymentAmount:'1476.08', RepaymentAmount:'1476.7') {
        	RelatedEntityRef(RelatedID:'LoanDetail-1')
        	RepaymentPeriod {
        		Period(Unit:"${repaymentPeriod}")
        	}
        }
    }
}
return wrap()