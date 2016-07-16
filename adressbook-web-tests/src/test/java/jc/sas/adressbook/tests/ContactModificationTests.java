package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

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
    public void testContactModification() {
        Contacts before = app.contact().all();
        NamesData modifiedContact = before.iterator().next();
        NamesData names = new NamesData().withId(modifiedContact.getId()).withFName("UFirst").withMName("UMid").withLName("ULast").withNName("UNickname");
        BusinessData bdata = new BusinessData().withAddress1("UAddress1").withCompany("UCompany").withTitle("UTitle");
        PhonesData phones = new PhonesData().withPhone1("123456").withMobPhone("1234567").withWorkPhone("12345678").withFax("123456789");
        EmailsData mails = new EmailsData().withEmail1("test@test.ru").withEmail2("test2@test.ru").withEmail3("test3@test.ru");
        OtherData other = new OtherData().withWebsite("http://ya1.ru").withAddress2("UAddress2").withHomePhone2("UHome").withNoteText("UNote");
        app.contact().chooseForEdit(modifiedContact.getId());
        app.contact().modify(names, bdata, phones, mails, other);
        app.goTo().contactPageBack();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(names)));


    }
}
