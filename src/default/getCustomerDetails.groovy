common = loadScript('Common.groovy')

def addContactDetails(builder, c) {
    builder.ContactDetails {
        AddressDetails(PriorAddress:c.PriorAddress, Residential:c.Residential, Registered:c.Registered, HousingStatus: c.HousingStatus) {
            RelatedEntityRef(RelatedID:"Address-${c.CustomerNumber}")
            if (c.AddressDurationLength || c.AddressDurationUnits) {
                Duration(Length:c.AddressDurationLength, Units: c.AddressDurationUnits)
            }
        }
		if (c.MailingAddressId) {
			AddressDetails(Mailing:'Yes') {
				RelatedEntityRef(RelatedID:"MailingAddress-${c.CustomerNumber}")
				if (c.AddressDurationLength || c.AddressDurationUnits) {
					Duration(Length:c.AddressDurationLength, Units: c.AddressDurationUnits)
				}
			}
		}
        if (c.TradingAddressId) {
            AddressDetails(PriorAddress:'No', Trading:'Yes') {
                RelatedEntityRef(RelatedID:"TradingAddress-${c.CustomerNumber}")
                if (c.AddressDurationLength || c.AddressDurationUnits) {
                    Duration(Length:c.AddressDurationLength, Units: c.AddressDurationUnits)
                }
            }
        }
        if (c.HomePhoneNumber || c.Mobile) HomePhone {
            if (c.HomePhoneNumber) Phone(PreferredContactMethod:"${c.PreferredContact=='Home'?'Yes':'No'}") {
                FixedPhone(AreaCode:c.HomePhoneAreaCode, c.HomePhoneNumber)
            }
            if (c.Mobile) Phone(PreferredContactMethod:"${c.PreferredContact=='Mobile'?'Yes':'No'}") {
                Mobile(c.Mobile)
            }
        }
        if (c.WorkPhoneNumber) WorkPhone {
            Phone(PreferredContactMethod:"${c.PreferredContact=='Work'?'Yes':'No'}") {
                FixedPhone(AreaCode:c.WorkPhoneAreaCode, c.WorkPhoneNumber)
            }
        }
        if (c.Email) Email(PreferredContactMethod:"${c.PreferredContact=='Email'?'Yes':'No'}", c.Email)
    }
}

def addIDVerification(builder, c) {
    if (c.isIDVerificationVerified && c.IDVerificationType) {
        builder.IDVerification(IsCustomerIDVerified:c.isIDVerificationVerified) {
            Identifier(UniqueID:"IDVerification-${c.CustomerNumber}",Type:c.IDVerificationType )
        }
    }
}

def addCompany(builder, c) {
    builder.Party(Class:'2') {
        Identifier(UniqueID:"Party-${c.CustomerNumber}")
        Company (
            NumberOfEmployees:c.NumberOfEmployees,
            IsGSARequired:c.IsGSARequired,
            TradingStartDate:c.TradingStartDate
        ) {
            RelatedEntityRef(RelatedID: "Party-${c.CustomerNumber}")
            CompanyName(BusinessName: c.OtherName)
            addContactDetails(builder, c)
            CompanyNumber(ABN: c.ABN, ACN: c.ACN)
            if (c.RegisteredDate) {
                RegisteredIn() {
                    Date "${c.RegisteredDate}"
                }
            }
            Business(Type:c.BusinessType)
        }
        BranchDomicile(FormattedAddress:'105 Miller St, North Sydney NSW 2060',
            FormattedPhoneNumber:'13 22 65',
            LocationLatitude:'-33.837517',
            LocationLongitude:'151.207236')
        TwoFAChannel('SMS')
    }
}

def addTrust(builder, c) {
    builder.Party(Class:'2') {
        Identifier(UniqueID:"Party-${c.CustomerNumber}")
        Trust(
            TrustName:c.OtherName,
            TrustType:c.TrustType,
            TrustDate:c.RegisteredDate,
            ABN:c.ABN,
            NumberOfEmployees:c.NumberOfEmployees,
            IsGSARequired:c.IsGSARequired
        ) {
            RelatedEntityRef(RelatedID:"Party-${c.CustomerNumber}")
            addContactDetails(builder, c)
            if (c.TrustVestingDate) {
                TrustVestingDate() {
                    Date "${c.TrustVestingDate}"
                }
            }
        }
        BranchDomicile(FormattedAddress:'105 Miller St, North Sydney NSW 2060',
                FormattedPhoneNumber:'13 22 65',
                LocationLatitude:'-33.837517',
                LocationLongitude:'151.207236')
    }
}

def addIndividual(builder, c) {
    builder.Party(Status:c.CustomerStatus) {
        Identifier(UniqueID:c.CustomerNumber)
        Privacy() {
            if (c.DriversLicenceNumber) {
                partyNames = [c.FirstName, c.OtherName, c.LastName]
                partyNames.removeAll(['', null])
                PointVerification(
                    CardNumber:c.DriversLicenceCardNumber,
                    DocumentNumber:c.DriversLicenceNumber,
                    DocumentType:"DriversLicenceAust",
                    NameOnDocument:partyNames.join(' '),
                    Description:"Australian Drivers Licence"
                ) {
                    PlaceOfIssue() {
                        State(Name:c.DriversLicenceState)
                    }
                    EndDate() {
                        Date('2030-12-25')
                    }
                }
            }
        }
        Person(Sex:c.Sex) {
            RelatedEntityRef(RelatedID:"Party-${c.CustomerNumber}")
            PersonName {
                NameTitle(Value:((c.Sex=='FEMALE') ? ((c.MaritalStatus=='MARRIED') ? 'MRS' : 'MS') : 'MR'))
                FirstName(c.FirstName)
                OtherName(c.OtherName)
                Surname(c.LastName)
            }
            DateOfBirth {
                Date(c.DateOfBirth)
            }
            MaritalStatus(Status:c.MaritalStatus)
            Residency(Status:c.ResidencyStatus)
            CountryOfBirth {
                Country(ISO3166:c.CountryOfBirth)
            }
            addContactDetails(builder, c)
        }
        addIDVerification(mb, cust)
    }
}

def addCompanyContactRelatedParty(builder, c) {
    builder.RelatedParty(RelPartyType:'COMPANY_CONTACT') {
        Identifier(UniqueID:'RP00000001')
        PersonName {
            NameTitle(Value:'MR')
            FirstName('Damien')
            OtherName('Wilifred')
            Surname('Harcourt')
        }
        RelatedEntityRef(RelatedID:"Party-${c.CustomerNumber}")
        RelatedEntityRef(RelatedID:'Address-CompanyContact')
        WorkPhone {
            Phone(PreferredContactMethod:'No') {
                FixedPhone(AreaCode:'02', '88795277')
            }
            Phone(PreferredContactMethod:'No') {
                Mobile('0494778672')
            }
        }
        HomePhone {
            Phone(PreferredContactMethod:'No') {
                FixedPhone(AreaCode:'02', '88787602')
            }
        }
        Email(PreferredContactMethod:'Yes', 'dwh_1@kmi.com')
    }
}

def addAccountantRelatedParty(builder, c) {
    builder.RelatedParty(RelPartyType:'ACCOUNTANT') {
        Identifier(UniqueID:'RP00000002')
        PersonName {
            NameTitle(Value:'MS')
            FirstName('Justine')
            OtherName('Feliciy')
            Surname('Dawson')
        }
        RelatedEntityRef(RelatedID:"Party-${c.CustomerNumber}")
        RelatedEntityRef(RelatedID:'Address-Accountant')
        WorkPhone {
            Phone(PreferredContactMethod:'No') {
                FixedPhone(AreaCode:'03', '67753211')
            }
            Phone(PreferredContactMethod:'Yes') {
                Mobile('0481456890')
            }
        }
        HomePhone {
            Phone(PreferredContactMethod:'No') {
                FixedPhone(AreaCode:'03', '67775601')
            }
        }
        Email(PreferredContactMethod:'No', 'justine.d@yourmoney.com')
    }
}

// load the customer
party = body.GetCustomerDetailsRequest.PartySegment.Party
CustomerNumber = party.Identifier.@UniqueID.text()
assert CustomerNumber?.trim()  : 'No CustomerNumber'
filter = [CustomerNumber:CustomerNumber]
cust = load('Customer', filter, false)[0] // should only be 1!
log.fine "cust: ${cust}"

boolean isCompany = 'Company' == cust.Type
boolean isTrust = 'Trust' == cust.Type
mb.GetCustomerDetailsResponse(xmlns:'http://www.sandstone.com.au/lending') {
    Identifier(UniqueID:random())
    RevisionNumber(LenderVersion:'1.0')
    PartySegment {
        if (isCompany) addCompany(mb, cust)
        else if (isTrust) addTrust(mb, cust)
        else addIndividual(mb, cust)
    }
    AddressSegment {
        common.addAddress(mb, "Address-${cust.CustomerNumber}", cust.AddressID)
        if (isCompany && ('256973' == CustomerNumber)) {
            common.addAddress(mb, 'Address-CompanyContact', '3')
            common.addAddress(mb, 'Address-Accountant', '5')
        }
		if (cust.MailingAddressId) {
			common.addAddress(mb, "MailingAddress-${cust.CustomerNumber}", cust.MailingAddressId)
		}
        if (cust.TradingAddressId) {
            common.addAddress(mb, "TradingAddress-${cust.CustomerNumber}", cust.TradingAddressId)
        }
    }
    RelatedPartySegment {
        RelatedParty(RelPartyType:'Lender') {
            Identifier(UniqueID:"Party-${cust.CustomerNumber}")
            Lender(LenderStaff:cust.IsStaffMember) {
                CustomerNumber(cust.CustomerNumber)
                if(cust.DateJoined) DateJoined {
                    Date(cust.DateJoined)
                }
            }
        }
        if (isCompany && ('256973' == CustomerNumber)) {
            addCompanyContactRelatedParty(mb, cust)
            addAccountantRelatedParty(mb, cust)
        }
    }
}
return wrap()