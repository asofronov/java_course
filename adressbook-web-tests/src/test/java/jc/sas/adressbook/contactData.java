package jc.sas.adressbook;

public class contactData {
    private final String fname;
    private final String mname;
    private final String lname;
    private final String nickname;
    private final String title;
    private final String company;
    private final String address;
    private final String homephone;
    private final String mobilephone;
    private final String workphone;
    private final String fax;
    private final String email1;
    private final String email2;
    private final String email3;
    private final String httplink;
    private final String address2;
    private final String homephone2;
    private final String noteText;

    public contactData(String fname, String mname, String lname, String nickname, String title, String company, String address, String homephone, String mobilephone, String workphone, String fax, String email1, String email2, String email3, String httplink, String address2, String homephone2, String noteText) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homephone = homephone;
        this.mobilephone = mobilephone;
        this.workphone = workphone;
        this.fax = fax;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.httplink = httplink;
        this.address2 = address2;
        this.homephone2 = homephone2;
        this.noteText = noteText;
    }

    public String getFname() {
        return fname;
    }

    public String getMname() {
        return mname;
    }

    public String getLname() {
        return lname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomephone() {
        return homephone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public String getFax() {
        return fax;
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

    public String getHttplink() {
        return httplink;
    }

    public String getAddress2() {
        return address2;
    }

    public String getHomephone2() {
        return homephone2;
    }

    public String getNoteText() {
        return noteText;
    }
}
