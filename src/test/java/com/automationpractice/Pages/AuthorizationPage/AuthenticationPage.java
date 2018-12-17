package com.automationpractice.Pages.AuthorizationPage;

import Models.User.User;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.CreateAccountPage;
import com.automationpractice.Pages.HomePage.HomePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class AuthenticationPage extends HomePage {

    @FindBy(id = "email_create")
    private WebElement inputEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement buttonCreate;

    @FindBy(id = "email")
    private WebElement inputCurrentEmail;

    @FindBy(id = "passwd")
    private WebElement inputPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement buttonSubmitLogin;

    @FindBy(className = "lost_password from_group")
    private WebElement linkForgotYourPassword;

    @FindBy(id = "create_account_error")
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
}
