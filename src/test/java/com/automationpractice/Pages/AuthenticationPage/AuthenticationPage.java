package com.automationpractice.Pages.AuthenticationPage;

import Models.Page.Page;
import Models.User.User;
import com.automationpractice.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends Page {

    private CreateAccountStep createStep = new CreateAccountStep(this.driver);

    private Account account = new Account(this.driver);

    public MyAddress address = new MyAddress(this.driver);

    public PersonalInfo personalInfo = new PersonalInfo(this.driver);

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("AuthorizationPage"));
    }

    //Create an account:

    @FindBy(id = "email_create")
    private WebElement inputEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement buttonCreate;

    //Already registered:

    @FindBy(id = "email")
    private WebElement inputCurrentEmail;

    @FindBy(id = "passwd")
    private WebElement inputPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement buttonSubmitLogin;

    @FindBy(className = "lost_password from_group")
    private WebElement linkForgotYourPassword;

    public void createAccount(User user) {
        this.inputEmail.sendKeys(user.getEmail());
        this.buttonCreate.click();
        this.createStep.createAnAccount(user);
    }

    public void authorizeUser(User user) {
        this.inputCurrentEmail.sendKeys(user.getEmail());
        this.inputPassword.sendKeys(user.getPassword());
        this.buttonSubmitLogin.click();
    }

    public void clickMyAddress() {
        this.account.clickMyAddresses();
    }

    public void clickMyPersonalInfo() {
        this.account.clickMyPersonalInfo();
    }

    public void clickMyWishList() {
        this.account.clickMyWishlists();
    }

    public void clickOrderHistoryAndDetails() {
        this.account.clickOrderHistoryAndDetails();
    }

    public void clickMyCreditSlips() {
        this.account.clickMyCreditSlips();
    }
}
