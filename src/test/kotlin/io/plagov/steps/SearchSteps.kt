package io.plagov.steps

import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.kotlintest.matchers.collections.shouldNotBeEmpty
import io.kotlintest.matchers.withClue
import io.plagov.pages.SearchResultsPage
import io.plagov.pages.SignInModal

class SearchSteps {

  private val searchResultsPage = SearchResultsPage()
  private val signInModal = SignInModal()

  @Then("search results for a known author are not empty")
  fun searchResultsForKnownAuthorAreNotEmpty() {
    withClue("Search results for a known author should not be empty") {
      searchResultsPage.searchResults().shouldNotBeEmpty()
    }
  }

  @When("user opens a random book from search results")
  fun userOpensRandomBookFromSearchResults() {
    signInModal.dismissModal()
    searchResultsPage.searchResults().random().openBook()
  }

}
