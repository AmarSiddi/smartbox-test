package com.smartbox.base;

import org.openqa.selenium.WebDriver;


/**
 * @author Amarnath
 *
 * DriverFactory class is used to generate a single driver instance.
 * This will help during the parallel thread execution.
 */

public class DriverFactory {

    //Singleton Design Pattern
    private DriverFactory() {
    }

    private static DriverFactory instance  = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }

}
