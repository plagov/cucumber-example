package io.plagov.steps

import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import io.cucumber.java.en.Then
import io.plagov.pages.SearchResultsPage

class SearchSteps {

  private val searchResultsPage = SearchResultsPage()

  @Then("search results for a known author are not empty")
  fun searchResultsForKnownAuthorAreNotEmpty() {
    searchResultsPage.searchResults().shouldHave(sizeGreaterThan(0)
      .because("Search results for a known author should not be empty"))
  }
}
