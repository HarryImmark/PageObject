package Test;

import com.sun.jndi.cosnaming.IiopUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import page.ProductPage;
import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebDriverJoom_Test {
    private WebDriver driver;
    private ChromeOptions options;
    private static final String Product_URL_for_CheckBuyWithoutColor = "https://www.joom.com/ru/products/5f06ad934ca8140106df64a3";
    private static final String Product_URL_for_CheckEmptyBasket = "https://www.joom.com/ru/products/5f1a841fcd239a0106798bd2";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void CheckEmptyBasket ()
    {
        int SearchProductsInBasket = new ProductPage(driver)
                .CloseSpam(Product_URL_for_CheckEmptyBasket)
                .AddProduct()
                .OpenBasket()
                .DeleteFromBasket()
                .CountItemsInBasket();
        Assert.assertTrue(SearchProductsInBasket == 0,"Basket not empty");
    }

    @Test
    public void CheckBuyWithoutColor ()
    {
         int CheckForExeption = new ProductPage(driver)
                 .CloseSpam(Product_URL_for_CheckBuyWithoutColor)
                 .AddProduct()
                 .CheckExepion();
         Assert.assertTrue(CheckForExeption > 0,"The item was delete from basket");
    }

    @AfterMethod(alwaysRun = true)
    public void driverShutDown()
    {
        driver.quit();
        driver = null;
    }
}
