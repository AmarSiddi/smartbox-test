package com.smartbox.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaits {

    WebDriverWait wait;

    public void waitPresenceOfElement(WebDriver driver, By locator){
         wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
         wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitClickableElement(WebDriver driver, By locator){
        wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitPresenceOfAlert(WebDriver driver){
        wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
