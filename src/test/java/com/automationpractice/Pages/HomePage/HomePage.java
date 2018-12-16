package com.automationpractice.Pages.HomePage;

import Models.Page.Page;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.HomePage.IncludedPages.ContactUsPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl(getClass().getSimpleName()));
        log.debug("Creating an instance HomePage");
    }

    @FindBy(id = "contact-link")
    private WebElement buttonContactUs;

    @FindBy(className = "login")
    private WebElement buttonSignIn;

    @FindBy(className = "logout")
    private WebElement buttonSignOut;

    @FindBy(className = "account")
    private WebElement spanAccount;

    public ContactUsPage clickContactUsBtn() {
        this.buttonContactUs.click();
        return new ContactUsPage(driver);
    }

    public AuthenticationPage clickSignInBtn() {
        this.buttonSignIn.click();
        return new AuthenticationPage(driver);
    }

    public HomePage clickSignOutBtn() {
        this.buttonSignOut.click();
        return new HomePage(driver);
    }
}
