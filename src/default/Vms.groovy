/**
 * Support for VMS valuation types and fake host codes
 */
RESTRICTED = 'RestrictedAccessAssessment'
FULL = 'FullRegistered'
PROGRESS = 'ProgressInspection'
ME = 'ModelledEstimate'
STANDARD = 'Standard'
TO_BE_ERECTED = 'ToBeErected'

/**
 * Number of digits in property value amount, set to 4 and we assume 3 zeros
 * are appended to the specified amount. e.g. ABCD -> 1,234,000 so we support
 * values up to 10M.
 */
LENGTH = 4

valuationTypeMap = [R:RESTRICTED,
    F:FULL,
    P:PROGRESS,
    T:FULL,
    M:FULL,
    (RESTRICTED):'R',
    (PROGRESS):'P',
	(ME):'M']

valSubTypeMap = [F:STANDARD,
    M:ME,
    P:STANDARD,
    R:STANDARD,
    T:STANDARD]

valuationStatusMap = [S:'Initial', // submitted
    C:'ValuationCompleted',
    F:'Finalised',
    I:'Inquiring',
    D:'Declined',
    P:'InProgress',
    Y:'Delayed',
    A:'Instructed'
]

// letters used for digits from 0..9 (J is zero, A is 1, etc.)
digitMap = 'JABCDEFGHI'

orderCode=''
String amount = '0'
isUpdate = body.editValuationRequest.size() > 0
isRequest = body.valuationRequest.size() > 0
isCancel = body.cancelValuationRequest.size() > 0
log.fine "${[update:isUpdate, request:isRequest, cancel:isCancel]}"

if (isRequest) {
    requestType = [FULL, RESTRICTED, ME, PROGRESS].find {
        body.valuationRequest.ValuationTransaction.Message.ValuationType."${it}".size() > 0
    }
	def valuationTypeValue = body.valuationRequest.ValuationTransaction.Message.ValuationType."${requestType}";
	if ("FullRegistered".equals(valuationTypeValue.name()) && "ModelledEstimate".equals(valuationTypeValue.@ValSubType?.text())) {
		requestType = ME
	}
    log.info "requestType: ${requestType}"
}

def getRequestCode() {
    return body.'**'.find {
        it.name() == 'Identifier' && it.@Description == 'VMS' && it.@Type == 'ThirdPartyAssigned' && it.@UniqueID
    }?.@UniqueID.text()
}

/**
 * Create a suitable order code based on what's known about the valuation
 */
def createOrderCode() {
    estimate = body.depthFirst().find{it.name() == 'EstimatedValue'}?.@Amount?.text()
    amount = estimate ? estimate : '500000' // use 500k if no other estimate found
    log.fine "estimate: ${estimate}"
    rType = valuationTypeMap.find{it.key == requestType}?.value
    rType = rType ? rType : 'F' // use full type by default
    orderCode = "${rType}${codeAmount}CNNS" // completed & no errors
    log.fine "created orderCode: ${orderCode}" 
}

/**
 * Find the first valid order code in the given string and use that, if none
 * found then set code to null
 */
def setOrderCode(String value) {
    orderCode = value?.find("[RFPTM][A-J]{${LENGTH}}[SCFIDPYA][NEX][NEX][SFEX]")
    if (orderCode) log.info "orderCode set to ${orderCode}"
    else log.fine "Invalid orderCode ${value}"
}

def getLoanReference() {
    def id = body.getValuationDocumentsRequest.ValuationTransaction.Message.Identifier
    return id.find{ it.@Type == 'LenderAssigned' }.@UniqueID.text()
}

String getAmount() {
    // convert amount section of code into digits
    String amt = amountCode.collect { digitMap.indexOf(it) }.join()
    amount = (amt) ? "${amt}000" : 0
    return amount
}

def getValuationType() {
    return valuationTypeMap[valuationTypeCode]
}

def getValuationSubType() {
    return valSubTypeMap[valuationTypeCode]
}

def getValuationTypeCode() {
    return orderCode ? orderCode[0] : null
}

def getAmountCode() {
    return orderCode ? orderCode[1..4] : null
}

/**
 * Map each digit in the amount to the corresponding letter from the map, limit
 * number of digits to 3 and pad with zeros 
 */
def getCodeAmount() {
    amount.collect{digitMap[it as int]}.join().take(LENGTH).padLeft(LENGTH, digitMap[0])
}

def getValuationStatus() {
    return valuationStatusMap[getValuationStatusCode()]
}

def getValuationStatusCode() {
    return orderCode.substring(4,5)
}

def isProgressInspection() {
    return valuationType == PROGRESS
}


def isFullRegistered() {
    return valuationType == FULL && valuationSubType == STANDARD
}

def isRestrictedAccess() {
    return valuationType == RESTRICTED
}

def isModelledEstimate() {
    return valuationType == FULL && valuationSubType == ME
}

def isTOC() {
    return valuationTypeCode == 'T'
}

//applied to VMS cancelValuationRequest (Cancel)
def isSuccess() {
    return errorCode == 'S'
}

//applied to VMS cancelValuationRequest (Cancel)
//  -->VMS internal error, can't access database or whatever so cancellation request can't be processed.
//applied to getValuation (request) and getValuationDocuments (update)
def isError() {
    return errorCode == 'E'
}

//applied to VMS cancelValuationRequest (Cancel)
//no valuation can't be cancelled (maybe it's already complete or cancelled)
def isFailed() {
    return errorCode == 'F'
}

//applied to VMS valuationRequest (request) and getValuationDocuments (update)
def hasNoError() {
    return errorCode == 'N'
}

def getErrorCode() {
    //if (!orderCode) return null
    if (isRequest) return orderCode[5]
    if (isUpdate) return orderCode[6]
    if (isCancel) return orderCode[7]
    return null
}
