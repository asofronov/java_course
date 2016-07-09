package jc.sas.adressbook.model;

public class PhonesData {
    private String homePhone1;
    private String mobilePhone;
    private String workPhone;
    private String fax;

    public PhonesData withPhone1(String homePhone1) {
        this.homePhone1 = homePhone1;
        return this;
    }

    public PhonesData withMobPhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public PhonesData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public PhonesData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getHomePhone1() {
        return homePhone1;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFax() {
        return fax;
    }
}
