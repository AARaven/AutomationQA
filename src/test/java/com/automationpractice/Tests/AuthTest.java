package com.automationpractice.Tests;

import Models.User.User;
import com.automationpractice.Data.Data;
import com.automationpractice.Pages.AuthorizationPage;
import org.testng.annotations.Test;

public class AuthTest extends TestBase {

    @Test(dataProvider = "Users",dataProviderClass = Data.class)
    public void createAndVerifyAccount(User user) {
        AuthorizationPage a = new AuthorizationPage(driver);
        LOGGER.info("Starting new page...");
        a.open();
        LOGGER.info("Trying create account...");
        a.createAnAccountAndSignOut(user);
        LOGGER.info("Trying logIn...");
        a.openUserAccount(user);
    }

    @Test(dataProvider = "Users",dataProviderClass = Data.class)
    public void verifyRecentAccount(User user) {
        LOGGER.info("Initializing webpage...");
        AuthorizationPage auth = new AuthorizationPage(driver);
        LOGGER.info("Open authorization page...");
        auth.open();
        LOGGER.info("Verifying recent account...");
        auth.verifyUserAccount(user);
        LOGGER.info("Completed.");
    }
}
