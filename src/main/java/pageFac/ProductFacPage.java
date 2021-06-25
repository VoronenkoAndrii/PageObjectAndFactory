package pageFac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class ProductFacPage extends GeneralPageFacPage {

    @FindBy(xpath = "//h1[@class='product__title']")
    WebElement getTitle;

    @FindBy(xpath = "//span[contains(text(),'Мобильные телефоны')]")
    WebElement mobilePhones;

    @FindBy(css = "input[formcontrolname=min]")
    WebElement minFiled;

    @FindBy(css = "input[formcontrolname=max]")
    WebElement maxFiled;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    WebElement buttonOk;

    @FindBy(css = "span.good-tile__price-value")
    List<WebElement> selectedElems;

    @FindBy(css = "label[for='Apple']")
    WebElement apple;

    @FindBy(css = "label[for='Huawei']")
    WebElement huawei;

    @FindBy(css = "span.goods-tile__title")
    List<WebElement> selectedElemsTitles;

    @FindBy(css = "label[for='Galaxy A']")
    WebElement galaxy;

    @FindBy(css = "input[formcontrolname=max]")
    WebElement findMax;

    public ProductFacPage(WebDriver driver, WebDriverWait wait, Robot robot) {
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

        return getTitle.getText();
    }

    public WebElement findMobilePhones() {
        return mobilePhones;
    }

    public void minFiledClear() {
        minFiled.clear();
    }

    public void minFiledSend(String price) {
        minFiled.sendKeys(price);
    }

    public void maxFiledClear() {

        findMax.clear();
    }

    public void maxFiledSend(String price) {
        maxFiled.sendKeys(price);
    }

    public void pressButtonOk() {
        buttonOk.click();
    }

    public List<WebElement> findAllSelectedElems() {
        return selectedElems;
    }

    public void findAndClickApple() {
        apple.click();
    }

    public void findAndClickHuawei() {
        huawei.click();
    }

    public List<WebElement> findAllSelectedElemsTitles() {
        return selectedElemsTitles;
    }

    public void findAndClickGalaxy() {
        galaxy.click();
    }
}
