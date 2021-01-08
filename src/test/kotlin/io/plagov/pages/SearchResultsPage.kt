package io.plagov.pages

import com.codeborne.selenide.Condition.exactTextCaseSensitive
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements

class SearchResultsPage {

  fun load(): SearchResultsPage {
    header().shouldBe(visible).shouldHave(exactTextCaseSensitive("Search"))
    searchQuery().shouldBe(visible)
    mediumTabs().shouldBe(visible)
    return this
  }

  fun searchResults() = elements(".leftContainer table tbody tr")

  private fun header() = element("h1")
  private fun searchQuery() = element("#search_query_main")
  private fun mediumTabs() = element(".mediumTabs")

}
