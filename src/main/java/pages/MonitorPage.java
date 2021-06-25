package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class MonitorPage extends GeneralPage{

    private final By addMonitorToCompare =(By.xpath("//button[@class='compare-button ng-star-inserted']"));
    private final By ComparisonList = (By.xpath("//button[@aria-label='Списки сравнения']"));
    public MonitorPage(WebDriver driver, WebDriverWait wait, Robot robot) {
        super(driver, wait, robot);
    }
    public void addMonitorToCompareAndClick(){
        getElement(addMonitorToCompare).click();
    }
    public void ComparisonListAndClick(){
        getElement(ComparisonList).click();
    }
}
