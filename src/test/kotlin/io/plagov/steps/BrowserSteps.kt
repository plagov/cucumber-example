package io.plagov.steps

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.WebDriverRunner
import io.cucumber.java.en.Given
import io.kotlintest.shouldBe
import org.openqa.selenium.chrome.ChromeOptions
import org.testcontainers.containers.BrowserWebDriverContainer

class BrowserSteps {

    private val browserImage = "selenium/standalone-chrome-debug:3.141.59"
    private val container: BrowserWebDriverContainer<*> = BrowserWebDriverContainer<Nothing>(browserImage).withCapabilities(ChromeOptions())

    @Given("start browser")
    fun startBrowser() {
        startBrowserContainer()
        open("/")
        container.dockerImageName shouldBe browserImage
    }

    private fun startBrowserContainer() {
        container.start()
        configureSelenide()
    }

    private fun configureSelenide() {
        WebDriverRunner.setWebDriver(container.webDriver)
        Configuration.baseUrl = "https://www.goodreads.com/"
        Configuration.browserSize = "1920x1080"
    }
}
