import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SamsungMinMax {
    WebDriver driver;
    WebDriverWait wait;
    Robot robot = new Robot();
    private String baseUrl = "https://rozetka.com.ua/";
    HomePage homePage;
    ProductPage productPage;


    public SamsungMinMax() throws AWTException {
    }


    @BeforeClass
    public void actionBeforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        homePage = new HomePage(driver, wait, robot);
        productPage = new ProductPage(driver, wait, robot);

    }

    @AfterClass
    public void closeChrome() {
        driver.quit();
    }

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(baseUrl);
    }

    @Test
    public void searchPrice() {
        homePage.findByModel("samsung");
        driver.manage().window().maximize();
        homePage.delay();
        productPage.findMobilePhones().click();
        productPage.minFiledClear();
        productPage.minFiledSend("5000");
        productPage.maxFiledClear();
        productPage.maxFiledSend("15000");
        productPage.pressButtonOk();
        productPage.delay();
        List<WebElement> elementList = productPage.findAllSelectedElems();
        for (WebElement element : elementList) {
            int goodPrice = Integer.parseInt(element.getText().replaceAll("&nbsp", "").replaceAll(" ", ""));
            assertTrue(goodPrice > 5000 && goodPrice < 15000);
        }
    }
}