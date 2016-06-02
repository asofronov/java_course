package jc.sas.adressbook;

public class NamesData {
    private final String firstName;
    private final String midName;
    private final String lastName;
    private final String nickname;

    public NamesData(String firstName, String midName, String lastName, String nickname) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.nickname = nickname;
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
}
