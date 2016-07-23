package ru.sas.tests;

import org.testng.annotations.Test;

public class ContactDeletion extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContactButton();
        app.getContactHelper().submitContactDeletion();
        app.getNavigationHelper().gotoContactPage();
    }

}
