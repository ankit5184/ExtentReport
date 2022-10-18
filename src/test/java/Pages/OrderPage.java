package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class OrderPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@title='Orders']")
    private WebElement orderHistory;

    @FindBy(xpath = "(//span[contains(text(),'Details')])[1]")
    private WebElement orderDetails;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void orderHistoryPage() throws InterruptedException {
        orderHistory.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        orderDetails.click();
        Thread.sleep(10000);
    }

    public void scrollDown() throws InterruptedException {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, 1000)");
        Thread.sleep(10000);
    }

}
