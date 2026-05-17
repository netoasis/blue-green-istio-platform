import  groovy.time.TimeCategory

party = body.GetCustomerProfileRequest.PartySegment.Party

// username of requesting the customer profile
userName = ""
for (identifier in body.GetCustomerProfileRequest.Sender.User.Identifier) {
    if("SenderAssigned".equalsIgnoreCase(identifier.@Type.text())) {
        userName = identifier.@UniqueID.text()
    }
}

// customer number used for both company and person
CustomerNumber = party.Identifier.@UniqueID.text()

assert (CustomerNumber?.trim())  : "Doesn't have unique identifier ID"
filter = [:]
if (CustomerNumber && !("jFoxTest".equalsIgnoreCase(userName) && "990000".equalsIgnoreCase(CustomerNumber))) filter.CustomerNumber = CustomerNumber

// get account numbers base from customer number
accounts = load('CustomerAccount', filter, false)
accountDetails = []
debitAccountDescriptionMap = [SAVINGS:'GoalSaver', PASSBOOK:'Passbook', CHEQUE:'Cheque', 'TRANSACTIONAL':'aSaver Debit', BUSINESS_TERM_DEPOSIT:'Business term deposit', BUSINESS_TRANSACTIONAL:'Business transaction account', BUSINESS_STANDARD_DEPOSIT:'Business savings account']

debitAccountProductNameMap = [KIWISAVER:'LIFESTAGES KIWISAVER']

accounts.each{
    account ->
    accountDetails << load('Account', [AccountNumber:account.AccountNumber], false)
}

// load loan pkg based on linked accountNumber
pkgs = []

accounts.each{
    account ->
    pkgs << load('Package', [AccountNumber:account.AccountNumber], false)
}

//if jFoxTest is requesting the profile for customer number 990000, return empty accounts
if("jFoxTest".equalsIgnoreCase(userName) && "990000".equalsIgnoreCase(CustomerNumber))
{
    accountDetails = []
    pkgs = null
}

// Populate asset accounts list
assetAccounts = accountDetails.findAll {
       ['SAVINGS', 'PASSBOOK', 'CHEQUE', 'TERM_DEPOSIT', 'TRANSACTIONAL', 'BUSINESS_TERM_DEPOSIT', 'BUSINESS_TRANSACTIONAL', 'BUSINESS_STANDARD_DEPOSIT', 'KIWISAVER'].contains(it[0].AccountType)
}

// find a savings account to link into pkg
savingsAccount = accountDetails.find {
       ['SAVINGS', 'TRANSACTIONAL'].contains(it[0].AccountType)
}

// Populate liability accounts list
liabAccounts = accountDetails.findAll {
       ['BUSINESS_LENDING', 'INSTITUTION_LOAN', 'PROPERTY', 'CREDIT_CARD', 'PERSONAL_LOAN', 'LINE_OF_CREDIT', 'OVERDRAFT', 'SECURED_OVERDRAFT', 'OTHER', 'BANK_GUARANTEE'].contains(it[0].AccountType)
}

//assert (accounts) : 'No account numbers are associated with this customer number'
common = loadScript('Common.groovy')

finalSecurityAccounts=[]
refSecurityAccounts=[:]
rawSecurityAccounts=[:]
lmiPolicies=[]
relatedLenderParties=[]
relatedAssetInsurerParties=[]

relatedOwnerParties=[]
processedOwnerParties=[]

refLiabilityAccounts=[:]
refDepositAccts=[:]

dateFormat="yyyy-MM-dd"

mb.GetCustomerProfileResponse(xmlns:'http://www.sandstone.com.au/lending') {
    Identifier(UniqueID:random())
    RevisionNumber(LenderVersion:'1.0')
    PartySegment {
        Party {
            Identifier(UniqueID:CustomerNumber)
        }
    }
    FinancialSegment {
        liabAccounts.eachWithIndex{
            account, accountIndex ->
            addExistingAccount(mb, account[0], accountIndex+1)
            buildSecurityAccountsMap(account[0], accountIndex+1)
			buildRefLiabilityMap(account[0], accountIndex+1)          
        }
        finalSecurityAccounts?.unique().eachWithIndex {            
            securityAccount, securityIndex ->
            addSecurities(mb, securityAccount, securityIndex+1)
            buildRefSecurityMap(securityAccount,securityIndex+1)
        }
        assetAccounts.eachWithIndex {
            account, accountIndex ->
            addExistingAssets(mb, account[0], accountIndex+1)
			buildRefDepositAcctsMap(account[0], accountIndex+1)        
        }
		if(pkgs)
		pkgs.eachWithIndex {
			pkg, pkgIndex ->
			addPackage(mb, pkg[0], pkgIndex+1, pkg.isLinkedWithDepositAccount)
		}
		
    }
    if(liabAccounts)
    LoanDetailSegment {
        liabAccounts.eachWithIndex{
            account, accountIndex ->
            addLoanDetail(mb, account[0], accountIndex+1, rawSecurityAccounts, refSecurityAccounts)
        }
		liabAccounts.eachWithIndex{
			account, accountIndex ->
			if(account[0].AccountType != 'BANK_GUARANTEE')
			{
				addLoanRepayment(mb, account[0], accountIndex+1)
			}
		}
    }
    if(lmiPolicies || relatedLenderParties || relatedAssetInsurerParties || relatedOwnerParties)
    RelatedPartySegment {
		if(lmiPolicies)
		{
			lmiPolicies.eachWithIndex {
				lmiPolicy, policyIndex ->
				log.info "test ${lmiPolicy}"
				addInsurerParty(mb, lmiPolicy.InsurerName, policyIndex+1)
			}
		}
		if(relatedLenderParties)
		{
			relatedLenderParties.eachWithIndex {
				relatedLenderParty, relatedLenderPartyIndex ->
				addRelatedLenderParty(mb, relatedLenderParty, relatedLenderPartyIndex+1)
			}
		}
		if(relatedAssetInsurerParties)
		{
			relatedAssetInsurerParties.eachWithIndex {
				relatedAssetInsurerParty, relatedAssetInsurerPartyIndex ->
				addAssetInsurerParty(mb, relatedAssetInsurerParty, relatedAssetInsurerPartyIndex+1)
			}
		}
		if(relatedOwnerParties)
		{
			relatedOwnerParties.eachWithIndex {
				relatedOwnerParty, relatedOwnerPartyIndex ->
				addRelatedOwnerParty(mb, relatedOwnerParty, relatedOwnerPartyIndex+1)
			}		
		}
    }
    if(finalSecurityAccounts)
    AddressSegment {
        finalSecurityAccounts.unique().eachWithIndex {
            securityAccount, securityIndex ->
            common.addAddress(mb, "Address-${securityIndex+1}", "${securityAccount.AddressID}")
			if (securityAccount.GaragedAddress) {
				common.addAddress(mb, "GaragedAddress-${securityIndex+1}", "${securityAccount.GaragedAddress}")
			}
			if (securityAccount.OwnersRegisteredAddress) {
				common.addAddress(mb, "RegisteredAddress-${securityIndex+1}", "${securityAccount.OwnersRegisteredAddress}")
			}
        }
    }
    
    if(lmiPolicies)
    MortgageInsuranceSegment {
        lmiPolicies.eachWithIndex {
            lmiPolicy, policyIndex ->
            addMortgageInsurance(mb, lmiPolicy, policyIndex+1)
        }
    }	
}

def addPackage(builder, pkg, index, isLinkedWithDepositAccount)
{
    linkedSavingsAccount = null

	if(isLinkedWithDepositAccount)
	{
		linkedSavingsAccount = savingsAccount
	}
	
	if(pkg)
	{
		accountOwners = load('CustomerAccount', [AccountNumber:pkg.AccountNumber], false)
		liabAccnts = load('Account', [AccountNumber:pkg.AccountNumber], false)
		
		refDepositAccountId = refDepositAccts[linkedSavingsAccount[0].AccountNumber]		
		
		builder.Package(Code:pkg.Code, Name:pkg.Name, Number:pkg.Number, x_DepositAccount:"DepositAccountAsset-${refDepositAccountId}") {
			Identifier(UniqueID:"pkg-${index}")

			accountOwners.each {
				accountOwner ->
				x_Owner(RelatedID:accountOwner.CustomerNumber)
			}

			liabAccnts.each {
            	liabAccnt ->
				refLiabilityAccountId = refLiabilityAccounts[liabAccnt.AccountNumber]		
				x_Liability(RelatedID:"LoanLiabilty-${refLiabilityAccountId}")
			}
		}
	}
}

def addMortgageInsurance(builder, lmiPolicy, index)
{
    builder.Insurance(PolicyNumber:lmiPolicy.LmiPolicyNumber) {
        PercentOwned {
            RelatedEntityRef(RelatedID:"LoanAccount-${lmiPolicy.AccountIndex}")
        }
        RelatedEntityRef(RelatedID:"Insurer-${index}")
    }
}

def addInsurerParty(builder, insurerName, index)
{
    builder.RelatedParty(RelPartyType:"Insurer") {
        Identifier(UniqueID:"Insurer-${index}")
        Company {
            CompanyName(BusinessName:insurerName)
        }
    }
}

def addRelatedLenderParty(builder, lenderParty, index)
{
    builder.RelatedParty(RelPartyType:"Lender") {
        Identifier(UniqueID:"Lender-${index}")
        Company {
            CompanyName(BusinessName:lenderParty.LenderName)
        }
    }
}

def addRelatedOwnerParty(builder, party, index)
{	
	if(!processedOwnerParties.contains(party.OwnerNumber)) {
	
		filter = [CustomerNumber:party.OwnerNumber]
		
		cust = load('Customer', filter , false)[0]
	
		builder.RelatedParty(RelPartyType:"CoOwner") {
			Identifier(UniqueID:party.OwnerNumber)
	
			if(cust.Type == 'Company') {
				Company {
					CompanyName(BusinessName:cust.OtherName)
				}
			}
			
			if(cust.Type == 'Individual') {
				PersonName {
					Surname(cust.LastName)
				}
			}			
		}
	
		processedOwnerParties << party.OwnerNumber
	}
}

def addAssetInsurerParty(builder, insurerName, index)
{
    builder.RelatedParty(RelPartyType:"Insurer") {
        Identifier(UniqueID:"AssetInsurer-${index}")
        Company {
            CompanyName(BusinessName:insurerName.relatedAssetInsurerParty)
        }
    }
}

def addExistingAssets(builder, asset, index) {
    accountOwners = load('CustomerAccount', [AccountNumber:asset.AccountNumber], false)
    builder.ValueItem(Value:asset.OriginalAmount) {
        Identifier(UniqueID:"DepositAccountAsset-${index}")
        accountOwners.each {
            accountOwner ->
            PercentOwned() {
                RelatedEntityRef(RelatedID:accountOwner.CustomerNumber)
				relatedOwnerParties << [RelatedOwnerPartyIndex: index, OwnerNumber: accountOwner.CustomerNumber]
            }
        }
        Asset(Class:'CurrentAsset') {
            NonRealEstate {
                def description = debitAccountDescriptionMap.find{it.key == asset.AccountType}?.value
                DepositAccount(Description:description, DepositAccountType:asset.AccountType) {
                    AccountNumber(AcctNbr:asset.AccountNumber, AcctName:asset.AccountName, ProductName:debitAccountProductNameMap.find{it.key == asset.AccountType}?.value) {
                        if (asset.BSB) {
                            BSB(asset.BSB)
                        }
                        Branch(InternalNumb:'316')
                    }
                }
            }
        }
    }
}

def addLoanDetail(builder, account, index, rawSecurityAccounts, refSecurityAccounts) {
    accountDetails = load('Account', [AccountNumber:account.AccountNumber], false)
    accountDetails.each{
        accountDetail ->
        // GET THE FIRST PRODUCT INFORMATION
        product = load('Products', [ProductCode:accountDetail.ProductCode], false)[0]
    
        builder.LoanDetails(LinkedSavingsAccountNumber:'', 
            ProductCode:accountDetail.ProductCode,
            ProductType:product.ProductType,
            HasPendingRateChange:'No',
            ProductName:product.Description,
            CCIPremiumAmount:'0.00'
            ) {
            Identifier(UniqueID:"LoanAccount-${index}")

			// Added for LFEMERCURY-15924 for test scenario where a loan account retrieved from host without a linked collateral/property asset.
			if (CustomerNumber != '990026')
				addSecurityNode(builder, account.AccountNumber)

            OriginalAmount(Amount:accountDetail.OriginalAmount)
            LoanTerm(PaymentType:accountDetail.PaymentMethod, Units:accountDetail.Period, Type:product.InterestType, accountDetail.RemainingTerm)
			if(account.LoanDetailsMaturityDate) {
				MaturityDate {
					Date(account.LoanDetailsMaturityDate)
				}
			}
            CurrentAmount(Amount:accountDetail.CurrentAmount)
            InterestRate(RatePercent:accountDetail.InterestRate)
            if(accountDetail.RolloverProductCode) {
                rolloverProduct = load('Products', [ProductCode:accountDetail.RolloverProductCode], false)[0]
                RollOverProduct(ProductCode:accountDetail.RolloverProductCode) {
                    LoanTerm(PaymentType:accountDetail.RolloverPaymentMethod, Units:accountDetail.Period, Type:rolloverProduct.InterestType, accountDetail.RolloverTerm)
                    InterestRate(RatePercent:accountDetail.RolloverInterestRate)
                }
            }
        }
    }
}

def addLoanRepayment(builder, account, index) {
    accountDetails = load('Account', [AccountNumber:account.AccountNumber], false)
    accountDetails.each{
        accountDetail ->
        Date today = new Date();
        if(accountDetail.RolloverProductCode && accountDetail.AdditionalRepayment1RemainingTerm) {
            remainTerm = (accountDetail.RemainingTerm as int) - (accountDetail.AdditionalRepayment1RemainingTerm as int)
            originalTerm = (accountDetail.OriginalTerm as int) -  (accountDetail.AdditionalRepayment1RemainingTerm as int)
             
            if(accountDetail.AdditionalRepayment2RemainingTerm) {
                remainTerm = remainTerm - (accountDetail.AdditionalRepayment2RemainingTerm as int)
                originalTerm = originalTerm - (accountDetail.AdditionalRepayment2RemainingTerm as int)
            }
            
            // Build first repayment
            builder.LoanRepaymentDetails(RemainingTerm:remainTerm,
            RepaymentAmount:accountDetail.RepaymentAmount,
            AdditionalRepaymentAmount:accountDetail.AdditionalRepayment,
            OriginalTerm:originalTerm,
            PaymentMethod:accountDetail.PaymentMethod
            ) {
                RelatedEntityRef(RelatedID:"LoanAccount-${index}")
                RepaymentPeriod {
                    Period(Unit:accountDetail.Period)
                }
                if(accountDetail.CalculateMaturityDate == 'TRUE') {
                    use(TimeCategory) {
                        Date nextPaymentDate = today.plus(7);
                        NextPaymentDate {
                            Date(nextPaymentDate.format(dateFormat))
                        }
                        
                        Date maturityDate = today + remainTerm.months;
                        MaturityDate {
                            Date(maturityDate.format(dateFormat))
                        }
                    }
                }
            }
        
            // Build additional repayment
            builder.LoanRepaymentDetails(RemainingTerm:accountDetail.AdditionalRepayment1RemainingTerm,
            OriginalTerm:accountDetail.AdditionalRepayment1RemainingTerm,
            PaymentMethod:accountDetail.AdditionalRepayment1PaymentMethod
            ) {
                RelatedEntityRef(RelatedID:"LoanAccount-${index}")
                RepaymentPeriod {
                    Period(Unit:accountDetail.Period)
                }
                if(accountDetail.CalculateMaturityDate == 'TRUE') {
                    use(TimeCategory) {
                        Date maturityDate = today + (remainTerm + (accountDetail.AdditionalRepayment1RemainingTerm as int)).months;
                        MaturityDate {
                            Date(maturityDate.format(dateFormat))
                        }
                    }
                }
            }
            
            if(accountDetail.AdditionalRepayment2RemainingTerm) {
                builder.LoanRepaymentDetails(RemainingTerm:accountDetail.AdditionalRepayment2RemainingTerm,
                OriginalTerm:accountDetail.AdditionalRepayment2RemainingTerm,
                PaymentMethod:accountDetail.AdditionalRepayment2PaymentMethod,
                AdditionalRepaymentAmount:accountDetail.AdditionalRepayment,
                ) {
                    RelatedEntityRef(RelatedID:"LoanAccount-${index}")
                    RepaymentPeriod {
                       Period(Unit:accountDetail.Period)
                    }
                    if(accountDetail.CalculateMaturityDate == 'TRUE') {
                        use(TimeCategory) {
                            Date maturityDate = today + (accountDetail.RemainingTerm as int).months;
                            MaturityDate {
                                Date(maturityDate.format(dateFormat))
                            }
                        }
                    }
                }
            }
        } else {
            builder.LoanRepaymentDetails(RemainingTerm:accountDetail.RemainingTerm,
            RepaymentAmount:accountDetail.RepaymentAmount,
            AdditionalRepaymentAmount:accountDetail.AdditionalRepayment,
            NumberOfRepayments:accountDetail.NumberOfRepayments,
            OriginalTerm:accountDetail.OriginalTerm,
            PaymentMethod:accountDetail.PaymentMethod
            ) {
                RelatedEntityRef(RelatedID:"LoanAccount-${index}")
                RepaymentPeriod {
                    Period(Unit:accountDetail.Period)
                }
                if(accountDetail.CalculateMaturityDate == 'TRUE') {
                    use(TimeCategory) {
                        Date nextPaymentDate = today.plus(7);
                        NextPaymentDate {
                            Date(nextPaymentDate.format(dateFormat))
                        }
                        
                        Date maturityDate = today + (accountDetail.RemainingTerm as int).months;
                        MaturityDate {
                            Date(maturityDate.format(dateFormat))
                        }
                    }
                }
            }
        }
    }
}

def addSecurityNode(builder, accountNumber) {
    if(rawSecurityAccounts) {
        filteredSecurityRefs = filterFromList(rawSecurityAccounts,[AccountNumber:accountNumber])
        if(filteredSecurityRefs) {
            filteredSecurityRefs.each {
                filteredSecurityRef -> 
                builder.Security {
                    def refSecurityAccount = refSecurityAccounts[filteredSecurityRef.SecurityId]
                    RelatedEntityRef(RelatedID:"Security-${refSecurityAccount}")
                }
            }
        }
    }
}

def filterFromList(entries, Map filter = [:]) {
        if (!filter) return entries
        // filter the entries
        return entries.findAll { entry ->
            return filter.every {
                String column = it.key
                String field = entry[column].toUpperCase()
                String value = it.value
                String match = value.toUpperCase()
                return field.contains(match)
            }
        }
    }

def addExistingAccount(builder, loan, index) {
    accountOwners = load('CustomerAccount', [AccountNumber:loan.AccountNumber], false)
    builder.ValueItem(Value:loan.CurrentAmount) {
        Identifier(UniqueID:"LoanLiabilty-${index}")
        accountOwners.each {
            accountOwner ->
            PercentOwned(Relationship:accountOwner.Role) {
                RelatedEntityRef(RelatedID:accountOwner.CustomerNumber)
				relatedOwnerParties << [RelatedOwnerPartyIndex: index, OwnerNumber: accountOwner.CustomerNumber]
            }
        }
        Liability(UnpaidBalance:loan.CurrentAmount, Description:loan.Description, Type:loan.AccountType) {
			if(loan.LenderName)
			{
				RelatedEntityRef(RelatedID:"Lender-${index}")
				relatedLenderParties << [RelatedLenderPartyIndex: index, LenderName: loan.LenderName]
			}
            ExistingLoan(AdvanceFunds:loan.AdvanceAmount, UndrawnFunds:loan.UndrawnAmount, 
                CompletedIOTermUnits:loan.CompletedIOTermUnits, CompletedIOTermValue:loan.CompletedIOTermValue) {
                RelatedEntityRef(RelatedID:"LoanAccount-${index}")
            }
            AccountNumber(AcctNbr:loan.AccountNumber, AcctName:loan.AccountName) {
				if(loan.BSB)
				{
					BSB(loan.BSB)
				}
			}
        }
    }
    // build Lmi policy map list
    if(loan.LmiPolicyNumber)
        //if(!lmiPolicies) lmiPolicies = [AccountIndex: index, LmiPolicyNumber: loan.LmiPolicyNumber, InsurerName: loan.InsurerName]
        lmiPolicies << [AccountIndex: index, LmiPolicyNumber: loan.LmiPolicyNumber, InsurerName: loan.InsurerName]
}

def addSecurities(builder, security, index) {

	securityAccnts = load('SecurityAccount', [SecurityId:security.SecurityNo], false)
	accnts = load('Account',[AccountNumber:securityAccnts[0].AccountNumber], false)
	owners = load('CustomerAccount',[AccountNumber:accnts[0].AccountNumber], false)

	// Added for LFEMERCURY-15924 for test scenario where a loan account retrieved from host without a linked collateral/property asset.
	if (CustomerNumber == '990026')
		return
	owners = owners.findAll { '990026' != it.CustomerNumber && 'Borrower' == it.Role }

	builder.ValueItem(Value:security.Amount) {
        Identifier(UniqueID:"Security-${index}")
	
		owners.each {
			owner ->
			PercentOwned { RelatedEntityRef(RelatedID:owner.CustomerNumber) }
		}
		
        Asset(SecurityNo:security.SecurityNo, Class:'CurrentSecurity') {
            if(security.Type == 'RealEstate') 
                addPropertySecurity(builder, security, index)
            else
                addOtherSecurity(builder, security, index)
        }
    }
}

def addOtherSecurity(builder, security, index) {
    builder.NonRealEstate {
        switch(security.Type) {
            case 'Vehicle':
                OtherAsset {
                    MotorVehicle(VINNumber:'JT711UJA509171866',
                    Year:security.VehicleYear,
                    EngineNumber:'1FZ0433723',
                    Model:security.VehicleModel,
					ModelType:security.VehicleModelType,
                    VehicleType:security.VehicleType,
                    Make:security.VehicleMake) {
                        VehicleRegistration {
                            RegistrationNumber('1CJB351')
                            State(Name:security.State)
							ExpiryDate{  Date('2099-12-31')  }
                        }												
						if (security.GaragedAddress) {
							GaragedAddress {
							    RelatedEntityRef(RelatedID:"GaragedAddress-${index}")
							}
						}
						if (security.OwnersRegisteredAddress) {
							RegisteredAddress {
								RelatedEntityRef(RelatedID:"RegisteredAddress-${index}")
							}
						}
                    }
					if (security.InsuranceCompanyName) {
						Insurance(Category:security.InsuranceCategory, InsuredAmount:security.InsuredAmount, PremiumAmount:security.PremiumAmount, PolicyNumber:security.PolicyNumber) {
							RelatedEntityRef(RelatedID:"AssetInsurer-${index}")
							relatedAssetInsurerParties << [relatedAssetInsurerPartyIndex: "VehicleInsurer-${index}", relatedAssetInsurerParty: security.InsuranceCompanyName]
							InsuranceExpiryDate {  Date(security.InsuranceExpiryDate)  }
						}
					} else {
						Insurance(InsuredAmount:security.Amount, PolicyNumber:'MOT304176503') {
							InsuranceExpiryDate {  Date('2011-11-16')  }
						}
					}
                }
                break
        
            case 'DepositAccount' :
                DepositAccount(Description:'Deposit Account', DepositAccountType:security.DepositAccountType) {
                    AccountNumber(AcctNbr:security.DepositAccountNumber) { Branch(InternalNumb:'27') }
                }
                break
            
            default:
                OtherAsset(OtherAssetDescription:security.OtherAssetDescription,
                OtherAssetType:security.OtherAssetType)
                break
        }
    }
}
    
def addPropertySecurity(builder, security, index) {
    builder.RealEstate(Type:security.PropertyType, Zoning:security.Zoning, PropertyPrimaryPurpose:security.PropertyPrimaryPurpose, Status:security.AgeDescription ) {
        PropertyFeatures(LandArea:security.Area)
        EstimatedValue(security.Amount)
        PriorityAmount(Amount:security.PriorityAmount)
        Location {
            RelatedEntityRef(RelatedID:"Address-${index}")
            Title(RegisteredOwnerNames:security.RegisteredOwnerName, TorrensTitleRef:security.TorrensTitleRef, OtherDetails:security.TitleOtherDescText, PropertyRegistryDistrict:security.PropertyRegistryDistrict)
        }
		if (security.PolicyNumber)
		{
			Insurance(Category:security.InsuranceCategory, InsuredAmount:security.InsuredAmount, PremiumAmount:security.PremiumAmount, PolicyNumber:security.PolicyNumber) {
				RelatedEntityRef(RelatedID:"AssetInsurer-${index}")
				relatedAssetInsurerParties << [relatedAssetInsurerPartyIndex: index, relatedAssetInsurerParty: security.InsuranceCompanyName]
				InsuranceExpiryDate{
					Date(security.InsuranceExpiryDate)
				}
			}		
		}
        Valuation {
            ExistingValuation(ValuationAmount:security.Amount, ValuationSource:security.ValuationSource ?: 'Registered Valuer') {
                if (security.ValuationDate == 'CURRENT')
                {
                    ValuationDate {
                        Date(new Date().format(dateFormat, TimeZone.getTimeZone("GMT+11")))
                    }
                } else
                {
                    ValuationDate {
                        Date(security.ValuationDate ?: '2003-09-03')
                    }
                }
            }
        }
    }
}

def buildSecurityAccountsMap(account, index) {
       // from account number, get the security ids associated to it
       securityAccounts = load('SecurityAccount', [AccountNumber:account.AccountNumber], false)
       
        if (securityAccounts)
            if(!rawSecurityAccounts) rawSecurityAccounts = securityAccounts
            else securityAccounts.eachWithIndex {
                    securityAccount, securityAccountIndex ->
                    rawSecurityAccounts << securityAccounts[securityAccountIndex]
                 }
            securityAccounts.eachWithIndex{
                securityAccount, securityAccountIndex ->
                // from security id, match with security to generate property security segment
                securities = load('Security', [SecurityNo: securityAccount.SecurityId], false)
                // recombine the result to another list
                
                if (securities) 
                    if (!finalSecurityAccounts) finalSecurityAccounts = securities
                    else securities.eachWithIndex {
                            security, securityIndex ->
                            finalSecurityAccounts << securities[securityIndex]
                        }
            }
}

def buildRefSecurityMap(security,index) {
    if (!refSecurityAccounts) refSecurityAccounts = [(security.SecurityNo):index]
    else refSecurityAccounts.put(security.SecurityNo,index)
}

def buildRefLiabilityMap(liability,index) {
    if (!refLiabilityAccounts) refLiabilityAccounts = [(liability.AccountNumber):index]
    else refLiabilityAccounts.put(liability.AccountNumber,index)
}

def buildRefDepositAcctsMap(account,index) {
    if (!refDepositAccts) refDepositAccts = [(account.AccountNumber):index]
    else refDepositAccts.put(account.AccountNumber,index)
}

return wrap()
