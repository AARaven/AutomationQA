package com.automationpractice.Tests;

import com.automationpractice.Data.Data;
import Models.User.User;
import com.automationpractice.Page.AuthorizationPage;
import com.automationpractice.Page.StartPage;
import org.testng.annotations.Test;

public class AuthTest extends TestBase {

    @Test(dataProvider = "Users",dataProviderClass = Data.class)
    public void createAndVerifyAccount(User user) {
        StartPage s = new StartPage(this.driver);
        AuthorizationPage a = new AuthorizationPage(this.driver);
        LOGGER.info("Starting new page...");
        a.open();
        LOGGER.info("Trying create account...");
        a.createAnAccount(user);
        LOGGER.info("Trying logIn...");
        a.openUserAccount(user);
    }

    @Test(dataProvider = "Users",dataProviderClass = Data.class)
    public void verifyRecentAccount(User user) {
        LOGGER.info("Initializing webpage...");
        AuthorizationPage auth = new AuthorizationPage(this.driver);
        LOGGER.info("Open authorization page...");
        auth.open();
        LOGGER.info("Verifying recent account...");
        auth.verifyUserAccount(user);
        LOGGER.info("Completed.");
    }
}
