package com.automationpractice.Pages.StartPage;

import Models.Page.Page;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class StartPage extends Page {

    public StartPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("StartPage"));
        log.debug("creating an object StartPage");
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
