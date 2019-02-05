package com.automationpractice.Forms.RegistrationForms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressForm {
    
    private WebDriver driver;
    
    @FindBy( css = "input[id='firstname']" )     private   WebElement inputFirstName;
    @FindBy( css = "input[id='lastname']" )      private   WebElement inputLastName;
    @FindBy( css = "input[id='company']" )       private   WebElement inputCompany;
    @FindBy( css = "input[id='address1']" )      private   WebElement inputAddressOne;
    @FindBy( css = "input[id='address2']" )      private   WebElement inputAddressTwo;
    @FindBy( css = "input[id='city']" )          private   WebElement inputCity;
    @FindBy( css = "select[id='id_state']" )     private   WebElement selectState;
    @FindBy( css = "input[id='postcode']" )      private   WebElement inputPostCode;
    @FindBy( css = "select[id='id_country']" )   private   WebElement selectCountry;
    @FindBy( css = "textarea[id='other']" )      private   WebElement inputOther;
    @FindBy( css = "input[id='phone']" )         private   WebElement inputPhone;
    @FindBy( css = "input[id='phone_mobile']" )  private   WebElement inputPhoneMobile;
    @FindBy( css = "input[id='alias']" )         private   WebElement inputAlias;
    
    private WebDriver getDriver() {
        return this.driver;
    }
    
    private void setDriver( WebDriver driver ) {
        this.driver = driver;
    }
    
    private WebElement getInputFirstName() {
        return this.inputFirstName;
    }
    
    private WebElement getInputLastName() {
        return this.inputLastName;
    }
    
    private WebElement getInputCompany() {
        return this.inputCompany;
    }
    
    private WebElement getInputAddressOne() {
        return this.inputAddressOne;
    }
    
    private WebElement getInputAddressTwo() {
        return this.inputAddressTwo;
    }
    
    private WebElement getInputCity() {
        return this.inputCity;
    }
    
    private WebElement getSelectState() {
        return this.selectState;
    }
    
    private WebElement getInputPostCode() {
        return this.inputPostCode;
    }
    
    private WebElement getSelectCountry() {
        return this.selectCountry;
    }
    
    private WebElement getInputOther() {
        return this.inputOther;
    }
    
    private WebElement getInputPhone() {
        return this.inputPhone;
    }
    
    private WebElement getInputPhoneMobile() {
        return this.inputPhoneMobile;
    }
    
    private WebElement getInputAlias() {
        return this.inputAlias;
    }
    
    public AddressForm sendFirstName( String firstname ) {
        this.getInputFirstName().clear();
        this.getInputFirstName().sendKeys( firstname );
        return this;
    }
    
    public AddressForm sendLastName( String lastname ) {
        this.getInputLastName().clear();
        this.getInputLastName().sendKeys( lastname );
        return this;
    }
    
    public AddressForm sendCompany( String company ) {
        this.getInputCompany().clear();
        this.getInputCompany().sendKeys( company );
        return this;
    }
    
    public AddressForm sendAddressOne( String address1 ) {
        this.getInputAddressOne().clear();
        this.getInputAddressOne().sendKeys( address1 );
        return this;
    }
    
    public AddressForm sendAddressTwo( String address2 ) {
        this.getInputAddressTwo().clear();
        this.getInputAddressTwo().sendKeys( address2 );
        return this;
    }
    
    public AddressForm sendCity( String city ) {
        this.getInputCity().clear();
        this.getInputCity().sendKeys( city );
        return this;
    }
    
    public AddressForm selectState( String state ) {
        if ( state.equals( "0" ) ) {
            new Select( this.getSelectState() ).selectByValue( "" );
        } else {
            new Select( this.getSelectState() ).selectByValue( state );
        }
        return this;
    }
    
    public AddressForm sendPostCode( String postcode ) {
        this.getInputPostCode().clear();
        this.getInputPostCode().sendKeys( postcode );
        return this;
    }
    
    public AddressForm selectCountry( String country ) {
        new Select( this.getSelectCountry() ).selectByVisibleText( country );
        return this;
    }
    
    public AddressForm sendOther( String additionalInfo ) {
        this.getInputOther().clear();
        this.getInputOther().sendKeys( additionalInfo );
        return this;
    }
    
    public AddressForm sendPhone( String phone ) {
        this.getInputPhone().clear();
        this.getInputPhone().sendKeys( phone );
        return this;
    }
    
    public AddressForm sendPhoneMobile( String phoneMobile ) {
        this.getInputPhoneMobile().clear();
        this.getInputPhoneMobile().sendKeys( phoneMobile );
        return this;
    }
    
    public AddressForm sendAlias( String alias ) {
        this.getInputAlias().clear();
        this.getInputAlias().sendKeys( alias );
        return this;
    }
    
    public AddressForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}
