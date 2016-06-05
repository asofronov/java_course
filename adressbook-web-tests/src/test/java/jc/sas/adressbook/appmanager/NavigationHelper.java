package jc.sas.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by aleks on 05.06.2016.
 */
public class NavigationHelper extends HelperBase {
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void openGroup() {
        click(By.linkText("groups"));
    }

    public void backHomePage() {
        click(By.linkText("home page"));
    }

    public void backToGroups() {
        click(By.linkText("group page"));
    }
}
