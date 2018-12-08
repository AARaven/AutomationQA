package SeleniumTest.com.automationpractice.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends Page {

    public AuthorizationPage(WebDriver driver) {
        super(driver);
        this.setUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    public void sendEmailAndPushSubmit(String email) throws Exception {
        this.emailCreate.sendKeys(email);
        this.submitCreateAccount.click();
    }

    //REGISTER AREA:

    //Text area enter email for registration:
    @FindBy(id = "email_create")
    private WebElement emailCreate;

    //Create an account Button:
    @FindBy(id = "SubmitCreate")
    private WebElement submitCreateAccount;

    //LOGIN AREA:

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
}
