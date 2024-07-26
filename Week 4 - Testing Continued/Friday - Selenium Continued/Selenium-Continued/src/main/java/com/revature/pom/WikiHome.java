package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
    This class is going to be our page object model that represents the landing page
    of Wikipedia. We can use this class to store all the relevant information about the
    web page, save any actions we need to take on the page as methods of the class
    and when we actually run our application we simply create an object of this class
    to gain access to all the properties
 */
public class WikiHome {

    private WebDriver driver;

    private final String wikiUrl = "https://www.wikipedia.org/";

    /*
        By using the FindBy annotation we can tell the PageFactory how to locate the
        element we need and what field of the class to assign the found element to
        when an object is made of the class
     */
    @FindBy(id = "searchInput")
    private WebElement searchBar;

    /*
        A common way to find elements via Selenium or any other software that interacts
        with web elements is to use Xpath. Xpath is to html elements what a file path
        is to directories and files: it is the path to reach your element from the
        outermost HTML tags to the actual tag that represents your element.

        NOTE: Xpath can do A LOT more than just find an element by its full html path, but
        that will be explored later
     */
    @FindBy(xpath = "/html/body/main/div[2]/form/fieldset/button")
    private WebElement searchButton;

    public WikiHome(WebDriver driver){
        // we assign the pom a driver to interact with the web page
        this.driver = driver;
        /*
            We can use the PageFactory to abstract away the process of initializing
            web elements in our class. To make this work we have to provide the PageFactory
            two arguments: a driver to interact with the browser, and a location where
            the elements found are going to be saved. Four our purposes we will use the
            driver we pass to the constructor and tell the PageFactory to point towards the
            object being created and send the found element data here
         */
        PageFactory.initElements(driver,this);
    }

    public void goToWikipediaHome(){
        driver.get(wikiUrl);
    }

    public void enterTextIntoSearchBar(String input){
        searchBar.sendKeys(input);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

}
