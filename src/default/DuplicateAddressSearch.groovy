/*
 * LendFast sends the duplicateAddressSearch request message in order to find
 * out if there are existing valuations in VMS for a particular property that
 * MIGHT be usable for the current loan application (and thereby save our
 * customer from paying for a new valuation). If there is an existing valuation,
 * LendFast will change the subsequent request so that a valuer is not allocated
 * automatically. It requires manual intervention if a suitable valuation is
 * found to manually log in and link the existing one to the application.
 * 
 * So, for the purposes of this fake host message, we don't care about the
 * response content beyond the number of valuations returned.
 */

// get the list of valuation IDs matching the address
a = body.duplicateAddressSearchRequest.Address
addrString = [
    [a.UnitNo.text(), a.StreetNo.text()].findAll().join('-'),
    a.Street.text(),
    a.Street.@Type.text(),
    a.City.text(),
    a.State.@Name.text(),
    a.Postcode.text()
].findAll().join(' ') // call to findAll to remove null/empty vals from list
filter = [Address:addrString]
duplicates = load('ValuationAddress', filter)
log.info "Duplicate address search using ${filter} returned ${duplicates.size()} results"

mb.'vms:duplicateAddressSearchResponse'('xmlns:vms':'http://www.sandstone-vms.com.au/schema/vms/1.0',
        'xmlns:l':'http://www.lixi.org.au/schema/cal1.3/ValuationTransaction') {
    duplicates.each { dup ->
        'vms:ValuationSummary' {
            'l:Identifier'(UniqueID:dup.ID, Type:'ThirdPartyAssigned', Description:'VMS')
            // LendFast ignores the rest of the content, so leave it out
        }
    }
}
return wrap()