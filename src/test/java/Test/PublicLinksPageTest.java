package Test;

import org.testng.annotations.Test;

public class PublicLinksPageTest extends BaseTest {
    @Test(dataProvider = "PublicLinkPageTestData")
    public void PublicLinks(String publicurl, String mail, String firstName, String lastName, String phoneNumber,
                             String webSite, String company, String title) throws InterruptedException {
        pageFactory.getPublicLinksPage().publicLink(publicurl,mail,firstName,lastName,phoneNumber,webSite,company,title);
        pageFactory.getPublicLinksPage().verifyText();
    }
}
