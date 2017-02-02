package com.testtask.tests;

import com.testtask.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sergio on 28.01.2017.
 */

public class CheckDefaultProductAfterStart extends TestBase {


    @Test
    public void test() {
        mainPage.getCurrentBalance();
        mainPage.getCurrentBoughtDurationInDays();
        mainPage.getCurrentBoughtSpeed();
        mainPage.getCurrentPriceBoughtProduct();
        Assert.assertEquals(mainPage.getCurrentBalance(), "0", "Error - current or expected balance ≠ 0.");//тут сравним текущий и ожидаемый баланс и если нужно то сообщение об ошибке
        Assert.assertEquals(mainPage.getCurrentBoughtDurationInDays(), "0", "Error - current or expected duration are different.");
        Assert.assertEquals(mainPage.getCurrentBoughtSpeed(), "64", "Error - current or expected speed are different");
        Assert.assertEquals(mainPage.getCurrentPriceBoughtProduct(), "0", "Error - current or expected price are different.");

    }
}
