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
	public void verifyingElementsOnPageIsEnabled() {
		AuthenticationPage authentication = new AuthenticationPage( driver );
		authentication.navigate();
		
		AccountCreationPage creation =
				authentication
						.setEmail( "asasdfdf@asdf.ru" )
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
