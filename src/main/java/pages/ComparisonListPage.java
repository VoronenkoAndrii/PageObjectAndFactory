package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class ComparisonListPage extends GeneralPage {

    private final By ComparingTwoMonitors = (By.xpath("//a[@class='comparison-modal__link']"));
    private final By PriceMonitor = (By.xpath("//div[@class='product__price product__price--red ng-star-inserted']"));
    private final By MonitorsName = (By.xpath("//a[@class='product__heading']"));
    public ComparisonListPage(WebDriver driver, WebDriverWait wait, Robot robot) {
        super(driver, wait, robot);
    }
public void ComparingTwoMonitorsAndClick(){
        getElement(ComparingTwoMonitors).click();
}
    public List<WebElement> findMonitorsPrices(){
        return getElementList(PriceMonitor);
    }

    public  List<WebElement> ComparingMonitorsName(){
        return getElementList(MonitorsName);
    }
}
