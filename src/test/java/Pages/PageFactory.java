package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;

    private LoginPage loginPage;
    private StorePage storePage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;

    public PageFactory(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage getLoginPage(){
        if(loginPage == null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public StorePage getStorePage(){
        if(storePage == null){
            storePage = new StorePage(driver);
        }
        return storePage;
    }

    public AddToCartPage getAddToCartPage(){
        if(addToCartPage == null){
            addToCartPage = new AddToCartPage(driver);
        }
        return addToCartPage;
    }

    public OrderPage getOrderPage(){
        if(orderPage == null){
            orderPage = new OrderPage(driver);
        }
        return orderPage;
    }
}
