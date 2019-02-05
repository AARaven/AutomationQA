package com.automationpractice.Forms.LoginForms;

import com.automationpractice.Pages.AuthorizationPages.SecondaryPages.CreateAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountForm {
    
    private WebDriver driver;
    
    @FindBy( css = "input[id='email_create']" ) private  WebElement inputEmail;
    @FindBy( css = "button[id='SubmitCreate']" ) private WebElement buttonSubmit;
    
    private WebDriver getDriver() {
        return this.driver;
    }
    
    private void setDriver( WebDriver driver ) {
        this.driver = driver;
    }
    
    private WebElement getInputEmail() {
        return this.inputEmail;
    }
    
    private WebElement getButtonSubmit() {
        return this.buttonSubmit;
    }
    
    public CreateAccountForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public CreateAccountForm sendEmail( String email ) {
        this.getInputEmail().clear();
        this.getInputEmail().sendKeys( email );
        return this;
    }
    
    public CreateAccountPage clickSubmit() {
        this.getButtonSubmit().click();
        return new CreateAccountPage( getDriver() );
    }
}
