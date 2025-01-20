Feature: Login Functionality

  Scenario: Valid Login
    Given the user is on the Sauce Demo login page
    When the user enters valid credentials
    Then the user should be redirected to the products page
