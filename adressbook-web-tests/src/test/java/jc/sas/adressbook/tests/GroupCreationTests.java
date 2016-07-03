package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().openGroup();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroupButton();
        app.getGroupHelper().fillGroupData(new GroupData("TestFooter", "TestHeader", "testGroup"));
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().backToGroups();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }


}
