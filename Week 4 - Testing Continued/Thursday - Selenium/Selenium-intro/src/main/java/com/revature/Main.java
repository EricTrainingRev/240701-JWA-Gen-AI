package com.revature;

//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;

public class Main {

    /*
        If we are setting up our web driver manually we need a Java File object
        that tells our code where the driver is located so that Selenium can interface
        with it. chosenDriver will be the object we use
     */
    static File chosenDriver;

    public static void main(String[] args) {
        // Compiler will complain if we don't initialize the driver type
        WebDriver driver = null;
//        manualSetup(driver);
//        automaticDriverManagement(driver);
        usingMavenDependency(driver);

    }


    /*
        Before version 4 of Selenium you had to provide a path to the webdriver executable
        you wanted to use. This required setting a System property and providing a path
        to the driver executable

        This is a common need when a project is created using JDK 8
     */
    public static void manualSetup(WebDriver driver){
        // Step 1: set the path to the driver you are using in your File object
        chosenDriver = new File("src/main/resources/chromedriver.exe");
        // Step 2: assign a System property for your chosen driver
        System.setProperty("webdriver.chrome.driver",chosenDriver.getAbsolutePath());
        try{
            // Step 3: instantiate your Driver object
            /*
                Since I am using Chrome I instantiate a ChromeDriver object, but Selenium
                supports most modern browsers
             */
            driver = new ChromeDriver();
            // Step 4: do things automatically in the browser, like open Wikipedia!
            driver.get("https://www.wikipedia.org/");
        } finally {
            /*
                Use a finally block to make your driver quit: this will close any browsers
                opened by the driver and release the system resources the object was utilizing
             */
            if (driver != null){
                driver.quit();
            }
        }
    }

    /*
        Someone created a manager dependency for webdrivers that could be used
        to auto-decide what version of a driver to use based on the browser
        you are using for automation purposes
     */
    public static void automaticDriverManagement(WebDriver driver){
        WebDriverManager.chromedriver().setup();
        try{
            driver = new ChromeDriver();
            driver.get("https://www.wikipedia.org/");
        } finally {
            if (driver != null){
                driver.quit();
            }
        }
    }

    /*
        In Selenium version 4 the need to set the driver path information has been
        removed so you can simply create your driver and start using it
     */
    public static void usingMavenDependency(WebDriver driver){
        try{
            driver = new ChromeDriver();
            driver.get("https://www.wikipedia.org/");
        } finally {
            if (driver != null){
                driver.quit();
            }
        }
    }







}
