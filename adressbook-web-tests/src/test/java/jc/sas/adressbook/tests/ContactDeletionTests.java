package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void executePreconditions() {
        app.contact().listPage();
        if (app.contact().List().size() == 0) {
            app.contact().create(new NamesData().withFName("First").withMName("Mid").withLName("Last").withNName("Nickname"),
                    new BusinessData().withAddress1("UAddress1").withCompany("UCompany").withTitle("UTitle"),
                    new PhonesData().withPhone1("1234567").withMobPhone("12345678").withWorkPhone("123456789").withFax("1234567890"),
                    new EmailsData().withEmail1("test@test.ru").withEmail2("test2@test.ru").withEmail3("test3@test.ru"),
                    new OtherData().withWebsite("http://ya.ru").withAddress2("Address2").withHomePhone2("Home").withNoteText("Note"));
        }
    }

    @Test
    public void testContactDeletion() {
        Set<NamesData> before = app.contact().all();
        NamesData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<NamesData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);

    }
}
