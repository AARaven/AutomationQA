package com.automationpractice.Pages.AuthenticationPage.SplitedPages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class MyAccountPage extends NavigationForMyAccountPages {

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("MyAccountPage"));
        log.debug("creating an object MyAccountPage");
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

    public void clickMyAddresses() {
        this.buttonMyAddresses.click();
    }

    public void clickMyPersonalInfo() {
        this.buttonMyPersonalInfo.click();
    }

    public void clickMyWishLists() {
        this.buttonMyWishlist.click();
    }
}
