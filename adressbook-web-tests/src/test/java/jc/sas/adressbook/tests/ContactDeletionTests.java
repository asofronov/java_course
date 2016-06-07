package jc.sas.adressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by aleks on 07.06.2016.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getContactsHelper().getContactList();
        app.getContactsHelper().chooseContactCheckmark("//input[@id='6']");
        app.getContactsHelper().scrollToDeletion();
        app.getContactsHelper().submitContactDeletion();
        app.getContactsHelper().dialogConfirmDeletion();
    }
}
