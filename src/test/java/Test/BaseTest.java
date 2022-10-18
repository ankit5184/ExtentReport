package Test;

import Pages.PageFactory;
import ReadExcelData.ExcelDataConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.io.IOException;
import static Configuration.Listeners.screenRecorder;

public class BaseTest {

    static WebDriver driver;
    protected PageFactory pageFactory;

    @Parameters("browserName")
    @BeforeClass
    public void setUp(String browserName) throws IOException {

        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            pageFactory=new PageFactory(driver);
//            screenRecorder.start();
        }
        else if(browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            pageFactory=new PageFactory(driver);
            screenRecorder.start();
        }
    }

    public static WebDriver getDrivers() {
        return driver;
    }

    @AfterClass
    public void tearDown() throws IOException {
        driver.quit();
//        screenRecorder.stop();
    }

    @DataProvider(name = "WebsiteLoginData")
    public Object[][] passData() throws IOException {
        String excelSheetPath = System.getProperty("user.dir");
        ExcelDataConfig config = new ExcelDataConfig(excelSheetPath+"//TestData//TestExceldata.xls");
        int rows = config.getRowCount(1);
        int cols = config.getCellCount(1,1);
        String[][] data = new String[rows][cols];
        for(int i=1;i<=rows;i++){
            for(int j=0; j<cols; j++) {
                data[i-1][j] = config.getData(1, i, j);
            }
        }
        return data;
    }

    @DataProvider(name = "AddUserData")
    public Object[][] passDataForUers() throws IOException {
        String excelSheetPath = System.getProperty("user.dir");
        ExcelDataConfig config = new ExcelDataConfig(excelSheetPath+"//TestData//TestExceldata.xls");
        int rows = config.getRowCount(0);
        int cols = config.getCellCount(0,1);
        String[][] data = new String[rows][cols];
        for(int i=1;i<=rows;i++){
            for(int j=0; j<cols; j++) {
                data[i-1][j] = config.getData(0, i, j);
            }
        }
        return data;
    }
}