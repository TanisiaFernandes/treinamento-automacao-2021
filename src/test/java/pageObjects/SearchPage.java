package PageObjects;

import ElementMapper.SearchPageElementMapper;
import Utils.Browser;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends SearchPageElementMapper {
    public SearchPage(){
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    public String getTextNavigation_Page(){
        return navigation_page.getText();
    }
    public String getTextLighter(){
        return Lighter.getText();
    }
    public String getTextHeading_counter(){
        return heading_counter.getText();

    }
    public boolean isSearchPage(){
        return getTextNavigation_Page().equals("Search");

    }
}