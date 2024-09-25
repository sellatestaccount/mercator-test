Feature: Search and add to cart

  As a saucedemo user,
  I should be able to add the highest priced item to the shopping cart

  Scenario: Search highest price product and add to cart
    Given user navigated to saucedemo home page
    When user selects the highest price item from the product list
    Then the selected item has added to the cart