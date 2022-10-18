package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseTest {
    @Test(dataProvider = "WebsiteLoginData")
    public void OrderHistory(String url, String email, String password) throws InterruptedException {
        pageFactory.getLoginPage().Login(url, email, password);
        pageFactory.getOrderPage().orderHistoryPage();
        pageFactory.getOrderPage().scrollDown();
        pageFactory.getLoginPage().LogOut();
    }
}
