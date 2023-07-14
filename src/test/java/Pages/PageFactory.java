package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;

    private IntegrationsPage integrationPage;
    private PublicLinksPage publicLinksPage;
    private SanBoxPage sanBoxPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public IntegrationsPage getIntegrationPage(){
        if(integrationPage == null){
            integrationPage = new IntegrationsPage(driver);
        }
        return integrationPage;
    }

    public PublicLinksPage getPublicLinksPage() {
        if (publicLinksPage == null) {
            publicLinksPage = new PublicLinksPage(driver);
        }
        return publicLinksPage;
    }

    public SanBoxPage getSanBoxPage() {
        if (sanBoxPage == null) {
            sanBoxPage = new SanBoxPage(driver);
        }
        return sanBoxPage;
    }
}
