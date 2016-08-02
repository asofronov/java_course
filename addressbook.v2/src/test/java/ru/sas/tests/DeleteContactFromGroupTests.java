package ru.sas.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sas.model.ContactData;
import ru.sas.model.Contacts;
import ru.sas.model.GroupData;
import ru.sas.model.Groups;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new ContactData().withFirstName("FirstName").withLastName("LastName")
                    .withHomePhone("222").withMobilePhone("333").withWorkPhone("444").withEmail1("ya@tya.ru"));
        }
        if (app.db().groups().size() <= 1) {
            app.goTo().groupPage();
            Random r = new Random();
            app.group().create(new GroupData().withName("GroupName" + r.nextInt()).withHeader("GroupHeader").withFooter("GroupFooter"));
        }
    }

    @Test
    public void testDeletingContactFromAGroup() {
        GroupData group = app.db().groups().iterator().next();
        Contacts contacts = group.getContacts();
        if (contacts.size() == 0) {
            ContactData contact = app.db().contacts().iterator().next();
            app.goTo().contactPage();
            app.contact().addGroup(contact, group);
            contacts = app.db().groupsWithACertainId(group).getContacts();
        }
        ContactData contact = contacts.iterator().next();
        Groups before = contact.getGroups();
        Contacts beforeContacts = app.db().groupsWithACertainId(group).getContacts();
        app.contact().deleteGroup(contact, group);
        Groups after = app.db().contactWithACertainID(contact).getGroups();
        Contacts afterContacts = app.db().groupsWithACertainId(group).getContacts();
        assertThat(after, equalTo(before.without(group)));
        assertThat(afterContacts, equalTo(beforeContacts.without(contact)));
    }
}