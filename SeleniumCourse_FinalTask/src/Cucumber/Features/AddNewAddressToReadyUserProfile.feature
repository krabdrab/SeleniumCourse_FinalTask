Feature: Add new address to ready user profile

	Scenario Outline: Log in to user account on https://mystore-testlab.coderslab.pl/

		Given Browser opened Main Page https://mystore-testlab.coderslab.pl/index.php/
		When User clicked button signIn
		And User was logged in  after filled correct email and valid password
		And User clicked button address
		And User clicked button create new address
		And User filled out address details : <alias>, <address>, <postal code>, <country>, <phone> and clicked saveButton
#		Then User sees a confirmation message added "Address successfully added!"
		And User clicked button delete
#		Then user sees a confirmation message deleted "Address successfully deleted!"

	Examples:
	|alias	|address			|postal code |country		 |phone		 |
	|Mr		|Katowicka 1/23		|40-018		 |United Kingdom |123 456 789|
	|Mrs	|Lubuska	45/678	|52-001		 |United Kingdom |987 654 321|
	|Mis	|Warszawska	90/999	|00-110		 |United Kingdom |543 129 678|