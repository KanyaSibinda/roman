package applications.webui.Luma.pages;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.SeleniumWrapper;

public class StorePage extends SeleniumWrapper {
    private By createAccountTab = By.xpath("//div[@class = 'panel wrapper']//descendant::a[text() = 'Create an Account']");
    private By fitnessEquipment = By.xpath("//a[text() = 'Fitness Equipment']");

    public StorePage(Roman roman) {
        super(roman);
    }

    public void goToCreateAccount(){
        navigateTo();
        click(createAccountTab);
    }
    public void goToFitnessEquipment(){
        click(fitnessEquipment);
    }



    @Override
    protected String get_uri() {
        return "https://magento.softwaretestingboard.com/";
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}
