package Pages;

import Configuration.ExtentLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class StorePage {
    WebDriver driver;

    @FindBy(xpath = "(//a[@title='Dresses'])[2]")
    private WebElement dress;

    @FindBy(xpath = "(//div[@class='subcategory-image'])[3]")
    private WebElement clickOnSummerButton;

    @FindBy(xpath = "(//div[@class='product-image-container'])[1]")
    private WebElement clickOnDress;

    @FindBy(xpath = "//select[@name='group_1']")
    private WebElement dropDownHandle;

    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
    private WebElement proceedToCheckout;

    public StorePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnDress(){
        dress.click();
        ExtentLogger.pass("Click on Dress Button");
        clickOnSummerButton.click();
        clickOnDress.click();
    }

    public void dropDownValue(){
        Select select = new Select(dropDownHandle);
        select.selectByValue("2");
        ExtentLogger.pass("Value selected by drop down");
    }

    public void addToCart(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        addToCartButton.click();
        ExtentLogger.pass("Add select item to cart");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        proceedToCheckout.click();
        ExtentLogger.pass("Item is added to the cart");
    }
}
