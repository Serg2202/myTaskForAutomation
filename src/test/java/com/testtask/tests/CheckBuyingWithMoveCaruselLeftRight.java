package com.testtask.tests;

import com.testtask.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBuyingWithMoveCaruselLeftRight extends TestBase {

    @Test
    public void test(){
        mainPage.addBalance("450");
        for (int i=0;i<5;i++){
            mainPage.moveCaruselRight();
        }
        mainPage.moveCaruselLeft();
        mainPage.buyProduct();

        Assert.assertEquals(mainPage.getCurrentBalance(),"0","Error - current or expected balance are different.");
        Assert.assertEquals(mainPage.getCurrentPriceBoughtProduct(),"450","Error - expected or current price of bought product are different.");
        Assert.assertEquals(mainPage.getCurrentBoughtSpeed(),"640","Error - expected or current speed of bought product are different.");
        Assert.assertEquals(mainPage.getCurrentBoughtDurationInDays(),"0","Error - duration is incorrect.");
    }
}
