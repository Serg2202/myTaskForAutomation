package com.testtask.pages;

import com.testtask.Entities.ProductsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;


/**
 * Created by Sergio on 28.01.2017.
 */

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {//
        super(driver);
    }

    Actions actions = new Actions(driver);

    @FindBy(xpath = ".//*[@id='balance-holder']/span")
    private WebElement currentBalance;//текущий баланс

    @FindBy(xpath = ".//*[@class='tariff unavailable']//*[@class='time']/strong")
    private WebElement currentBoughtDurationInDays;//длительность в днях у подключенного продукта

    @FindBy(xpath = ".//*[@class='tariff']//*[@class='time']/strong")
    private WebElement currentSelectedDurationInDays;

    @FindBy(xpath = ".//*[@class='tariff unavailable']//*[@class='speed']/strong")
    private WebElement currentBoughtSpeed;//скорость в Кбит/сек у подлюченного продукта

    @FindBy(xpath = ".//*[@class='tariff unavailable']//*[@class='cost no-arrow']/strong")
    private WebElement currentPriceBoughtProduct;//стоимость в руб./мес у подлюченного продукта

    @FindBy(xpath = ".//*[@class='tariff']//*[@class='speed']/strong")
    private WebElement currentSelectedSpeed;//скорость в Кбит/сек у выбранного для подлючения продукта

    @FindBy(xpath = ".//*[@class='tariff']//*[@class='cost']/strong")
    private WebElement currentSelectedPrice;//стоимость в руб./мес у выбранного для подлючения продукта

    @FindBy(xpath = ".//*[@class='decrease']/a")
    private WebElement moveLeftButton;//переместить бегунок влево на одну позицию

    @FindBy(css = "div.increase > a.icon")
    private WebElement moveRightButton;

    @FindBy(id = "amount")
    private WebElement amountField;//поле ввода суммы пополнения счета

    @FindBy(xpath = "//a[contains( text(),'Пополнить')]")
    private WebElement addBalanceButton;//кнопка "Пополнить счет"

    @FindBy(xpath = ".//a[contains( text(),'Подключить')]")
    private WebElement buyButton;//кнопка "Подключить"

    @FindBy(xpath = "//a[contains( text(),'Сброс')]")
    private WebElement resetButton;//кнопка "Сброс"


    public void addBalance(String balance) {
        amountField.clear();
        amountField.sendKeys(balance);
        addBalanceButton.click();
    }

    public void buyProduct() {
        buyButton.click();
    }

    public void moveCaruselLeft() {
        Dimension size = moveLeftButton.getSize();
        actions.moveToElement(moveLeftButton, size.getWidth() - 4, size.getHeight() - 4).click().build().perform();
    }

    public void moveCaruselRight() {
        Dimension size = moveRightButton.getSize();
        actions.moveToElement(moveRightButton, size.getWidth() - 4, size.getHeight() - 4).click().build().perform();

    }

    public String getCurrentBalance() {
        return currentBalance.getText();
    }

    public void resetBalance() {
        resetButton.click();
    }

    public void setTarif(ProductsEnum product) {//здесь используем метод equals из-за того что сраниваются стринги
        while (!getCurrentSelectedPrice().equals(product.getPrice())) {// создали условие выбора продукта в зависимости от текущего баланса
            moveCaruselRight();
        }
        buyProduct();
    }

    public void refreshPage() {
        driver.navigate().refresh();//обновить страницу
    }

    public String getCurrentBoughtDurationInDays() {
        return currentBoughtDurationInDays.getText();
    }

    public String getCurrentBoughtSpeed() {
        return currentBoughtSpeed.getText();
    }

    public String getCurrentPriceBoughtProduct() {
        return currentPriceBoughtProduct.getText();
    }

    public String getCurrentSelectedPrice() {
        return currentSelectedPrice.getText();
    }

}
