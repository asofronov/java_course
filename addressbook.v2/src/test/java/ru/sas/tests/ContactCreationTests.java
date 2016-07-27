package ru.sas.tests;

import org.testng.annotations.Test;
import ru.sas.model.ContactData;
import ru.sas.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test (enabled = true)
    public void testContactCreation() {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/1.png");
        ContactData contact = new ContactData().withFirstName("TestName").withLastName("LastName")
                .withHomePhone("222-222-222").withMobilePhone("333-333-333").withWorkPhone("444-444-444")
                .withEmail1("test@test.ru").withPhoto(photo);
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after,
                equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }

    @Test (enabled = false)
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/1.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}
