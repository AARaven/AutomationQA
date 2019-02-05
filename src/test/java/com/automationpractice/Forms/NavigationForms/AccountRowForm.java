package com.automationpractice.Forms.NavigationForms;

import Models.User.User;
import com.automationpractice.Pages.AuthorizationPages.AuthenticationPage;
import com.automationpractice.Pages.HomePages.SecondaryPages.ContactUsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AccountRowForm {
    
    private WebDriver driver;
    
    @FindBy( css = "a[class=login]" ) private       WebElement buttonSignIn;
    @FindBy( css = "a[class=logout]" ) private      WebElement buttonSignOut;
    @FindBy( css = "div[id=contact-link]" ) private WebElement buttonContactUs;
    @FindBy( css = "a[class=account]" ) private     WebElement buttonAccount;
    
    private WebDriver getDriver() {
        return this.driver;
    }
    
    private void setDriver( WebDriver driver ) {
        this.driver = driver;
    }
    
    private WebElement getButtonSignIn() {
        return this.buttonSignIn;
    }
    
    private WebElement getButtonSignOut() {
        return this.buttonSignOut;
    }
    
    private WebElement getButtonContactUs() {
        return this.buttonContactUs;
    }
    
    private WebElement getButtonAccount() {
        return this.buttonAccount;
    }
    
    public AccountRowForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public AuthenticationPage clickSignIn() {
        this.getButtonSignIn().click();
        return new AuthenticationPage( getDriver() );
    }
    
    public ContactUsPage clickContactUs() {
        this.getButtonContactUs().click();
        return new ContactUsPage( getDriver() );
    }
    
    public void clickAccountButton() {
        this.getButtonAccount().click();
    }
    
    
    public AuthenticationPage clickSignOut() {
        this.getButtonSignOut().click();
        return new AuthenticationPage( getDriver() );
    }
    
    public SoftAssert verifyUser( User user ) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( this.getButtonAccount().getText(),
                                 user.getFirstName() + " " + ( user.getLastName() ) );
        return softAssert;
    }
}
