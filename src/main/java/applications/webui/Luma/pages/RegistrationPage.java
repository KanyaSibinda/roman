package applications.webui.Luma.pages;

import Roman.Roman;
import applications.webui.Luma.models.UserDetails;
import org.openqa.selenium.By;
import selenium.SeleniumWrapper;

public class RegistrationPage extends SeleniumWrapper {
    private By firstNameField = By.xpath("//input[@id = 'firstname']");
    private By lastNameField = By.xpath("//input[@id = 'lastname']");
    private By emailField = By.xpath("//input[@id = 'email_address']");
    private By passwordField = By.xpath("//input[@id = 'password']");
    private By confirmPasswordField = By.xpath("//input[@id = 'password-confirmation']");
    private By createAnAccountBtn = By.xpath("//button[@type = 'submit']//child::span[text() = 'Create an Account']");

    public RegistrationPage(Roman roman) {
        super(roman);
    }

    public void registerUser(UserDetails userDetails){
        sendKeys(firstNameField, userDetails.firstname);
        sendKeys(lastNameField, userDetails.lastname);
        sendKeys(emailField, userDetails.email);
        sendKeys(passwordField, userDetails.password);
        sendKeys(confirmPasswordField, userDetails.password);
        click(createAnAccountBtn);
    }

    @Override
    protected String get_uri() {
        return null;
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}
