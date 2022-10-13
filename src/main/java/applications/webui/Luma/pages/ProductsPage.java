package applications.webui.Luma.pages;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.SeleniumWrapper;

public class ProductsPage extends SeleniumWrapper {
    private By message = By.xpath("//div[@data-ui-id = 'message-success']");
    private By item = By.xpath("//a[contains(text() , 'Sprite Yoga Companion Kit')]");
    private By customizeAndGoToCartBtn = By.xpath("//button[@id = 'bundle-slide']");
    private By addToCartButton = By.xpath("//button[@id = 'product-addtocart-button']");
    private By customization = By.xpath("//input[@id = 'bundle-option-1-2']");
    private By cartWidget = By.xpath("//div[@class = 'header content']//descendant::a[@class = 'action showcart']");
    private By viewAndEditLink = By.xpath("//a[@class = 'action viewcart']//child::span[text() = 'View and Edit Cart']");
    public ProductsPage(Roman roman) {
        super(roman);
    }
    public void addItemToCart(){
        click(item);
        click(customizeAndGoToCartBtn);
        click(customization);
        click(addToCartButton,10);
    }
    public void goToCart(){
        click(cartWidget);
        click(viewAndEditLink);
    }
    public String getMessage(){
        return getText(message);
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
