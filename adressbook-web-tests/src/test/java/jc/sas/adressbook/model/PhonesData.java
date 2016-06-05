package jc.sas.adressbook.model;

public class PhonesData {
    private final String homePhone1;
    private final String mobilePhone;
    private final String workPhone;
    private final String fax;

    public PhonesData(String homePhone1, String mobilePhone, String workPhone, String fax) {
        this.homePhone1 = homePhone1;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.fax = fax;
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
