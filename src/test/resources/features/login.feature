Feature: As user I want to be able to login

  Background: common steps
    Given user is on the login page

  @smoke
  Scenario: Login with valid credentials
    When user logs in with valid credentials
    Then user should see "My account - My Store" page

  @negative_login @smoke
  Scenario Outline: Invalid login with <email> and <password>
    When user logs in with "<email>" username and "<password>" password
    Then user verifies that "<message>" message is displayed
    Examples:
      | email            | password | message                    |
      | bob789@gmail.com | qwer     | Invalid password          |
      | bob789@gmail.com |          | Password is required.      |
      | wrong@gmail.com  | b1234567 | Authentication failed.     |
      |                  | b1234567 | An email address required. |