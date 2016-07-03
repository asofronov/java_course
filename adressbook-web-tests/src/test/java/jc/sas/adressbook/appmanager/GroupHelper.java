package jc.sas.adressbook.appmanager;

import jc.sas.adressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void createGroupButton() {
        click(By.name("new"));
    }

    public void fillGroupData(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void chooseGroup() {
        click(By.name("selected[]"));
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

    public void createGroupProccess(GroupData group) {
        createGroupButton();
        fillGroupData(group);
        submitGroupCreation();
        NavigationHelper navigation = new NavigationHelper(wd);
        navigation.backToGroups();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();

    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            GroupData group = new GroupData(name, null, null);
            groups.add(group);
        }
        return groups;
    }
}
