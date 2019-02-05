package com.automationpractice.Pages.AuthorizationPages.SecondaryPages;

import Models.User.User;
import com.automationpractice.Forms.RegistrationForms.AccountCreationForm;
import com.automationpractice.Pages.AccountPages.AccountPage;
import com.automationpractice.Pages.HomePages.HomePage;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends HomePage {
    
    private AccountCreationForm accountCreationForm = new AccountCreationForm( getDriver() );
    
    private AccountCreationForm getAccountCreationForm() {
        return this.accountCreationForm;
    }
    
    public CreateAccountPage( WebDriver driver ) {
        super( driver );
    }
    
    public CreateAccountPage fillAddressForm( User user ) {
        this.getAccountCreationForm().getAddressForm()
            .sendFirstName( user.getFirstName() )
            .sendLastName( user.getLastName() )
            .sendCompany( user.getAddress().getCompany() )
            .sendAddressOne( user.getAddress().getAddress() )
            .sendAddressTwo( user.getAddress().getAddressSecondLine() )
            .sendCity( user.getAddress().getCity() )
            .selectState( Integer.toString( user.getAddress().getState().getNumber() ) )
            .sendPostCode( user.getAddress().getZipCode() )
            .selectCountry( user.getAddress().getCountry() )
            .sendOther( user.getAdditionalInfo() )
            .sendPhone( user.getHomePhone() )
            .sendPhoneMobile( user.getMobilePhone() )
            .sendAlias( user.getAlias() );
        return this;
    }
    
    public CreateAccountPage fillPersonalInfoForm( User user ) {
        this.getAccountCreationForm().getPersonalInfoForm()
            .setGender( user.getGender().getDescription() )
            .sendFirstName( user.getFirstName() )
            .sendLastName( user.getLastName() )
            .sendEmail( user.getEmail() )
            .sendPassword( user.getPassword() )
            .selectDay( user.getDay() )
            .selectMonth( Integer.toString( user.getMonths().getNumber() ) )
            .selectYear( user.getYear() )
            .setNewsLetters( user.isNewsLetter() )
            .setSpecialOffers( user.isSpecialOffers() );
        return this;
    }
    
    public AccountPage clickSubmit() {
        return this.getAccountCreationForm()
                   .clickSubmit();
    }
    
    //    private static final String ERROR_LIST_PATH = "./src/main/resources/ErrorsLists/errors
    //    .json";
//
//    public CreateAccountPage( WebDriver driver ) {
//        super( driver );
//    }
//
//    @Getter @FindBy( id = "submitAccount" )
//    private WebElement buttonRegister;
//
//    @Getter @FindBy( css = "div.alert.alert-danger" )
//    private WebElement alertDiv;
//
//    public CreateAccountPage fillUserData( User user ) {
//
//        new PersonalInfoSection( driver )
//                .fillPersonalInfoSection( user );
//        new AddressSection( driver )
//                .fillAddressSection( user );
//
//        return this;
//    }
//
//    public CreateAccountPage fillUserDataEmptyValues() {
//
//        new PersonalInfoSection( driver )
//                .unfilledPersonalInfoSection();
//        new AddressSection( driver )
//                .unfilledAddressSection();
//
//        return this;
//    }
//
//    public CreateAccountPage fillUserDataInvalidValues( User user ) {
//
//        new PersonalInfoSection( driver )
//                .fillPersonalInfoSectionInvalidData( user );
//        new AddressSection( driver )
//                .fillAddressSectionInvalidUserData( user );
//
//        return this;
//    }
//
//    public CreateAccountPage typeEmail( String email ) {
//
//        new PersonalInfoSection( driver ).getInputEmail().clear();
//        new PersonalInfoSection( driver ).getInputEmail().sendKeys( email );
//
//        return this;
//    }
//
//    public AccountPages clickRegister() {
//        this.buttonRegister.click();
//
//        return new AccountPages( driver );
//    }
//
//    public SoftAssert verifyThatAlertDivShowEmptyDataErrors() {
//
//        SoftAssert softAssert     = new SoftAssert();
//        WebElement errorContainer = alertDiv.findElement( By.tagName( "ol" ) );
//        String[]   actualErrors   = errorContainer.getText().split( "\\n" );
//        String[]   expectedErrors = getJsonAsStringArray( "requiredErrors", ERROR_LIST_PATH );
//
//        softAssert.assertTrue( alertDiv.isDisplayed(), "Alert message is not displayed." );
//
//        for ( int i = 0; i < actualErrors.length; i++ ) {
//            softAssert.assertTrue( actualErrors[ i ].contains( expectedErrors[ i ] ),
//                                   "The alert message {'" + expectedErrors[ i ] +
//                                   "'} is not displayed." );
//        }
//
//        return softAssert;
//    }
//
//    public SoftAssert verifyThatAlertDivShowInvalidDataErrors() {
//
//        SoftAssert softAssert     = new SoftAssert();
//        WebElement errorContainer = alertDiv.findElement( By.tagName( "ol" ) );
//        String[]   actualErrors   = errorContainer.getText().split( "\\n" );
//        String[]   expectedErrors = getJsonAsStringArray( "invalidErrors", ERROR_LIST_PATH );
//
//        softAssert.assertTrue
//                ( alertDiv.isDisplayed(),
//                  "Alert message is not displayed." );
//
//        for ( int i = 0; i < actualErrors.length; i++ ) {
//            softAssert.assertTrue
//                    ( actualErrors[ i ].contains( expectedErrors[ i ] ),
//                      "The alert message {'" + expectedErrors[ i ] +
//                      "'} is not displayed." );
//        }
//
//        return softAssert;
//    }
//
//    public SoftAssert verifyInputElementsOnPageIsEnabled() {
//        SoftAssert softAssert = new SoftAssert();
//
//        this.driver.findElements( By.tagName( "input" ) )
//                   .forEach( element -> softAssert.assertTrue
//                           ( element.isEnabled(), element.getAttribute( "name" ) ) );
//
//        return softAssert;
//    }
//
//    public SoftAssert verifySelectElementsOnPageIsEnabled() {
//        SoftAssert softAssert = new SoftAssert();
//
//        this.driver.findElements( By.tagName( "select" ) )
//                   .forEach( element -> softAssert.assertTrue
//                           ( element.isEnabled(),
//                             element.getAttribute( "name" ) + " is disabled." ) );
//
//        return softAssert;
//    }
//
//    public SoftAssert verifyTextAreaElementsOnPageIsEnabled() {
//        SoftAssert softAssert = new SoftAssert();
//        this.driver.findElements( By.tagName( "textarea" ) )
//                   .forEach( element -> softAssert.assertTrue
//                           ( element.isEnabled(),
//                             element.getAttribute( "name" ) + " is disabled." ) );
//
//        return softAssert;
//    }
}
