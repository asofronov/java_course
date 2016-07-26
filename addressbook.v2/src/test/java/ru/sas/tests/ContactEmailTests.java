package ru.sas.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sas.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("FirstName").withLastName("LastName").withEmail1("ya@ya.ru")
            .withEmail2("gmail@gmail.com").withEmail3("mail@mail.ru"));
        }
    }

    @Test
    public void testContactEmails() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditPage = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditPage)));
    }

    private String mergeEmails(ContactData contact) {
        return Stream.of(contact.getEmail1(), contact.getEmail2(), contact.getEmail3()).filter((s -> !s.equals(""))).collect(Collectors.joining("\n"));
    }
}
