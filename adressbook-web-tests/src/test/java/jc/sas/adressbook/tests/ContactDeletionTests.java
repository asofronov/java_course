package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void executePreconditions() {
        app.contact().listPage();
        if (app.contact().List().size() == 0) {
            app.contact().create(new NamesData("First", "Mid", "Last", "Nickname"),
                    new BusinessData("Address1", "Company", "Title"),
                    new PhonesData("123456", "1234567", "12345678", "123456789"),
                    new EmailsData("test@test.ru", "test2@test.ru", "test3@test.ru"),
                    new OtherData("http://ya.ru", "Address2", "Home", "Note"));
        }
    }

    @Test
    public void testContactDeletion() {
        List<NamesData> before = app.contact().List();
        int index = before.size() - 1;
        app.contact().select(index);
        app.contact().scrollToDelete();
        app.contact().deleteButton();
        app.contact().confirmDeletion();
        app.contact().listPage();
        List<NamesData> after = app.contact().List();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);

    }
}
