package jc.sas.adressbook;

public class GroupData {
    private final String footer;
    private final String header;
    private final String name;

    public GroupData(String footer, String header, String name) {
        this.footer = footer;
        this.header = header;
        this.name = name;
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
