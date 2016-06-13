package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.*;
import org.testng.annotations.Test;

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
        app.getContactsHelper().openEditForm("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img");
        app.getContactsHelper().fillNamesData(new NamesData("First", "Mid", "Last", "Nickname"));
        app.getContactsHelper().fillBusinessData(new BusinessData("Address1", "Company", "Title"));
        app.getContactsHelper().fillPhonesData(new PhonesData("123456", "1234567", "12345678", "123456789"));
        app.getContactsHelper().fillEmailsData(new EmailsData("test@test.ru", "test2@test.ru", "test3@test.ru"));
        app.getContactsHelper().fillOtherData(new OtherData("http://ya.ru", "Address2", "Home", "Note"));
        app.getContactsHelper().submitContactUpdate();
        app.getNavigationHelper().backHomePage();

    }
}
