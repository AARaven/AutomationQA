package com.automationpractice.Pages.AuthenticationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class Account {

    Account(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "icon-list-ol")
    private WebElement buttonOrderHistoryAndDetails;

    @FindBy(className = "icon-ban-circle")
    private WebElement buttonMyCreditSlips;

    @FindBy(className = "icon-building")
    private WebElement buttonMyAddresses;

    @FindBy(className = "icon-user")
    private WebElement buttonMyPersonalInfo;

    @FindBy(className = "icon-heart")
    private WebElement buttonMyWishlist;

    @FindBy(className = "info-account")
    private WebElement textInfoAccount;

    @FindBy(className = "btn btn-default button button-small")
    private WebElement buttonUpdate;

    public void clickOrderHistoryAndDetails() {
        this.buttonOrderHistoryAndDetails.click();
    }

    public void clickMyCreditSlips() {
        this.buttonMyCreditSlips.click();
    }

    public void clickMyPersonalInfo() {
        this.buttonMyPersonalInfo.click();
    }

    public void clickMyAddresses() {
        this.buttonMyAddresses.click();
    }

    public void clickMyWishlists() {
        this.buttonMyWishlist.click();
    }

    public boolean verifyTextInfoAccount(String target) {
        return this.textInfoAccount.getText().equals(target);
    }

}
