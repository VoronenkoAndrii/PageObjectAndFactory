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
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchBySeriesFac {
    WebDriver driver;
    WebDriverWait wait;
    Robot robot = new Robot();
    private String baseUrl = "https://rozetka.com.ua/";
    HomePageFacPage homePage;
    ProductFacPage productPage;

    public SearchBySeriesFac() throws AWTException {
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
    public void searchFilter() {
        homePage.findByModel("samsung");
        driver.manage().window().maximize();
        homePage.delay();
        productPage.findMobilePhones().click();
        productPage.delay();
        productPage.findAndClickGalaxy();
        productPage.delay();
        List<String> names = getNames(driver);
        for (String name: names){
            assertTrue(name.contains("Galaxy A"));
        }
    }

    public List<String> getNames(WebDriver driver) {
        List<String> names = new ArrayList<>();
        List<WebElement> elementList = productPage.findAllSelectedElemsTitles();
        for (WebElement e : elementList) {
            names.add(e.getText());
        }
        return names;
    }
}