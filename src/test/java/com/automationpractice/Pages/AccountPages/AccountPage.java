package com.automationpractice.Pages.AccountPages;

import com.automationpractice.Pages.AccountPages.SecondaryPages.*;
import com.automationpractice.Pages.HomePages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends HomePage {
    
    
    @FindBy( css = "a[title='Orders']" ) private       WebElement buttonOrderHistoryAndDetails;
    @FindBy( css = "a[title='Credit slips']" ) private WebElement buttonMyCreditSlips;
    @FindBy( css = "a[title='Addresses']" ) private    WebElement buttonMyAddresses;
    @FindBy( css = "a[title='Information']" ) private  WebElement buttonMyPersonalInfo;
    @FindBy( css = "a[title='My wishlists']" ) private WebElement buttonMyWishlist;
    @FindBy( css = "a[title='home']" ) private         WebElement buttonHome;
    
    private WebElement getButtonOrderHistoryAndDetails() {
        return this.buttonOrderHistoryAndDetails;
    }
    
    private WebElement getButtonMyCreditSlips() {
        return this.buttonMyCreditSlips;
    }
    
    private WebElement getButtonMyAddresses() {
        return this.buttonMyAddresses;
    }
    
    private WebElement getButtonMyPersonalInfo() {
        return this.buttonMyPersonalInfo;
    }
    
    private WebElement getButtonMyWishlist() {
        return this.buttonMyWishlist;
    }
    
    private WebElement getButtonHome() {
        return this.buttonHome;
    }
    
    public OrderHistoryPage clickOrderHistory() {
        this.getButtonOrderHistoryAndDetails().click();
        return new OrderHistoryPage( getDriver() );
    }
    
    public CreditSlipsPage clickCreditSlips() {
        this.getButtonMyCreditSlips().click();
        return new CreditSlipsPage( getDriver() );
    }
    
    public AddressPage clickAddresses() {
        this.getButtonMyAddresses().click();
        return new AddressPage( getDriver() );
    }
    
    public PersonalInfoPage clickPersonalInfo() {
        this.getButtonMyPersonalInfo().click();
        return new PersonalInfoPage( getDriver() );
    }
    
    public WishListPage clickMyWishes() {
        this.getButtonMyWishlist().click();
        return new WishListPage( getDriver() );
    }
    
    public AccountPage( WebDriver driver ) {
        super( driver );
    }
}
