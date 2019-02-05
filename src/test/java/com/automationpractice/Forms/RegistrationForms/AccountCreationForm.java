package com.automationpractice.Forms.RegistrationForms;

import com.automationpractice.Pages.AccountPages.AccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationForm {
    
    private WebDriver driver;
    
    @FindBy( css = "button[id='submitAccount']" ) private WebElement buttonSubmit;
    
    private WebDriver getDriver() {
        return this.driver;
    }
    
    private void setDriver( WebDriver driver ) {
        this.driver = driver;
    }
    
    private WebElement getButtonSubmit() {
        return this.buttonSubmit;
    }
    
    public PersonalInfoForm getPersonalInfoForm() {
        return new PersonalInfoForm( getDriver() );
    }
    
    public AddressForm getAddressForm() {
        return new AddressForm( getDriver() );
    }
    
    public AccountPage clickSubmit() {
        this.getButtonSubmit().click();
        return new AccountPage( getDriver() );
    }
    
    public AccountCreationForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}
