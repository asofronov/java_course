package ru.sas.tests;

import org.testng.annotations.Test;
import ru.sas.model.ContactData;

public class ContactDeletion extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoContactPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("UTestName", "LastName", "222", "333", "444", "ya@tya.ru"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContactButton();
        app.getContactHelper().submitContactDeletion();
        app.getNavigationHelper().gotoContactPage();
    }

}
