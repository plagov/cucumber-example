package io.plagov.pages

import com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual
import com.codeborne.selenide.Condition.empty
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements

class BookPage {

  fun load(): BookPage {
    bookTitle().shouldBe(visible).shouldNotBe(empty)
    bookAuthors().shouldHave(sizeGreaterThanOrEqual(1))
    return this
  }

  private fun bookTitle() = element("#bookTitle")
  fun bookAuthors() = elements("#bookAuthors .authorName")
}
