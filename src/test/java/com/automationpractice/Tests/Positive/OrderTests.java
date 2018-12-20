package com.automationpractice.Tests.Positive;

import Models.User.User;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.HomePage.HomePage;
import com.automationpractice.Pages.HomePage.IncludedPages.SearchPage;
import com.automationpractice.Tests.TestBase;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class OrderTests extends TestBase {

    @Test(dataProvider = "User", dataProviderClass = AccountCreationAndVerifyingTests.class)
    public void searchTShirtAndAddToCaret(User user) {
        HomePage home = new HomePage(driver);
        AuthenticationPage auth = new AuthenticationPage(driver);
        AccountPage account = new AccountPage(driver);
        home.navigate();

        SearchPage search = home.searchText("T-shirt");

        search
                .chooseTShirt("Faded Short Sleeve")
                .clickAddToCart()
                .clickSubmitSummary()
                .clickSubmitSignIn();

        auth
                .authorizeUser(user);

        search
                .clickSubmitAddress()
                .clickCheckBoxAgree()
                .clickProcessCarier()
                .clickBankWire()
                .clickConfirmMyOrder()
                .verifyOrderIsComplete()
                .assertAll();

        account .navigate();
        account
                .clickOrderHistory()
                .clickOnPdfFile();
    }


    @Test
    public void verifyThatTShirtWasAddedToOrderHistory() {
        AccountPage account = new AccountPage(driver);

        account.navigate();

        account
                .clickOrderHistory();
    }

}
