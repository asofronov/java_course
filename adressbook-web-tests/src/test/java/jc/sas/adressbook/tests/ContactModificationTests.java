package jc.sas.adressbook.tests;

import jc.sas.adressbook.model.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void executePreconditions() {
        app.contact().listPage();
        if (!app.contact().isThereContact()) {
            app.contact().create(new NamesData("First", "Mid", "Last", "Nickname"),
                    new BusinessData("Address1", "Company", "Title"),
                    new PhonesData("123456", "1234567", "12345678", "123456789"),
                    new EmailsData("test@test.ru", "test2@test.ru", "test3@test.ru"),
                    new OtherData("http://ya.ru", "Address2", "Home", "Note"));
        }
    }

    @Test
    public void testContactModification() {
        List<NamesData> before = app.contact().List();
        int index = before.size() - 1;
        NamesData names = new NamesData(before.get(index).getId(), "First", "Mid", "Last", "Nickname");
        BusinessData bdata = new BusinessData("Address1", "Company", "Title");
        PhonesData phones = new PhonesData("123456", "1234567", "12345678", "123456789");
        EmailsData mails = new EmailsData("test@test.ru", "test2@test.ru", "test3@test.ru");
        OtherData other = new OtherData("http://ya.ru", "Address2", "Home", "Note");
        app.contact().chooseForEdit(index);
        app.contact().modify(names, bdata, phones, mails, other);
        app.goTo().contactPageBack();
        List<NamesData> after = app.contact().List();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(names);
        Comparator<? super NamesData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }
}
