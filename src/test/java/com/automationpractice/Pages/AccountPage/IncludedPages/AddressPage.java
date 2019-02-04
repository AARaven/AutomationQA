package com.automationpractice.Pages.AccountPage.IncludedPages;

import Models.User.User;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.AddressSection;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class AddressPage extends AccountPage {
    
    private AddressSection userAddress = new AddressSection( driver );
    
    public AddressPage( WebDriver driver ) {
        super( driver );
    }
    
    @Getter @FindBy( id = "submitAddress" )
    private WebElement buttonSubmitAddress;
    
    @Getter @FindBy( linkText = "Update" )
    private WebElement buttonUpdate;
    
    @Getter @FindBy( linkText = "Delete" )
    private WebElement buttonDelete;
    
    @Getter @FindBy( linkText = "Add an address" )
    private WebElement buttonAddAddress;
    
    @Getter @FindBy( xpath = "//a[@class='btn btn-defaul button button-small']" )
    private WebElement buttonBackToYourAddresses;
    
    public AddressPage clickUpdate() {
        buttonUpdate.click();
        return new AddressPage( driver );
    }
    
    public AddressPage clickDelete() {
        buttonDelete.click();
        return this;
    }
    
    public AddressPage clickSubmitAddress() {
        buttonSubmitAddress.click();
        return this;
    }
    
    public AddressPage clickAddAddress() {
        buttonAddAddress.click();
        return this;
    }
    
    public AddressPage clickBackToYourAddresses() {
        buttonBackToYourAddresses.click();
        return this;
    }
    
    public AddressPage rewriteAll( User user ) {
        rewriteFirstName
                ( user.getFirstName() );
        rewriteLastName
                ( user.getLastName() );
        rewriteCompany
                ( user.getAddress().getCompany() );
        rewriteAddress
                ( user.getAddress().getAddress() );
        rewriteAddressSecondLine
                ( user.getAddress().getAddressSecondLine() );
        rewriteCity
                ( user.getAddress().getCity() );
//        rewriteState
//                (user.getState());
        rewriteZip
                ( user.getAddress().getZipCode() );
//        rewriteCountry
//                (user.getCountry());
        rewriteHomePhone
                ( user.getHomePhone() );
        rewriteMobilePhone
                ( user.getMobilePhone() );
        rewriteAdditionalInfo
                ( user.getAdditionalInfo() );
        rewriteAlias
                ( user.getAlias() );
        return this;
    }
    
    public SoftAssert verifyUserAddress( User user ) {
        SoftAssert softAssert = new SoftAssert();
        
        softAssert.assertTrue
                ( isUserFirstName( user ),
                  "User first name is not correct" );
        softAssert.assertTrue
                ( isUserLastName( user ),
                  "User last name is not correct" );
        softAssert.assertTrue
                ( isUserCompany( user ),
                  "User company is not correct" );
        softAssert.assertTrue
                ( isUserAddress( user ),
                  "User address is not correct" );
        softAssert.assertTrue
                ( isUserAddressSecondLine( user ),
                  "User address second line is not correct" );
        softAssert.assertTrue
                ( isUserCity( user ),
                  "User city is not correct" );
        softAssert.assertTrue
                ( isUserState( user ),
                  "User state is not correct" );
        softAssert.assertTrue
                ( isUserZip( user ),
                  "User zip is not correct" );
        softAssert.assertTrue
                ( isUserCountry( user ),
                  "User country is not correct" );
        softAssert.assertTrue
                ( isUserHomePhone( user ),
                  "User home phone is not correct" );
        softAssert.assertTrue
                ( isUserMobilePhone( user ),
                  "User mobile phone is not correct" );
        softAssert.assertTrue
                ( isUserAdditionalInfo( user ),
                  "User additional information is not correct" );
        softAssert.assertTrue
                ( isUserAlias( user ),
                  "User alias is not correct" );
        return softAssert;
    }
    
    private AddressPage rewriteFirstName( String firstname ) {
        rewriteElement( userAddress.getInputFirstName(), firstname );
        return this;
    }
    
    private AddressPage rewriteLastName( String lastname ) {
        rewriteElement( userAddress.getInputLastName(), lastname );
        return this;
    }
    
    private AddressPage rewriteCompany( String company ) {
        rewriteElement( userAddress.getInputCompany(), company );
        return this;
    }
    
    private AddressPage rewriteAddress( String address ) {
        rewriteElement( userAddress.getInputAddress1(), address );
        return this;
    }
    
    private AddressPage rewriteAddressSecondLine( String address2 ) {
        rewriteElement( userAddress.getInputAddress2(), address2 );
        return this;
    }
    
    private AddressPage rewriteCity( String city ) {
        rewriteElement( userAddress.getInputCity(), city );
        return this;
    }
    
    private AddressPage rewriteState( String state ) {
        new Select( userAddress.getSelectState() ).selectByValue( state );
        return this;
    }
    
    private AddressPage rewriteZip( String zip ) {
        rewriteElement( userAddress.getInputZipCode(), zip );
        return this;
    }
    
    private AddressPage rewriteCountry( String country ) {
        new Select( userAddress.getSelectCountry() ).selectByValue( country );
        return this;
    }
    
    private AddressPage rewriteHomePhone( String homePhone ) {
        rewriteElement( userAddress.getInputPhone(), homePhone );
        return this;
    }
    
    private AddressPage rewriteMobilePhone( String mobilePhone ) {
        rewriteElement( userAddress.getInputPhoneMobile(), mobilePhone );
        return this;
    }
    
    private AddressPage rewriteAdditionalInfo( String info ) {
        rewriteElement( userAddress.getInputAdditionalInfo(), info );
        return this;
    }
    
    private AddressPage rewriteAlias( String alias ) {
        rewriteElement( userAddress.getInputAlias(), alias );
        return this;
    }
    
    private boolean isUserFirstName( User user ) {
        return user.getFirstName()
                   .equals( userAddress.getInputFirstName()
                                       .getAttribute( "number" ) );
    }
    
    private boolean isUserLastName( User user ) {
        return user.getLastName()
                   .equals( userAddress.getInputLastName()
                                       .getAttribute( "number" ) );
    }
    
    private boolean isUserCompany( User user ) {
        return user.getAddress().getCompany()
                   .equals( userAddress.getInputCompany()
                                       .getAttribute( "number" ) );
    }
    
    private boolean isUserAddress( User user ) {
        return user.getAddress()
                   .equals( userAddress.getInputAddress1()
                                       .getAttribute( "number" ) );
    }
    
    private boolean isUserAddressSecondLine( User user ) {
        return user.getAddress().getAddressSecondLine()
                   .equals( userAddress.getInputAddress2()
                                       .getAttribute( "number" ) );
    }
    
    private boolean isUserCity( User user ) {
        return user.getAddress().getCity()
                   .equals( userAddress.getInputCity()
                                       .getAttribute( "number" ) );
    }
    
    private boolean isUserState( User user ) {
        return user.getAddress().getState()
                   .equals( new Select( userAddress.getSelectState() )
                                    .getFirstSelectedOption()
                                    .getText() );
    }
    
    private boolean isUserZip( User user ) {
        return user.getAddress().getZipCode()
                   .equals( userAddress.getInputZipCode()
                                       .getAttribute( "number" ) );
    }
    
    private boolean isUserCountry( User user ) {
        return user.getAddress().getCountry()
                   .equals( new Select( userAddress.getSelectCountry() )
                                    .getFirstSelectedOption()
                                    .getText() );
    }
    
    private boolean isUserHomePhone( User user ) {
        return user.getHomePhone()
                   .equals( userAddress.getInputPhone()
                                       .getAttribute( "number" ) );
    }
    
    private boolean isUserMobilePhone( User user ) {
        return user.getMobilePhone()
                   .equals( userAddress.getInputPhoneMobile()
                                       .getAttribute( "number" ) );
    }
    
    private boolean isUserAdditionalInfo( User user ) {
        return user.getAdditionalInfo()
                   .equals( userAddress.getInputAdditionalInfo()
                                       .getAttribute( "number" ) );
    }
    
    private boolean isUserAlias( User user ) {
        if ( user.getAlias().equals( "" ) ) {
            return true;
        }
        return user.getAlias()
                   .equals( userAddress.getInputAlias()
                                       .getAttribute( "number" ) );
    }
}
