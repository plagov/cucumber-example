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
    coverImage().shouldBe(visible)
    description().shouldBe(visible).shouldNotBe(empty)
    bookAuthorProfile().shouldBe(visible)
    return this
  }

  fun bookAuthors() = elements("#bookAuthors .authorName")

  private fun bookTitle() = element("#bookTitle")
  private fun coverImage() = element("#coverImage")
  private fun description() = element("#description")

  private fun bookAuthorProfile() = element(".bookAuthorProfile")

  fun bookAuthorProfileName() = bookAuthorProfile().find(".bookAuthorProfile__name")
}
