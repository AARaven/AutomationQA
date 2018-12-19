package com.automationpractice.Tests.Positive;

import Models.User.User;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.HomePage.HomePage;
import com.automationpractice.Tests.TestBase;
import org.testng.annotations.Test;

public class OrderTests extends TestBase {

    @Test(dataProvider = "User", dataProviderClass = AccountCreationAndVerifyingTests.class)
    public void searchTShirtAndAddToCaret(User user) {
        HomePage home = new HomePage(driver);
        home.navigate();
        home.clickSignInBtn()
                .authorizeUser(user);
        home
                .searchText("T-shirt")
                .chooseTShirt("Faded Short Sleeve T-shirts")
                .clickAddToCart();

        AccountPage account = new AccountPage(driver);
        account.navigate();
        account.clickOrderHistory().refresh();
    }

    @Test
    public void verifyThatTShirtWasAddedToOrderHistory() {
        AccountPage account = new AccountPage(driver);

        account.navigate();

        account
                .clickOrderHistory();
    }

}
