package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.sql.Driver;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private final By SpamLocator = By.className("close_jsx_svg__svg");
    private final By ButtonAddLocator = By.className("button___1WAua");
    private final By ExeptionLocator = By.xpath("//*[@class='error___1q9h7']");
    private final By ButtonOpenBasketLocator = By.xpath("//*[@href='/ru/cart']");

public ProductPage(WebDriver  driver)
{
    this.driver = driver;
}

public  ProductPage CloseSpam(String URL)
{
    driver.get(URL);
    WebElement SearchSpam = (new WebDriverWait(driver, 100))
            .until(ExpectedConditions.presenceOfElementLocated(SpamLocator));
    SearchSpam.click();
    return this;
}

public ProductPage AddProduct()
{
    WebElement ButtonAdd = driver.findElement(ButtonAddLocator);
    ButtonAdd.click();
    return this;
}

public int CheckExepion()
{
    List<WebElement> Exeption = driver.findElements(ExeptionLocator);
    return Exeption.size();
}

public  BasketPage OpenBasket()
{
    WebElement GoToBasket = driver.findElement(ButtonOpenBasketLocator);
    GoToBasket.click();
    return new BasketPage(driver);
}



}
