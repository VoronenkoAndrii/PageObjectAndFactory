package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class ProductCatalogPage extends GeneralPage {

    private final By getMonitorAndClick= By.linkText("Мониторы");

    public ProductCatalogPage(WebDriver driver, WebDriverWait wait, Robot robot) {
        super(driver, wait, robot);
    }

    public void findMonitorAndClick(){
        getElement(getMonitorAndClick).click();
    }
}
