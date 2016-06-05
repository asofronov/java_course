package jc.sas.adressbook.appmanager;

import jc.sas.adressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by aleks on 05.06.2016.
 */
public class GroupHelper {

    private FirefoxDriver wd;

    public GroupHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void submit() {
        wd.findElement(By.name("submit")).click();
    }

    public void createGroup() {
        wd.findElement(By.name("new")).click();
    }

    public void fillGroupData(GroupData groupData) {
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    }
}
