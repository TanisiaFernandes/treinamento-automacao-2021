package ElementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageElementMapper {

    @FindBy(className = "navigation_page")
    public WebElement navigation_page;

    @FindBy(className = "lighter")
    public WebElement Lighter;

    @FindBy(className = "heading-counter")
    public WebElement heading_counter;

}
