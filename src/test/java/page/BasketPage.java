package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasketPage {
    private WebDriver driver;
    private final By DeleteItemInBasketButtonLocator = By.xpath("//*[@class='text___183EF']");
    private final By ConfirmLocator = By.xpath("//*[@class='button___3hmfW button___TbaLj fill-brand___18fJk padding-normal___2ctfV rounded___1J8B1']");
    private final By ItemLocator = By.xpath("//*[@class='inner___15C_']");

    public BasketPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public BasketPage DeleteFromBasket ()
    {
        WebElement DeleteItemButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(DeleteItemInBasketButtonLocator));
        DeleteItemButton.click();
        WebElement Confirm = driver.findElement(ConfirmLocator);
        Confirm.click();
        return this;
    }

    public int CountItemsInBasket()
    {
        List<WebElement> ItemsInBasket = driver.findElements(ItemLocator);
        return ItemsInBasket.size();
    }




}
