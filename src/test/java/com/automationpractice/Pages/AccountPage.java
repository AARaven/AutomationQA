package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    private static final String ACCOUNT_PAGE_URL = "http://automationpractice.com/index.php?controller=my-account";

    public AccountPage(WebDriver driver) {
        super(driver);
        this.setUrl(ACCOUNT_PAGE_URL);
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

    public void clickMyWishlist() {
        this.buttonMyWishlist.click();
    }

    public boolean verifyTextInfoAccount(String target) {
        return this.textInfoAccount.getText().equals(target);
    }
}
