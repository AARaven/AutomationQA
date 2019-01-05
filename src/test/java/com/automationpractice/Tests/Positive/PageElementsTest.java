package com.automationpractice.Tests.Positive;

import Models.User.User;
import com.automationpractice.Data.UserData;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.AccountCreationPage;
import com.automationpractice.Pages.HomePage.HomePage;
import com.automationpractice.Tests.BaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class PageElementsTest extends BaseTest {
	
	@Test( description = "A test that implements" +
			" the verification of elements on the creation an account page." )
	@Step( "Verifying that elements on creation an account page is enabled." )
	public void verifyingElementsIsEnabled() {
		AuthenticationPage authentication =
				new AuthenticationPage( getDriver() );
		AccountCreationPage creation =
				new AccountCreationPage( getDriver() );
		
		authentication.navigate();
		
		authentication
				.setEmail( "asd12fdVf@as2df.ru" )
				.clickSubmitCreate();
		
		creation
				.verifyInputElementsOnPageIsEnabled()
				.assertAll();
		
		creation
				.verifySelectElementsOnPageIsEnabled()
				.assertAll();
		
		creation
				.verifyTextAreaElementsOnPageIsEnabled()
				.assertAll();
	}
	
	@Test( dataProvider = "ValidUser", dataProviderClass = UserData.class )
	public void exampleTestElements( User user ) {
		HomePage home = new HomePage( getDriver() );
		AuthenticationPage authentication = new AuthenticationPage( getDriver() );
		AccountPage myAccount = new AccountPage( getDriver() );
		
		home
				.navigate();
		home
				.clickSignIn();
		
		authentication
				.authorizeUser( user );
		
		
	}
}
