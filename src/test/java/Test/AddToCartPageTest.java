package Test;

import org.testng.annotations.Test;
import sun.security.mscapi.CPublicKey;

public class AddToCartPageTest extends BaseTest {
    @Test(dataProvider = "WebsiteLoginData")
    public void AddToCart(String url, String email, String password) {
        pageFactory.getLoginPage().Login(url, email, password);
        pageFactory.getStorePage().clickOnDress();
        pageFactory.getStorePage().dropDownValue();
        pageFactory.getStorePage().addToCart();
        pageFactory.getAddToCartPage().clickOnShoppingCart();
        pageFactory.getAddToCartPage().proceedToCheckOut();
        pageFactory.getAddToCartPage().checkBoxClick();
        pageFactory.getAddToCartPage().check();
        pageFactory.getAddToCartPage().confirmOrderedItem();
        pageFactory.getLoginPage().LogOut();
    }
}
