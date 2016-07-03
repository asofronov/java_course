package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().openGroup();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroupProccess(new GroupData("TestFooter", "TestHeader", "testGroup"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().chooseGroup();
        app.getGroupHelper().clickEdit();
        app.getGroupHelper().fillGroupData(new GroupData("UpdatedFooter", "UpdatedHeader", "UpdatedTitleGroup"));
        app.getGroupHelper().submitUpdateGroup();
        app.getNavigationHelper().backToGroups();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }
}
