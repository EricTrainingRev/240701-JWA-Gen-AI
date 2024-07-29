package com.revature;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            driver.get("C:\\Users\\EricSuminski\\Desktop\\240701-JWA-Gen-AI\\Week 5 - Selenium\\Monday\\Selenium-Continued\\src\\main\\resources\\slider.html");
            WebElement slider = driver.findElement(By.tagName("input"));
            /*
                In order to tell Selenium where to move the mouse in order to interact with the
                slider element we need to know where in the HTML Content Render Pane the element
                exists
             */
            Point sliderTopLeft = slider.getLocation();

            /*
                Another piece of the puzzle we need is to find the length and width of the element.
                We can use the width and height data of the element, alongside the pixel position
                of the top left corener, to calculate where Selenium should move the mouse
             */
            Dimension sliderWidthAndHeight = slider.getSize();

            /*
                Using the width of the element and the total number of possible values for
                the element we can determine how much space each value takes up along the slider
                path. We just divide the width by total possible values - 1 since (in this example)
                the input starts with an initial value (keep it as an integer since pixels don't work in floating point values)

                Once you know how much space each value takes on the slider, it should be a simple
                multiplication equation to figure out how many pixels to move the slider to get
                the result you want
             */
            System.out.println(sliderWidthAndHeight.width / 10); // returns 12


            /*
                The slider on the page opened above does not play nice with the sendKeys option
                provided by the driver. Because of this we are going to have to manually tell
                Selenium how to interact with the element. Any time you have some action or chain
                of actions that require a fine level of control and/or instruction from you to
                Selenium you can use the Actions API. You do this by creating an Actions object
                and then chaining the actions you want to take in the object, and then calling
                the perform() method to execute those actions.
             */
            new Actions(driver)
                    /*
                        first thing we need to do is tell Selenium to move the mouse to the slider
                        icon that we will drag to our intended position. Getting the X coordinate
                        is easy: we just reference the x value of the Point object we retrieved from
                        the getLocation method above.

                        Getting the Y position requires a little bit of math: a good target point would
                        be the center of the element (center of the total height) because that should actually
                        allow for us to tell Selenium to click and hold, and the mouse should be over
                        the drag icon. If we go down the whole height of the elment we will probbaly miss
                        it. Also, if the mouse is too far left of the icon we can adjust the x position
                        by a few pixels if necessary

                        keep in mind that in the render pane addition moves towards the right of the view
                        in the x axis, and it moves down the view along the y axis
                     */
                    .moveToLocation(sliderTopLeft.getX(),sliderTopLeft.getY() + sliderWidthAndHeight.getHeight()/2 )
                    /*
                        The Actions api allows using a click and clickAndHold method, both can
                        target a specific element, or if you leave off the specific element then
                        the action will be performed wherever the mouse currently is
                     */
                    .clickAndHold()
                    /*
                        above we figured out that each value takes up ~11 pixels, so if we want to
                        get to the value of 5 we need to move 5*12=60 pixels along the x axis
                     */
                    .moveByOffset(60,0)
                    /*
                        When we are ready to release the mouse click we call the release method
                     */
                    .release()
                    /*
                        If you are ready to perform the action right away you can call perform
                        and the action sequence will be executed right away. If you are setting
                        it up for later use, or to be used multiple times, you can use the
                        build() method instead to create an action object that can be saved to
                        a variable and used later
                     */
                    .perform();
            System.out.println(driver.findElement(By.tagName("h1")).getText());
        } finally {
            if(driver != null){
                driver.quit();
            }
        }
    }
}
