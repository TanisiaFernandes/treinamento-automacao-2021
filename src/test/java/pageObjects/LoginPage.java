package PageObjects;

import ElementMapper.LoginPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import Utils.Browser;


public class LoginPage extends LoginPageElementMapper {
    public LoginPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);

    }
    @Step("Preencheu email")
    public void fillEmail(){
        email.sendKeys("tanisia123@gmail.com");
    }
    @Step("Preencheu a senha")
    public void fillPasswd() { passwd.sendKeys("12345");}
    @Step("Clicou em Sign In")
    public void ClickBtnSubmitLogin() {
        SubmitLogin.click();

    }
}
