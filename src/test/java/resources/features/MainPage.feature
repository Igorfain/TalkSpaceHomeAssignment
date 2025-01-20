Feature: Main Page Functionality

  Scenario: Verify user is on the main page
    Given the user is logged in
    Then the main page title should be "Products"

  Scenario: Add a product to the cart
    When the user adds a product to the cart
    Then the cart should have 1 item
