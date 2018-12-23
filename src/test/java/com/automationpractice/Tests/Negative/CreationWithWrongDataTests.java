package com.automationpractice.Tests.Negative;

import Models.User.User;
import com.automationpractice.Data.UserData;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.AccountCreationPage;
import com.automationpractice.Tests.BaseTest;
import org.testng.annotations.Test;

public class CreationWithWrongDataTests extends BaseTest {
	
	@Test( dataProvider = "InvalidUser", dataProviderClass = UserData.class )
	public void creationAnAccountWithEmptyUserData( User user ) {
		AuthenticationPage authentication =
				new AuthenticationPage( driver );
		
		authentication.navigate();
		authentication
				.setEmail( user.getEmail() )
				.clickSubmitCreate();
		
		AccountCreationPage creation =
				new AccountCreationPage( driver );
		creation
				.fillUserDataEmptyValues()
				.clickRegister();
		creation.
				verifyThatAlertDivShowEmptyDataErrors()
				.assertAll();
	}
	
	@Test( dataProvider = "InvalidUser", dataProviderClass = UserData.class )
	public void creationAnAccountWithInvalidUserData( User user ) {
		AuthenticationPage authentication =
				new AuthenticationPage( driver );
		authentication.navigate();
		
		AccountCreationPage creation =
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
