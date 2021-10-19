package PageObjects;

import ElementMapper.CategoryPageElementMapper;
import Utils.Browser;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage extends CategoryPageElementMapper {

    public CategoryPage(){
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    public Boolean isPageTShirts(){
        return getAuthenticationPageTShirts().contains("T-SHIRTS");
    }

    public String getAuthenticationPageTShirts(){
        return nameCategoryTShirts.getText();
    }

    public void clickProductAddToProductPage(){
        BasePage.mouseOver(productNameCategory);
        buttonMoreAddToProductPage.click();
    }

    public String getProductNameCategory(){
        return productNameCategory.getText();
    }
}
