package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DelayedPage {

    private WebDriver driver;

    /*
        If you know you have a situation where you need Selenium to wait for a specific
        scenario to finish, resource to load, anything that is separate from just waiting
        on slow internet, it is better to create an explicit wait object to handle that
        scenario instead of adjusting your implicit wait to accommodate the long wait time.
        If the wait is only going to be used for a single check it make sense to name it based
        off the thing you are waiting for, but if you have many different waits you need to
        accomodate you can make a generic "wait" variable and use it for all your waiting needs
     */
    private WebDriverWait waitForDelayedMessage;

    @FindBy(id = "message")
    private WebElement message;

    public DelayedPage(WebDriver driver){
        this.driver = driver;
        /*
            When creating explicit waits using the WebDriverWait class we need to provide the driver that is being
            paused and the maximum time to pause execution before Selenium continues operations
         */
        this.waitForDelayedMessage = new WebDriverWait(driver, Duration.ofSeconds(4));
        PageFactory.initElements(driver, this);
    }

    public void openDelayedPage(){
        /*
            In older versions of Selenium you had to provide the "File://" protocol to Selenium when opening a local
            file (similar to providing "https://" or "http://" when going to a web page.
         */
        driver.get("C:\\Users\\EricSuminski\\Desktop\\240701-JWA-Gen-AI\\Week 4 - Testing Continued\\Thursday - Selenium\\Selenium-Continued\\src\\main\\resources\\delayed-page.html");
    }

    public void printMessage(){
        /*
            Because the element we need to get the text from does not exist until after 3 seconds have passed, Selenium
            will throw an ElementNotFound exception if we don't tell it explicitly to wait for the element to be created.
            By using our wait object we can tell Selenium to pause execution until, in our case, the element we want
            to grab the text from is present on the web page.
         */
        waitForDelayedMessage.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        System.out.println(message.getText());
    }

}
