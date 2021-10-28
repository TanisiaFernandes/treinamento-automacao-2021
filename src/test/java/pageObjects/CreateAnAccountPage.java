package PageObjects;

import ElementMapper.CreateAnAccountPageElementMapper;
import Utils.Browser;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage extends CreateAnAccountPageElementMapper {
    public CreateAnAccountPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }
}
