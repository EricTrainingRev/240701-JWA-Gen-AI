package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CSSSelector {
    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            // you can switch alt value to see either option in action
            boolean alt = false;
            if (alt){
                /*
                    You can still make use of your ids and classes when using the css selector
                    option, you just use the css selector syntax
                 */
                driver.get("https://www.wikipedia.org/");
                WebElement searchInput = driver.findElement(By.cssSelector("#searchInput"));
                searchInput.sendKeys("puppy");
                WebElement searchButton = driver.findElement(By.cssSelector(".pure-button"));
                searchButton.click();
                System.out.println(driver.getTitle());
            } else {
                /*
                    So far we have primarily been using the Id, class, and tag selectors
                    to find our elements. Another powerful tool we can use is the css
                    selector. This allows us to use any attribute of an element to find it
                    or all the elements with the given element information. This uses the same
                    syntax as a style tag or external css style sheet to determine what elements
                    receive styling
                 */
                driver.get("https://www.wikipedia.org/");
                WebElement searchInput = driver.findElement(By.cssSelector("[accesskey='F']")); // returns first matching results
                List<WebElement> searchElements = driver.findElements(By.cssSelector("[accesskey='F']")); // returns all matching results
                System.out.println(searchElements.getClass());
                searchInput.sendKeys("puppy");
                WebElement searchButton = driver.findElement(By.cssSelector("[type='submit']"));
                searchButton.click();
                System.out.println(driver.getTitle());
            }

        } finally {
            if (driver != null){
                driver.quit();
            }
        }
    }
}
