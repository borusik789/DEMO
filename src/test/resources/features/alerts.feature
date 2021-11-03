Feature: JS Alerts efficiency verification

  Background: user is on practice alerts page
    Given user is on javascript alerts page

  Scenario: Simple alert verification
    When user clicks on alert button
    Then user should see alert window with "I am a JS Alert" text
    When user clicks OK
    Then alert should disappear
    And Message should say "You successfully clicked an alert"


  Scenario: Confirmation alert verification
    When user clicks on confirmation box button
    Then user should see alert window with "I am a JS Confirm" text
    When user clicks cancel
    Then alert should disappear
    And Message should say "You clicked: Cancel"

  Scenario: Prompt alert verification
    When user clicks on prompt alert button
    Then user should see alert window with "I am a JS prompt" text
    When user type "Boris"
    And  user clicks OK
    Then alert should disappear
    And Message should say "You entered: Boris"

