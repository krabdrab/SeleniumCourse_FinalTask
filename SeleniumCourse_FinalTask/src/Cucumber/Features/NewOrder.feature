Feature: New order

  Scenario Outline: Adding new order
    Given User opened https://mystore-testlab.coderslab.pl/ page
    And User clicks on SingIn button
    And User enters email <email> and password <password> and click SignIn button
    When User finds Hummingbird Printed Sweater
    And User choose size, quantity, add product to the basket and goes to checkout
    And User confirms address alias <alias>
    And User choose delivery method Pick up in store, choose pay by Check and confirms order
    Then User sees order confirmation
#    And Screenshot is taken
#    And User goes back to account page and goes to order history
#    And Browser is closed
    Examples:
      | email                   | firstname | lastname  | password  | alias |
      | jan.jakowski@Silesia.pl | Jan       | Jankowski | 123!@#Qwe | Mis   |