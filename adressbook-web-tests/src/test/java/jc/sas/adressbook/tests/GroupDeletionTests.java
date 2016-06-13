package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().openGroup();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroupProccess(new GroupData("TestFooter", "TestHeader", "testGroup"));
        }
        app.getGroupHelper().chooseGroup();
        app.getGroupHelper().submitGroupDeletion();
        app.getNavigationHelper().backToGroups();
    }
}
