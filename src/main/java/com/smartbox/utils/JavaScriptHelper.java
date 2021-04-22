package com.smartbox.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {

    JavascriptExecutor executor;

    public void scrollToElement(WebDriver driver, WebElement element){
        executor = (JavascriptExecutor)driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void forceClickElement(WebDriver driver, WebElement element){
        executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
}
