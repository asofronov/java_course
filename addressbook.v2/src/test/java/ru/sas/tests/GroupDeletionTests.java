package ru.sas.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sas.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("GroupName", "GroupHeader", "GroupFooter"));
        }
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.getGroupHelper().getGroupList();
        int index = before.size() - 1;
        app.getGroupHelper().selectGroup(index);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
