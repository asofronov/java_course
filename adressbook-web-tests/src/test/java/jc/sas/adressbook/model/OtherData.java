package jc.sas.adressbook.model;

public class OtherData {
    private String website;
    private String address2;
    private String homePhone2;
    private String noteText;

    public OtherData withWebsite(String website) {
        this.website = website;
        return this;
    }

    public OtherData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public OtherData withHomePhone2(String homePhone2) {
        this.homePhone2 = homePhone2;
        return this;
    }

    public OtherData withNoteText(String noteText) {
        this.noteText = noteText;
        return this;
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
