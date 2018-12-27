package com.automationpractice.Tests.Positive;

import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.AccountCreationPage;
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
}
