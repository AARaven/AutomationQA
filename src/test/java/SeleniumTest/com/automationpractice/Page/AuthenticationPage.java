package SeleniumTest.com.automationpractice.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends Page {

    //Text area enter email for registration:
    @FindBy(id = "email_create")
    private WebElement emailCreate;

    //Create an account Button:
    @FindBy(id = "SubmitCreate")
    private WebElement submitCreateAccount;

    //Text area email:
    @FindBy(id = "email")
    private WebElement email;

    //Text area password:
    @FindBy(id = "passwd")
    private WebElement password;

    //SignIn Button:
    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginAccount;

    //forgot your password link:
    @FindBy(className = "lost_password from_group")
    private WebElement forgotYourPassword;

    public AuthenticationPage() {
        this.pageURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        this.pageTitle = "Login - My Store";
    }
}
