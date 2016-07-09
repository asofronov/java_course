package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void executePreconditions() {
        app.goTo().groupPage();
        if (app.group().List().size() == 0) {
            app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
        }
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.group().List();
        int index = before.size() - 1;
        app.group().select(index);
        app.group().confirmDeletion();
        app.goTo().groupPageBack();
        List<GroupData> after = app.group().List();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);

    }
}
