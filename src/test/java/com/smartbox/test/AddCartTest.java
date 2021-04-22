package com.smartbox.test;

import com.smartbox.pages.CheckoutCartPage;
import com.smartbox.pages.SmartBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddCartTest extends SmartBoxPage {

    SmartBoxPage smartBox = new SmartBoxPage();
    CheckoutCartPage checkout = new CheckoutCartPage();

    String productName = "Happy Birthday";
    String giftBoxType = "Our most popular gift boxes";

    @Test(priority = 1, enabled = false)
    public void verifyTitle(){
        Assert.assertEquals(smartBox.getPageTitle(),"Smartbox Ireland - Experience Gifts for all Occasions");
    }

    @Test(priority = 2)
    public void verifyAddProduct(){
        smartBox.addProductToCart(productName, giftBoxType);
        String addedCartProduct = checkout.checkPresenceOfItem(productName);
        Assert.assertEquals(addedCartProduct,"Happy Birthday  (e-Voucher)");
    }
}
