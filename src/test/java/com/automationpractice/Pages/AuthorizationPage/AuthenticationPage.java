package com.automationpractice.Pages.AuthorizationPage;

import Models.User.User;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.CreateAccountPage;
import com.automationpractice.Pages.HomePage.HomePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.asserts.SoftAssert;

@Log4j2
public class AuthenticationPage extends HomePage {

    @FindBy(how = How.ID, using = "email_create")
    private WebElement inputEmail;

    @FindBy(how = How.ID, using = "SubmitCreate")
    private WebElement buttonCreate;

    @FindBy(how = How.ID, using = "email")
    private WebElement inputCurrentEmail;

    @FindBy(how = How.ID, using = "passwd")
    private WebElement inputPassword;

    @FindBy(how = How.ID, using = "SubmitLogin")
    private WebElement buttonSubmitLogin;

    @FindBy(how = How.CLASS_NAME, using = "lost_password from_group")
    private WebElement linkForgotYourPassword;

    @FindBy(how = How.ID, using = "create_account_error")
    private WebElement alertMessageInvalidEmailAddress;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl(getClass().getSimpleName()));
        log.debug("Creating an instance AccountPage");
    }

    public AuthenticationPage setEmail(User user) {
        this.inputEmail.clear();
        this.inputEmail.sendKeys(user.getEmail());
        return this;
    }

    public AuthenticationPage setEmail(String value) {
        this.inputEmail.clear();
        this.inputEmail.sendKeys(value);
        return this;
    }

    public AuthenticationPage setCurrentEmail(User user) {
        this.inputCurrentEmail.clear();
        this.inputCurrentEmail.sendKeys(user.getEmail());
        return this;
    }

    public AuthenticationPage setCurrentPassword(User user) {
        this.inputPassword.clear();
        this.inputPassword.sendKeys(user.getPassword());
        return this;
    }

    public CreateAccountPage clickSubmitCreate() {
        this.buttonCreate.click();
        return new CreateAccountPage(driver);
    }

    public AccountPage clickSubmitLogin() {
        this.buttonSubmitLogin.clear();
        return new AccountPage(driver);
    }

    public AccountPage createAccount(User user) {
        this.inputEmail.sendKeys(user.getEmail());
        this.buttonCreate.click();
        return new CreateAccountPage(driver)
                .setFieldsUserData(user)
                .clickRegister();
    }

    public AccountPage authorizeUser(User user) {
        this.inputCurrentEmail.sendKeys(user.getEmail());
        this.inputPassword.sendKeys(user.getPassword());
        this.buttonSubmitLogin.click();
        return new AccountPage(driver);
    }

    private boolean isAlert() {
        return this.alertMessageInvalidEmailAddress.isDisplayed();
    }

    public SoftAssert verifyAlertMessage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isAlert(), this.alertMessageInvalidEmailAddress.getText());
        return softAssert;
    }
}
