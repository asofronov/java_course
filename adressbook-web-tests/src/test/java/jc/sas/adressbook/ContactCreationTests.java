package jc.sas.adressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {
        app.addButton();
        app.fillNamesData(new NamesData("First", "Mid", "Last", "Nickname"));
        app.fillBusinessData(new BusinessData("Address1", "Company", "Title"));
        app.fillPhonesData(new PhonesData("123456", "1234567", "12345678", "123456789"));
        app.fillEmailsData(new EmailsData("test@test.ru", "test2@test.ru", "test3@test.ru"));
        app.fillOtherData(new OtherData("http://ya.ru", "Address2", "Home", "Note"));
        app.confirmation();
        app.backHomePage();
    }

}
