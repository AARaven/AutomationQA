package com.automationpractice.Pages.AccountPage;

import com.automationpractice.Pages.AccountPage.IncludedPages.*;
import com.automationpractice.Pages.HomePage.HomePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends HomePage {
    
    public AccountPage( WebDriver driver ) {
        super( driver );
    }
    
    @Getter @FindBy( className = "icon-list-ol" )
    private WebElement buttonOrderHistoryAndDetails;
    
    @Getter @FindBy( className = "icon-ban-circle" )
    private WebElement buttonMyCreditSlips;
    
    @Getter @FindBy( className = "icon-building" )
    private WebElement buttonMyAddresses;
    
    @Getter @FindBy( className = "icon-user" )
    private WebElement buttonMyPersonalInfo;
    
    @Getter @FindBy( className = "icon-heart" )
    private WebElement buttonMyWishlist;
    
    @Getter @FindBy( className = "info-account" )
    private WebElement textInfoAccount;
    
    @Getter @FindBy( linkText = "Home" )
    private WebElement buttonMainHome;
    
    @Getter @FindBy( xpath = "//ul[@class='footer_links clearfix']//li[1]//a[1]" )
    private WebElement buttonBactToYourAccount;
    
    @Getter @FindBy( xpath = "//ul[@class='footer_links clearfix']//li[2]//a[1]" )
    private WebElement buttonHome;
    
    public AccountPage clickBackToYourAccount() {
        this.buttonBactToYourAccount.click();
        return new AccountPage( driver );
    }
    
    public OrderHistoryPage clickOrderHistory() {
        this.buttonOrderHistoryAndDetails.click();
        return new OrderHistoryPage( driver );
    }
    
    public CreditSlipsPage clickMyCreditSlipsPage() {
        this.buttonMyCreditSlips.click();
        return new CreditSlipsPage( driver );
    }
    
    public AddressPage clickMyAddressPage() {
        this.buttonMyAddresses.click();
        return new AddressPage( driver );
    }
    
    public AccountInfoPage clickMyAccountInfoPage() {
        this.buttonMyPersonalInfo.click();
        return new AccountInfoPage( driver );
    }
    
    public WishListPage clickMyWishListPage() {
        this.buttonMyWishlist.click();
        return new WishListPage( driver );
    }
    
    protected void rewriteElement( WebElement element, String value ) {
        element.clear();
        element.sendKeys( value );
    }
}
