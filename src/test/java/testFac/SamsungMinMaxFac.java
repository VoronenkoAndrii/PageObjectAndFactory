package testFac;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFac.HomePageFacPage;
import pageFac.ProductFacPage;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SamsungMinMaxFac {
    WebDriver driver;
    WebDriverWait wait;
    final int waitTime = 500;
    Robot robot = new Robot();
    private String baseUrl = "https://rozetka.com.ua/";
    HomePageFacPage homePage;
    ProductFacPage productPage;


    public SamsungMinMaxFac() throws AWTException {
    }


    @BeforeClass
    public void actionBeforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        homePage = new HomePageFacPage(driver, wait, robot);
        productPage = new ProductFacPage(driver, wait, robot);

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
        robot.delay(waitTime);
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