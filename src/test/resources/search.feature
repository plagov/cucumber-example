Feature: Goodreads global search

  Scenario: Search books of a known author
    Given user opened the Goodreads home page
    When user searches for a known author from global search on home page
    Then search results for a known author are not empty
