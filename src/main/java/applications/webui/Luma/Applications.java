package applications.webui.Luma;

import Roman.Roman;
import applications.webui.Luma.pages.*;


public class Applications {
    public StorePage storePage;
    public RegistrationPage registrationPage;
    public CustomerAccountPage customerAccountPage;
    public ProductsPage productsPage;
    public CartPage cartPage;
    public Applications(Roman roman){
        storePage = new StorePage(roman);
        registrationPage = new RegistrationPage(roman);
        customerAccountPage = new CustomerAccountPage(roman);
        productsPage = new ProductsPage(roman);
        cartPage = new CartPage(roman);

    }
}
