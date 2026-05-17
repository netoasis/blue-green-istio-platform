reqApp = body.UploadDisbursalDetailsRequest.Application
String loanId = reqApp.LoanDetailSegment.LoanDetails[0].Identifier.@UniqueID.text();
String payTo = reqApp.LoanDetailSegment.DisbursalDetails[0].DisbursementAmount.@PayableTo.text();

if ('UPLOADTIMEOUT'.equalsIgnoreCase(payTo))
{
    Random random = new Random();
    int randomNumber = random.nextInt(61 - 60) + 60;
    sleep randomNumber * 1000 //65 seconds
    return null;
}

mb.UploadDisbursalDetailsResponse(xmlns:'http://www.sandstone.com.au/lending') {
    Identifier(UniqueID:random())
    RevisionNumber(LenderVersion:'1.0')
}
return wrap()