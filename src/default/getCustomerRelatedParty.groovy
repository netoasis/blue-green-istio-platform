common = loadScript('Common.groovy')

// load the customer
CustomerNumber = body.GetCustomerRelatedPartyRequest.RelatedPartySegment.RelatedParty.Lender.CustomerNumber.text()
assert CustomerNumber?.trim()  : 'No CustomerNumber'
filter = [CustomerNumber:CustomerNumber]

def addCompany(builder, c, customerRelatedParties) {
	builder.Party() {
		Identifier(UniqueID:"Party-${c.CustomerNumber}")
		Company {
			RelatedEntityRef(RelatedID:c.CustomerNumber)
			customerRelatedParties.findAll { 'Yes' == it.IsBeneficialOwner }.each { bo ->
				BeneficialOwner(
					PercentShares:bo.PercentShares,
					IsSignatory:bo.IsSignatory,
					RelationshipType:bo.RelationshipType
				) {
					RelatedEntityRef(RelatedID:"RelatedParty-${bo.RelatedEntityCustomerNumber}")
				}
			}
			customerRelatedParties.each { crp ->
				CompanyRelatedParty(
						PercentShares:crp.PercentShares,
						IsSignatory:crp.IsSignatory,
						RelationshipType:crp.RelationshipType
				) {
					RelatedEntityRef(RelatedID:"RelatedParty-${crp.RelatedEntityCustomerNumber}")
				}
			}
		}
	}
}

def addTrust(builder, c, customerRelatedParties) {
	builder.Party() {
		Identifier(UniqueID:"Party-${c.CustomerNumber}")
		Trust {
			RelatedEntityRef(RelatedID:c.CustomerNumber)
			customerRelatedParties.findAll { 'TRUSTEE' == it.RelationshipType }.each { trustee ->
				Trustees() {
					RelatedEntityRef(RelatedID:"RelatedParty-${trustee.RelatedEntityCustomerNumber}")
				}
			}
			customerRelatedParties.findAll { 'BENEFICIARY' == it.RelationshipType }.each { beneficiary ->
				TrustBeneficiary(PercentShares: beneficiary.PercentShares) {
					RelatedEntityRef(RelatedID:"RelatedParty-${beneficiary.RelatedEntityCustomerNumber}")
				}
			}
		}
	}
}

def addIndividualRelatedParty(builder, c) {
	builder.Person() {
		RelatedEntityRef(RelatedID:"RelatedParty-${c.CustomerNumber}-Lender")
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
		addContactDetails(builder, c)
	}
}

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

def addCompanyRelatedParty(builder, c) {
	builder.Company() {
		RelatedEntityRef(RelatedID:"RelatedParty-${c.CustomerNumber}-Lender")
		CompanyName(BusinessName:c.OtherName)
		addContactDetails(builder, c)
		CompanyNumber(ABN:c.ABN)
	}
}

def response
if (CustomerNumber == '256973')
{
	response = '''
<GetCustomerRelatedPartyResponse xmlns='http://www.sandstone.com.au/lending'>
  <Identifier UniqueID='' />
  <PartySegment>
    <Party>
      <Identifier UniqueID='256973-Company-1' />
      <Person>
        <RelatedEntityRef RelatedID='256973-RelatedParty-Lender-1' />
      </Person>
    </Party>
    <Party>
        <Identifier UniqueID='256973-Trust-1' />
        <RelatedEntityRef RelatedID="256973-TrustSettlor-1" />
        <Trust TrustName="test" TrustDate="2016-01-01" TrustType="Discretionary">
            <TrustBeneficiaries>
                <RelatedEntityRef RelatedID='256973-TrustBeneficiary-1' />
                <RelatedEntityRef RelatedID='256973-TrustBeneficiary-2' />
            </TrustBeneficiaries>
        </Trust>
        <Company>
            <RelatedEntityRef RelatedID='256973-RelatedParty-Lender-2' />
        </Company>
    </Party>
  </PartySegment>
  <RelatedPartySegment>
    <RelatedParty RelPartyType='Lender'>
      <Identifier UniqueID='256973-RelatedParty-Lender-1' />
      <Company>
        <CompanyName BusinessName='Kingsway Ministries Inc' />
      </Company>
      <Lender ExistingCustomer='Yes' LenderStaff='No'>
        <CustomerNumber>256973</CustomerNumber>
      </Lender>
    </RelatedParty>
        <RelatedParty RelPartyType="TrustSettlor">
         <Identifier UniqueID="256973-TrustSettlor-1" />
         <Company>
            <RelatedEntityRef RelatedID="Settlor-Lender-1" />
            <CompanyName BusinessName='Trust Settlor name' />
          </Company>  
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="Settlor-Lender-1" />
         <Company>
            <CompanyName BusinessName="Sandstone Technology" />
         </Company>
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>986022</CustomerNumber>
         </Lender>
      </RelatedParty>
    <RelatedParty RelPartyType='Lender'>
      <Identifier UniqueID='256973-RelatedParty-Lender-2' />
      <Company>
        <CompanyName BusinessName='Sandstone Tech' />
      </Company>
      <Lender ExistingCustomer='Yes' LenderStaff='No'>
        <CustomerNumber>987003</CustomerNumber>
      </Lender>
    </RelatedParty>    
    <RelatedParty RelPartyType='TrustBeneficiary'>
      <Identifier UniqueID='256973-TrustBeneficiary-1' />
      <Person>
        <RelatedEntityRef RelatedID='256973-TrustBeneficiary-Lender-1' />
        <PersonName>
              <NameTitle Value="MR"/>
              <FirstName>Damien</FirstName>
              <OtherName>Wilifred</OtherName>
              <Surname>Harcourt</Surname>
        </PersonName>   
      </Person>
    </RelatedParty>
    <RelatedParty RelPartyType='Lender'>
      <Identifier UniqueID='256973-TrustBeneficiary-Lender-1' />      
      <Lender ExistingCustomer='Yes' LenderStaff='No'>
        <CustomerNumber>987005</CustomerNumber>
      </Lender>
    </RelatedParty>
   <RelatedParty RelPartyType='TrustBeneficiary'>
      <Identifier UniqueID='256973-TrustBeneficiary-2' />
      <Person>
        <RelatedEntityRef RelatedID='256973-TrustBeneficiary-Lender-2' />
        <PersonName>
            <NameTitle Value="MR"/>
            <FirstName>Julius</FirstName>
            <OtherName/>
            <Surname>Randle</Surname>
        </PersonName>   
      </Person>
    </RelatedParty>
    <RelatedParty RelPartyType='Lender'>
      <Identifier UniqueID='256973-TrustBeneficiary-Lender-2' />      
      <Lender ExistingCustomer='Yes' LenderStaff='No'>
        <CustomerNumber>984001</CustomerNumber>
      </Lender>
    </RelatedParty>    
  </RelatedPartySegment>
</GetCustomerRelatedPartyResponse>
	'''
}
else if (CustomerNumber == '916792')
{
	response = '''
<GetCustomerRelatedPartyResponse xmlns="http://www.sandstone.com.au/lending">
   <Identifier UniqueID="" />
   <PartySegment>
      <Party>
         <Identifier UniqueID="916792-Individual-1" />
         <Person>
            <RelatedEntityRef RelatedID="916792-Lender-1" />
         </Person>
      </Party>
      <Party>
         <Identifier UniqueID="916792-Trust-1" />
         <Trust TrustName="test" TrustDate="2016-01-01" TrustType="Discretionary">
            <TrustBeneficiaries>
               <RelatedEntityRef RelatedID="916792-TrustBeneficiary-1" />
            </TrustBeneficiaries>
         </Trust>
         <Company>
            <RelatedEntityRef RelatedID="916792-RelatedParty-Lender-2" />
         </Company>
      </Party>
   </PartySegment>
   <RelatedPartySegment>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="916792-Lender-1" />
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>916792</CustomerNumber>
         </Lender>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="916792-RelatedParty-Lender-1" />
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>910000</CustomerNumber>
         </Lender>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="916792-RelatedParty-Lender-2" />
         <Company>
            <CompanyName BusinessName="Sandstone Tech" />
            <Business Type="PTYLTD"/>
         </Company>
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>910001</CustomerNumber>
         </Lender>
      </RelatedParty>             
      <RelatedParty RelPartyType="PowerOfAttorney">
         <Identifier UniqueID="RP00000001" />
         <Person>
            <RelatedEntityRef RelatedID="916792-RelatedParty-Lender-1" />
            <PersonName>
               <NameTitle Value="MR" />
               <FirstName>Damien</FirstName>
               <OtherName>Wilifred</OtherName>
               <Surname>Harcourt</Surname>
            </PersonName>
            <ContactDetails>
               <AddressDetails PriorAddress="No" Residential="Yes">
                  <RelatedEntityRef RelatedID="Address-333" />
               </AddressDetails>
               <HomePhone>
                  <Phone PreferredContactMethod="No">
                     <FixedPhone AreaCode="04">88787602</FixedPhone>
                  </Phone>
               </HomePhone>
               <WorkPhone>
                  <Phone PreferredContactMethod="No">
                     <FixedPhone AreaCode="04">88795277</FixedPhone>
                  </Phone>
                  <Phone PreferredContactMethod="No">
                     <Mobile>0494778672</Mobile>
                  </Phone>
               </WorkPhone>
               <Email PreferredContactMethod="Yes">dwh_1@kmi.com</Email>
            </ContactDetails>
         </Person>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="Lender-1" />
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>910003</CustomerNumber>
         </Lender>
      </RelatedParty>
      <RelatedParty RelPartyType="PowerOfAttorney">
         <Identifier UniqueID="RP00000002" />
         <Person>
            <RelatedEntityRef RelatedID="Lender-2" />
            <PersonName>
               <NameTitle Value="MS" />
               <FirstName>Justine</FirstName>
               <OtherName>Felicity</OtherName>
               <Surname>Dawson</Surname>
            </PersonName>
            <ContactDetails>
               <HomePhone>
                  <Phone PreferredContactMethod="No">
                     <FixedPhone AreaCode="03">67775601</FixedPhone>
                  </Phone>
               </HomePhone>
               <WorkPhone>
                  <Phone PreferredContactMethod="No">
                     <FixedPhone AreaCode="03">67753211</FixedPhone>
                  </Phone>
                  <Phone PreferredContactMethod="Yes">
                     <Mobile>0481456890</Mobile>
                  </Phone>
               </WorkPhone>
               <Email PreferredContactMethod="No">justine.d@yourmoney.com</Email>
            </ContactDetails>
         </Person>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="Lender-2" />
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>910004</CustomerNumber>
         </Lender>
      </RelatedParty>      
      <RelatedParty RelPartyType="TrustBeneficiary">
         <Identifier UniqueID="916792-TrustBeneficiary-1" />
         <Company>
            <RelatedEntityRef RelatedID="916792-TrustBeneficiary-Lender-4" />
            <CompanyName BusinessName="Trust beneficiary company" />
            <Business Type="PTYLTD"/>
            <CompanyRelatedParty>
               <RelatedEntityRef RelatedID="Beneficiary-RelatedParty-1" />
            </CompanyRelatedParty>           
         </Company>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="916792-TrustBeneficiary-Lender-4" />
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>910005</CustomerNumber>
         </Lender>
      </RelatedParty>
      <RelatedParty RelPartyType="ACCOUNTANT">
         <Identifier UniqueID="Beneficiary-RelatedParty-1" />
         <Company>
            <RelatedEntityRef RelatedID="Beneficiary-RelatedParty-Lender-1" />
            <CompanyName BusinessName="Beneficiary company related party" />
         </Company>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="Beneficiary-RelatedParty-Lender-1" />
         <Company>
            <CompanyName BusinessName="Sandstone Technology" />
         </Company>
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>910006</CustomerNumber>
         </Lender>
      </RelatedParty>      
   </RelatedPartySegment>
</GetCustomerRelatedPartyResponse>
	'''
}
else if (CustomerNumber == '986020')
{
	response = '''
<GetCustomerRelatedPartyResponse xmlns="http://www.sandstone.com.au/lending">
   <Identifier UniqueID="" />
   <PartySegment>
      <Party>
         <Identifier UniqueID="986020-Individual-1" />
         <Person>
            <RelatedEntityRef RelatedID="986020-Lender-1" />
         </Person>
      </Party>
      <Party>
         <Identifier UniqueID="986020-Trust-1" />
         <RelatedEntityRef RelatedID="986020-TrustSettlor-1" />
         <Trust TrustName="test" TrustDate="2016-01-01" TrustType="Discretionary">
            <TrustBeneficiaries>
                <RelatedEntityRef RelatedID="986020-TrustBeneficiary-1" />
            </TrustBeneficiaries>
         </Trust>
         <Company>
            <RelatedEntityRef RelatedID="986020-RelatedParty-Lender-2" />
         </Company>
      </Party>
   </PartySegment>
   <RelatedPartySegment>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="986020-Lender-1" />
         <Company>
            <CompanyName BusinessName="Sandstone Tech" />
         </Company>
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>986020</CustomerNumber>
         </Lender>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="986020-RelatedParty-Lender-2" />
         <Company>
            <CompanyName BusinessName="Sandstone Tech" />
         </Company>
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>986021</CustomerNumber>
         </Lender>
      </RelatedParty>
      <RelatedParty RelPartyType="TrustSettlor">
         <Identifier UniqueID="986020-TrustSettlor-1" />
         <Person Sex="MALE">
            <RelatedEntityRef RelatedID="Settlor-Lender-1" />
            <PersonName>
               <NameTitle Value="MS" />
               <FirstName>Steve</FirstName>
               <OtherName />
               <Surname>Dawson</Surname>
            </PersonName>
            <DateOfBirth>
               <Date>1990-06-03</Date>
            </DateOfBirth>
            <ContactDetails>               
               <HomePhone>
                  <Phone PreferredContactMethod="No">
                     <FixedPhone AreaCode="02">9876-5432</FixedPhone>
                  </Phone>
                  <Phone PreferredContactMethod="No">
                     <Mobile>0459653653</Mobile>
                  </Phone>
               </HomePhone>
               <WorkPhone>
                  <Phone PreferredContactMethod="Yes">
                     <FixedPhone AreaCode="02">9911-5533</FixedPhone>
                  </Phone>
               </WorkPhone>
               <Email PreferredContactMethod="No">steve@dawson.com</Email>
            </ContactDetails>            
         </Person>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="Settlor-Lender-1" />
         <Company>
            <CompanyName BusinessName="Sandstone Technology" />
         </Company>
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>986022</CustomerNumber>
         </Lender>
      </RelatedParty>
      <RelatedParty RelPartyType="PowerOfAttorney">
         <Identifier UniqueID="RP00000001" />
         <Person>
            <RelatedEntityRef RelatedID="Lender-1" />
            <PersonName>
               <NameTitle Value="MR" />
               <FirstName>Damien</FirstName>
               <OtherName>Wilifred</OtherName>
               <Surname>Harcourt</Surname>
            </PersonName>
            <ContactDetails>
               <AddressDetails PriorAddress="No" Residential="Yes">
                  <RelatedEntityRef RelatedID="Address-333" />
               </AddressDetails>
               <HomePhone>
                  <Phone PreferredContactMethod="No">
                     <FixedPhone AreaCode="04">88787602</FixedPhone>
                  </Phone>
               </HomePhone>
               <WorkPhone>
                  <Phone PreferredContactMethod="No">
                     <FixedPhone AreaCode="04">88795277</FixedPhone>
                  </Phone>
                  <Phone PreferredContactMethod="No">
                     <Mobile>0494778672</Mobile>
                  </Phone>
               </WorkPhone>
               <Email PreferredContactMethod="Yes">dwh_1@kmi.com</Email>
            </ContactDetails>
         </Person>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="Lender-1" />
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>986023</CustomerNumber>
         </Lender>
      </RelatedParty>
      <RelatedParty RelPartyType="PowerOfAttorney">
         <Identifier UniqueID="RP00000002" />
         <Person>
            <RelatedEntityRef RelatedID="Lender-2" />
            <PersonName>
               <NameTitle Value="MS" />
               <FirstName>Justine</FirstName>
               <OtherName>Felicity</OtherName>
               <Surname>Dawson</Surname>
            </PersonName>
            <ContactDetails>
               <HomePhone>
                  <Phone PreferredContactMethod="No">
                     <FixedPhone AreaCode="03">67775601</FixedPhone>
                  </Phone>
               </HomePhone>
               <WorkPhone>
                  <Phone PreferredContactMethod="No">
                     <FixedPhone AreaCode="03">67753211</FixedPhone>
                  </Phone>
                  <Phone PreferredContactMethod="Yes">
                     <Mobile>0481456890</Mobile>
                  </Phone>
               </WorkPhone>
               <Email PreferredContactMethod="No">justine.d@yourmoney.com</Email>
            </ContactDetails>
         </Person>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="Lender-2" />
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>986024</CustomerNumber>
         </Lender>
      </RelatedParty>
      <RelatedParty RelPartyType="PowerOfAttorney">
         <Identifier UniqueID="RP00000003" />
         <Person>
            <RelatedEntityRef RelatedID="Lender-3" />
            <PersonName>
               <NameTitle Value="MS" />
               <FirstName>Betty</FirstName>
               <OtherName />
               <Surname>Barnes</Surname>
            </PersonName>
            <ContactDetails>
               <HomePhone>
                  <Phone PreferredContactMethod="No">
                     <FixedPhone AreaCode="03">67775601</FixedPhone>
                  </Phone>
               </HomePhone>
               <WorkPhone>
                  <Phone PreferredContactMethod="No">
                     <FixedPhone AreaCode="03">67753211</FixedPhone>
                  </Phone>
                  <Phone PreferredContactMethod="Yes">
                     <Mobile>0481456890</Mobile>
                  </Phone>
               </WorkPhone>
               <Email PreferredContactMethod="No">betty.b@askhelp.com</Email>
            </ContactDetails>
         </Person>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="Lender-3" />
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>986025</CustomerNumber>
         </Lender>
      </RelatedParty>
      <RelatedParty RelPartyType="TrustBeneficiary">
         <Identifier UniqueID="986020-TrustBeneficiary-1" />
         <Company>
            <RelatedEntityRef RelatedID="986020-TrustBeneficiary-Lender-4" />
            <CompanyName BusinessName="Trust beneficiary company" />
            <Business Type="PTYLTD"/>
            <CompanyRelatedParty>
               <RelatedEntityRef RelatedID="Beneficiary-RelatedParty-1" />
            </CompanyRelatedParty>
            <CompanyRelatedParty>
               <RelatedEntityRef RelatedID="Beneficiary-RelatedParty-2" />
            </CompanyRelatedParty>
         </Company>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="986020-TrustBeneficiary-Lender-4" />
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>986026</CustomerNumber>
         </Lender>
      </RelatedParty>
      <RelatedParty RelPartyType="ACCOUNTANT">
         <Identifier UniqueID="Beneficiary-RelatedParty-1" />
         <Company>
            <RelatedEntityRef RelatedID="Beneficiary-RelatedParty-Lender-1" />
            <CompanyName BusinessName="Beneficiary company related party" />
         </Company>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="Beneficiary-RelatedParty-Lender-1" />
         <Company>
            <CompanyName BusinessName="Sandstone Technology" />
         </Company>
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>986027</CustomerNumber>
         </Lender>
      </RelatedParty>
      <RelatedParty RelPartyType="ACCOUNTANT">
         <Identifier UniqueID="Beneficiary-RelatedParty-2" />
         <Person Sex="MALE">            
            <RelatedEntityRef RelatedID="Beneficiary-RelatedParty-Lender-2" />
            <PersonName>
               <NameTitle Value="MS" />
               <FirstName>Justine</FirstName>
               <OtherName>Felicity</OtherName>
               <Surname>Dawson</Surname>
            </PersonName>
         </Person>
      </RelatedParty>
      <RelatedParty RelPartyType="Lender">
         <Identifier UniqueID="Beneficiary-RelatedParty-Lender-2" />
         <Lender ExistingCustomer="Yes" LenderStaff="No">
            <CustomerNumber>986028</CustomerNumber>
         </Lender>
      </RelatedParty>
   </RelatedPartySegment>
</GetCustomerRelatedPartyResponse>
	'''
}
else
{
	cust = load('Customer', filter, false)[0] // should only be 1!
	if (cust) { // found
		customerRelatedParties = load('CustomerRelatedParty', filter, false)
		boolean isCompany = 'Company' == cust.Type
		boolean isTrust = 'Trust' == cust.Type
		if (customerRelatedParties) {
			mb.GetCustomerRelatedPartyResponse(xmlns: 'http://www.sandstone.com.au/lending') {
				Identifier(UniqueID:"GetCustomerRelatedParty-${cust.CustomerNumber}")
				PartySegment() {
					if (isCompany) addCompany(mb, cust, customerRelatedParties)
					else if (isTrust) addTrust(mb, cust, customerRelatedParties)
//					else addIndividual(mb, cust, customerRelatedParties)
				}
				RelatedPartySegment() {
					processedParties = []
					customerRelatedParties.each { rp ->
						def relatedEntityCustomerNumber = rp.RelatedEntityCustomerNumber
						if (!processedParties.contains(relatedEntityCustomerNumber)) {
							filter = [CustomerNumber: relatedEntityCustomerNumber]
							relatedParty = load('Customer', filter, false)[0] // should only be 1!
							RelatedParty() {
								Identifier(UniqueID: "RelatedParty-${relatedParty.CustomerNumber}")
								if ('Individual' == relatedParty.Type) {
									addIndividualRelatedParty(mb, relatedParty)
								} else if ('Company' == relatedParty.Type) {
									addCompanyRelatedParty(mb, relatedParty)
								}
							}
							RelatedParty(RelPartyType: "Lender") {
								Identifier(UniqueID: "RelatedParty-${relatedParty.CustomerNumber}-Lender")
								Lender(ExistingCustomer: 'Yes', LenderStaff: "${relatedParty.IsStaffMember}") {
									CustomerNumber "${relatedParty.CustomerNumber}"
								}
							}
							processedParties.add(relatedEntityCustomerNumber)
						}
					}
				}
				AddressSegment() {
					processedParties = []
					customerRelatedParties.each { rp ->
						def relatedEntityCustomerNumber = rp.RelatedEntityCustomerNumber
						if (!processedParties.contains(relatedEntityCustomerNumber)) {
							filter = [CustomerNumber: relatedEntityCustomerNumber]
							relatedParty = load('Customer', filter, false)[0] // should only be 1!
							common.addAddress(mb, "Address-${relatedParty.CustomerNumber}", relatedParty.AddressID)
							if (relatedParty.MailingAddressId) {
								common.addAddress(mb, "MailingAddress-${relatedParty.CustomerNumber}", relatedParty.MailingAddressId)
							}
							if (relatedParty.TradingAddressId) {
								common.addAddress(mb, "TradingAddress-${relatedParty.CustomerNumber}", relatedParty.TradingAddressId)
							}
							processedParties.add(relatedEntityCustomerNumber)
						}
					}
				}
			}
			return wrap()
		}
	}
	response = '''
<GetCustomerRelatedPartyResponse xmlns='http://www.sandstone.com.au/lending'>
  <Identifier UniqueID='' />
  <PartySegment>
    <Party>
      <Identifier UniqueID='Party-123' />
    </Party>
  </PartySegment>
</GetCustomerRelatedPartyResponse>	
	'''
}
return wrap(response)
