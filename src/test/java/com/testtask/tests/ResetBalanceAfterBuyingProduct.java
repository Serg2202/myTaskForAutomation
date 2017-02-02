package com.testtask.tests;

import com.testtask.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ResetBalanceAfterBuyingProduct extends TestBase {

    @Test
    public void test(){
        mainPage.addBalance("500");
        mainPage.moveCaruselRight();
        mainPage.buyProduct();
        mainPage.resetBalance();

        Assert.assertEquals(mainPage.getCurrentBalance(),"0","Error - current or expected balance are different.");
        Assert.assertEquals(mainPage.getCurrentBoughtDurationInDays(),"0","Error - duration is incorrect.");
        Assert.assertEquals(mainPage.getCurrentBoughtSpeed(),"64","Error - expected or current speed of bought product are different.");
        Assert.assertEquals(mainPage.getCurrentPriceBoughtProduct(),"0","Error - expected or current price of bought product are different.");

    }
}
