package com.testtask.tests;

import com.testtask.base.TestBase;
import com.testtask.Entities.ProductsEnum;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sergio on 30.01.2017.
 */

public class RefreshBrowserWhenActiveproductAndMoveCarusel extends TestBase {

    @Test
    public void test(){
        mainPage.addBalance("300");
        mainPage.setTarif(ProductsEnum.ProductWithPrice300);
        mainPage.buyProduct();
        mainPage.refreshPage();
        Assert.assertEquals(mainPage.getCurrentBalance(),"0","Error - current or expected balance ≠ 0.");
        Assert.assertEquals(mainPage.getCurrentBoughtDurationInDays(),"0","Error - current or expected duration are different.");
        Assert.assertEquals(mainPage.getCurrentBoughtSpeed(),"64","Error - current or expected speed are different.");
        Assert.assertEquals(mainPage.getCurrentPriceBoughtProduct(),"0","Error - current or expected price are different.");

    }
}
