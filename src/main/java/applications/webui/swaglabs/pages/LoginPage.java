package applications.webui.swaglabs.pages;

import Roman.Roman;
import applications.webui.swaglabs.models.Credentials;
import selenium.SeleniumWrapper;
import org.openqa.selenium.By;

public class LoginPage extends SeleniumWrapper {
    private By usernameField = By.xpath("//input[@id = 'user-name']");
    private By passwordField = By.xpath("//input[@id = 'password']");
    private By loginBtn = By.xpath("//input[@id = 'login-button']");
    public LoginPage(Roman roman){
        super(roman);
    }

    public void login(Credentials credentials){
        navigateTo();
        sendKeys(usernameField,credentials.getUsername());
        sendKeys(passwordField,credentials.getPassword());
        click(loginBtn);
    }

    @Override
    protected String get_uri() {
        return "https://www.saucedemo.com/";
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}
