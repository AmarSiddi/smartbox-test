package com.smartbox.test;

import com.smartbox.pages.AddCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCartTest extends AddCartPage {

    String giftBoxType = "Our most popular gift boxes";
    String productName = "Happy Birthday";

    @Test(priority = 1, enabled = false)
    public void verifyTitle(){
        Assert.assertEquals(getPageTitle(),"Smartbox Ireland - Experience Gifts for all Occasions");
    }

    @Test(priority = 2)
    public void verifyAddProduct(){
        addProductToCart(productName, giftBoxType);
        String addedCartProduct = checkPresenceOfItem(productName);
        Assert.assertEquals(addedCartProduct,"Happy Birthday  (e-Voucher)");
    }
}
