package com.automationpractice.Forms.LoginForms;

import com.automationpractice.Pages.AuthorizationPages.SecondaryPages.PasswordRecoverPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetrievePasswordForm {
    
    private WebDriver driver;
    
    @FindBy( css = "input[id='email']" )
    private WebElement inputEmail;
    @FindBy( xpath = "//p[@class='submit']//button[@type='submit']" )
    private WebElement buttonRetrievePassword;
    
    private WebDriver getDriver() {
        return this.driver;
    }
    
    private void setDriver( WebDriver driver ) {
        this.driver = driver;
    }
    
    private WebElement getInputEmail() {
        return this.inputEmail;
    }
    
    private WebElement getButtonRetrievePassword() {
        return this.buttonRetrievePassword;
    }
    
    public RetrievePasswordForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public RetrievePasswordForm sendEmail( String email ) {
        this.getInputEmail().clear();
        this.getInputEmail().sendKeys( email );
        return this;
    }
    
    public PasswordRecoverPage clickRetrievePassword() {
        this.getButtonRetrievePassword().click();
        return new PasswordRecoverPage( getDriver() );
    }
}
