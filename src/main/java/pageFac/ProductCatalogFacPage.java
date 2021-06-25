package pageFac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class ProductCatalogFacPage extends GeneralPageFacPage {

    @FindBy(linkText = "Мониторы")
    WebElement getMonitorAndClick;

    public ProductCatalogFacPage(WebDriver driver, WebDriverWait wait, Robot robot) {
        super(driver, wait, robot);
    }

    public void findMonitorAndClick() {
        getMonitorAndClick.click();
    }
}
