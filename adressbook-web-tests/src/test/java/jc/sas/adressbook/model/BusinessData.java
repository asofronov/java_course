package jc.sas.adressbook.model;

public class BusinessData {
    private final String address1;
    private final String company;
    private final String title;

    public BusinessData(String address1, String company, String title) {
        this.address1 = address1;
        this.company = company;
        this.title = title;
    }

    public String getAddress1() {
        return address1;
    }

    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }
}
