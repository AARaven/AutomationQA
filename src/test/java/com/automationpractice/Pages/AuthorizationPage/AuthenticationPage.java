package com.automationpractice.Pages.AuthorizationPage;

import Models.User.User;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.AccountCreationPage;
import com.automationpractice.Pages.HomePage.HomePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends HomePage {
    
    @Getter @FindBy( id = "email_create" )
    private WebElement inputEmail;
    
    @Getter @FindBy( id = "SubmitCreate" )
    private WebElement buttonCreate;
    
    @Getter @FindBy( id = "email" )
    private WebElement inputCurrentEmail;
    
    @Getter @FindBy( id = "passwd" )
    private WebElement inputPassword;
    
    @Getter @FindBy( id = "SubmitLogin" )
    private WebElement buttonSubmitLogin;
    
    @Getter @FindBy( css = "a[title='Recover your forgotten password']" )
    private WebElement linkForgotYourPassword;
    
    public AuthenticationPage( WebDriver driver ) {
        super( driver );
    }
    
    public AuthenticationPage setEmail( User user ) {
        this.inputEmail.clear();
        this.inputEmail.sendKeys( user.getEmail() );
        return this;
        
    }
    
    public AuthenticationPage setEmail( String value ) {
        this.inputEmail.clear();
        this.inputEmail.sendKeys( value );
        
        return this;
    }
    
    public AuthenticationPage setCurrentEmail( User user ) {
        this.inputCurrentEmail.clear();
        this.inputCurrentEmail.sendKeys( user.getEmail() );
        
        return this;
        
    }
    
    public AuthenticationPage setCurrentPassword( User user ) {
        this.inputPassword.clear();
        this.inputPassword.sendKeys( user.getPassword() );
        
        return this;
    }
    
    public AuthenticationPage clickForgotYourPassword() {
        this.linkForgotYourPassword.click();
        
        return this;
    }
    
    public AccountCreationPage clickSubmitCreate() {
        this.buttonCreate.click();
        
        return new AccountCreationPage( driver );
    }
    
    public AccountPage clickSubmitLogin() {
        this.buttonSubmitLogin.clear();
        
        return new AccountPage( driver );
    }
    
    public AccountPage createAccount( User user ) {
        this.inputEmail.sendKeys( user.getEmail() );
        this.buttonCreate.click();
        
        return new AccountCreationPage( driver ).fillUserData( user )
                                                .clickRegister();
    }
    
    public AccountPage authorizeUser( User user ) {
        this.inputCurrentEmail.sendKeys( user.getEmail() );
        this.inputPassword.sendKeys( user.getPassword() );
        this.buttonSubmitLogin.click();
        
        return new AccountPage( driver );
    }
}
