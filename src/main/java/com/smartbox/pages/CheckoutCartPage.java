package com.smartbox.pages;

import com.smartbox.base.DriverFactory;
import com.smartbox.base.TestBase;
import com.smartbox.utils.DriverOperations;
import org.openqa.selenium.By;

/**
 * @author Amarnath
 * ChekcoutCartPage class used to perform operations on checkout page like
 * 1. Verifying the Item present in the cart
 * <p>
 * we can also perform other operations like find quantity, place order, remove item etc.
 */

public class CheckoutCartPage extends TestBase {

    DriverOperations operations = new DriverOperations();

    By placeOrder = By.xpath("//div[@class='summary-total__content']//button[@type='button']/span[text()='Place order']");


    public By itemToDelete(String deleteItem) {
        return By.xpath("//*[@class='row item item-ebox']//a[text()='" + deleteItem
                + " ']/ancestor::div[3]//button[@type='button']/following-sibling::a");
    }

    public By itemQuantity(String itemName) {
        return By.xpath("//*[@class='row item item-ebox']//a[text()='" + itemName + " ']/ancestor::div[3]/div//select");
    }


    public String checkPresenceOfItem(String itemName) {
        By item = By.xpath("//a[text()='" + itemName + " ']");
        return operations.getText(DriverFactory.getInstance().getDriver(), item);
    }

    public void removeItem(String itemName) {
        operations.element_click(DriverFactory.getInstance().getDriver(), itemToDelete(itemName));
    }

    public void placeOrder() {
        operations.element_click(DriverFactory.getInstance().getDriver(), placeOrder);
    }

    public int getItemQuantity(String itemName) {
        String value = operations.getAttributeValue(DriverFactory.getInstance().getDriver(),
                itemQuantity(itemName), "data-qty");
        return Integer.parseInt(value);
    }
}
