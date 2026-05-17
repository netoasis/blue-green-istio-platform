isIndividual = body.CreateCustomerRequest.PartySegment.Party.Person.PersonName.FirstName.text()

if(isIndividual)
{
	name = body.CreateCustomerRequest.PartySegment.Party.Person.PersonName
	first = name.FirstName.text()
	last = name.Surname.text()
	other = name.OtherName.text()
	// look up the customer ID using first & last names
	filter = [Type: 'Individual', FirstName:first, LastName:last]
}else
{
	companyName = body.CreateCustomerRequest.PartySegment.Party.Company.CompanyName.@BusinessName.text()
	filter = [Type: 'Company', OtherName:companyName]
}

cNum = load('Customer', filter, true)[0]?.CustomerNumber
cNum = (cNum)? cNum : randomCustomerNumber()

mb.CreateCustomerResponse(xmlns:'http://www.sandstone.com.au/lending') {
    Identifier(UniqueID:random())
    RevisionNumber(LenderVersion:'1.0')
    PartySegment {
        Party {
            Identifier(UniqueID: cNum)
			if (isIndividual) addIndividual(mb, first, other, last)
			else addCompany(mb, companyName)
        }
    }
}

def addIndividual(builder, first, other, last) {
    builder.Person() {
		PersonName {
			FirstName(first)
			OtherName(other)
			Surname(last)
		}
	}
}

def addCompany(builder, companyName) {
    builder.Company() {
		CompanyName(BusinessName:companyName)
    }
}

return wrap()
