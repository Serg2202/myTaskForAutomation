package com.testtask.base;

import com.testtask.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.testtask.constants.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sergio on 30.01.2017.
 */

//база для тестов- подготовительные операции. сюда вынес общую часть, которая используется в тестах
public class TestBase {

    protected WebDriver driver;
    protected String baseUrl = "http://localhost:4567/index.html";
    protected MainPage mainPage;

    @BeforeSuite
    public void setSuit() throws Exception {
        runApplicationJar();
        System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_EXE);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearSuite() throws Exception {
        driver.quit();
    }

    private void runApplicationJar() {//метод который запускат jar-ник
        try {
            String getAbsolutePathJarFile=new File(Constants.APPLICATION_PATH).getAbsolutePath();// оптимизировал использование констант, прикрутил использование абсолютного пути
            ProcessBuilder processBuilder = new ProcessBuilder(System.getenv("JAVA_HOME") + "\\bin\\java", "-jar", getAbsolutePathJarFile);
            processBuilder.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage(driver);
        mainPage.refreshPage();
        mainPage.resetBalance();
    }
}
