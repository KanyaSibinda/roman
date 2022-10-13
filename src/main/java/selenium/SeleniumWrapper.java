package selenium;

import Roman.Roman;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class SeleniumWrapper extends AbstractPage {
    Roman roman;
    public SeleniumWrapper(Roman roman){
        super(roman);
        this.roman = roman;
    }
    public void refreshWindow(){
        roman._driver.navigate().refresh();
    }

    public String getAlertText(){
        return roman._driver.switchTo().alert().getText();
    }
    public void waitForAlert(){
        WebDriverWait wait = new WebDriverWait(roman._driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
