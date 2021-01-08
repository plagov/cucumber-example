package io.plagov.steps

import com.google.inject.Inject
import io.cucumber.java.en.Given
import io.cucumber.java.en.When
import io.plagov.pages.HomePage

class HomepageSteps @Inject constructor(private val browserSteps: BrowserSteps) {

  private val homePage = HomePage()

  companion object {
    const val KNOWN_AUTHOR = "Ernest Hemingway"
  }

  @Given("user opened the Goodreads home page")
  fun userOpenedTheGoodreadsHomePage() {
    browserSteps.startBrowser()
    homePage.load()
  }

  @When("user searches for a known author from global search on home page")
  fun userSearchesForKnownAuthorFromGlobalSearchOnHomePage() {
    homePage.searchInGlobalSearch(KNOWN_AUTHOR)
  }
}
