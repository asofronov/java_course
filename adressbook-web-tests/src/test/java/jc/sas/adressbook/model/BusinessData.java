package jc.sas.adressbook.model;

public class BusinessData {
    private String address1;
    private String company;
    private String title;

    public BusinessData withAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public BusinessData withCompany(String company) {
        this.company = company;
        return this;
    }

    public BusinessData withTitle(String title) {
        this.title = title;
        return this;
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
