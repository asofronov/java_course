package jc.sas.adressbook.model;

public class EmailsData {
    private String email1;
    private String email2;
    private String email3;

    public EmailsData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public EmailsData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public EmailsData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }
}
