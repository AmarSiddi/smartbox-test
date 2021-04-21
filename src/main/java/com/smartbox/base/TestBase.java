package com.smartbox.base;

import com.smartbox.utils.PropertiesOperations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    BrowserFactory browserFactory = new BrowserFactory();

    @BeforeMethod
    public void LaunchApplication() throws Exception {
        String browser = PropertiesOperations.getPropertyValue("browser");
        String url = 	PropertiesOperations.getPropertyValue("url");

        DriverFactory.getInstance().setDriver(browserFactory.browserInstance(browser));

        DriverFactory.getInstance().getDriver().manage().window().maximize();
        DriverFactory.getInstance().getDriver().navigate().to(url);

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.getInstance().closeBrowser();
    }
}
