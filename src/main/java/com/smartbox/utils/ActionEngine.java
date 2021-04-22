package com.smartbox.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionEngine {

    public void element_click(WebDriver driver, By locator) {
        driver.findElement(locator);
    }

    public void element_sendKeys(WebDriver driver, By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    public String getText(WebDriver driver, By locator){
        return driver.findElement(locator).getText();
    }
}
