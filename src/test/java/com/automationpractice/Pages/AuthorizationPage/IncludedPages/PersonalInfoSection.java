package com.automationpractice.Pages.AuthorizationPage.IncludedPages;

import Models.User.User;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PersonalInfoSection {
    
    public PersonalInfoSection( WebDriver driver ) {
        PageFactory.initElements( driver, this );
    }
    
    @Getter @FindBy( id = "id_gender1" )
    private WebElement radioGenderMale;
    
    @Getter @FindBy( id = "id_gender2" )
    private WebElement radioGenderFemale;
    
    @Getter @FindBy( id = "newsletter" )
    private WebElement checkboxNewsLetter;
    
    @Getter @FindBy( id = "optin" )
    private WebElement checkboxSpecialOffers;
    
    @Getter @FindBy( id = "days" )
    private WebElement selectDays;
    
    @Getter @FindBy( id = "months" )
    private WebElement selectMonths;
    
    @Getter @FindBy( id = "years" )
    private WebElement selectYears;
    
    @Getter @FindBy( id = "customer_firstname" )
    private WebElement inputCustomerFirstName;
    
    @Getter @FindBy( id = "customer_lastname" )
    private WebElement inputCustomerLastName;
    
    @Getter @FindBy( id = "passwd" )
    private WebElement inputPassword;
    
    @Getter @FindBy( id = "email" )
    private WebElement inputEmail;
    
    void fillPersonalInfoSection( User user ) {
        setGender( user );
        setDataFields
                ( inputCustomerFirstName, user.getFirstName() );
        setDataFields
                ( inputCustomerLastName, user.getLastName() );
        setDataFields
                ( inputPassword, user.getPassword() );
        setDataFields
                ( inputEmail, user.getEmail() );
        
        setDateOfBirth(
                user.getDay(),
                Integer.toString( user.getMonths().getNumber() ),
                user.getYear()
                      );
        setNewsLetter( user );
        setSpecialOffers( user );
    }
    
    void unfilledPersonalInfoSection() {
        setDataFields( inputEmail, "" );
    }
    
    void fillPersonalInfoSectionInvalidData( User user ) {
        setGender( user );
        setDataFields
                ( inputCustomerFirstName, user.getFirstName() );
        setDataFields
                ( inputCustomerLastName, user.getLastName() );
        setDataFields
                ( inputPassword, user.getPassword() );
        setNewsLetter( user );
        setSpecialOffers( user );
    }
    
    private void setGender( User user ) {
        if ( ( user.getGender().name().equals( "MALE" ) ) ) {
            this.getRadioGenderMale().click();
        } else {
            this.getRadioGenderFemale().click();
        }
    }
    
    private void setDateOfBirth( String day, String month, String year ) {
        new Select( this.selectDays ).selectByValue( day );
        new Select( this.selectMonths ).selectByValue( month );
        new Select( this.selectYears ).selectByValue( year );
    }
    
    private void setNewsLetter( User user ) {
        if ( user.isNewsLetter() ) this.checkboxNewsLetter.click();
    }
    
    private void setSpecialOffers( User user ) {
        if ( user.isSpecialOffers() ) this.checkboxSpecialOffers.click();
    }
    
    private void setDataFields( WebElement element, String value ) {
        element.clear();
        if ( value.isEmpty() ) element.clear();
        else element.sendKeys( value );
    }
}
