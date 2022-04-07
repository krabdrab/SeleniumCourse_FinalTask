Feature: Add new address to ready user profile

  Scenario Outline: Log in to user account on https://mystore-testlab.coderslab.pl/

    Given Browser opened Main Page https://mystore-testlab.coderslab.pl/index.php/
    When User clicked button signIn
    And User was logged in  after filled correct email and valid password
    And User clicked button address
    And User clicked button create new address
    And User filled out address details <alias>, <address>, <city>, <postal code>, <phone> and clicked saveButton
    Then Added address information should be <alias>, <address>, <city>, <postal code>, <phone> and sees message confirmed "Address successfully added!"
    And User clicked delete Button and sees message confirmed "Address successfully deleted!"


    Examples:
      | alias | address           | postal code | city     | phone       |
      | Mr    | Katowicka 1/23    | 40-018      | Katowice | 123 456 789 |
#      | Mrs   | Lubuska 45/678    | 52-001      | Kielce   | 987 654 321 |
#      | Mis   | Warszawska 90/999 | 00-110      | Gliwice  | 543 129 678 |