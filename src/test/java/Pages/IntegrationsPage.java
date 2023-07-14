package Pages;

import Configuration.ExtentLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class IntegrationsPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div[7]/div/div[2]/div/div[2]/div/iframe")
    private WebElement IFrame;

    @FindBy(xpath = "//*[@id='707883_37131pi_707883_37131']")
    private WebElement enterEmail;

    @FindBy(xpath = "//*[@id='707883_37127pi_707883_37127']")
    private WebElement enterName;

    @FindBy(xpath = "//*[@id='707883_37129pi_707883_37129']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='707883_37139pi_707883_37139']")
    private WebElement Company;

    @FindBy(xpath = "//*[@id='707883_37135pi_707883_37135']")
    private WebElement phone_number;

    @FindBy(xpath = "//*[@id='707883_37141pi_707883_37141']")
    private WebElement review_like;

    @FindBy(xpath = "//*[@id='pardot-form']/p[3]/input")
    private WebElement submit;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div[7]/div/div[2]/div/div[2]/div/iframe")
    private WebElement Iframe2;

    @FindBy(xpath = "//*[@id=\"pardot-form\"]/p[1]/strong\n")
    private WebElement text;

    public IntegrationsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void integration(String homepageUrl,String integrationPageUrl, String mail, String firstname,
                            String lastname, String company, String phoneNumber, String review){
        driver.get(homepageUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(integrationPageUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2200)");
        driver.switchTo().frame(IFrame);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        enterEmail.sendKeys(mail);
        enterName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        Company.sendKeys(company);
        phone_number.sendKeys(phoneNumber);
        review_like.sendKeys(review);
        submit.click();
        driver.switchTo().defaultContent();
    }

    public void verifyText(){
        driver.switchTo().frame(Iframe2);
        String actualText = text.getText();
        ExtentLogger.pass(actualText);
        String expectedText = "Thank you for submitting your request, an integration specialist will get back to you soon (1 business day).";
        if (actualText.equals(expectedText)) {
            System.out.println("Text verification passed");
        } else {
            System.out.println("Text verification failed");
        }
        driver.switchTo().defaultContent();
    }
}
