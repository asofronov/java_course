package jc.sas.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by aleks on 05.06.2016.
 */
public class NavigationHelper {
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void openGroup() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void backHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void backToGroups() {
        wd.findElement(By.linkText("group page")).click();
    }
}
