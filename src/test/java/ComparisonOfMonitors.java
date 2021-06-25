import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ComparisonOfMonitors {
    WebDriver driver;
    WebDriverWait wait;
    Robot robot;

    HomePage homePage;
    ProductCatalogPage productCatalogPage;
    ProductPage productPage;
    MonitorPage monitorPage;
    ComparisonListPage comparisonListPage;
    private String baseUrl = "https://rozetka.com.ua/";

    public ComparisonOfMonitors() throws AWTException {
    }

    @BeforeClass
    public void actionBeforeTest() throws AWTException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        robot = new Robot();
        homePage = new HomePage(driver, wait, robot);
        productCatalogPage = new ProductCatalogPage(driver, wait, robot);
        productPage = new ProductPage(driver, wait, robot);
        monitorPage = new MonitorPage(driver, wait, robot);
        comparisonListPage = new ComparisonListPage(driver, wait, robot);
    }

    @AfterClass
    public void closeChrome() {
        driver.quit();
    }

    @BeforeMethod
    public void navigateToUrl(){driver.get(baseUrl);}
    @Test
    public void comparison() {

        homePage.findÀndClickByNotesAndComp();
        homePage.delay();
        productCatalogPage.findMonitorAndClick();
        homePage.delay();

        Integer firstMonitorPrice = productPage.findElemetPrice(4000);
        productPage.delay();
        String firstTitle = productPage.getTextTitle();
        monitorPage.addMonitorToCompareAndClick();
        monitorPage.delay();
        driver.navigate().back();
        Integer secondMonitorPrice = productPage.findElemetPrice(firstMonitorPrice);
        monitorPage.delay();
        String secondTitle = productPage.getTextTitle();
        monitorPage.addMonitorToCompareAndClick();
        monitorPage.delay();
        monitorPage.ComparisonListAndClick();
        monitorPage.delay();
        comparisonListPage.ComparingTwoMonitorsAndClick();
        comparisonListPage.delay();

        List<WebElement> selectedPrices = comparisonListPage.findMonitorsPrices();
        System.out.println("selectedPrices size = " + selectedPrices.size());
        assertTrue(selectedPrices.size() == 2);
        for (WebElement e : selectedPrices) {
            int currentPrice = parsePrice(e.getText());
            System.out.println("currentPrice = " + currentPrice);
            assertTrue(currentPrice == firstMonitorPrice || currentPrice == secondMonitorPrice);
        }

        List<WebElement> selectedTitles = comparisonListPage.ComparingMonitorsName();
        System.out.println("selectedTitles size = " + selectedTitles.size());
        for (WebElement e : selectedTitles) {
            String currentTitle = e.getText();
            System.out.println("currentTitle = " + currentTitle);
            assertTrue(currentTitle.equals(firstTitle) || currentTitle.equals(secondTitle));
        }
    }

    private int parsePrice(String text) {
        String[] prices = text.replaceAll("\\s", "").split("₴");
        return Integer.parseInt(prices[1]);
    }

}
