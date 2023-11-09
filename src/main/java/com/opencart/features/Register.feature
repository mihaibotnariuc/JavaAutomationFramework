@run
Feature: Register Test Suite

  Background:
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed


  Scenario: Access the Account page after successful registration
    Given "/" endpoint is accessed
    When the registerLink from Header menu is clicked
    Then The new page url contains "route=account/register" keyword


  Scenario: The Account Page URL is opened when the registration is successful

    When the following form from "RegisterPage" is populated as follow:
      | firstNameInput | Random         |
      | lastNameInput  | Random         |
      | emailInput     | RandomEmail    |
      | passwordInput  | RandomPassword |
    And the "privacyInput" from "RegisterPage" is clicked
    And the "continueBtn" from "RegisterPage" is clicked

    Then The new page url contains "route=account/success" keyword

  Scenario: User remains on the registerPage when the continue button is not clicked
    When the following form from "RegisterPage" is populated as follow:
      | firstNameInput | Random         |
      | lastNameInput  | Random         |
      | emailInput     | RandomEmail    |
      | passwordInput  | RandomPassword |
    Then The new page url contains "route=account/register" keyword


  Scenario Outline: An error message is displayed when invalid <impacted attribute> is used for register flow
    When the following form from "RegisterPage" is populated as follow:
      | firstNameInput | <firstName>    |
      | lastNameInput  | <lastName>     |
      | emailInput     | <emailData>    |
      | passwordInput  | <passwordData> |
    And the "privacyInput" from "RegisterPage" is clicked
    And the "subscribeButton" from "RegisterPage" is clicked
    And the "continueBtn" from "RegisterPage" is clicked
    Then the following list of error message is displayed
      | <impacted attribute> must be between 1 and 32 characters! |
    Examples:
      | impacted attribute | firstName                                                            | lastName                                        | emailData   | passwordData |
      | First Name         | asdmalsdmasdasd564665321325a4sdasd23dfghdfjdjdgjhsfkyfdhtykdryfh1111 | Random                                          | RandomEmail | Random       |
      | Last Name          | Mihai                                                                | asdmalsd1231231231231masdasd56325a4sdasd2311111 | RandomEmail | Random       |
