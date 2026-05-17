common = loadScript('Common.groovy')

def addCompany(builder, company, index) {
    builder.Party() {
        Identifier(UniqueID:company.CustomerNumber)
        Company {
            CompanyName(BusinessName:company.OtherName)
            ContactDetails {
                AddressDetails {
                    RelatedEntityRef(RelatedID:"Address-${index}")
                }
            }
        }
    }
}

def addTrust(builder, trust, index) {
    builder.Party() {
        Identifier(UniqueID:trust.CustomerNumber)
        Trust(TrustName:trust.OtherName, TrustType:trust.TrustType) {
            ContactDetails {
                AddressDetails {
                    RelatedEntityRef(RelatedID:"Address-${index}")
                }
            }
        }
    }
}

def addPerson(builder, person, index) {
    builder.Party() {
        Identifier(UniqueID:person.CustomerNumber)
        Person {
            PersonName {
                FirstName(person.FirstName)
                OtherName(person.OtherName)
                Surname(person.LastName)
            }
            DateOfBirth {
                Date(person.DateOfBirth)
            }
            ContactDetails {
                AddressDetails {
                    RelatedEntityRef(RelatedID:"Address-${index}")
                }
            }
        }
    }
}

// Set up filter map based on search information given
filter = [:]
party = body.CustomerSearchRequest.PartySegment.Party

// customer number used for both company and person
filter.CustomerNumber = party.Identifier.@UniqueID.text()
UniqueIdentiferType = party.Identifier.@Type.text()

isPerson = !party.Person.isEmpty()
if (isPerson) {
    filter.FirstName = party.Person.PersonName.FirstName.text()
    if(filter.FirstName?.equalsIgnoreCase('HOSTERROR')) {
        return soapFault('UFSS0001', 'UFSS0001')
    }

    filter.LastName = party.Person.PersonName.Surname.text()
    filter.DateOfBirth = party.Person.DateOfBirth.Date.text()
}

isCompany = !party.Company.isEmpty()
if (isCompany) filter.OtherName = party.Company.CompanyName.@BusinessName.text()

isTrust = !party.Trust.isEmpty()
if (isTrust) filter.OtherName = party.Trust.@TrustName.text()

assert (isPerson && !isCompany && !isTrust) || (isCompany && !isPerson && !isTrust) ||  (isTrust && !isCompany && !isPerson): 'cannot have person and company and trust in same request'
filter.Type = isPerson ? 'Individual' : (isTrust ? 'Trust' : 'Company')

// find the list of customers matching the search parameters
customers = load('Customer', filter, false)
log.info "Customer search using ${filter} returned ${customers.size()} results"
if (!customers && 'AccountNumber' == UniqueIdentiferType)  {
    // Try account number
    accountFilter = [AccountNumber : party.Identifier.@UniqueID.text()]
    log.info "Customer search using ${accountFilter} on CustomerAccount"
    customerAccounts = load('CustomerAccount', accountFilter, false)
    log.info "Customer search using ${accountFilter} on CustomerAccount returned ${customerAccounts.size()} results"
    customers = []
    customerAccounts.each {
        filter.CustomerNumber = it.CustomerNumber
        customers += load('Customer', filter, false)
    }
}
if (!customers || customers.isEmpty()) return soapFault('No matching customers found.', 'CUST_SEARCH_NO_MATCH')

mb.CustomerSearchResponse(xmlns:'http://www.sandstone.com.au/lending') {
    Identifier(UniqueID:random())
    RevisionNumber(LenderVersion:'1.0')
    PartySegment {
        customers.eachWithIndex { cust, i ->
            if ('Company' == cust.Type) addCompany(mb, cust, i)
            else  if ('Trust' == cust.Type) addTrust(mb, cust, i)
            else addPerson(mb, cust, i)
        }
    }
    AddressSegment {
        customers.eachWithIndex { cust, i ->
            common.addAddress(mb, "Address-${i}", cust.AddressID)
        }
    }
}
return wrap()