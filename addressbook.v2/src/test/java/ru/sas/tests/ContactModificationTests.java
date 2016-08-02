package ru.sas.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sas.model.ContactData;
import ru.sas.model.Contacts;
import ru.sas.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new ContactData().withFirstName("FirstName").withLastName("LastName")
                    .withHomePhone("222").withMobilePhone("333").withWorkPhone("444").withEmail1("ya@tya.ru"));
        }
    }

    @Test
    public void testContactModification() {
        app.goTo().contactPage();
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("UFirstName").withLastName("ULastName")
                .withHomePhone("1111").withMobilePhone("2222").withWorkPhone("3333").withEmail1("test@test.ru");
        app.contact().modify(contact);
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
        veifyContactListInUI();
    }
}
