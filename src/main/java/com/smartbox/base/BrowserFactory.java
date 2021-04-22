package com.smartbox.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.time.Duration;

/**
 * @author Amarnath
 * BrowserFactory class is used to initialise the required browser instances.
 */

public class BrowserFactory {

    public WebDriver browserInstance(String browser) {

        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions foptions = new FirefoxOptions();
            foptions.addArguments("-private");
            driver = new FirefoxDriver(foptions);

        }
        if (browser.equalsIgnoreCase("ie")) {

            WebDriverManager.iedriver().setup();
            InternetExplorerOptions iOptions = new InternetExplorerOptions();
            iOptions.addCommandSwitches("-private");
            driver = new InternetExplorerDriver(iOptions);

        }

        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        return driver;
    }


}
