package com.automationpractice.Pages;

import Models.User.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage {

    @FindBy(id = "email_create")
    private WebElement inputEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement buttonCreate;

    @FindBy(id = "email")
    protected WebElement inputCurrentEmail;

    @FindBy(id = "passwd")
    protected WebElement inputPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement buttonSubmitLogin;

    @FindBy(className = "lost_password from_group")
    private WebElement linkForgotYourPassword;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("AuthorizationPage"));
    }

    public void setPassword(String password) {
        this.inputPassword.sendKeys(password);
    }

    public void setEmail(String email) {
        this.inputCurrentEmail.sendKeys(email);
    }

    public void setCreationEmail(String email) {
        this.inputEmail.sendKeys(email);
    }

    public void pushCreateAnAccount() {
        this.buttonCreate.click();
    }

    public void pushSignInAccount() {
        this.buttonSubmitLogin.click();
    }

    public void fillCreationEmail(User user) {
        setCreationEmail(user.getEmail());
        pushCreateAnAccount();
    }

    public void authorizeAccount(User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        pushSignInAccount();
    }

    public boolean isLoginEqualSpanText(User user) {
        return this.spanAccount.getText().equals
                (user.getFirstName() + " " + user.getLastName());
    }

    public boolean isLoginSpanDisplayed() {
        return this.spanAccount.isDisplayed();
    }
}
