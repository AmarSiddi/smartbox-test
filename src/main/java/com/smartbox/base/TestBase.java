package com.smartbox.base;

import com.smartbox.utils.PropertiesOperations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**@author Amarnath
 * TestBase class will be extended by each Page Class.
 * This class @BeforeMethod and @AfterMethod statements will be executed with each test in Test Library.
 * A driver parameter is fetched from config.properties file, which then used to create a respective driver instance.
 *
 * For Parameter we can also use TestNG @Parameters annotation to pass it from testng.xml file.
 *
 */

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
