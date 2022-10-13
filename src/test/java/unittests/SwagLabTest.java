package unittests;

import Roman.RomanBase;
import applications.webui.swaglabs.Applications;
import applications.webui.swaglabs.models.Credentials;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class SwagLabTest extends RomanBase {

    @BeforeEach
    public void setup(){
        roman()._driver = roman().selenium.getChromeDriver();

        roman()._driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("TC_01")
    public void enteringValidCredentials(){
        Applications applications = new Applications(roman());
        applications.loginPage.login(new Credentials("standard_user","secret_sauce"));
        applications.productsPage.addItemToCart("Sauce Labs Fleece Jacket","add-to-cart-sauce-labs-fleece-jacket");
        applications.productsPage.goToCartPage();
        boolean isItemInCart = applications.cartPage.checkIfItemInCart("Sauce Labs Fleece Jacket","$49.99");
        assertTrue(isItemInCart);

    }

}
