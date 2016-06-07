package jc.sas.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by aleks on 05.06.2016.
 */
public class HelperBase {

    protected FirefoxDriver wd;

    public HelperBase(FirefoxDriver wd) {
        this.wd = wd;
    }

    protected void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    public void scrollDown(String xpath) {
        WebElement element = wd.findElement(By.xpath(xpath));
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();"
                , element);

    }

}
