@Purchasing
Feature: Purchasing
  User wants to purchase products in Swag Labs

  @TC4
  Scenario Outline: User adds products to the cart and completes the purchase
    Given User is on the login page
    When User inputs "<userName>" as username and "<password>" as password
    Then User will be redirected to the inventory page
    And User is on the inventory page
    When User sorts products by "<filter>"
    And User clicks product "<productName1>" to add it to the cart
    Then Verify the number of products in the cart is "<countProduct1>"
    When User clicks product "<productName2>" to add it to the cart
    Then Verify the number of products in the cart is "<countProduct2>"
    And User clicks the cart button to go to the cart page
    Then User will be redirected to the inventory page
    And Product "<productName1>" and "<productName2>" will be displayed in item list
    When User removes "<productName2>" from the cart
    And User clicks checkout button
    Then User is on the 'Checkout Information' page
    When User inputs "<firstname>" in the first name field, "<lastname>" in the last name field, and "<code>" in the postal code field
    And User clicks the continue button
    Then User is redirected to the Checkout Overview Page
    And Verify the price of product "<productName1>" should be equal to the total price
    And Verify the tax value should be equal to 8% of the total price
    And Verify total payment should be equal to total product price plus tax
    When User clicks the finish button
    Then User will successfully complete the purchase

    Examples:
      | userName      | password     | filter              | productName1      | countProduct1 | productName2          | countProduct2 | firstname | lastname | code |
      | standard_user | secret_sauce | Price (low to high) | Sauce Labs Onesie | 1             | Sauce Labs Bike Light | 2             | nia       | halimah  | 2222 |
