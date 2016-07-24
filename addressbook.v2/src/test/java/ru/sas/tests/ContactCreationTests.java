package ru.sas.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sas.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContactLink();
        ContactData contact = new ContactData("TestName", "LastName", "222-222-222", "333-333-333", "444-444-444", "test@test.ru");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
