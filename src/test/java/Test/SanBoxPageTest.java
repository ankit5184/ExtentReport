package Test;

import org.testng.annotations.Test;

public class SanBoxPageTest extends BaseTest {
    @Test(dataProvider = "SandBoxPageTestData")
    public void SandBox(String sandBoxUrl,String mail,String firstName, String lastName, String phoneNumber,
                        String webSite, String company, String title) throws InterruptedException {
        pageFactory.getSanBoxPage().sandBox(sandBoxUrl, mail, firstName, lastName, phoneNumber, webSite, company, title);
        pageFactory.getSanBoxPage().verifyText();
    }
}