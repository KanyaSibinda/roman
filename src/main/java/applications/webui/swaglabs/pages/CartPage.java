package applications.webui.swaglabs.pages;

import Roman.Roman;
import selenium.SeleniumWrapper;
import org.openqa.selenium.By;

public class CartPage extends SeleniumWrapper {
    private By cartItem = By.xpath("//div[@class = 'cart_list']//descendant::div[text() = 'Sauce Labs Fleece Jacket']");

    private By itemPrice = By.xpath("//div[@class = 'inventory_item_price']");

    public CartPage(Roman roman){
        super(roman);
    }


    public Boolean checkIfItemInCart(String itemName, String price){
        Boolean itemInCart;

        if (getText(cartItem).equals(itemName) && getText(itemPrice).equals(price)) {
            itemInCart = true;
        }else {
            itemInCart = false;
        }
        return itemInCart;
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
