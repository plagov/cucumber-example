package io.plagov.steps

import io.cucumber.guice.ScenarioScoped
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.kotlintest.matchers.numerics.shouldBeExactly

@ScenarioScoped
class SmokeSteps {

    private var initialApples = 0
    private var additionalApples = 0

    @Given("user has {int} apples")
    fun userHasApples(apples: Int) {
        initialApples = apples
    }

    @When("user gets {int} more apples")
    fun userGetsMoreApples(addedApples: Int) {
        additionalApples = addedApples
    }

    @Then("user has total of {int} apples")
    fun userHasTotalApples(totalApples: Int) {
        totalApples.shouldBeExactly(initialApples + additionalApples)
    }
}
