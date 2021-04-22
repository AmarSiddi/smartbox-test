package com.smartbox.pages;

import com.smartbox.base.DriverFactory;
import com.smartbox.base.TestBase;
import com.smartbox.utils.ActionEngine;
import com.smartbox.utils.JavaScriptHelper;
import com.smartbox.utils.SeleniumWaits;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

/**
 * We can also implement Page Factory approach to store the element and initialize it.
 * ex:
 * @FindBy(id="ele_id"); WebElement ele_name;
 * public Class_Name (){ PageFactory.initElements(driver),this;}
 *
 */

public class AddCartPage extends TestBase {

    JavaScriptHelper helper = new JavaScriptHelper();
    SeleniumWaits waits = new SeleniumWaits();
    ActionEngine action = new ActionEngine();
    WebDriver driver;

    By addToCart = By.xpath("//div[@class='show-for-medium-up']//span[text()='Add to cart']");
    By goToCart = By.xpath("//a[text()='Go to cart']");
    By cartPage = By.xpath("//*[text()='Cart']");

    public String getPageTitle() {
        return DriverFactory.getInstance().getDriver().getTitle();
    }

    public By selectProduct(String productName, String giftBoxCategory) {
        return By.xpath( "//a[@data-product-name='" + productName + "' and @data-product-list='" + giftBoxCategory + "']//div[text()='See more']");
    }

    @SneakyThrows
    public void addProductToCart(String productName, String giftBoxCategory) {

        driver = DriverFactory.getInstance().getDriver();

        waits.waitPresenceOfElement(driver, selectProduct(productName,giftBoxCategory));
        helper.forceClickElement(driver, driver.findElement(selectProduct(productName,giftBoxCategory)));
        helper.forceClickElement(driver, driver.findElement(addToCart));
        waits.waitPresenceOfElement(driver, goToCart);
        helper.forceClickElement(driver, driver.findElement(goToCart));

    }

    public String checkPresenceOfItem(String itemName) {
        By item = By.xpath("//a[text()='"+itemName+" ']");
        return action.getText(DriverFactory.getInstance().getDriver(),item);
    }

    public void goToCartPage() {
        action.element_click(DriverFactory.getInstance().getDriver(), cartPage);
    }


}
