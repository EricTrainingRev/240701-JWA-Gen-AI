package com.revature;

import com.revature.pom.AlertPage;
import com.revature.pom.DelayedPage;
import com.revature.pom.PuppyPage;
import com.revature.pom.WikiHome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = null;
//        basicPomUsage(driver);
//        usingExplicitWaits(driver);
        handlingAlerts(driver);

    }

    public static void basicPomUsage(WebDriver driver){
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
            System.out.println(puppyPage.verifyWeAreOnThePuppyPage());

        } finally {
            if(driver != null){
                driver.quit();
            }
    }

}

    public static void usingExplicitWaits(WebDriver driver) {
        try{
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            DelayedPage delayedPage = new DelayedPage(driver);
            delayedPage.openDelayedPage();
            delayedPage.printMessage();
        } finally {
            driver.quit();
        }
    }

    public static void handlingAlerts(WebDriver driver){
        try{
            driver = new ChromeDriver();
            AlertPage alertPage = new AlertPage(driver);
            alertPage.openAlertPage();
            alertPage.clickButton();
            alertPage.handleAlert();
        } finally {
            driver.quit();
        }
    }
}