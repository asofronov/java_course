package jc.sas.adressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by aleks on 07.06.2016.
 */
public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().openGroup();
        app.getGroupHelper().chooseGroupPosition("1");
        app.getGroupHelper().submitGroupDeletion();
        app.getNavigationHelper().backToGroups();
    }
}
