def addAddress(builder, uniqueId, addressId) {
    def address = load('Address', [AddressID:addressId])[0]
    assert address : "Unable to find address with id ${addressId}"
    builder.AddressWrapper {
        Identifier(UniqueID:uniqueId)
        Address {
			if (address.City) {
				if(address.UnitNo) {
					UnitNo(address.UnitNo)
				}
				StreetNo(address.StreetNo)
				Street(Type:address.StreetType, address.Street)
				City(address.City)
				State(Name:address.State)
				Postcode(address.PostCode)
				DeliveryPointIdentifier(BarCode:'')
				Country(ISO3166:address.Country)
			}            
			else if (address.NonStdAddress) {
				NonStdAddress(address.NonStdAddress)
			}
        }
    }
}