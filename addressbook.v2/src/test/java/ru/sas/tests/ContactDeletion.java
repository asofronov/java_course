package ru.sas.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sas.model.ContactData;
import ru.sas.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletion extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("FirstName").withLastName("LastName")
                    .withHomePhone("222").withMobilePhone("333").withWorkPhone("444").withEmail("ya@tya.ru"));
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().contactPage();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after,
                equalTo(before.without(deletedContact)));

    }
}
