package PageObjects;

import ElementMapper.ProductPageElementMapper;
import Utils.Browser;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends ProductPageElementMapper {

    public ProductPage(){
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    public String getProductNamePDP(){
        return productNamePDP.getText();
    }

    public void clickButtonAddToCart(){
        buttonAddToCart.click();
    }

    public void clickButtonModalProceedToCheckout(){
        buttonModalProceedToCheckout.click();
    }
}
