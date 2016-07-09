package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationContact() {
        app.contact().listPage();
        List<NamesData> before = app.contact().List();
        NamesData names = new NamesData("First", "Mid", "Last", "Nickname");
        BusinessData bdata = new BusinessData("Address1", "Company", "Title");
        PhonesData phones = new PhonesData("123456", "1234567", "12345678", "123456789");
        EmailsData mails = new EmailsData("test@test.ru", "test2@test.ru", "test3@test.ru");
        OtherData other = new OtherData("http://ya.ru", "Address2", "Home", "Note");
        app.contact().create(names, bdata, phones, mails, other);
        app.goTo().contactPageBack();
        List<NamesData> after = app.contact().List();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(names);
        Comparator<? super NamesData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
