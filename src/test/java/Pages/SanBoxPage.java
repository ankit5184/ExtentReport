package Pages;

import Configuration.ExtentLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SanBoxPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div[3]/div/div/div/div[1]/div/div/div/a")
    private WebElement startButton;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div/div/div[2]/div/div[2]/div/iframe")
    private WebElement IFrame;

    @FindBy(xpath = "//*[@id=\"707883_36887pi_707883_36887\"]")
    private WebElement enterMail;

    @FindBy(xpath = "//*[@id=\"707883_36883pi_707883_36883\"]")
    private WebElement first_Name;

    @FindBy(xpath = "//*[@id=\"707883_36885pi_707883_36885\"]")
    private WebElement last_Name;

    @FindBy(xpath = "//*[@id=\"707883_36891pi_707883_36891\"]")
    private WebElement phone_number;

    @FindBy(xpath = "//*[@id=\"707883_36889pi_707883_36889\"]")
    private WebElement website;

    @FindBy(xpath = "//*[@id=\"707883_36895pi_707883_36895\"]")
    private WebElement enter_company;

    @FindBy(xpath = "//*[@id=\"707883_36893pi_707883_36893\"]")
    private WebElement enter_title;

    @FindBy(xpath = "//*[@id=\"pardot-form\"]/p[3]/input")
    private WebElement get_started;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div/div/div[2]/div/div[2]/div/iframe")
    private WebElement IFrame2;

    @FindBy(xpath = "//*[@id=\"pardot-form\"]/p[1]/strong")
    private WebElement text;

    public SanBoxPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sandBox(String sandBoxUrl, String mail,String firstName, String lastName, String phoneNumber,
                        String webSite, String company, String title){
        driver.get(sandBoxUrl);
        startButton.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.switchTo().frame(IFrame);
        enterMail.sendKeys(mail);
        first_Name.sendKeys(firstName);
        last_Name.sendKeys(lastName);
        phone_number.sendKeys(phoneNumber);
        website.sendKeys(webSite);
        enter_company.sendKeys(company);
        enter_title.sendKeys(title);
        get_started.click();
        driver.switchTo().defaultContent();
    }

    public void verifyText(){
        driver.switchTo().frame(IFrame2);
        String actualText = text.getText();
        ExtentLogger.pass(actualText);
        String expectedText = "Thank you for submitting your request, a customer success agent will get back to you shortly.";
        if (actualText.equals(expectedText)) {
            System.out.println("Text verification passed");
        } else {
            System.out.println("Text verification failed");
        }
        driver.switchTo().defaultContent();
    }
}
