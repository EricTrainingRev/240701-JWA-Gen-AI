package com.revature;

//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.time.Duration;

public class Main {

    /*
        If we are setting up our web driver manually we need a Java File object
        that tells our code where the driver is located so that Selenium can interface
        with it. chosenDriver will be the object we use
     */
    static File chosenDriver;

    public static void main(String[] args) {
        // Compiler will complain if we don't initialize the driver type
        WebDriver driver = null;
        usingMavenDependency(driver);

    }


    /*
        Before version 4 of Selenium you had to provide a path to the webdriver executable
        you wanted to use. This required setting a System property and providing a path
        to the driver executable

        This is a common need when a project is created using JDK 8
     */
    public static void manualSetup(WebDriver driver){
        // Step 1: set the path to the driver you are using in your File object
        chosenDriver = new File("src/main/resources/chromedriver.exe");
        // Step 2: assign a System property for your chosen driver
        System.setProperty("webdriver.chrome.driver",chosenDriver.getAbsolutePath());
        try{
            // Step 3: instantiate your Driver object
            /*
                Since I am using Chrome I instantiate a ChromeDriver object, but Selenium
                supports most modern browsers
             */
            driver = new ChromeDriver();
            // Step 4: do things automatically in the browser, like open Wikipedia!
            driver.get("https://www.wikipedia.org/");
        } finally {
            /*
                Use a finally block to make your driver quit: this will close any browsers
                opened by the driver and release the system resources the object was utilizing
             */
            if (driver != null){
                driver.quit();
            }
        }
    }

    /*
        Someone created a manager dependency for webdrivers that could be used
        to auto-decide what version of a driver to use based on the browser
        you are using for automation purposes
     */
    public static void automaticDriverManagement(WebDriver driver){
        WebDriverManager.chromedriver().setup();
        try{
            driver = new ChromeDriver();
            driver.get("https://www.wikipedia.org/");
        } finally {
            if (driver != null){
                driver.quit();
            }
        }
    }

    /*
        In Selenium version 4 the need to set the driver path information has been
        removed so you can simply create your driver and start using it

        Use this setup for your own work, but be aware of how to set up your project
        with the other options
     */
    public static void usingMavenDependency(WebDriver driver){
        try{
            driver = new ChromeDriver();
            /*
                A good practice is to determine an implicit wait value: this tells
                Selenium how long to wait for an element it is meant to interact with
                to be viewable/accessible before throwing an ElementNotFound Exception.
                This can help (for testing purposes) to avoid flakey tests (tests that
                inconsistently pass and then fail) due to things like a poor internet
                connection.

                That being said, don't set this value too high, otherwise you will miss
                other problems in your application such as poor performance or performance
                bottlenecks in your application that having a low implicit wait time
                would reveal
             */
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            /*
                Anytime you want to open a webpage in the browser you can use the get
                method. This works for going to web pages, but it also works for opening
                files from the local system.
             */
            driver.get("https://www.wikipedia.org/");
            /*
                If we want to look up an article on Wikipedia, say on puppies, we need
                to be able to tell Selenium where the search bar is, and what text to
                send to the search bar

                The first step is to gain access to the search input: we can do this
                by using the driver's findElement method. When we call findElement we
                have to provide a selector using the By class. For the example below
                the chosen selector is the id attribute: this means we want selenium
                to find the element that has the given id value and return a reference
                to it as a WebElement object.

                After we have access to the element we can use the sendKeys method to
                tell Selenium what text we want to enter into the search bar

                After we send our text to the search input we need to find the button
                and click on it

                Once we have accomplished all these actions then we should be on the
                wiki page that talks about puppies!
             */
            WebElement searchBar = driver.findElement(By.id("searchInput"));
            searchBar.sendKeys("puppy");

            WebElement searchButton = driver.findElement(By.tagName("button"));
            searchButton.click();
        } finally {
            if (driver != null){
                driver.quit();
            }
        }
    }







}
