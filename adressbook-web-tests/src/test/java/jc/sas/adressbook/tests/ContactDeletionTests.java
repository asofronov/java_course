package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void executePreconditions() {
        app.getContactsHelper().getContactList();
        if (!app.getContactsHelper().isThereContact()) {
            app.getContactsHelper().createContact(new NamesData("First", "Mid", "Last", "Nickname"),
                    new BusinessData("Address1", "Company", "Title"),
                    new PhonesData("123456", "1234567", "12345678", "123456789"),
                    new EmailsData("test@test.ru", "test2@test.ru", "test3@test.ru"),
                    new OtherData("http://ya.ru", "Address2", "Home", "Note"));
        }
    }

    @Test
    public void testContactDeletion() {
        List<NamesData> before = app.getContactsHelper().getContactsList();
        int index = before.size() - 1;
        app.getContactsHelper().chooseContact(index);
        app.getContactsHelper().scrollToDeletion();
        app.getContactsHelper().submitContactDeletion();
        app.getContactsHelper().dialogConfirmDeletion();
        app.getContactsHelper().getContactList();
        List<NamesData> after = app.getContactsHelper().getContactsList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);

    }
}
