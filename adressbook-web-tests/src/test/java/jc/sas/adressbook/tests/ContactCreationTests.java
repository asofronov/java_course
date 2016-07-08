package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationContact() {
        app.getContactsHelper().getContactList();
        List<NamesData> before = app.getContactsHelper().getContactsList();
        app.getContactsHelper().addButton();
        NamesData names = new NamesData("First", "Mid", "Last", "Nickname");
        app.getContactsHelper().fillNamesData(names);
        app.getContactsHelper().fillBusinessData(new BusinessData("Address1", "Company", "Title"));
        app.getContactsHelper().fillPhonesData(new PhonesData("123456", "1234567", "12345678", "123456789"));
        app.getContactsHelper().fillEmailsData(new EmailsData("test@test.ru", "test2@test.ru", "test3@test.ru"));
        app.getContactsHelper().fillOtherData(new OtherData("http://ya.ru", "Address2", "Home", "Note"));
        app.getContactsHelper().submitContactCreation();
        app.getNavigationHelper().backHomePage();
        List<NamesData> after = app.getContactsHelper().getContactsList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(names);
        int max = 0;
        for (NamesData n : after) {
            if(n.getId() > max) {
                max = n.getId();
            }
        }
        names.setId(max);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }



}
