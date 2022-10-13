package applications.webui.Luma.pages;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.SeleniumWrapper;

public class CartPage extends SeleniumWrapper {
    private By itemName = By.xpath("//table[@id = 'shopping-cart-table']//descendant::a[text() = 'Sprite Yoga Companion Kit']");
    private By itemPrice = By.xpath("//td[@class = 'col price']//descendant::span[@class = 'price']");
    public CartPage(Roman roman) {
        super(roman);
    }

    public Boolean validateItemInCart(){
        boolean itemPresent;
        if (getText(itemName).equals("Sprite Yoga Companion Kit") && getText(itemPrice).equals("$65.00")){
            itemPresent = true;
        }else {
            itemPresent = false;
        }
        return itemPresent;
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
