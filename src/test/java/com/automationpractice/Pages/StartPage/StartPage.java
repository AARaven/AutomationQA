package com.automationpractice.Pages.StartPage;

import Models.Page.Page;
import com.automationpractice.Pages.AuthenticationPage.AuthenticationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class StartPage extends Page {

    public AuthenticationPage authentication = new AuthenticationPage(this.driver);

    public StartPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("BasePage"));
    }

    @FindBy(id = "contact-link")
    private WebElement buttonContactUs;

    @FindBy(className = "login")
    private WebElement buttonSignIn;

    @FindBy(className = "logout")
    private WebElement buttonSignOut;

    @FindBy(className = "account")
    protected WebElement spanAccount;

    public void clickContactUsBtn() {
        this.buttonContactUs.click();
    }

    public void clickSignInBtn() {
        this.buttonSignIn.click();
    }

    public void clickSignOutBtn() {
        this.buttonSignOut.click();
    }
}
