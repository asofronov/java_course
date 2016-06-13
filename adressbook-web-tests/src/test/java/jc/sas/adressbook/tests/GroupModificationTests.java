package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by aleks on 07.06.2016.
 */
public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().openGroup();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroupProccess(new GroupData("TestFooter", "TestHeader", "testGroup"));
        }
        app.getGroupHelper().chooseGroup();
        app.getGroupHelper().clickEdit();
        app.getGroupHelper().fillGroupData(new GroupData("UpdatedFooter", "UpdatedHeader", "UpdatedTitleGroup"));
        app.getGroupHelper().submitUpdateGroup();
        app.getNavigationHelper().backToGroups();
    }
}
