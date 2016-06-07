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
        app.getGroupHelper().chooseGroupPosition("1");
        app.getGroupHelper().clickEdit();
        app.getGroupHelper().fillGroupData(new GroupData("UpdatedFooter", "UpdatedHeader", "UpdatedTitleGroup"));
        app.getGroupHelper().submitUpdateGroup();
        app.getNavigationHelper().backToGroups();

    }
}
