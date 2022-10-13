package applications.webui.demoblazestore.pages;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.SeleniumWrapper;

public class CartPage extends SeleniumWrapper {
    private By product = By.xpath("//div[@class = 'table-responsive']//descendant::td[text() = 'Samsung galaxy s6']");
    private By productPrice = By.xpath("//div[@class = 'table-responsive']//descendant::td[text() = '360']");
    public CartPage(Roman roman) {
        super(roman);
    }

    public boolean checkIfItemIsInCart(){
        boolean productInCart;
        if (getText(product).equals("Samsung galaxy s6") && getText(productPrice).equals("360")){
             productInCart = true;
        }else {
            productInCart = false;
        }
        return productInCart;
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
