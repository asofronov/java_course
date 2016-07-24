package ru.sas.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sas.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupData("Group1", "GroupHeader", "GroupFooter"));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);

    }


}
