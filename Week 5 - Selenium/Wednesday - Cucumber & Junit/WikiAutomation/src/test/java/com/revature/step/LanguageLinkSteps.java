package com.revature.step;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LanguageLinkSteps {

    /*
        Anytime you are working with Examples tables you can either
        provide a hard coded step implementation
        (The User clicks js-link-box-en link) or you can paramaterize
        the step in your code by wrapping the type of data in curly
        brackets (see below)

        If you go the parameterized route then you can call the parameter
        provided to the step method whatever you want, but the type of
        the parameter must match the type in your acceptance criteria
        statement
     */
    @When("The User clicks {string} link")
    public void the_User_clicks_js_link_box_en_link(String linkId) {
        /*
            For each run of the Scenario outline that uses this step the same method will
            be called, but the linkId information will change, which should lead to different
            outcomes in the Then step
         */
        TestRunner.wikiHome.clickLanguageLink(linkId);
    }

    @Then("The User should be redirected to {string}")
    public void the_User_should_be_redirected_to_Wikipedia_la_enciclopedia_libre(String title) {
        /*
            For each run of he SCenario outline that uses this step the same method will be called,
            but the title information will change, and the appropriate check should be made
         */
        Assert.assertEquals(title, TestRunner.driver.getTitle());
    }

}
