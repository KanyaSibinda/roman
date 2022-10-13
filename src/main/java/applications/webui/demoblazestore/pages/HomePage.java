package applications.webui.demoblazestore.pages;

import Roman.Roman;
import applications.webui.demoblazestore.models.Credentials;
import org.openqa.selenium.By;
import selenium.SeleniumWrapper;

import java.util.concurrent.TimeUnit;

public class HomePage extends SeleniumWrapper {
    private By signupTab = By.xpath("//a[@id = 'signin2']");
    private By loginTab = By.xpath("//a[@id = 'login2']");
    private By signUpUsername = By.xpath("//input[@id = 'sign-username']");
    private By signUpPassword = By.xpath("//input[@id = 'sign-password']");
    private By signUpBtn = By.xpath("//button[text() = 'Sign up']");
    private By sigUpCloseBtn = By.xpath("//button[text() = 'Sign up']//preceding-sibling::button[text() = 'Close']");
    private By loginUsername = By.xpath("//input[@id = 'loginusername']");
    private By loginPassword = By.xpath("//input[@id = 'loginpassword']");
    private By loginBtn = By.xpath("//button[text() = 'Log in']");

    public HomePage(Roman roman) {
        super(roman);
    }
    public String getUrl(){
        return get_uri();
    }
    public void signUp(Credentials credentials){
        navigateTo();
        click(signupTab);
        sendKeys(signUpUsername,credentials.getUsername());
        sendKeys(signUpPassword,credentials.getPassword());
        click(signUpBtn);
        click(sigUpCloseBtn);
    }
    public void logIn(Credentials credentials){
        navigateTo();
        click(loginTab);
        sendKeys(loginUsername, credentials.getUsername());
        sendKeys(loginPassword, credentials.getPassword());
        click(loginBtn);
    }


    @Override
    protected String get_uri() {
        return "https://www.demoblaze.com/";
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}
