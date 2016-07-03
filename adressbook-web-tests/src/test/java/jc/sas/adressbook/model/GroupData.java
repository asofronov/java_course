package jc.sas.adressbook.model;

public class GroupData {
    private final String name;
    private final String header;
    private final String footer;


    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public String getFooter() {
        return footer;
    }

    public String getHeader() {
        return header;
    }

    public String getName() {
        return name;
    }
}
