package com.testtask.tests;

import com.testtask.base.TestBase;
import com.testtask.Entities.ProductsEnum;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sergio on 30.01.2017.
 */

public class CheckBuyingMinMaxProduct extends TestBase {

//здесь обеъединил 2 кейса похожие по смыслу
    @Test
    public void checkBuyingMinProduct() {
        mainPage.addBalance("300");
        mainPage.setTarif(ProductsEnum.ProductWithPrice300);
        mainPage.buyProduct();
        Assert.assertEquals(mainPage.getCurrentBalance(), "0", "Test checkBuyingMinProduct: Error - current or expected balance are different.");
        Assert.assertEquals(mainPage.getCurrentBoughtDurationInDays(),"0","Test checkBuyingMinProduct: Error - current or expected duration are different.");
        Assert.assertEquals(mainPage.getCurrentBoughtSpeed(), "320", "Test checkBuyingMinProduct: Error - selected speed of product is differ from expected.");
        Assert.assertEquals(mainPage.getCurrentPriceBoughtProduct(), "300", "Test checkBuyingMinProduct: Error - selected price of product is differ from expected.");
    }

    @Test
    public void checkBuyingMaxProduct() {
        mainPage.addBalance("1400");
        mainPage.setTarif(ProductsEnum.ProductWithPrice1400);
        mainPage.buyProduct();
        Assert.assertEquals(mainPage.getCurrentBalance(), "0", "Test checkBuyingMaxProduct: Error - current or expected balance are different.");
        Assert.assertEquals(mainPage.getCurrentBoughtDurationInDays(), "0", "Test checkBuyingMaxProduct: Error - current or expected duration are different.");
        Assert.assertEquals(mainPage.getCurrentPriceBoughtProduct(), "1400", "Test checkBuyingMaxProduct: Error - selected price of product is differ from expected.");
        Assert.assertEquals(mainPage.getCurrentBoughtSpeed(), "Макс", "Test checkBuyingMaxProduct: Error - selected speed of product is differ from expected.");

    }


}
