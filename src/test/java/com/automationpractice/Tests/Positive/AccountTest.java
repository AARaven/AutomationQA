package com.automationpractice.Tests.Positive;

import Models.User.User;
import com.automationpractice.Data.UserData;
import com.automationpractice.Pages.AccountPages.AccountPage;
import com.automationpractice.Pages.AccountPages.SecondaryPages.PersonalInfoPage;
import com.automationpractice.Pages.AuthorizationPages.AuthenticationPage;
import com.automationpractice.Pages.AuthorizationPages.SecondaryPages.CreateAccountPage;
import com.automationpractice.Tests.BaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AccountTest extends BaseTest {
    
    private AccountPage authorizeUser( User user ) {
        AuthenticationPage authentication = new AuthenticationPage( getDriver() );
        AccountPage        account        = new AccountPage( getDriver() );
    
        authentication
                .openPage();
        authentication
                .getLoginForm()
                .sendEmail( user.getEmail() )
                .sendPassword( user.getPassword() )
                .clickSignIn();
    
        account
                .getAccountRow()
                .verifyUser( user ).assertAll();
        
        return account;
    }
    
    @Test( description = "Test that implement creation an account.",
           dataProvider = "ValidUser", dataProviderClass = UserData.class )
    @Step( "Navigate to authentication page and create a new account." )
    public void testAccountCreation( User user ) {
        
        AuthenticationPage authentication = new AuthenticationPage( getDriver() );
        CreateAccountPage  creation       = new CreateAccountPage( getDriver() );
        AccountPage        account        = new AccountPage( getDriver() );
        
        authentication
                .openPage();
        authentication
                .getCreateAccountForm()
                .sendEmail( user.getEmail() )
                .clickSubmit();
        
        creation
                .fillPersonalInfoForm( user )
                .fillAddressForm( user )
                .clickSubmit();
        
        account
                .getAccountRow()
                .verifyUser( user ).assertAll();
        account
                .getAccountRow()
                .clickSignOut();
    }
    
    @Test( description = "Test that implement authorization an account.",
           dataProvider = "ValidUser", dataProviderClass = UserData.class )
    @Step( "Navigate to authentication page and authorize an account." )
    public void testAccountAuthorization( User user ) {
        
        AuthenticationPage authentication = new AuthenticationPage( getDriver() );
        AccountPage        account        = new AccountPage( getDriver() );
        
        authentication
                .openPage();
        authentication
                .getLoginForm()
                .sendEmail( user.getEmail() )
                .sendPassword( user.getPassword() )
                .clickSignIn();
        
        account
                .getAccountRow()
                .verifyUser( user ).assertAll();
        account
                .getAccountRow()
                .clickSignOut();
    }
    
    @Test( description = "Test that implement verifying account personal info.",
           dataProvider = "ValidUser", dataProviderClass = UserData.class )
    @Step( "Navigate to personal info page from account page and verify personal info." )
    public void testVerifyingPersonalInfo( User user ) {
        
        AuthenticationPage authentication = new AuthenticationPage( getDriver() );
        AccountPage        account        = new AccountPage( getDriver() );
        PersonalInfoPage   personalInfo   = new PersonalInfoPage( getDriver() );
        
        authentication
                .openPage();
        authentication
                .authorizeUser( user );
        
        account
                .clickPersonalInfo();

//        personalInfo


//        myAccount
//                .clickMyAccountInfoPage()
//                .verifyPersonalInfo( user )
//                .assertAll();
//
//        myAccount.clickSignOut();
    }
    
    @Test( description = "Test that implement verifying account address.",
           dataProvider = "ValidUser", dataProviderClass = UserData.class )
    @Step( "Navigate to address page from account page and verify address." )
    public void testVerifyingAddress( User user ) {
        
        AuthenticationPage authentication = new AuthenticationPage( getDriver() );
        AccountPage        account        = new AccountPage( getDriver() );
        
        authentication
                .openPage();
        authentication
                .authorizeUser( user );
        
        account
                .clickAddresses()
                .clickUpdate();
//                .verifyUserAddress( user )
//                .assertAll();
        account
                .getAccountRow()
                .clickSignOut();
    }
    
    @Test( description = "Test that implement rewriting personal info in current account.",
           dataProvider = "Users", dataProviderClass = UserData.class )
    @Step( "Navigate to account page and rewrite personal info." )
    public void testRewritingPersonalInfo( User user, User otherUser ) {
        
        AuthenticationPage authentication = new AuthenticationPage( getDriver() );
        AccountPage        account        = new AccountPage( getDriver() );
        
        authentication
                .openPage();
        authentication
                .authorizeUser( user );
        
        account
                .clickPersonalInfo();
//                .rewriteAll( otherUser )
//                .clickSave();
        account
                .getAccountRow()
                .clickSignOut();
    }
    
    @Test( description = "Test that implement rewriting address in current account.",
           dataProvider = "Users", dataProviderClass = UserData.class )
    @Step( "Navigate to address page from account page and rewrite address." )
    public void testRewritingAddress( User user, User otherUser ) {
        
        AuthenticationPage authentication = new AuthenticationPage( getDriver() );
        AccountPage        account        = new AccountPage( getDriver() );
        
        authentication
                .openPage();
        authentication
                .authorizeUser( user );
        
        account
                .clickAddresses()
                .clickUpdate();
//                .rewriteAll( otherUser )
//                .clickSubmitAddress();
        account
                .getAccountRow()
                .clickSignOut();
    }
}
