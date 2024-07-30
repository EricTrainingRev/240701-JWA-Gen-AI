# Select Elements
**Note: much more detailed information about working with Select elements can be found [here](https://www.selenium.dev/documentation/webdriver/support_features/select_lists/)**

## Creating Select Objects
```java
WebElement element = driver.findElement(By.id("someId"));
Select selectElement = new Select(element);
```

## Select Methods
- getOptions()
    - returns a List of WebElements for each option for the select element
- getAllSelectedOptions()
    - returns a list of all selected options for the select element
        - only returns multiple elements if working with a select element that allows multiple selection via the multiple attribute
- selectByVisibleTest()
    - selects an option based on its text value (content between the option tags)
- selectByValue()
    - selects an option based on its value attribute 
- selectByIndex()
    - selects an option based on its index position in the list of options (top of list starts at 0)