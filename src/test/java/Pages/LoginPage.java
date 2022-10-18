package Pages;

import Configuration.ExtentLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signIn;

    @FindBy(xpath = "(//input[@name='email'])[1]")
    private WebElement enterEmail;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement enterPassword;

    @FindBy(xpath = "//button[@name='SubmitLogin']")
    private WebElement submitLogin;

    @FindBy(xpath = "//a[@class='logout']")
    private  WebElement logout;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Login(String url, String email, String password) {
        driver.get(url);
        signIn.click();
        ExtentLogger.pass("Click on SignIn Button");
        enterEmail.sendKeys(email);
        ExtentLogger.pass("Email :"+ email);
        enterPassword.sendKeys(password);
        ExtentLogger.pass("Password :" + password);
        submitLogin.click();
    }

    public void LogOut(){
        logout.click();
        ExtentLogger.pass("Click on SignOut Button");
    }
}
