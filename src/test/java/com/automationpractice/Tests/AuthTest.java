package com.automationpractice.Tests;

import Models.User.User;
import com.automationpractice.Data.Data;
import com.automationpractice.Pages.AccountCreationPage;
import com.automationpractice.Pages.AuthorizationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends TestBase {

    @Test(dataProvider = "Users", dataProviderClass = Data.class)
    public void createAnAccountAndVerifyCreation(User user) {
        AuthorizationPage auth = new AuthorizationPage(this.driver);
        AccountCreationPage create = new AccountCreationPage(this.driver);
        auth.openPage();
        auth.fillCreationEmail(user);
        create.setAllFields(user);
        create.pushSubmitAnAccount();
        Assert.assertTrue(auth.isLoginEqualSpanText(user), "Wrong account data.");
        auth.clickSignOutBtn();
    }

    @Test(dataProvider = "Users", dataProviderClass = Data.class)
    public void verifyAnAccountWhichWasCreated(User user) {
        AuthorizationPage auth = new AuthorizationPage(this.driver);
        auth.openPage();
        auth.authorizeAccount(user);
        Assert.assertTrue(auth.isLoginEqualSpanText(user), "Wrong account data.");
        auth.clickSignOutBtn();
    }
}
