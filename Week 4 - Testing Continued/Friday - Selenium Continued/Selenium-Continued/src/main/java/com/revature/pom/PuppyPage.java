package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PuppyPage {

    private WebDriver driver;

    public PuppyPage(WebDriver driver){
        this.driver = driver;
        // keep this in your pom even if you don't have any elements to init initially
        PageFactory.initElements(driver, this);
    }

    public boolean verifyWeAreOnThePuppyPage(){
        String titleText = driver.getTitle();
        return "Puppy - Wikipedia".equals(titleText);
    }

}
