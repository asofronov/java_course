package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactsHelper().getContactList();
        if (!app.getContactsHelper().isThereContact()) {
            app.getContactsHelper().createContact(new NamesData("First", "Mid", "Last", "Nickname"),
                    new BusinessData("Address1", "Company", "Title"),
                    new PhonesData("123456", "1234567", "12345678", "123456789"),
                    new EmailsData("test@test.ru", "test2@test.ru", "test3@test.ru"),
                    new OtherData("http://ya.ru", "Address2", "Home", "Note"));
        }
        List<NamesData> before = app.getContactsHelper().getContactsList();
        app.getContactsHelper().openEditForm(before.size() - 1);
        NamesData names = new NamesData(before.get(before.size() - 1).getId(), "First", "Mid", "Last", "Nickname");
        app.getContactsHelper().fillNamesData(names);
        app.getContactsHelper().fillBusinessData(new BusinessData("Address1", "Company", "Title"));
        app.getContactsHelper().fillPhonesData(new PhonesData("123456", "1234567", "12345678", "123456789"));
        app.getContactsHelper().fillEmailsData(new EmailsData("test@test.ru", "test2@test.ru", "test3@test.ru"));
        app.getContactsHelper().fillOtherData(new OtherData("http://ya.ru", "Address2", "Home", "Note"));
        app.getContactsHelper().submitContactUpdate();
        app.getNavigationHelper().backHomePage();
        List<NamesData> after = app.getContactsHelper().getContactsList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(names);

        Comparator<? super NamesData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }
}
