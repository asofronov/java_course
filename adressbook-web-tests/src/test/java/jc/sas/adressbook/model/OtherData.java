package jc.sas.adressbook.model;

public class OtherData {
    private final String website;
    private final String address2;
    private final String homePhone2;
    private final String noteText;

    public OtherData(String website, String address2, String homePhone2, String noteText) {
        this.website = website;
        this.address2 = address2;
        this.homePhone2 = homePhone2;
        this.noteText = noteText;
    }

    public String getWebsite() {
        return website;
    }

    public String getAddress2() {
        return address2;
    }

    public String getHomePhone2() {
        return homePhone2;
    }

    public String getNoteText() {
        return noteText;
    }
}
