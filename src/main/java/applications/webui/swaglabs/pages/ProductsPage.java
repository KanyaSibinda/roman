package applications.webui.swaglabs.pages;

import Roman.Roman;
import selenium.SeleniumWrapper;
import org.openqa.selenium.By;

public class ProductsPage extends SeleniumWrapper {
    private By cartWidget = By.xpath("//div[@id = 'shopping_cart_container']");
    private By addToCartBtn(String txt){
        return  By.xpath("//button[@id = '"+txt+"']");
    }
    private By inventoryLabel(String txt){
        return (By.xpath("//div[@class = 'inventory_item_label']//descendant::div[text()='"+txt+"']"));
    }

    public ProductsPage(Roman roman){
        super(roman);
    }

    public void addItemToCart(String txt,String _txt){
        click(inventoryLabel(txt));
        click(addToCartBtn(_txt));
    }

    public void goToCartPage(){
        click(cartWidget);
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
