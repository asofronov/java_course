package jc.sas.adressbook.model;

public class NamesData {
    private int id = Integer.MAX_VALUE;;
    private String firstName;
    private String midName;
    private String lastName;
    private String nickname;

    public NamesData withId(int id) {
        this.id = id;
        return this;
    }

    public NamesData withFName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public NamesData withMName(String midName) {
        this.midName = midName;
        return this;
    }

    public NamesData withLName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public NamesData withNName(String nickName) {
        this.nickname = nickName;
        return this;
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
