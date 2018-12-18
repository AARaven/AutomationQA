package com.automationpractice.Pages.AccountPage;

import com.automationpractice.Pages.AccountPage.IncludedPages.*;
import com.automationpractice.Pages.HomePage.HomePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class AccountPage extends HomePage {

    public AccountPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl(getClass().getSimpleName()));
        log.debug("Creating an instance AccountPage");
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

    @FindBy(linkText = "Home")
    private WebElement buttonMainHome;

    @FindBy(xpath = "//ul[@class='footer_links clearfix']//li[1]//a[1]")
    private WebElement buttonBactToYourAccount;

    @FindBy(xpath = "//ul[@class='footer_links clearfix']//li[2]//a[1]")
    private WebElement buttonHome;

    public HomePage clickHome() {
        if (this.getCurrentUrl().equals(
                "http://automationpractice.com/" +
                        "index.php?controller=my-account")) {
            this.buttonMainHome.click();
        } else this.buttonHome.click();
        return new HomePage(driver);
    }

    public AccountPage clickBackToYourAccount() {
        this.buttonBactToYourAccount.click();
        return new AccountPage(driver);
    }

    public OrderHistoryPage clickOrderHistory() {
        this.buttonOrderHistoryAndDetails.click();
        return new OrderHistoryPage(driver);
    }

    public CreditSlipsPage clickMyCreditSlipsPage() {
        this.buttonMyCreditSlips.click();
        return new CreditSlipsPage(driver);
    }

    public AddressPage clickMyAddressPage() {
        this.buttonMyAddresses.click();
        return new AddressPage(driver);
    }

    public AccountInfoPage clickMyAccountInfoPage() {
        this.buttonMyPersonalInfo.click();
        return new AccountInfoPage(driver);
    }

    public WishListPage clickMyWishListPage() {
        this.buttonMyWishlist.click();
        return new WishListPage(driver);
    }

    protected void rewriteElement(WebElement element,String value) {
        element.clear();
        element.sendKeys(value);
    }
}
