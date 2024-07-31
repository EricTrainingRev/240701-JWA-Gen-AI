package com.revature.step;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchBarSteps {

    @Given("The User is on the Wikipedia homepage")
    public void the_User_is_on_the_Wikipedia_homepage() {
        TestRunner.wikiHome.goToWikiHome();
    }

    @When("The User enters puppy in the search bar")
    public void the_User_enters_puppy_in_the_search_bar() {
        TestRunner.wikiHome.sendPuppyToSearchInput();
    }

    @When("The User clicks the search button")
    public void the_User_clicks_the_search_button() {
        TestRunner.wikiHome.clickSearchButton();
    }

    @Then("The User should be redirected to the Puppy Wikipedia article")
    public void the_User_should_be_redirected_to_the_Puppy_Wikipedia_article() {
        /*
            Junit provides a class called Assert that can be used to verify that our User Story
            (the scenario being executed) is being achieved as expected. You can provide a custom
            fail message if you want, but often the built in exception report will be sufficient
         */
        Assert.assertEquals("Puppy - Wikipedia", TestRunner.driver.getTitle());
    }

}
