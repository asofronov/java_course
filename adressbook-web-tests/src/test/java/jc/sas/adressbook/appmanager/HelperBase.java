package jc.sas.adressbook.appmanager;

import jc.sas.adressbook.model.NamesData;
import org.openqa.selenium.*;

/**
 * Created by aleks on 05.06.2016.
 */
public class HelperBase {

    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    public void scrollDown(String xpath) {
        WebElement element = wd.findElement(By.xpath(xpath));
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();"
                , element);

    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

}
