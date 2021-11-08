@t
Feature: JS Alerts efficiency verification

  Background: user is on javascript alerts page
    Given user is on javascript alerts page

  @t
  Scenario Outline: Java Script simple and confirmational alert verification
    When user clicks for "<alert>"
    Then alert should say "<alertMessage>"
    When user type "<text>"
    And user clicks "<button>"
    Then Message should say "<message>"

    Examples:
      | alert      | alertMessage      | text | button | message                           |
      | JS Alert   | I am a JS Alert   |      | OK     | You successfully clicked an alert |
      | JS Confirm | I am a JS Confirm |      | OK     | You clicked: Ok                   |
      | JS Confirm | I am a JS Confirm |      | Cancel | You clicked: Cancel               |
      | JS Prompt  | I am a JS prompt  | Bob  | OK     | You entered: Bob                  |
      | JS Prompt  | I am a JS prompt  |      | Cancel | You entered: null                 |

