package PageObjects;

import ElementMapper.CartPageElementMapper;
import Utils.Browser;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CartPageElementMapper {

    public CartPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getNameProductCart(){
        return productNameCart.getText();
    }
}

