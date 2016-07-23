package ru.sas;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Group1", "GroupHeader", "GroupFooter"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
