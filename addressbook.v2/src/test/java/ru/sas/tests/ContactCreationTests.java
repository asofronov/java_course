package ru.sas.tests;

import org.testng.annotations.Test;
import ru.sas.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().createContactLink();
        app.getContactHelper().fillContactForm(new ContactData("TestName", "LastName", "222-222-222", "333-333-333", "444-444-444", "test@test.ru", null));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
    }

}
