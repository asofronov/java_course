package ru.sas.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String homePhone;
    private final String mobilePhone;
    private final String workPhone;
    private final String email;

    public ContactData(String firstName, String lastName, String homePhone, String mobilePhone, String workPhone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getEmail() {
        return email;
    }

}
