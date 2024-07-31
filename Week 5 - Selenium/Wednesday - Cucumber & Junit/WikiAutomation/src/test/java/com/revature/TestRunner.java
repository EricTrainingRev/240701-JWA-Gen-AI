package com.revature;

import com.revature.pom.WikiHome;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
    a TestRunner class is used to facilitate the setup and teardown of
    your automated tests. It is particularly useful when using Cucumber
    and Junit for automated browser testing because we can use the
    TestRunner class to initialize our driver, poms, and any other shared
    resources needed for our End-to-End testing
 */
@RunWith(Cucumber.class)// this tells Junit that Cucumber will be providing test step information
@CucumberOptions(
        /*
            The features option tells Cucumber where to find our feature files. You can put the
            path to individual files, or you can provide one or more directories that contain feature
            files. The option below tells Cucumber that there is a directory called "features" in
            the classpath (resources directories are added to the classpath in maven built applications)
            so the features information below tells Cucumber it can find our feature files in the
            given directory found somewhere in the classpath

            example of multiple feature file locations:
            features = {"file/one.feature","another/file/here.feature", etc.}
         */
        features = "classpath:features",
        /*
            The glue option is used to tell Cucumber where the associated code
            for the acceptance criteria is located. Similar to the features option,
            this can be a reference to on or more packages that have your code, or
            it can be to specific classes
         */
        glue = "com.revature.step",
        /*
            the plugin option lets you configure other generic settings for
            your tests. The options below make the terminal readout of the
            test results easier to understand (pretty) and the second tells
            Cucumber to generate a nice html test report at the given location
            (html:src/test/resources/reports/html-report.html)
         */
        plugin = {
                "pretty",
                "html:src/test/resources/reports/html-report.html",
                "json:src/test/resources/reports/json-report.json"
        }
)
public class TestRunner {
    /*
        The resources we initialize in this TestRunner class are going
        to be static so we can access them directly from the class
        itself.
     */
    public static WebDriver driver;

    public static WebDriverWait wait;

    public static WikiHome wikiHome;

    /*
        In order to make sure that the objects we need are available
        for testing we can use a setup method to initialize all
        of our classes. We can make sure this method runs automatically by
        annotating the method with @BeforeClass (provided by Junit). This tells
        Junit to execute the setup method before any other tests are run
     */
    @BeforeClass
    public static void setup(){
        // set up the driver
        driver = new ChromeDriver();
        // set up your implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        // initialize any page object models
        wikiHome = new WikiHome(driver);
        // initialize a wait object for any situations you need to explicitly wait for something
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}
