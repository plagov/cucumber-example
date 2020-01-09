Feature: Smoke test feature

  Scenario: Smoke test scenario
    Given user has 2 apples
    When user gets 2 more apples
    Then user has total of 4 apples

  Scenario: run browser
    Given start browser