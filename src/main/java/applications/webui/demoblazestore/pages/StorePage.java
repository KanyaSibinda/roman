package applications.webui.demoblazestore.pages;

import Roman.Roman;
import applications.webui.demoblazestore.widgets.ProductsWidget;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.SeleniumWrapper;

import java.time.Duration;

public class StorePage extends SeleniumWrapper {
    private Roman roman;
    private By cart = By.xpath("//a[@id = 'cartur']");
    private By phoneTab = By.xpath("//a[text() = 'Phones']");
    private By productLocator(String product){
        return By.xpath("//div[@class = 'col-lg-4 col-md-6 mb-4']//descendant::a[text() = '"+product+"']");
    }

    public StorePage(Roman roman) {
        super(roman);
        this.roman = roman;
    }

    public void clickProduct(String productName){
        refreshWindow();
        click(productLocator(productName));
    }

    public void addProductToCart(String productName){
        ProductsWidget productsWidget = new ProductsWidget(roman,productName);
        productsWidget.addToCart();
    }

    public String getPopUpText(){
        waitForAlert();
        return getAlertText();
    }
    public void clickOkOnPopUp(){
        acceptAlert();
    }
    public void goToCartPage(){
        click(cart);
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
