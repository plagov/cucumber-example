package io.plagov.steps

import com.codeborne.selenide.CollectionCondition.itemWithText
import com.codeborne.selenide.Condition
import io.cucumber.java.en.Then
import io.plagov.pages.BookPage

class BookSteps {

  private val bookPage = BookPage()

  @Then("opened book is by a known author")
  fun openedBookIsByKnownAuthor() {
    bookPage.load().bookAuthors().shouldHave(itemWithText(HomepageSteps.KNOWN_AUTHOR))
    bookPage.bookAuthorProfileName().shouldHave(Condition.exactTextCaseSensitive(HomepageSteps.KNOWN_AUTHOR))
  }
}
