package PageObjects;

import Utils.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage extends Browser {

    public static void mouseOver(WebElement element){
        Actions action = new Actions(Browser.getCurrentDriver());
        action.moveToElement(element).build().perform();
    }
}
