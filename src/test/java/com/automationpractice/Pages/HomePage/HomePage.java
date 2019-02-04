package com.automationpractice.Pages.HomePage;

import Models.WebPage.BasePage;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.HomePage.IncludedPages.ContactUsPage;
import com.automationpractice.Pages.HomePage.IncludedPages.SearchPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    
    public HomePage( WebDriver driver ) {
        super( driver );
    }
    
    @Getter @FindBy( id = "search_query_top" )
    private WebElement inputSearch;
    
    @Getter @FindBy( id = "contact-link" )
    private WebElement buttonContactUs;
    
    @Getter @FindBy( className = "logout" )
    private WebElement buttonSignOut;
    
    @Getter @FindBy( className = "account" )
    private WebElement buttonAccount;
    
    @Getter @FindBy( css = "a[class=login]" )
    private WebElement buttonSignIn;
    
    public HomePage clickSignOut() {
        this.getButtonSignIn().click();
        
        return new HomePage( getDriver() );
    }
    
    public ContactUsPage clickContactUs() {
        this.getButtonContactUs().click();
        
        return new ContactUsPage( getDriver() );
    }
    
    public AuthenticationPage clickSignIn() {
        this.getButtonSignIn().click();
        
        return new AuthenticationPage( getDriver() );
    }
    
    public SearchPage typeToSearchField( String text ) {
        this.getInputSearch().sendKeys( text );
        this.getInputSearch().submit();
        
        return new SearchPage( getDriver() );
    }
}
