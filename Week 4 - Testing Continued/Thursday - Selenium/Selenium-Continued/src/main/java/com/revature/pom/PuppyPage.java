package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PuppyPage {

    @FindBy(tagName = "title")
    private WebElement title;

    private WebDriver driver;

    public PuppyPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyWeAreOnThePuppyPage(){
        String titleText = title.getText();
        return "Puppy - Wikipedia".equals(titleText);
    }

}
