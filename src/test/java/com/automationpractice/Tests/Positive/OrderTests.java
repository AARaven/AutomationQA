package com.automationpractice.Tests.Positive;

import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.HomePage.HomePage;
import com.automationpractice.Tests.TestBase;
import org.testng.annotations.Test;

public class OrderTests extends TestBase {

    @Test
    public void searchTShirtAndAddToCaret() {
        HomePage home = new HomePage(driver);
        home.navigate();

        home
                .searchText("T-shirts")
                .clickOnProduct();
    }

    @Test
    public void verifyThatTShirtWasAddedToOrderHistory() {
        AccountPage account = new AccountPage(driver);

        account.navigate();

        account
                .clickOrderHistory();
    }

}
