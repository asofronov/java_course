package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().openGroup();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().createGroupButton();
        GroupData group = new GroupData("test1", "test2", "test3");
        app.getGroupHelper().fillGroupData(group);
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().backToGroups();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);


        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }


}
