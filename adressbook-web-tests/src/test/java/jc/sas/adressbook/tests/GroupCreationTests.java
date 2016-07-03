package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().openGroup();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().createGroupButton();
        app.getGroupHelper().fillGroupData(new GroupData("TestFooter", "TestHeader", "testGroup"));
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().backToGroups();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }


}
