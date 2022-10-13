package applications.webui.swaglabs;

import Roman.Roman;
import applications.webui.swaglabs.pages.CartPage;
import applications.webui.swaglabs.pages.LoginPage;
import applications.webui.swaglabs.pages.ProductsPage;

public class Applications {

    public LoginPage loginPage;
    public ProductsPage productsPage;
    public CartPage cartPage;
    public Applications(Roman roman){
        loginPage = new LoginPage(roman);
        productsPage = new ProductsPage(roman);
        cartPage = new CartPage(roman);
    }
}
