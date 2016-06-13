package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().openGroup();
        app.getGroupHelper().createGroupProccess(new GroupData("TestFooter", "TestHeader", "testGroup"));
    }
}
