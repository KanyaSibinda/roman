package applications.webui.demoblazestore.widgets;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.AbstractWidget;

public class ProductsWidget extends AbstractWidget {
    String productName;
    private By addToCartBtn = By.xpath(".//a[text() = 'Add to cart']");

    public ProductsWidget(Roman roman, String productName) {
        super(roman);
        this.productName = productName;
    }

    public void addToCart(){
        click(addToCartBtn);
    }

    @Override
    protected By _Locator() {
        return By.xpath("//h2[text() = '"+productName+"']//ancestor::div[@id = 'tbodyid']");
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}
