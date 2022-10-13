package unittests;

import Roman.RomanBase;
import applications.webui.Luma.Applications;
import applications.webui.Luma.models.UserDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class LumaTests extends RomanBase {
    String firstname = "Vegeter";
    String lastname = "Saiyan";
    String email = "vegeterr@dhrl.lil";
    String password = "Vegeter123";

    @BeforeEach
    public void setUp(){
        roman()._driver = roman().selenium.getEdgeDriver();
        roman()._driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void register_New_User_And_Add_Item_To_The_Cart(){
        Applications applications = new Applications(roman());
        applications.storePage.goToCreateAccount();
        applications.registrationPage.registerUser(new UserDetails(firstname,lastname,email,password));
        applications.customerAccountPage.goToSales();
        applications.storePage.goToFitnessEquipment();
        applications.productsPage.addItemToCart();
        String msg = applications.productsPage.getMessage();
        applications.productsPage.goToCart();
        boolean itemInCart = applications.cartPage.validateItemInCart();
        Assertions.assertEquals("You added Sprite Yoga Companion Kit to your shopping cart.",msg);
        Assertions.assertTrue(itemInCart);

    }

}
