Feature: Register Test Suite

  Scenario: Access the Account page after successful registration
    Given "/" endpoint is accessed
    And RegisterPage is accessed from Homepage buttons
    When the registerLink from Header menu is clicked
    Then The new page url contains "route=account/register" keyword

  Scenario: The Account Page URL is opened when the registration is successful
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed
    When the register form is populated with valid random data
    And Continue button is clicked
    Then The new page url contains "route=account/success" keyword

    Scenario: User remains on the registerPage when the continue button is not clicked
      Given "/index.php?route=account/register&language=en-gb" endpoint is accessed
      When the register form is populated with valid random data
      Then The new page url contains "route=account/register" keyword