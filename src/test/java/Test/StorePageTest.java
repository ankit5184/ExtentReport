package Test;

import org.testng.annotations.Test;

public class StorePageTest extends BaseTest {
    @Test(dataProvider = "WebsiteLoginData")
    public void StorePage(String url, String email, String password) {
        pageFactory.getLoginPage().Login(url, email, password);
        pageFactory.getStorePage().clickOnDress();
        pageFactory.getStorePage().dropDownValue();
        pageFactory.getStorePage().addToCart();
        pageFactory.getLoginPage().LogOut();
    }
}
