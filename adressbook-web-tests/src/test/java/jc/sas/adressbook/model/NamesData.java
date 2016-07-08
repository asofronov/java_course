package jc.sas.adressbook.model;

public class NamesData {
    private int id;
    private final String firstName;
    private final String midName;
    private final String lastName;
    private final String nickname;

    public NamesData(int id, String firstName, String midName, String lastName, String nickname) {
        this.id = id;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.nickname = nickname;
    }

    public NamesData(String firstName, String midName, String lastName, String nickname) {
        this.id = 0;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.nickname = nickname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMidName() {
        return midName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "NamesData{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NamesData namesData = (NamesData) o;

        if (id != namesData.id) return false;
        if (firstName != null ? !firstName.equals(namesData.firstName) : namesData.firstName != null) return false;
        return lastName != null ? lastName.equals(namesData.lastName) : namesData.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
