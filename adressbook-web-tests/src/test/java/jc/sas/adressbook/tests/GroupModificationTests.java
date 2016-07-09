package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void executePreconditions() {
        app.goTo().groupPage();
        if (app.group().List().size() == 0) {
            app.group().create(new GroupData().withName("test").withHeader("test2").withFooter("test3"));
        }
    }

    @Test
    public void testGroupModification() {
        List<GroupData> before = app.group().List();
        GroupData group = new GroupData().withId(before.get(before.size() - 1).getId()).withName("utest1").withHeader("utest2").withFooter("utest3");
        int index = before.size() - 1;
        app.group().modify(group, index);
        app.goTo().groupPageBack();
        List<GroupData> after = app.group().List();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
