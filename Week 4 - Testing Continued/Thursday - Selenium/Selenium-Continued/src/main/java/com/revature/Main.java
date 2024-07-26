package com.revature;

import com.revature.pom.PuppyPage;
import com.revature.pom.WikiHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            /*
                Once we have created our page object models we can now initialize
                all our objects and walk through whatever steps we want to automate
             */
            driver = new ChromeDriver();
            // don't forget to set an implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            WikiHome wikiHome = new WikiHome(driver);
            PuppyPage puppyPage = new PuppyPage(driver);

            wikiHome.goToWikipediaHome();
            wikiHome.enterTextIntoSearchBar("puppy");
            wikiHome.clickSearchButton();
            puppyPage.verifyWeAreOnThePuppyPage();

        } finally {
            if(driver != null){
                driver.quit();
            }
        }

    }

}
