package ru.sas.tests;

import org.testng.annotations.Test;
import ru.sas.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("UFName","ULname","1111","222","333","ya@ya.ru",null));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
    }
}
