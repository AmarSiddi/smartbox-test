package com.smartbox.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**@author Amarnath
 *
 * DriveOperation class is used to write the click, sendKeys, getText operations separately.
 * devlopers doesn't need to use find by elements in the page class.
 *
 * Basically, it will helps to remove boilerplate in page classes.
 */

public class DriverOperations {

    public void element_click(WebDriver driver, By locator) {
        driver.findElement(locator);
    }

    public void element_sendKeys(WebDriver driver, By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    public String getText(WebDriver driver, By locator){
        return driver.findElement(locator).getText();
    }

    public String getAttributeValue(WebDriver driver, By locator, String attributeName){
        return driver.findElement(locator).getAttribute(attributeName);
    }
}
