package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class ProductPage extends GeneralPage {
    private final By getTitle = (By.xpath("//h1[@class='product__title']"));
    private final By mobilePhones = (By.xpath("//span[contains(text(),'Мобильные телефоны')]"));
    private final By minFiled = (By.cssSelector("input[formcontrolname=min]"));
    private final By maxFiled = (By.cssSelector("input[formcontrolname=max]"));
    private final By buttonOk = (By.xpath("(//button[@type='submit'])[1]"));
    private final By selectedElems = (By.cssSelector("span.good-tile__price-value"));
    private final By apple = (By.cssSelector("label[for='Apple']"));
    private final By huawei =  (By.cssSelector("label[for='Huawei']"));
    private final By selectedElemsTitles =(By.cssSelector("span.goods-tile__title"));
    private final By galaxy = (By.cssSelector("label[for='Galaxy A']"));

    public ProductPage(WebDriver driver, WebDriverWait wait, Robot robot) {
        super(driver, wait, robot);
    }

    public Integer findElemetPrice(int price) {
        List<WebElement> elementList = driver.findElements(By.cssSelector("span.goods-tile__price-value"));
        int counter = 1;
        for (WebElement e : elementList) {
            int currPrice = Integer.parseInt(e.getText().replace("&nbsp", "").replaceAll(" ", ""));
            if (currPrice < price) {
                driver.findElement(By.xpath("(//span[@class='goods-tile__price-value']//preceding::a[2])" + "[" + counter + "]")).click();
                return currPrice;
            }
            counter++;
        }
        return null;
    }

    public String getTextTitle() {
        return getElement(getTitle).getText();
    }

    public WebElement findMobilePhones() {
        return driver.findElement(mobilePhones);
    }

    public void minFiledClear() {
        getElement(minFiled).clear();
    }

    public void minFiledSend(String price) {
        driver.findElement(minFiled).sendKeys(price);
    }

    public void maxFiledClear() {
        getElement(maxFiled).clear();
    }

    public void maxFiledSend(String price) {
        driver.findElement(maxFiled).sendKeys(price);
    }
    public void pressButtonOk(){
        getElement(buttonOk).click();
    }

    public List<WebElement> findAllSelectedElems(){
        return driver.findElements(selectedElems);
    }

    public void findAndClickApple(){
        driver.findElement(apple).click();
    }

    public void findAndClickHuawei(){
        driver.findElement(huawei).click();
    }

    public List<WebElement> findAllSelectedElemsTitles(){
        return driver.findElements(selectedElemsTitles);
    }

    public void findAndClickGalaxy(){ driver.findElement(galaxy).click();}
}
