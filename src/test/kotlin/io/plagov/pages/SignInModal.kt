package io.plagov.pages

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element

class SignInModal {

  private fun container() = element(".modal--centered")

  fun dismissModal() {
    container().shouldBe(visible).find(".modal__close").click()
    container().shouldNotBe(visible)
  }

}
