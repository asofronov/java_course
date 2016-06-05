package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.*;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {
        app.getContactsHelper().addButton();
        app.getContactsHelper().fillNamesData(new NamesData("First", "Mid", "Last", "Nickname"));
        app.getContactsHelper().fillBusinessData(new BusinessData("Address1", "Company", "Title"));
        app.getContactsHelper().fillPhonesData(new PhonesData("123456", "1234567", "12345678", "123456789"));
        app.getContactsHelper().fillEmailsData(new EmailsData("test@test.ru", "test2@test.ru", "test3@test.ru"));
        app.getContactsHelper().fillOtherData(new OtherData("http://ya.ru", "Address2", "Home", "Note"));
        app.getContactsHelper().submitContactCreation();
        app.getNavigationHelper().backHomePage();
    }

}
