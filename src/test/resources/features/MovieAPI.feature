@MovieAPI
Feature: API movie dataBase verification

  @apiCalls
  Scenario: As a user I should be able to verify API calls for Mortal Kombat movie

    Given The Open Movie Database
    Then user can verify API calls for different movies