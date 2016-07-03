package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().openGroup();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroupProccess(new GroupData("TestFooter", "TestHeader", "testGroup"));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().chooseGroup();
        app.getGroupHelper().clickEdit();
        app.getGroupHelper().fillGroupData(new GroupData("UpdatedFooter", "UpdatedHeader", "UpdatedTitleGroup"));
        app.getGroupHelper().submitUpdateGroup();
        app.getNavigationHelper().backToGroups();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
