package ru.sas.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sas.model.ContactData;
import ru.sas.model.GroupData;
import ru.sas.model.Groups;

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
        if (app.db().groups().size() <= 1) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("GroupName").withHeader("GroupHeader").withFooter("GroupFooter"));
        }
    }

    @Test
    public void testAddContactToGroup() {
        app.goTo().contactPage();
        ContactData contact = app.db().contacts().iterator().next();
        Groups before = contact.getGroups();
        GroupData addedGroup = app.db().groups().iterator().next();
        app.contact().addGroup(contact, addedGroup);
        Groups after = app.db().contactWithACertainID(contact).getGroups();
        assertThat(after, equalTo(before.withAdded(addedGroup.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
