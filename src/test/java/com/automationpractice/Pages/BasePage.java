package com.automationpractice.Pages;

import Models.Page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends Page {


    @FindBy(id = "contact-link")
    private WebElement buttonContactUs;

    @FindBy(className = "login")
    private WebElement buttonSignIn;

    @FindBy(className = "logout")
    private WebElement buttonSignOut;

    @FindBy(className = "account")
    protected WebElement spanAccount;

    public BasePage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("BaseUrl"));
    }

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
