package ru.sas.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sas.model.ContactData;
import ru.sas.model.GroupData;
import ru.sas.model.Groups;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by aleks on 01.08.2016.
 */
public class AddContactToGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new ContactData().withFirstName("FirstName").withLastName("LastName")
                    .withHomePhone("222").withMobilePhone("333").withWorkPhone("444").withEmail1("ya@tya.ru"));
        }
    }

    @Test
    public void testAddContactToGroup() {
        app.goTo().contactPage();
        Groups groups = app.db().groups();
        ContactData contact = app.db().contacts().iterator().next();
        Groups before = contact.getGroups();
        GroupData addedGroup = null;
        Groups contactGroups = contact.getGroups();
        for (GroupData group : groups) {
            addedGroup = group;
            for (GroupData contactGroup : contactGroups) {
                if (addedGroup.equals(contactGroup)) {
                    addedGroup = null;
                    break;
                }
            }
            if (addedGroup != null) {
                app.contact().addGroup(contact, addedGroup);
                break;
            }
        }
        if (addedGroup == null) {
            addedGroup = new GroupData().withName("GroupName").withHeader("GroupHeader").withFooter("GroupFooter");
            app.goTo().groupPage();
            app.group().create(addedGroup);
            app.goTo().contactPage();
            app.contact().addGroup(contact, addedGroup);
        }
        Groups after = app.db().contactWithACertainID(contact).getGroups();
        addedGroup = addedGroup.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        assertThat(after, equalTo(before.withAdded(addedGroup)));


    }
}
