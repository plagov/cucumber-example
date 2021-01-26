package io.plagov.steps

import io.cucumber.java.en.Then
import io.kotlintest.matchers.collections.shouldNotBeEmpty
import io.kotlintest.matchers.withClue
import io.plagov.pages.SearchResultsPage

class SearchSteps {

  private val searchResultsPage = SearchResultsPage()

  @Then("search results for a known author are not empty")
  fun searchResultsForKnownAuthorAreNotEmpty() {
    withClue("Search results for a known author should not be empty") {
      searchResultsPage.searchResults().shouldNotBeEmpty()
    }
  }

}
