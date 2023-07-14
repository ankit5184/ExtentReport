package Test;

import org.testng.annotations.Test;

public class IntegrationsPageTest extends BaseTest {
    @Test(dataProvider = "IntegrationPageTestData")
    public void Integrations(String homepageUrl,String integrationPageUrl, String mail, String firstname,
                             String lastname, String company, String phoneNumber, String review){
        pageFactory.getIntegrationPage().integration(homepageUrl,integrationPageUrl,
                mail,firstname,lastname,company,phoneNumber,review);
        pageFactory.getIntegrationPage().verifyText();

    }
}
