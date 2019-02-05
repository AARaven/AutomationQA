package com.automationpractice.Forms.LoginForms;

import com.automationpractice.Pages.AccountPages.AccountPage;
import com.automationpractice.Pages.AuthorizationPages.SecondaryPages.PasswordRecoverPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginForm {
    
    private WebDriver driver;
    
    @FindBy( css = "input[id='email']" )
    private WebElement inputEmail;
    @FindBy( css = "input[id='passwd']" )
    private WebElement inputPassword;
    @FindBy( css = "a[title='Recover your forgotten password']" )
    private WebElement linkRecoverForgottenPassword;
    @FindBy( css = "button[id='SubmitLogin']" )
    private WebElement buttonSubmit;
    
    private WebDriver getDriver() {
        return this.driver;
    }
    
    private void setDriver( WebDriver driver ) {
        this.driver = driver;
    }
    
    private WebElement getInputEmail() {
        return this.inputEmail;
    }
    
    private WebElement getInputPassword() {
        return this.inputPassword;
    }
    
    private WebElement getLinkRecoverForgottenPassword() {
        return this.linkRecoverForgottenPassword;
    }
    
    private WebElement getButtonSubmit() {
        return this.buttonSubmit;
    }
    
    public LoginForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public LoginForm sendEmail( String email ) {
        this.getInputEmail().clear();
        this.getInputEmail().sendKeys( email );
        return this;
    }
    
    public LoginForm sendPassword( String password ) {
        this.getInputPassword().clear();
        this.getInputPassword().sendKeys( password );
        return this;
    }
    
    public PasswordRecoverPage clickRecoverPassword() {
        this.getLinkRecoverForgottenPassword().click();
        return new PasswordRecoverPage( getDriver() );
    }
    
    public AccountPage clickSignIn() {
        this.getButtonSubmit().click();
        return new AccountPage( getDriver() );
    }
}
