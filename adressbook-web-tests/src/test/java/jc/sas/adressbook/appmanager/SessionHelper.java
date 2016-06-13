package jc.sas.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


class SessionHelper extends HelperBase {

    SessionHelper(WebDriver wd) {
        super(wd);
    }

    void login(String login, String password) {
        type(By.name("user"), login);
        type(By.name("pass"), password);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
