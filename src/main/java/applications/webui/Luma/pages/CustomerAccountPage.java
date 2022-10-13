package applications.webui.Luma.pages;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.SeleniumWrapper;

public class CustomerAccountPage extends SeleniumWrapper {
    private By saleTab = By.xpath("//a[@id = 'ui-id-8']");

    public CustomerAccountPage(Roman roman) {
        super(roman);
    }

    public void goToSales(){
        click(saleTab);
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
