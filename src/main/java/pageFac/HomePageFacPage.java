package pageFac;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class HomePageFacPage extends GeneralPageFacPage {

    @FindBy(xpath = "//input[@name='search']")
    WebElement modelFounded;

    @FindBy(linkText = "Ноутбуки и компьютеры")

    WebElement notesAndComp;

    private final By getByNotesAndComp = By.linkText("Ноутбуки и компьютеры");

    public HomePageFacPage(WebDriver driver, WebDriverWait wait, Robot robot) {
        super(driver, wait, robot);
    }

    public void findÀndClickByNotesAndComp() {
        notesAndComp.click();
    }


    public void findByModel(String model) {
        modelFounded.sendKeys(model + Keys.ENTER);
    }

}
