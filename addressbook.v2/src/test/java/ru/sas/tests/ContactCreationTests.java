package ru.sas.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sas.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().createContactLink();
        app.getContactHelper().fillContactForm(new ContactData("TestName", "LastName", "222-222-222", "333-333-333", "444-444-444", "test@test.ru"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }

}
