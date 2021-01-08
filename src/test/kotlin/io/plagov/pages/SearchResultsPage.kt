package io.plagov.pages

import com.codeborne.selenide.Condition.cssClass
import com.codeborne.selenide.Condition.exactTextCaseSensitive
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement

class SearchResultsPage {

  fun load(): SearchResultsPage {
    header().shouldBe(visible).shouldHave(exactTextCaseSensitive("Search"))
    searchQuery().shouldBe(visible)
    mediumTabs().shouldBe(visible)
    return this
  }

  fun searchResults() = elements(".leftContainer table tbody tr")
    .map { SearchResultItem(it) }

  private fun header() = element("h1")
  private fun searchQuery() = element("#search_query_main")
  private fun mediumTabs() = element(".mediumTabs")
  private fun booksLink() = element("#booksLink")

  inner class SearchResultItem(private val container: SelenideElement) {
    fun openBook(): BookPage {
      booksLink().shouldHave(cssClass("selectedTab"))
      container.find(".bookTitle").click()
      return BookPage().load()
    }
  }

}
