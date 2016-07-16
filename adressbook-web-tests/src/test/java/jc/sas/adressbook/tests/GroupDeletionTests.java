package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import jc.sas.adressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        app.goTo().groupPageBack();
        Groups after = app.group().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        assertThat(after,
                equalTo(before.without(deletedGroup)));
    }
}
