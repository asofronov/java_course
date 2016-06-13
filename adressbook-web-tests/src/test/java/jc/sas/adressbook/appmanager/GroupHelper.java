package jc.sas.adressbook.appmanager;

import jc.sas.adressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by aleks on 05.06.2016.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void createGroup() {
        click(By.name("new"));
    }

    public void fillGroupData(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void chooseGroupPosition(String position) {
        click(By.xpath("//div[@id='content']/form/span["+ position + "]/input"));
    }

    public void clickEdit() {
        click(By.name("edit"));
    }


    public void submitUpdateGroup() {
        click(By.name("update"));
    }

    public void submitGroupDeletion() {
        click(By.name("delete"));
    }
}
