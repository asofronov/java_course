package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void executePreconditions() {
        app.getNavigationHelper().openGroup();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroupProccess(new GroupData("test1", "test2", "test3"));
        }
    }

    @Test
    public void testGroupModification() {
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData(before.get(before.size() - 1).getId(), "test", "test", "test");
        int index = before.size() - 1;
        app.getGroupHelper().modifyGroup(group, index);
        app.getNavigationHelper().backToGroups();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
