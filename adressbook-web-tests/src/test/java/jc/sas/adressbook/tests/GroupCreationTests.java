package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroups() {
        app.openGroup();
        app.getGroupHelper().createGroup();
        app.getGroupHelper().fillGroupData(new GroupData("TestFooter", "TestHeader", "testGroup"));
        app.getGroupHelper().submitGroupCreation();
        app.backToGroups();
    }


}
