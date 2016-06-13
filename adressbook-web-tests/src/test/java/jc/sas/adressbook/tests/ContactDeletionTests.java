package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.*;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getContactsHelper().getContactList();
        if (!app.getContactsHelper().isThereContact()) {
            app.getContactsHelper().createContact(new NamesData("First", "Mid", "Last", "Nickname"),
                    new BusinessData("Address1", "Company", "Title"),
                    new PhonesData("123456", "1234567", "12345678", "123456789"),
                    new EmailsData("test@test.ru", "test2@test.ru", "test3@test.ru"),
                    new OtherData("http://ya.ru", "Address2", "Home", "Note"));
        }
        app.getContactsHelper().chooseContact();
        app.getContactsHelper().submitContactDeletion();
        app.getContactsHelper().dialogConfirmDeletion();
    }
}
