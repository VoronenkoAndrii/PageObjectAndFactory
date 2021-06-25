package pageFac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class ComparisonListPageFacPage extends GeneralPageFacPage {


    @FindBy(xpath = "//a[@class='comparison-modal__link']")
    WebElement comparingTwoMonitors;
    @FindBy(xpath = "//div[@class='product__price product__price--red ng-star-inserted']")
    List<WebElement> priceMonitor;
    private final By MonitorsName = (By.xpath("//a[@class='product__heading']"));
    @FindBy(xpath = "//a[@class='product__heading']")
    List<WebElement> monitorsName;

    public ComparisonListPageFacPage(WebDriver driver, WebDriverWait wait, Robot robot) {
        super(driver, wait, robot);
    }

    public void ComparingTwoMonitorsAndClick() {
        comparingTwoMonitors.click();
    }

    public List<WebElement> findMonitorsPrices() {
        return priceMonitor;
    }

    public List<WebElement> ComparingMonitorsName() {
        return monitorsName;
    }
}


