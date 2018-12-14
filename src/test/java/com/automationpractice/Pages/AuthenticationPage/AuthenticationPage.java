package com.automationpractice.Pages.AuthenticationPage;

import Models.User.User;
import com.automationpractice.Pages.AuthenticationPage.SplitedPages.*;
import com.automationpractice.Pages.StartPage.StartPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class AuthenticationPage extends StartPage {

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

    public MyWishListPage wishList = new MyWishListPage(this.driver);

    private CreateAccountStep createStep = new CreateAccountStep(this.driver);

    private MyAccountPage myAccountPage = new MyAccountPage(this.driver);

    public OrderHistoryPage orders = new OrderHistoryPage(this.driver);

    public MyCreditSlipsPage creditSlips = new MyCreditSlipsPage(this.driver);

    public MyAddressPage address = new MyAddressPage(this.driver);

    public MyAccountInfoPage personalInfoPage = new MyAccountInfoPage(this.driver);


    public AuthenticationPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("AuthorizationPage"));
        log.debug("creating an object AuthenticationPage");
    }

    public void createAccount(User user) {
        this.inputEmail.sendKeys(user.getEmail());
        this.buttonCreate.click();
        this.createStep.fillAllFields(user);
        this.createStep.clickSubmitAnAccount();
    }

    public void authorizeUser(User user) {
        this.inputCurrentEmail.sendKeys(user.getEmail());
        this.inputPassword.sendKeys(user.getPassword());
        this.buttonSubmitLogin.click();
    }

    public void clickMyAddress() {
        this.myAccountPage.clickMyAddresses();
    }

    public void clickMyPersonalInfo() {
        this.myAccountPage.clickMyPersonalInfo();
    }

    public void clickMyWishList() {
        this.myAccountPage.clickMyWishLists();
    }

    public void clickOrderHistoryAndDetails() {
        this.myAccountPage.clickOrderHistoryAndDetails();
    }

    public void clickMyCreditSlips() {
        this.myAccountPage.clickMyCreditSlips();
    }
}
