package ru.sas.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sas.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("FirstName").withLastName("LastName")
                    .withHomePhone("222").withMobilePhone("333").withWorkPhone("444").withEmail1("ya@tya.ru")
                    .withAddress("Flaming street").withEmail1("test@test.ru").withEmail2("test2@test.ru").withEmail3("test3@test.ru"));
        }
    }

    @Test
    public void testContactDetails() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);
        ContactData contactInfoFromEditPage = app.contact().infoFromEditForm(contact);
        assertThat(cleaned(mergeDetails(contactInfoFromEditPage)), equalTo(contactInfoFromDetailsPage.getAllDetails()));
    }

    private String mergeDetails(ContactData contact) {
        String homePhone = "";
        String mobile = "";
        String work = "";
        if (!contact.getHomePhone().equals("")) {
            homePhone = "H: " + contact.getHomePhone();
        }
        if (!contact.getMobilePhone().equals("")) {
            mobile = "M: " + contact.getMobilePhone();
        }
        if (!contact.getWorkPhone().equals("")) {
            work = "W: " + contact.getWorkPhone();
        }
        return Stream.of(contact.getFirstName() + " " + contact.getLastName(), contact.getAddress() + "\n", homePhone,
                mobile, work, "\n" + contact.getEmail1() + " (www.test.ru)" + "\n" + contact.getEmail2() + " (www.test.ru)" + "\n" + contact.getEmail3()
                        + " (www.test.ru)").filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String details) {
        return details.replace("  ", " ");

    }
}

