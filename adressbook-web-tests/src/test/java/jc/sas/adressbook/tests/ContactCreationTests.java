package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.*;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationContact() {
        app.contact().listPage();
        Contacts before = app.contact().all();
        NamesData names = new NamesData().withFName("First").withMName("Mid").withLName("Last").withNName("Nick");
        BusinessData bdata = new BusinessData().withAddress1("UAddress1").withCompany("UCompany").withTitle("UTitle");
        PhonesData phones = new PhonesData().withPhone1("1234567").withMobPhone("12345678").withWorkPhone("123456789").withFax("1234567890");
        EmailsData mails = new EmailsData().withEmail1("test@test.ru").withEmail2("test2@test.ru").withEmail3("test3@test.ru");
        OtherData other = new OtherData().withWebsite("http://ya.ru").withAddress2("Address2").withHomePhone2("Home").withNoteText("Note");
        app.contact().create(names, bdata, phones, mails, other);
        app.goTo().contactPageBack();

        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() + 1);
        assertThat(after,
                equalTo(before.withAdded(names.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }


}
