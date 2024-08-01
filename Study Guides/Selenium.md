# Selenium

### Introduction

Selenium is an open source project for web browser automation. This means that Selenium consists of software that can control a web browser and perform actions like any human user could - for example, navigating to a website, clicking buttons, and filling out forms. Selenium WebDriver is the core of Selenium which provides an API in many different languages for programmers to write code to manipulate the browser. We will be looking at the Java API for Selenium WebDriver (Selenium WebDriver supports multiple programming languages, not just Java)

There are a few use cases for Selenium:
* Automated scripts, for example to schedule tedious tasks like filling out a timesheet each week
* Web scraping - gathering information from website front-ends without needing back-end API integrations
* Test automation - this is the main use case, and can be deployed in DevOps pipelines to validate end to end features
* Performance testing - measuring the responsiveness of a webapp accurately and consistently

### Configuring Selenium

To get started, first include the following dependency in your `pom.xml` file (assuming you're using Maven):

```xml
<!-- this version assumes you are using JDK 8. if using a newer JDK version 4.* is easier to set up -->
<dependency>
  <groupId>org.seleniumhq.selenium</groupId>
  <artifactId>selenium-java</artifactId>
  <version>3.141.59</version>
</dependency>
```

You can find the most updated version [here](https://www.selenium.dev/maven/) as well.

Next, we will need to include the driver of the browser we want to use if using a version of Selenium older than V 4. Selenium uses this executable to interact with the browser instance.

Use one of the links below to download your particular driver, and include it in the `src/main/resources` folder:
* [Chrome](https://chromedriver.chromium.org/downloads)
* [Firefox](https://github.com/mozilla/geckodriver/releases)
* [Edge](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)

### Getting Started

Once configured, you can start using Selenium's API. Below are some of the main classes and interfaces we will need to use:
* `WebDriver` - to control the browser window itself
  * `WebDriver.findElementsBy()` method to query the DOM
* `By` - how should we query the DOM?
  * id, className, tagName, CSS selector, xpath, link text, partial link text
* `WebElement` - represents an HTML element
* `WebDriverWait` - for performing explicit waits
* `ExpectedCondition` - add dynamic waiting for certain conditions

To create a browser instance and go to google.com we can do the following:

```java
// start here if using Selenium V3 or older
File path = new File("src/main/resources/chromedriver.exe");
System.setProperty("webdriver.chrome.driver", path.getAbsolutePath());
// start here if using Selenium V4 or newer
WebDriver driver = new ChromeDriver();
driver.get("https://google.com");
driver.quit(); // make sure to always quit the driver when finished. try/finally works well for this
```
**NOTE**: different implementations of the WebDriver (such as ChromeDriver or EdgeDriver) have different Option classes that allow you to configure the settings for the browser that Selenium uses for automation. For instance, if you wanted to verify that you can navigate a website without needing cookies active you could start the browser in incognito mode to prevent accidentally using cookie data. Depending on the browser you are using the flags you will add to the option object will be different
```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--incognito");
WebDriver driver = new ChromeDriver(options);
```
Note that if you need to open a browser using a profile (common when testing in enterprise virtual machines) using your browsers option class is how you would activate the profile

Now, what if we want to find elements on the page and manipulate them?

```java
WebElement myElement = driver.findElement(By.id('someId'));
myElement.click(); // just like a human would click a button!
myElement.sendKeys("Hello, world!"); // if this is an input, we can send text to it
List<WebElement> allDivs = myElement.findElements(By.tagName("div")); // we can search within elements too!
// now we can even print out the text inside each HTML element
for (WebElement div : allDivs) {
  System.out.println(div.getText());
}
```
Selenium supports 8 Locator strategies by default:
|Locator|Description|
|-----------|-----------|
|class name|	Locates elements whose class name contains the search value (compound class names are not permitted)|
|css selector|	Locates elements matching a CSS selector|
|id|	Locates elements whose ID attribute matches the search value|
|name|	Locates elements whose NAME attribute matches the search value|
|link text|	Locates anchor elements whose visible text matches the search value|
|partial link text|	Locates anchor elements whose visible text contains the search value. If multiple elements are matching, only the first one will be selected.|
|tag name|	Locates elements whose tag name matches the search value|
|xpath|	Locates elements matching an XPath expression|

What happens if we try to query for an element, but that element does not exist on the page? Selenium will throw a `NoSuchElementException`. There is also a chance that we have a reference to an element that no longer exists. If we try to use it, we will get a `StaleElementException` as shown below.

```java
WebElement myElement = driver.findElement(By.id("someId"));
driver.get("http://someothersite.com");
myElement.click(); // StaleElementException thrown here!
```

Sometimes we will get a `NoSuchElementException` when we try to query for an element before it gets loaded on the DOM. In these cases, we would like
to **wait for the element to appear**. There are three ways of approaching this:
* Implicit waits
* Explicit waits
* Fluent waits

Implicit waits are a global configuration on the `WebDriver` object and apply every time the DOM is queried. 
```java
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().wait(Duration.ofSeconds(1)); // this tells the driver to wait up to one second for elements to be found on the page
```

Explicit waits apply individually and adjust the waiting time explicitly and dynamically at regular intervals. For example, if it usually takes 3 seconds for an element to load, you can use an explicit wait to poll at intervals of 200 milliseconds up to a maximum of 5 seconds. This is not possible with an implicit wait. You should **ALWAYS use explicit waits** (don't use Thread.sleep()). They are not only more performant but have well documented and defined behavior and work with a wide variety of conditions.

Below is an example of using an explicit wait to wait until the element is visible on the page.

```java
WebElement invalidElement = driver.findElement(By.id("someId"));
invalidElement.click(); // NoSuchElementException!
WebElement myElement = new WebDriverWait(driver, Duration.ofSeconds(5))
   .until(ExpectedConditions.elementToBeVisible(By.id("someId")));
myElement.click(); // works now!
```

There are many other "expected conditions" you can use from the `ExpectedConditions` class, which you can find in the API documentation. A few use cases are listed below:
* Waiting for an element to exist, be invisible, be clickable, to contain certain text
* Waiting for the URL or title of the page to match a pattern
* Waiting for a certain number of matched elements to appear
* Combining wait conditions with logical `.and()` and `.or()` methods


**Fluent waits** take Explicit Waits a couple steps further.
* we still have the ability to set the time we are waiting
* we still have the ability to provide some Expected Condition
* we also have: 
  * the ability to control the frequency at which we are polling the page
  * the ability to ignore any exceptions that might be thrown

```java
new FluentWait<WebDriver>(driver)
    .withTimeout(Duration.ofSeconds(10)) // how long in total to wait for the page/DOM to load
    .pollingEvery(Duration.ofSecond(2)) // during those 10 seconds - we are looking at the DOM every 2 seconds
    .ignoring(ElementNotInteractableException.class) // if any exception occurs - we ignore it and keep polling
    .until(ExpectedConditions.visibilityOf(someWebElement)); // specifies what condition to be looking for
```

### xpath
xpath is a subject interviewers like to ask questions about, so you will want to dedicate time to studying how to make use of this resource. The [xpath cheatsheet](https://devhints.io/xpath) is an excellent resource for learning how to use this tool, and it includes a link to a web page that allows for practicing using it as well.

### Page Object Model Pattern

Imagine you are trying to automate a single page application. There are multiple views that you need to interact with and many elements to query for. Navigating to pages and repeatedly querying the DOM can result in messy, unorganized code. A simple design pattern to organize your code around is called the **Page Object Model**. In this pattern, you create one class for every page you are interacting with. The fields of this class are the elements on the page you perform actions on. This allows for both *encapsulation of the state and behavior of each page* as well as *abstracting lower level code away*. Selenium has support for this pattern through the `@FindBy` annotation and the `PageFactory` class. Let's view an example below.

```java
public class CheckoutPage {
  WebDriver driver;

  @FindBy(className = "item")
  private List<WebElement> items;

  @FindBy(id = "purchase")
  private WebElement buyItemsBtn;

  public MyHomePage(WebDriver dr) {
    this.driver = dr;
    PageFactory.init(dr, this); // we need this line to tell Selenium to instantiate the fields in our class
  }

  public WebElement getFirstItemName() {
    return items.get(0).getText();
  }

  public void buyAllItems() {
    buyItemsBtn.click();
  }
}
```

The example above represents a simple checkout page of an ecommerce site. There are two elements we are about - divs with the "item" class and the button to purchase the items. Notice how we encapsulate the fields and provide public methods to manipulate those fields in semantically meaningful ways. Also, other areas of the application can now simply call `new CheckoutPage(driver).buyAllItems()` instead of worrying about querying for elements and clicking them. Therefore this pattern lets us properly use abstraction when writing automated tests.

## Actions API
Selenium WebDriver makes use of HTTP to interact with the browser: for most interactions this is fine, but sometimes you need a more true-to-the-user way of interacting with the browser (drag and drop, moving a slider via click and drag, drawing in a canvas, etc.). In these scenarios Selenium has the Actions API: using the Actions class you can chain together a collection of commands that give you more fine-tune control over the user mouse, keyboard, wheel, and pen if one is connected. These actions you chain together can then be executed immediately or saved in an Action object for future use

```java
// example taken from lecture demo
            new Actions(driver)
                    .moveToLocation(sliderTopLeft.getX(),sliderTopLeft.getY() + sliderWidthAndHeight.getHeight()/2 )
                    .clickAndHold()
                    .moveByOffset(60,0)
                    .release()
                    .perform();
```

## Screenshot functionality
Selenium has the ability to take a screenshot of the browser render pane and save the data to a File object in your Java code. This can be particularly useful when using Selenium for testing purposes to have a visual of what the webpage you are interacting with looks like when things go wrong, and is a better alternate than trying to add clunky sleep calls in your test code
```java
// TakesScreenshot is an interface that implements getScreenshotAs, so we cast the WebDriver to it in order to gain access to the method
File fileData = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// remember that you make a Path (singular) object via Paths (plural) get() method
Path screenshotDestination = Paths.get("src/main/resources/filename.jpeg"); // can choose an extension of your choice
// Use the Files (plural) class to copy the file data to your destination
Files.copy(fileData.toPath(), screenshotDestination);
```

## Selenium IDE and Selenium Grid
Selenium IDE is a plugin for browsers (Chrome and Firefox have native compatibility) that allows for recording user input and generating Selenium commands for the actions taken. It can be used to help build test cases for automated test suites quickly, and through the use of extra plugins it can be a robust automation suite directly accessed in the browser.

Selenium Grid is a tool that "allows the execution of WebDriver scripts on remote machines by routing commands sent by the client to remote browser instances." It allows for running your Selenium code on multiple machines and in multiple browsers simultaneously. This is a useful tool for testing that a web application behaves as intended across operating systems and web browsers

## JavaScript Executor
Selenium has the ability to execute JavaScript for you in the browser during automation. For testing purposes it is generally better to avoid using the executor during automated test steps (typical users will not write and execute JavaScript during their normal use of a web application.... usually) but it can be a useful resource for debugging faulty tests and aggregating data for defect reports. However, to get the most out of the tool you need to have a good understanding of how JavaScript works and how to interact with the DOM via JavaScript. It is a worthwhile tool too explore if you know JavaScript or want to log more data in your defect reports, but for general training purposes it is not necessary to use.

### Building a Test Automation Framework

With Selenium, you have a powerful tool to create automated end-to-end tests. Large projects often invest time and resources into building out a **test automation framework** - an easily extensible and maintainable framework for creating and running automated tests. The framework should make it easy to create new tests with little effort. 
Test automation frameworks have several advantages over manual testing, including:
* More accurate and consistent
* Faster
* Scalable

Often test automation frameworks have test suites that are built into the project's devops pipeline and executed on certain branches or triggered by a pull request. Having efficient automated tests will provide fast feedback to the development team and notify them if new code broke one of the tests.

Finally, there are a few different types of frameworks that testers can create:
* Data-driven framework
  * Test data (.csv files, text files, database) is separated and externalized from the test itself
  * Tests read in values from the external test data
  * Useful when same test case needs to be run with different inputs
* Keyword-driven framework
  * Both data and actions are defined outside the test
  * Actions (click, navigate, type) define the steps the test should take

# Behavior Driven Development
BDD is the practice of performing development from the perspective of the end user.
- unless other practices like Test Driven Development, BDD focuses on what the end user wants to do and how that can be achieved

Behavior Driven Development takes into account the user experience, expectations, actions, etc. If you can think of something the end user might consider with your intended application, it should be considered. This approach should affect the way you think about all the parts of your application
- Database
- API
- Who is your end user?

# End to End Testing
A common practice in BDD is End to End testing: this is the process of simulating an end user interacting with the system you are building in an automated fashion.
- log in to a service
- create an account
- adding an item to a shopping cart
- removing data from a list on the website
- etc.

## E2E testing: organization of User Stories
When organizing your E2E tests, User Stories are used to organize and determine what needs to happen to represent the end user interacting with the service. For the purposes of training we will make use of the following syntax to guide our User Story creation process:
- As a
    - customer
    - employee
    - puppy
    - etc.
    - new user
    - potential user
    - long time user
- I want 
    - to log in
    - to log out
    - to add a specific item to my shopping cart
    - to scratch the furniture
    - to create an account with the service
    - etc.
        - note that these "I want"s are specific
- So that
    - I can order my coffee
    - I can save it for ordering later
    - I can get my owner to pay attention to me
    - etc.

When creating your User Stories keep in mind that you will more likely than not need to change or update the document, so make sure whatever tool you use to save your User Story information is flexible and allows for easy changes.

## E2E Testing: Creating Acceptance Criteria
Once you have your User Stories (or at least the initial User Stories, since there may be updates) you need to have a way to determine whether a User Story is completed successfully or not with your automated steps. One way of doing this is through the use of Acceptance Criteria. Acceptance Criteria is a collection of actions the end user takes in order to complete the User Story. A common way of framing Acceptance Criteria is to use Gherkin Syntax. By using Gherkin Syntax we will eventually be able to map the actions listed in our Acceptance Criteria to code execution in order to determine whether a User Story has been completed or not. Some of the key words we will focus on:
- Feature
    - a high level description of a User Story or group of User Stories
- Scenario
    - an explicit or direct description of a User Story being implemented
        - this can be a positive or negative scenario

Scenarios (and scenario outlines) can use the following terms to organize their Acceptance Criteria steps. Keep in mind these key words are purely used to indicate new steps to take, which means you can not have duplicate implementations (having a given and when statement with the same text would cause an error). Also, Cucumber does not perform any special actions based on your step keyword used: the expected use case of these keywords is purely for human readability when looking through the feature files and reading test reports.
- Given
    - A starting point and/or precondition for executing the Acceptance Criteria
- When
    - An action that must be taken in order to complete the Acceptance Criteria
- Then 
    - the intended outcome of completing the Acceptance Criteria
    - "Then" statements should be written as "normative" statements
        - example: Then the user "should" be redirected to the puppy homepage
- And/But
    - either can be substituted for a Given, When, or Then when you have multiple Given, When, or Then statements in a row. Can be used to make reading the steps a little less choppy
- \*
    - a star icon can be used in place of any of the step key words

A few other keywords to keep in mind to make organization and automation easier:
- Scenario Outline
    - this keyword is used in conjunction with the "Examples" keyword to make parameterized Scenarios
- Example
    - this keyword is used to indicate that the following information is parameterized information for a Scenario Outline
- Background
    - Background can be used in a feature any time you have a shared starting condition between your scenarios (one or more shared "Given" statement)



# Test Automation Example

### User Stories
When working on an application User Stories will often be created to help define the following:
- who is using the application
- what does the user want to do with the application
- why does the user want to perform said action on the application?
- the ```User-Story-Acceptance-Criteria-Example.xlsx``` document has simple examples of how to set up user stories

These user stories help to create concrete goals for what you are trying to achieve with your application

### Acceptance Criteria
Once the User Stories are created you can write Acceptance Criteria to lay out the specific actions a User will take in order to complete the User Story. Note that these steps can be for both positive and negative scenarios, depending on the User story.

Once your Acceptance Criteria is written you can move on to creating files and codes to perform automated End to End testing. This example will use Cucumber, Junit, and Selenium to accomplish automated testing.

### Cucumber
Cucumber is a testing framework that allows you to easily create End to End tests that utilize gherkin syntax. This framework can take your acceptance criteria (found in one or more feature files) and link them to test steps you create in test classes (typically placed inside of a steps package). Once you have your steps defined (not implemented) you can then write the code to make sure your acceptance criteria is being fulfilled. What Cucumber does specifically is link your acceptance criteria with the step implementations you create in your test classes.

An example feature file that can be used to generate code steps
```feature
Feature: As a user I should be able to view Wikipedia pages in different languages
  Scenario: As an English user I should be able to view Wikipedia in English
    Given I am on the Wikipedia home page
    When  I click the English link
    Then  I should be on the English home page
  Scenario: As an Spanish user I should be able to view Wikipedia in Spanish
    Given I am on the Wikipedia home page
    When  I click the Spanish link
    Then  I should be on the Spanish home page
  Scenario: As an Italian user I should be able to view Wikipedia in Italian
    Given I am on the Wikipedia home page
    When  I click the Italian link
    Then  I should be on the Italian home page
```
To generate methods associated with your steps you have a few options:
- if you are using a cucumber/gherkin plugin in your IDE you can execute the feature file directly to have Cucumber generate the steps for you
- you can execute your Test Runner class (assuming you told it where the feature files are located) and have Cucumber generate the steps for you
- you can execute the the "test" or "verify" maven commands to trigger your tests and have Cucumber generate the steps for you
    - To make Cucumber generate your code steps via maven from the terminal your working directory for the terminal needs to be the root folder of the application, or the command will not work properly.
```java
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WikiLinksSteps {

    @Given("I am on the Wikipedia home page")
    public void i_am_on_the_wikipedia_home_page() {
        // you write code here to simulate a user's actions
    }
    @When("I click the English link")
    public void i_click_the_english_link() {
        // you write code here to simulate a user's actions
    }
    @Then("I should be on the English home page")
    public void i_should_be_on_the_english_home_page() {
        // you write code here to simulate a user's actions
    }

    @When("I click the Spanish link")
    public void i_click_the_spanish_link() {
        // you write code here to simulate a user's actions
    }
    @Then("I should be on the Spanish home page")
    public void i_should_be_on_the_spanish_home_page() {
        // you write code here to simulate a user's actions
    }

    @When("I click the Italian link")
    public void i_click_the_italian_link() {
        // you write code here to simulate a user's actions
    }
    @Then("I should be on the Italian home page")
    public void i_should_be_on_the_italian_home_page() {
        // you write code here to simulate a user's actions
    }

}
```
Cucumber takes the acceptance criteria above and links it to the steps defined above.

In order to centralize your control over your End to End testing a test runner class can be used. This class is where you will initialize and destroy all shared resources needed for your tests. 

```java
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

@RunWith(Cucumber.class) // this sets Cucumber as the framework to run our tests
@CucumberOptions(
        /*
            features: this determines which feature file/s will be used
            glue: this tells Cucumber where the step implementations are. Direct it to a package
         */
        features = "classpath:features",
        glue = "com/revature/steps"
)
public class TestRunner {

    /*
        The WebDriver field below is necessary for interacting with webpages: it has nothing to do inherently with Cucumber, but you will need it to make use of Selenium: see notes below for Selenium information
    */
    public static WebDriver driver;


    @BeforeClass
    public static void setup(){
        // use the three lines below to set your driver: see Selenium notes below for more information
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); // this tells Java what kind of driver you are using, and where it is located
        driver = new ChromeDriver(); // this initializes the value of the driver field you created above
    }

    // don't forget to quit your driver when you are done
    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}

```

Note in the above: All Cucumber has done is link the feature file steps with the Java code steps by using the TestRunner class: you as the tester must provide the means of actually implementing the steps. I skipped ahead a bit and added the Driver field to the TestRunner class already: Selenium will make use of it to interact with the webpage.

### Selenium
Selenium is a browser automation tool: that's it (see their website). That being said, Selenium is the perfect tool to pair with cucumber to create End to End tests for web applications, since Selenium can fill in for a real person interacting with your web pages. In the above examples we linked our acceptance criteria with our code steps, but we had no means of simulating a user on Wikipedia. This is where Selenium comes in: we can use it to simulate the actions a user would take browsing the web. Since the driver has already been set up in the TestRunner we can implement our steps via Selenium in the WikiLinksSteps class
```java
package com.revature.steps;

import com.revature.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.Assert;

public class WikiLinksSteps {

    @Given("I am on the Wikipedia home page")
    public void i_am_on_the_wikipedia_home_page() {
        // the get method is used to simulate the user typing a url into the browser
        TestRunner.driver.get("https://www.wikipedia.org/");
    }
    @When("I click the English link")
    public void i_click_the_english_link() {
        // the findElement method is used to locate an element on the DOM. You first use the By class to determine the css selector you are using, and the second argument is the selector value
        WebElement englishLink = TestRunner.driver.findElement(By.id,"js-link-box-en");
        // the click method is used to simulate the user clicking on a web element
        englishLink.click();
        
    }
    @Then("I should be on the English home page")
    public void i_should_be_on_the_english_home_page() {
        // the getTitle method is used to retrieve the title of the webpage you are on
        String title = TestRunner.driver.getTitle();
        // here we are using the Assert class from Junit to make sure we are on the correct page, else the step will fail because the assertEquals method will throw an exception
        Assert.assertEquals("Wikipedia, the free encyclopedia", title);
    }

    @When("I click the Spanish link")
    public void i_click_the_spanish_link() {
        // note that we can choose different kinds of selectors other than just an id
        WebElement spanishLink = TestRunner.driver.findElement(By.cssSelector,"div[lang='es']");
        spanishLink.click();
    }
    @Then("I should be on the Spanish home page")
    public void i_should_be_on_the_spanish_home_page() {
        Assert.assertEquals("Wikipedia, la enciclopedia libre", TestRunner.driver.getTitle());

    }

    @When("I click the Italian link")
    public void i_click_the_italian_link() {
        // note I can directly call click() on the result of findElement()
        TestRunner.driver.findElement(By.xpath,"/html/body/div[2]/div[8]/a").click();
    }
    @Then("I should be on the Italian home page")
    public void i_should_be_on_the_italian_home_page() {
        Assert.assertEquals("Wikipedia, l'enciclopedia libera", TestRunner.driver.getTitle());
    }

}
```
Notice that Selenium itself is not doing any testing: it is simply simulating the actions of a user. Cucumber is checking to see if an exception is thrown in any of the steps, and if they are, then it marks the step as failing. 

This code is fine, but for larger tests it can be a hassle having to write all of the code inside of the steps themselves: this also makes any potential refactors to the test more difficult, because you would need to comb through the steps to find all the places where any affected code is located and then manually change each individual place. To avoid this problem, and to avoid general boilerplate code, you can create a Page Object Model for each webpage you simulate interacting with, which will localize all the web elements you need to interact with, making it both easier to interact with elements, and also easier to refactor your code when necessary.
```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHome {

    private WebDriver driver;

    public WikiHome(WebDriver driver){
        // a driver is necessary for finding the web elements you need to interact with. You can initialize this field in the TestRunner
        this.driver = driver;
        // the page factory abstracts away the logic for interacting with web elements: you use the @FindBy annotation to indicate how the PageFactory can find the elements you need on a web page
        PageFactory.initElements(driver,this);
    }

    // we use FindBy to tell the page factory what selector and associated values to use to find the element we want
    @FindBy(id = "js-link-box-en")
    public WebElement english;

    @FindBy(css = "div[lang='es']")
    public WebElement spanish;

    @FindBy(xpath = "/html/body/div[2]/div[8]/a")
    public WebElement italian;

}
```
With the page object model created you can add it to the TestRunner class to make use of it in your step implementation
```java
import com.revature.poms.WikiHome;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com/revature/steps",
)
public class TestRunner {

    public static WebDriver driver;
    public static WikiHome wikiHome;


    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        // don't forget to pass your driver into your poms
        wikiHome = new WikiHome(driver);
    }

    // don't forget to quit your driver when you are done
    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}
```
Now that your page object model is initialized in the TestRunner you can use it in your steps
```java
package com.revature.steps;

import com.revature.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WikiLinksSteps {

    @Given("I am on the Wikipedia home page")
    public void i_am_on_the_wikipedia_home_page() {
        TestRunner.driver.get("https://www.wikipedia.org/");
    }
    @When("I click the English link")
    public void i_click_the_english_link() {
        TestRunner.wikiHome.english.click();
    }
    @Then("I should be on the English home page")
    public void i_should_be_on_the_english_home_page() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Wikipedia, the free encyclopedia", title);
    }

    @When("I click the Spanish link")
    public void i_click_the_spanish_link() {
        TestRunner.wikiHome.spanish.click();
    }
    @Then("I should be on the Spanish home page")
    public void i_should_be_on_the_spanish_home_page() {
        Assert.assertEquals("Wikipedia, la enciclopedia libre", TestRunner.driver.getTitle());
    }
    @When("I click the Italian link")
    public void i_click_the_italian_link() {
        TestRunner.wikiHome.italian.click();
    }
    @Then("I should be on the Italian home page")
    public void i_should_be_on_the_italian_home_page() {
        Assert.assertEquals("Wikipedia, l'enciclopedia libera", TestRunner.driver.getTitle());
    }
}
```
Now any potential changes to your webpage can be handled in the pom (like an id being changed, an element being replaced with another, etc) and your steps can remain the same.
### Selenium/Cucumber wrap-up
- Cucumber
    - a testing framework that can turn your Acceptance Criteria into executable steps
    - Alone it does NOT provide the means of interacting with your web pages
- Selenium
    - a web browser automation tool
    - you can simulate user actions on the web using Selenium, but it does not provide any inherent testing features
    - [This is the documentation for Selenium: it contains more specific methods you can use to automate user actions](https://www.selenium.dev/documentation/overview/)

- Cucumber and Selenium together
    - You use Cucumber to determine the steps a user would take for your E2E tests
    - You use Selenium to automate the actions a user would do on your webpages 
- Page Object Model
    - a design pattern used to reduce boilerplate code and simplify the refactoring of your E2E tests.
    - you write the code to locate your elements in the pom, then reference them via a pom object in the steps
        - you could even go as far as to create methods which perform the desired action upon the element, and then call the method in your step implementation
- Junit
    - a test framework that integrates well with Cucumber
    - we make use of the Junit BeforeClass and AfterClass decorators to set up and tear down our E2E test