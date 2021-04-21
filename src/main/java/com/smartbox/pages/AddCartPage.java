package com.smartbox.pages;

import com.smartbox.base.DriverFactory;
import com.smartbox.base.TestBase;
import org.openqa.selenium.By;

public class AddCartPage extends TestBase {

    public String getPageTitle() {
        return DriverFactory.getInstance().getDriver().getTitle();
    }

    public void addProductToCart(String giftBoxGategory, String productName){
        DriverFactory.getInstance().getDriver().findElement(By.xpath("//section[@data-productlist='" + giftBoxGategory + "']/div/div/div/a[@data-product-name='" + productName + "']/div/div[text()='See more']")).click();
        DriverFactory.getInstance().getDriver().findElement(By.xpath("//section[2]/div[2]/div[1]/a[1]/span[1]")).click();
    }

}
