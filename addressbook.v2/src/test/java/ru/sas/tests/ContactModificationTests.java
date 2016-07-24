package ru.sas.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sas.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("FirsttName", "LastName", "222", "333", "444", "ya@tya.ru"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(before.size()-1);
        ContactData modifiedContact = new ContactData(before.get(before.size()-1).getId(),"UFName","ULname","1111","222","333","ya@ya.ru");
        app.getContactHelper().fillContactForm(modifiedContact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1);
        before.add(modifiedContact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
