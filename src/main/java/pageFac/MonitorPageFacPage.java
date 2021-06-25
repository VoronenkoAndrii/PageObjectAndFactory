package pageFac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class MonitorPageFacPage extends GeneralPageFacPage {

    @FindBy(xpath = "//button[@class='compare-button ng-star-inserted']")
    WebElement addMonitorToCompare;

    @FindBy(xpath = "//button[@aria-label='Списки сравнения']")
    WebElement comparisonList;

    public MonitorPageFacPage(WebDriver driver, WebDriverWait wait, Robot robot) {
        super(driver, wait, robot);
    }

    public void addMonitorToCompareAndClick() {
        addMonitorToCompare.click();
    }

    public void ComparisonListAndClick() {
        comparisonList.click();
    }
}
