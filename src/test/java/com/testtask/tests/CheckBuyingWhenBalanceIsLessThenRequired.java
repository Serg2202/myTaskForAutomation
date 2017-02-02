package com.testtask.tests;

import com.testtask.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckBuyingWhenBalanceIsLessThenRequired extends TestBase {

    @Test
    public void test(){
        mainPage.addBalance("200");
        mainPage.moveCaruselRight();
        mainPage.buyProduct();
        Assert.assertEquals(mainPage.getCurrentBalance(),"200","");
        Assert.assertEquals(mainPage.getCurrentBoughtDurationInDays(),"0","");
        Assert.assertEquals(mainPage.getCurrentBoughtSpeed(),"64","");
        Assert.assertEquals(mainPage.getCurrentPriceBoughtProduct(),"0","");
    }

}
