package jc.sas.adressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroups() {
        app.openGroup();
        app.createGroup();
        app.fillGroupData(new GroupData("TestFooter", "TestHeader", "testGroup"));
        app.submit();
        app.backToGroups();
    }


}
