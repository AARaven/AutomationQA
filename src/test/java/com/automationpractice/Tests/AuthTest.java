package com.automationpractice.Tests;

import Models.User.User;
import com.automationpractice.Data.Data;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Log4j2
public class AuthTest extends TestBase {

    private static final String
            USERS_VALID_PATH = "./src/main/resources/UsersProfiles/Valid/UsersProfiles.json";
    private static final String
            USERS_INVALID_PATH = "./src/main/resources/UsersProfiles/Invalid/UsersProfiles.json";

    private Data data = new Data();

    @DataProvider(name = "Users")
    public Object[][] getUser() {
        return new Object[][]{
                {data.getData("Alex", User.class, USERS_VALID_PATH),
                        data.getData("John", User.class, USERS_VALID_PATH)},
        };
    }

    @Test(dataProvider = "Users")
    public void createAnAccount(User user) {
        AuthenticationPage auth =
                new AuthenticationPage(this.driver);

        log.info("Open authorization page.");
        auth.navigate();

        log.info("Create an account.");
        auth
                .setEmail(user)
                .clickSubmitCreate()
                .setFieldsUserData(user)
                .clickRegister();

        log.info("Click 'sign out' button.");
        auth
                .clickSignOutBtn();
    }

    @Test(dataProvider = "Users")
    public void verifyPersonalInfo(User user) {
        AuthenticationPage auth =
                new AuthenticationPage(driver);

        log.info("Open authorization page.");
        auth
                .navigate();

        log.info("Authorize user");
        log.info("Open personal info page.");
        log.info("Verify personal info.");
        auth
                .authorizeUser(user)
                .clickMyAccountInfoPage()
                .verifyPersonalInfo(user)
                .assertAll();

        log.info("Logging out.");
        auth
                .clickSignOutBtn();
    }

    @Test(dataProvider = "Users")
    public void verifyUserAddress(User user) {
        AuthenticationPage auth =
                new AuthenticationPage(this.driver);

        log.info("Open authorization page.");
        auth
                .navigate();

        log.info("Authorization user and verify him address.");
        auth

                .authorizeUser(user)
                .clickMyAddressPage()
                .verifyUserAddress(user)
                .assertAll();

        log.info("Logging out.");
        auth
                .clickSignOutBtn();
    }

    @Test(dataProvider = "Users")
    public void simpleTestRefactor(User user) {
        AuthenticationPage auth =
                new AuthenticationPage(driver);
        auth.navigate();
        auth
                .authorizeUser(user)
                .clickMyAccountInfoPage()
                .verifyPersonalInfo(user)
                .assertAll();
    }

    @Test(dataProvider = "Users")
    public void rewriteUserAddress(User user, User temp) {
        AuthenticationPage authenticationPage =
                new AuthenticationPage(driver);
        authenticationPage.navigate();

        authenticationPage
                .authorizeUser(user)
                .clickMyAddressPage()
                .clickUpdate()
                .rewriteAll(temp);
    }
}
