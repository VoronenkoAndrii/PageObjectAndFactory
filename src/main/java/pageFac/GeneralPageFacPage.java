package pageFac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class GeneralPageFacPage {
    final int waitTime = 500;

    WebDriver driver;
    WebDriverWait wait;
    WebElement element;
    Robot robot;

    public GeneralPageFacPage(WebDriver driver, WebDriverWait wait, Robot robot) {
        this.driver = driver;
        this.wait = wait;
        this.robot = robot;
        PageFactory.initElements(driver, this);
    }

    public void delay() {
        robot.delay(waitTime);
    }

    protected List<WebElement> getElementList(By pageElement) {
        return driver.findElements(pageElement);
    }

    protected WebElement getElement(By pageElement) {
        return element = driver.findElement(pageElement);
    }

}

