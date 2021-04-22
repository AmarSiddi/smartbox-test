package com.smartbox.pages;

import com.smartbox.base.BrowserFactory;
import com.smartbox.base.DriverFactory;
import com.smartbox.base.TestBase;
import com.smartbox.utils.DriverOperations;
import com.smartbox.utils.JavaScriptHelper;
import com.smartbox.utils.SeleniumWaits;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**@author Amarnath
 *
 * SmartBoxPage class used to implement operations like
 * 1. Finding the particular product from the category
 * 2. Adding the product to the cart
 */

public class SmartBoxPage extends TestBase {

    JavaScriptHelper je = new JavaScriptHelper();
    SeleniumWaits waits = new SeleniumWaits();
    DriverOperations operations = new DriverOperations();
    WebDriver driver;

    By addToCart = By.xpath("//div[@class='show-for-medium-up']//span[text()='Add to cart']");
    By goToCart = By.xpath("//a[text()='Go to cart']");

    public String getPageTitle() {
        return DriverFactory.getInstance().getDriver().getTitle();
    }

    public By selectProduct(String productName, String giftBoxCategory) {
        return By.xpath("//a[@data-product-name='" + productName + "' and @data-product-list='" + giftBoxCategory + "']//div[text()='See more']");
    }

    @SneakyThrows
    public void addProductToCart(String productName, String giftBoxCategory) {

        driver = DriverFactory.getInstance().getDriver();
        waits.waitPresenceOfElement(driver, selectProduct(productName, giftBoxCategory));
        je.forceClickElement(driver, driver.findElement(selectProduct(productName, giftBoxCategory)));
        //operations.element_click(driver, selectProduct(productName, giftBoxCategory));

        je.forceClickElement(driver, driver.findElement(addToCart));
        waits.waitPresenceOfElement(driver, goToCart);
        je.forceClickElement(driver, driver.findElement(goToCart));

    }

}
