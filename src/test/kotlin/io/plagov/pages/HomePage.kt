package io.plagov.pages

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.title
import io.kotlintest.shouldBe

class HomePage {

  fun load(): HomePage {
    searchBox().shouldBe(visible)
    newAccountBox().shouldBe(visible)
    title().shouldBe("Goodreads | Meet your next favorite book")
    return this
  }

  fun searchInGlobalSearch(textToSearch: String): SearchResultsPage {
    siteSearchField().setValue(textToSearch).pressEnter()
    return SearchResultsPage().load()
  }

  private fun searchBox() = element("#searchBox")
  private fun siteSearchField() = element("#sitesearch_field")
  private fun newAccountBox() = element("#newAccountBox")
}
