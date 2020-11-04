package io.plagov.steps

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.Selenide.title
import com.codeborne.selenide.WebDriverRunner
import io.cucumber.java.en.Given
import io.kotlintest.shouldBe
import org.openqa.selenium.chrome.ChromeOptions
import org.testcontainers.containers.BrowserWebDriverContainer

class BrowserSteps {

    private val browserImage = "selenium/standalone-chrome:85.0"
    private val container: BrowserWebDriverContainer<*> = BrowserWebDriverContainer<Nothing>(browserImage).withCapabilities(ChromeOptions())

    @Given("start browser")
    fun startBrowser() {
        startBrowserContainer()
        open("/")
        title() shouldBe "Google"
        container.getDockerImageName() shouldBe browserImage
    }

    private fun startBrowserContainer() {
        container.start()
        configureSelenide()
    }

    private fun configureSelenide() {
        WebDriverRunner.setWebDriver(container.getWebDriver())
        Configuration.baseUrl = "https://www.google.com"
        Configuration.browserSize = "1920x1080"
    }
}
