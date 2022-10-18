package Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(dataProvider = "WebsiteLoginData")
    public void Login(String url, String email, String password) {
        pageFactory.getLoginPage().Login(url, email, password);
        pageFactory.getLoginPage().LogOut();
    }
}
