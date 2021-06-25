package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class HomePage extends GeneralPage{

    private final By getByNotesAndComp= By.linkText("Ноутбуки и компьютеры");
    private final By searchField = (By.xpath("//input[@name='search']"));

    public HomePage(WebDriver driver, WebDriverWait wait, Robot robot) {
        super(driver, wait, robot);
    }

    public void findÀndClickByNotesAndComp(){
        getElement(getByNotesAndComp).click();
    }


    public void findByModel(String model){
        driver.findElement(searchField).sendKeys(model + Keys.ENTER);
    }

}
