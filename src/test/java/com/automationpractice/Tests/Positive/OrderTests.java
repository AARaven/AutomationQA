package com.automationpractice.Tests.Positive;

import Models.User.User;
import com.automationpractice.Data.UserData;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.AccountPage.IncludedPages.OrderHistoryPage;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.HomePage.HomePage;
import com.automationpractice.Pages.HomePage.IncludedPages.SearchPage;
import com.automationpractice.Tests.BaseTest;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTests extends BaseTest {
	
	@Test( dataProvider = "ValidUser", dataProviderClass = UserData.class,
			description = "A test that implementing creation an order." )
	@Step( "Product search and ordering." )
	public void searchProductAndOrdering( User user ) throws InterruptedException {
		HomePage home = new HomePage( driver );
		AuthenticationPage authentication = new AuthenticationPage( driver );
		AccountPage myAccount = new AccountPage( driver );
		home.navigate();
		
		SearchPage search = home.typeToSearchField( "dress" );
		
		search
				.chooseProduct( "Printed Dress" )
				.clickAddToCart()
				.clickSubmitSummary()
				.clickSubmitSignIn();
		authentication
				.authorizeUser( user );
		search
				.clickSubmitAddress()
				.clickCheckBoxAgree()
				.clickProcessCarrier()
				.clickBankWire()
				.clickConfirmMyOrder()
				.verifyOrderIsComplete()
				.assertAll();
		
		myAccount.navigate();
		
		myAccount
				.clickOrderHistory()
				.downloadOrderAsPdf();
	}
	
	@Test( description = "A test that implementing verifying that file is downloaded and suffix is .pdf" )
	@Step( "Verifying that order was saved as a pdf file" )
	public void verifyingDownloadedFileSavedAsPDF() {
		OrderHistoryPage order = new OrderHistoryPage( driver );
		Assert.assertFalse( order.isDownloaded(), "File with .pdf suffix is not exist." );
		System.out.println(order.getDownloadFileName());
	}
}
