package unittests;

import Roman.RomanBase;
import applications.webui.demoblazestore.Applications;
import applications.webui.demoblazestore.models.Credentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class DemoBlazeTest extends RomanBase {

    @BeforeEach
    public void setUp(){
        roman()._driver = roman().selenium.getChromeDriver();
        roman()._driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void addingNewUser(){
        Applications applications = new Applications(roman());
        applications.homePage.signUp(new Credentials("vegeter@kai.dbz","vegeter"));
        applications.homePage.logIn(new Credentials("vegeter@kai.dbz", "vegeter"));
        assertEquals("https://www.demoblaze.com/index.html#",applications.homePage.getUrl());
    }

    @Test
    public void addingItemToCart(){
        Applications applications = new Applications(roman());
        applications.homePage.logIn(new Credentials("vegeter@kai.dbz","vegeter"));
        applications.storePage.clickProduct("Samsung galaxy s6");
        applications.storePage.addProductToCart("Samsung galaxy s6");
        String message = applications.storePage.getPopUpText();
        applications.storePage.clickOkOnPopUp();
        applications.storePage.goToCartPage();
        assertEquals("Product added.", message);
        assertTrue(applications.cartPage.checkIfItemIsInCart());
    }
}
