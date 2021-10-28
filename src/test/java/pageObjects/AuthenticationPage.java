package PageObjects;

import ElementMapper.AuthenticationPageElementMapper;
import Utils.Browser;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends AuthenticationPageElementMapper {
    public AuthenticationPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }
}
