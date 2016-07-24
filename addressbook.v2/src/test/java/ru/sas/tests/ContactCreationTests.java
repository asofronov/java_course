package ru.sas.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sas.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContactLink();
        app.getContactHelper().fillContactForm(new ContactData("TestName", "LastName", "222-222-222", "333-333-333", "444-444-444", "test@test.ru"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
