package com.revature;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TakingScreenshot {
    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.get("https://wikipedia.com");
            captureScreenshot(driver,"screenshot.jpeg");
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            if (driver != null){
                driver.quit();
            }
        }
    }


    public static void captureScreenshot(WebDriver driver, String filename) throws IOException{
        // 1. we get screenshot data saved in a File object
        File fileData = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // 2. set the path for where the screenshot will be saved
        Path screenshotDestination = Paths.get("src/main/resources/" + filename);
        // 3. use Files.copy() method to save fileData to the screenshotDestination
        Files.copy(fileData.toPath(), screenshotDestination);
    }
}
