package SeleniumTest.com.automationpractice.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends Page {

    public AuthPage() {
        this.url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        this.title = "Login - My Store";
    }

    //REGISTER AREA:

    //Text area enter email for registration:
    @FindBy(id = "email_create")
    private WebElement emailCreate;

    //Create an account Button:
    @FindBy(id = "SubmitCreate")
    private WebElement submitCreateAccount;
    //99% positive case:

    public void sendEmailAndPushSubmit(String email) throws Exception {
        if (this.emailCreate.isDisplayed()) {
            this.emailCreate.sendKeys(email);
        } else throw new Exception("The email area is not available.");

        if (this.submitCreateAccount.isDisplayed()) {
            this.submitCreateAccount.click();
        } else throw new Exception("The submit button is not available.");
    }

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
