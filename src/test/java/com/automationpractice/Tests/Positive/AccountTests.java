package com.automationpractice.Tests.Positive;

import Models.User.User;
import com.automationpractice.Data.UserData;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.AccountCreationPage;
import com.automationpractice.Tests.BaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class AccountTests extends BaseTest {
	
	@Test( dataProvider = "ValidUser", dataProviderClass = UserData.class,
			description = "A test that implement creation an account." )
	@Step( "Navigate to authentication page and create a new account." )
	public void creationAnAccount( User user ) {
		AuthenticationPage authentication =
				new AuthenticationPage( driver );
		
		authentication.navigate();
		
		AccountCreationPage creation =
				authentication
						.setEmail( user )
						.clickSubmitCreate();
		creation
				.fillUserData( user )
				.clickRegister();
	}
	
	@Test( dataProvider = "ValidUser", dataProviderClass = UserData.class,
			description = "A test that implement authorization an account." )
	@Step( "Navigate to authentication page and authorize an account." )
	public void accountAuthorization( User user ) {
		AuthenticationPage authentication = new AuthenticationPage( this.driver );
		authentication.navigate();
		authentication
				.authorizeUser( user );
	}
	
	@Test( dataProvider = "ValidUser", dataProviderClass = UserData.class,
			description = "A test that implement verifying account personal info." )
	@Step( "Navigate to personal info page from account page and verify personal info." )
	public void verifyUserPersonalInfo( User user ) {
		AccountPage myAccount = new AccountPage( driver );
		myAccount.navigate();
		myAccount
				.clickMyAccountInfoPage()
				.verifyPersonalInfo( user )
				.assertAll();
	}
	
	@Test( dataProvider = "ValidUser", dataProviderClass = UserData.class,
			description = "A test that implement verifying account address." )
	@Step( "Navigate to address page from account page and verify address." )
	public void verifyUserAddress( User user ) {
		AccountPage myAccount = new AccountPage( driver );
		myAccount.navigate();
		myAccount
				.clickMyAddressPage()
				.clickUpdate()
				.verifyUserAddress( user )
				.assertAll();
	}
	
	@Test( dataProvider = "Users", dataProviderClass = UserData.class,
			description = "A test that implement rewriting personal info in current account." )
	@Step( "Navigate to account page and rewrite personal info." )
	public void rewriteUserPersonalInfo( User user, User otherUser ) {
		AuthenticationPage authentication =
				new AuthenticationPage( driver );
		
		authentication.navigate();
		
		AccountPage myAccount =
				authentication
						.authorizeUser( user );
		myAccount
				.clickMyAccountInfoPage()
				.rewriteAll( otherUser )
				.clickSave();
	}
	
	@Test( dataProvider = "Users", dataProviderClass = UserData.class,
			description = "A test that implement rewriting address in current account." )
	@Step( "Navigate to address page from account page and rewrite address." )
	public void rewriteUserAddress( User user, User otherUser ) {
		AuthenticationPage authentication =
				new AuthenticationPage( driver );
		
		authentication.navigate();
		
		AccountPage myAccount =
				authentication
						.authorizeUser( user );
		myAccount
				.clickMyAddressPage()
				.clickUpdate()
				.rewriteAll( otherUser )
				.clickSubmitAddress();
	}
}
