package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void executePreconditions() {
        app.contact().listPage();
        if (!app.contact().isThereContact()) {
            app.contact().create(new NamesData().withFName("First").withMName("Mid").withLName("Last").withNName("Nickname"),
                    new BusinessData().withAddress1("Address1").withCompany("Company").withTitle("Title"),
                    new PhonesData().withPhone1("1234").withMobPhone("12345").withWorkPhone("123456").withFax("1234567"),
                    new EmailsData().withEmail1("test@test.ru").withEmail2("test2@test.ru").withEmail3("test3@test.ru"),
                    new OtherData().withWebsite("http://ya.ru").withAddress2("Address2").withHomePhone2("Home").withNoteText("Note"));
        }
    }

    @Test
    public void testContactPhones() {
    app.goTo().homePage();
        Contacts before = app.contact().all();
        NamesData modifiedContact = before.iterator().next();
    }
}
