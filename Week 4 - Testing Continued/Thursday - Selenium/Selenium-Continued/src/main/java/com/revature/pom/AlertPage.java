package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage {

    WebDriver driver;

    @FindBy(xpath = "/html/body/button")
    WebElement button;

    public AlertPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAlertPage(){
        driver.get("C:\\Users\\EricSuminski\\Desktop\\240701-JWA-Gen-AI\\Week 4 - Testing Continued\\Thursday - Selenium\\Selenium-Continued\\src\\main\\resources\\alert-page.html");
    }

    public void clickButton(){
        button.click();
    }

    public void handleAlert(){
        /*
            When managing alerts you have a few options
            - accept(): this clicks the "ok" or "Accept" button, depending on what kind of alert you are working with
            - dismiss(): this clicks the "decline" or "cancel" button if one is present, otherwise just closes the alert
            - getText(): will return text content of the alert as a string
            - sendText(): this can be used to send text if the alert accepts input
         */
        driver.switchTo().alert().dismiss();
        // if we don't handle the alert first then the button text can't be accessed
        System.out.println(button.getText());
    }

}
