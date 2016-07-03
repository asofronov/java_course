package jc.sas.adressbook.appmanager;

import jc.sas.adressbook.model.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsHelper extends HelperBase {

    ContactsHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillOtherData(OtherData otherData) {
        type(By.name("homepage"), otherData.getWebsite());
        type(By.name("address2"), otherData.getAddress2());
        type(By.name("phone2"), otherData.getHomePhone2());
        type(By.name("notes"), otherData.getNoteText());
    }

    public void fillEmailsData(EmailsData emailsData) {
        type(By.name("email"), emailsData.getEmail1());
        type(By.name("email2"), emailsData.getEmail2());
        type(By.name("email3"), emailsData.getEmail3());
    }

    public void fillPhonesData(PhonesData phonesData) {
        type(By.name("home"), phonesData.getHomePhone1());
        type(By.name("mobile"), phonesData.getMobilePhone());
        type(By.name("work"), phonesData.getWorkPhone());
        type(By.name("fax"), phonesData.getFax());
    }

    public void fillBusinessData(BusinessData businessData) {
        type(By.name("title"), businessData.getTitle());
        type(By.name("company"), businessData.getCompany());
        type(By.name("address"), businessData.getAddress1());
    }

    public void fillNamesData(NamesData namesData) {
        type(By.name("firstname"), namesData.getFirstName());
        type(By.name("middlename"), namesData.getMidName());
        type(By.name("lastname"), namesData.getLastName());
        type(By.name("nickname"), namesData.getNickname());
    }

    public void addButton() {
        click(By.linkText("add new"));
    }

    public void getContactList() {
        wd.get("http://localhost/addressbook/");
    }

    public void openEditForm(String way) {
        click(By.xpath(way));
    }

    public void submitContactUpdate() {
        click(By.name("update"));
    }

    public void chooseContact() {
        click(By.name("selected[]"));
    }

    public void scrollToDeletion() {
        scrollDown("//div[@id='content']/form[2]/div[2]/input");
    }

    public void submitContactDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void dialogConfirmDeletion() {
        wd.switchTo().alert().accept();
    }

    public void createContact(NamesData names, BusinessData bdata, PhonesData phones, EmailsData emails, OtherData otherdata) {
        addButton();
        fillNamesData(names);
        fillBusinessData(bdata);
        fillPhonesData(phones);
        fillEmailsData(emails);
        fillOtherData(otherdata);
        submitContactCreation();
    }

    public boolean isThereContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
