package com.automationpractice.Tests.Negative;

import Models.User.User;
import com.automationpractice.Data.UserData;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.AccountCreationPage;
import com.automationpractice.Tests.BaseTest;
import org.testng.annotations.Test;

public class NegativeCreationTest extends BaseTest {
	
	@Test( dataProvider = "InvalidUser", dataProviderClass = UserData.class )
	public void creationWithEmptyData( User user ) {
		AuthenticationPage authentication =
				new AuthenticationPage( getDriver() );
		AccountCreationPage creation =
				new AccountCreationPage( getDriver() );
		
		authentication.navigate();
		
		authentication
				.setEmail( user.getEmail() )
				.clickSubmitCreate();
		
		creation
				.fillUserDataEmptyValues()
				.clickRegister();
		
		creation.
				verifyThatAlertDivShowEmptyDataErrors()
				.assertAll();
	}
	
	@Test( dataProvider = "InvalidUser", dataProviderClass = UserData.class )
	public void creationWithInvalidData( User user ) {
		AuthenticationPage authentication =
				new AuthenticationPage( getDriver() );
		AccountCreationPage creation =
				new AccountCreationPage( getDriver() );
		
		authentication.navigate();
		
		authentication
				.setEmail( user.getEmail() )
				.clickSubmitCreate();
		
		creation
				.fillUserDataInvalidValues( user )
				.typeEmail( "!@#$!%" )
				.clickRegister();
		creation
				.verifyThatAlertDivShowInvalidDataErrors()
				.assertAll();
	}
}
