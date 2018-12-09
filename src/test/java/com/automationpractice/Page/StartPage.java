package com.automationpractice.Page;

import Models.Page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends Page {

    //Button contact us:
    @FindBy(id = "contact-link")
    private WebElement contactUsBtn;

    //Button sign in:
    @FindBy(className = "login")
    private WebElement signInBtn;

    //Button sign out:
    @FindBy(className = "logout")
    private WebElement signOutBtn;

    //CONSTRUCTOR:
    public StartPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("BaseUrl"));
//        this.setUrl(getJsonUrl("BaseUrl"));
    }

    protected void pressContactUsBtn() {
        this.contactUsBtn.click();
    }

    protected void pressSignInBtn() {
        this.signInBtn.click();
    }

    protected void pressSignOutBtn() {
        this.signOutBtn.click();
    }
}
