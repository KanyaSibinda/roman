package applications.webui.demoblazestore;

import Roman.Roman;
import applications.webui.demoblazestore.pages.CartPage;
import applications.webui.demoblazestore.pages.HomePage;
import applications.webui.demoblazestore.pages.StorePage;

public class Applications {
    public HomePage homePage;
    public StorePage storePage;
    public CartPage cartPage;
    public Applications(Roman roman){
        homePage = new HomePage(roman);
        storePage = new StorePage(roman);
        cartPage = new CartPage(roman);
    }
}
