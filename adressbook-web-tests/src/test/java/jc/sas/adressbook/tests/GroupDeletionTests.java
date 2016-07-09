package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void executePreconditions() {
        app.getNavigationHelper().openGroup();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroupProccess(new GroupData("test1", "test2", "test3"));
        }
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.getGroupHelper().getGroupList();
        int index = before.size() - 1;
        app.getGroupHelper().chooseGroup(index);
        app.getGroupHelper().submitGroupDeletion();
        app.getNavigationHelper().backToGroups();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);

    }
}
