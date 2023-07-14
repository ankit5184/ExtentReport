package Pages;

import Configuration.ExtentLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PublicLinksPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div[7]/div/div[2]/div/div/div/iframe")
    private WebElement IFrame;

    @FindBy(xpath = "//*[@id=\"707883_34916pi_707883_34916\"]")
    private WebElement enterMail;

    @FindBy(xpath = "//*[@id=\"707883_34912pi_707883_34912\"]")
    private WebElement first_Name;

    @FindBy(xpath = "//*[@id=\"707883_34914pi_707883_34914\"]")
    private WebElement last_Name;

    @FindBy(xpath = "//*[@id=\"707883_34920pi_707883_34920\"]")
    private WebElement phone_number;

    @FindBy(xpath = "//*[@id=\"707883_34918pi_707883_34918\"]")
    private WebElement website;

    @FindBy(xpath = "//*[@id=\"707883_34924pi_707883_34924\"]")
    private WebElement enter_company;

    @FindBy(xpath = "//*[@id='707883_34922pi_707883_34922']")
    private WebElement enter_title;

    @FindBy(xpath = "//*[@id=\"pardot-form\"]/p[3]/input")
    private WebElement get_started;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div[7]/div/div[2]/div/div/div/iframe")
    private WebElement IFrame2;

    @FindBy(xpath = "//*[@id=\"pardot-form\"]/p[1]/strong")
    private WebElement text;

    public PublicLinksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void publicLink(String publicurl, String mail, String firstName, String lastName, String phoneNumber,
                           String webSite, String company, String title){
        driver.get(publicurl);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2200)");
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
        String expectedText = "Thank you for submitting your request, an integration specialist will get back to you soon (1 business day).";
        if (actualText.equals(expectedText)) {
            System.out.println("Text verification passed");
        } else {
            System.out.println("Text verification failed");
        }
        driver.switchTo().defaultContent();
    }
}
