package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// This is the pom (page object model) for the Wikipedia homepage, our scenarios will all
// make use of this pom
public class WikiHome {

    private WebDriver driver;

    private String url = "https://www.wikipedia.org/";

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(tagName = "button")
    private WebElement searchButton;

    public WikiHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToWikiHome(){
        driver.get(url);
    }

    public void sendPuppyToSearchInput(){
        searchInput.sendKeys("puppy");
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    /*
        In this example we find the link by providing an id to the method, and then the driver
        finds the element when the method is called, but you could instead make a field to
        represent each of the links, and then based on the string value provided call the click
        method on the appropriate link
     */
    public void clickLanguageLink(String id){
        WebElement link =  driver.findElement(By.id(id));
        link.click();
    }

}
