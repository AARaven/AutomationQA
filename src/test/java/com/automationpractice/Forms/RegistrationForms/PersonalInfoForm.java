package com.automationpractice.Forms.RegistrationForms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PersonalInfoForm {
    
    private WebDriver driver;
    
    @FindBy( css = "input[id='id_gender1']" ) private         WebElement radioMale;
    @FindBy( css = "input[id='id_gender2']" ) private         WebElement radioFemale;
    @FindBy( css = "input[id='customer_firstname']" ) private WebElement inputFirstName;
    @FindBy( css = "input[id='customer_lastname']" ) private  WebElement inputLastName;
    @FindBy( css = "input[id='email']" ) private              WebElement inputEmail;
    @FindBy( css = "input[id='passwd']" ) private             WebElement inputPassword;
    @FindBy( css = "select[id='days']" ) private              WebElement selectDays;
    @FindBy( css = "select[id='months']" ) private            WebElement selectMonths;
    @FindBy( css = "select[id='years']" ) private             WebElement selectYears;
    @FindBy( css = "input[id='newsletter']" ) private         WebElement checkboxNewsLetters;
    @FindBy( css = "input[id='optin']" ) private              WebElement checkboxSpecialOffers;
    
    private WebDriver getDriver() {
        return this.driver;
    }
    
    private void setDriver( WebDriver driver ) {
        this.driver = driver;
    }
    
    private WebElement getRadioMale() {
        return this.radioMale;
    }
    
    private WebElement getRadioFemale() {
        return this.radioFemale;
    }
    
    private WebElement getInputFirstName() {
        return this.inputFirstName;
    }
    
    private WebElement getInputLastName() {
        return this.inputLastName;
    }
    
    private WebElement getInputEmail() {
        return this.inputEmail;
    }
    
    private WebElement getInputPassword() {
        return this.inputPassword;
    }
    
    private WebElement getSelectDays() {
        return this.selectDays;
    }
    
    private WebElement getSelectMonths() {
        return this.selectMonths;
    }
    
    private WebElement getSelectYears() {
        return this.selectYears;
    }
    
    private WebElement getCheckboxNewsLetters() {
        return this.checkboxNewsLetters;
    }
    
    private WebElement getCheckboxSpecialOffers() {
        return this.checkboxSpecialOffers;
    }
    
    public PersonalInfoForm clickRadioMale() {
        this.getRadioMale().click();
        return this;
    }
    
    public PersonalInfoForm clickRadioFemale() {
        this.getRadioFemale().click();
        return this;
    }
    
    public PersonalInfoForm setGender( String gender ) {
        if ( gender.equals( "Male" ) ) this.getRadioMale().click();
        this.getRadioFemale().click();
        return this;
    }
    
    public PersonalInfoForm sendFirstName( String firstname ) {
        this.getInputFirstName().clear();
        this.getInputFirstName().sendKeys( firstname );
        return this;
    }
    
    public PersonalInfoForm sendLastName( String lastname ) {
        this.getInputLastName().clear();
        this.getInputLastName().sendKeys( lastname );
        return this;
    }
    
    public PersonalInfoForm sendEmail( String email ) {
        this.getInputEmail().clear();
        this.getInputEmail().sendKeys( email );
        return this;
    }
    
    public PersonalInfoForm sendPassword( String password ) {
        this.getInputPassword().clear();
        this.getInputPassword().sendKeys( password );
        return this;
    }
    
    public PersonalInfoForm selectDay( String day ) {
        new Select( this.getSelectDays() ).selectByValue( day );
        return this;
    }
    
    public PersonalInfoForm selectMonth( String month ) {
        if ( month.equals( "0" ) ) {
            new Select( this.getSelectMonths() ).selectByValue( "" );
        } else {
            new Select( this.getSelectMonths() ).selectByValue( month );
        }
        return this;
    }
    
    public PersonalInfoForm selectYear( String year ) {
        new Select( this.getSelectYears() ).selectByValue( year );
        return this;
    }
    
    public PersonalInfoForm clickNewsLetters() {
        this.getCheckboxNewsLetters().click();
        return this;
    }
    
    public PersonalInfoForm setNewsLetters( boolean newsletter ) {
        if ( newsletter ) this.getCheckboxNewsLetters().click();
        return this;
    }
    
    public PersonalInfoForm clickSpecialOffers() {
        this.getCheckboxSpecialOffers().click();
        return this;
    }
    
    public PersonalInfoForm setSpecialOffers( boolean specialOffers ) {
        if ( specialOffers ) this.getCheckboxSpecialOffers().click();
        return this;
    }
    
    public PersonalInfoForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}
