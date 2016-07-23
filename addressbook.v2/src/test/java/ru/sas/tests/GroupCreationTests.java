package ru.sas.tests;

import org.testng.annotations.Test;
import ru.sas.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("Group1", "GroupHeader", "GroupFooter"));
    }

}
