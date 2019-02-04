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

public class OrderTest extends BaseTest {
    
    @Test( dataProvider = "ValidUser", dataProviderClass = UserData.class,
           description = "A test that implementing creation an order." )
    @Step( "Product search and ordering." )
    public void searchProductAndOrdering( User user ) {
        
        HomePage           home           = new HomePage( getDriver() );
        SearchPage         search         = new SearchPage( getDriver() );
        AuthenticationPage authentication = new AuthenticationPage( getDriver() );
        AccountPage        myAccount      = new AccountPage( getDriver() );
        
        home.openPage();
        
        home.typeToSearchField( "dress" );
        
        search
                .chooseProduct( "Printed Dress" )
                .clickAddToCart()
                .clickSubmitSummary()
                .clickSubmitSignIn();
        
        authentication.authorizeUser( user );
        
        search
                .clickSubmitAddress()
                .clickCheckBoxAgree()
                .clickProcessCarrier()
                .clickBankWire()
                .clickConfirmMyOrder()
                .verifyOrderIsComplete()
                .assertAll();
        
        myAccount.openPage();
        
        myAccount
                .clickOrderHistory()
                .downloadOrderAsPdf();
        
        myAccount.clickSignOut();
    }
    
    @Test( description = "A test that implementing verifying that file is downloaded and suffix " +
                         "is .pdf" )
    @Step( "Verifying that order was saved as a pdf file" )
    public void verifyingDownloadedFile() {
        OrderHistoryPage order = new OrderHistoryPage( getDriver() );
        
        Assert.assertFalse( order.isDownloaded(), "File with .pdf suffix is not exist." );
        System.out.println( order.getDownloadFileName() );
    }
}
