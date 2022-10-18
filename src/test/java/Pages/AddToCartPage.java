package Pages;

import Configuration.ExtentLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class AddToCartPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement shoppingCart;

    @FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
    private WebElement proceedToCheckout;

    @FindBy(xpath = "//button[@name='processAddress']")
    private WebElement processAddress;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement shippingAddress;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkBox;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement paymentOption;

    @FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
    private WebElement payByCheck;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement confirmOrder;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnShoppingCart() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        shoppingCart.click();
        ExtentLogger.pass("Click on to see the item in cart");
    }

    public void proceedToCheckOut() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        proceedToCheckout.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        processAddress.click();
    }

    public void checkBoxClick() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        checkBox.click();

    }

    public void check() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        paymentOption.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        payByCheck.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void confirmOrderedItem() {
        confirmOrder.click();
    }
}
