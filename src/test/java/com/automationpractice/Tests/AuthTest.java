package com.automationpractice.Tests;

import Models.User.User;
import com.automationpractice.Data.Data;
import com.automationpractice.Pages.AuthenticationPage.AuthenticationPage;
import com.automationpractice.Pages.AuthenticationPage.SplitedPages.MyAddressPage;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Log4j2
public class AuthTest extends TestBase {

    private static final String
            USERS_VALID_PATH = "./src/main/resources/UsersProfiles/Valid/UsersProfiles.json";
    private static final String
            USERS_INVALID_PATH = "./src/main/resources/UsersProfiles/Invalid/UsersProfiles.json";

    private Data data = new Data();

    @Parameters("UsersJsonPath")
    @DataProvider(name = "Users")
    public Object[][] getUser() {
        return new Object[][]{
                {data.getData("Alex", User.class, USERS_VALID_PATH)},
//                {data.getData("John", User.class, USERS_VALID_PATH)},
        };
    }

    @Test(dataProvider = "Users")
    public void createAnAccount(User user) {
        AuthenticationPage auth = new AuthenticationPage(this.driver);

        log.info("Open authorization page.");
        auth
                .openPage();

        log.info("Create an account.");
        auth
                .createAccount(user);

        log.info("Click 'sign out' button.");
        auth
                .clickSignOutBtn();
    }

    @Test(dataProvider = "Users")
    public void verifyPersonalInfo(User user) {
        AuthenticationPage auth = new AuthenticationPage(driver);

        log.info("Open authorization page.");
        auth
                .openPage();

        log.info("Authorize user");
        auth
                .authorizeUser(user);

        log.info("Open personal info page.");
        auth.personalInfoPage
                .openPage();

        log.info("Verify personal info.");
        auth.personalInfoPage
                .verifyPersonalInfo(user)
                .assertAll();

        log.info("Click 'sign out' button.");
        auth
                .clickSignOutBtn();
    }

    @Test(dataProvider = "Users")
    public void verifyUserAddress(User user) {
        AuthenticationPage auth = new AuthenticationPage(this.driver);
        MyAddressPage address = new MyAddressPage(this.driver);

        log.info("Open authorization page and authorize user");
        auth
                .openPage();
        auth
                .authorizeUser(user);

        log.info("Open myAddress page.");
        address
                .openPage();

        log.info("Click 'update'.");
        address
                .clickUpdate();

        log.info("Verify addresses information.");
        address
                .verifyUserAddress(user)
                .assertAll();

        log.info("Click 'sign out' button.");
        auth
                .clickSignOutBtn();
    }

    @Test(dataProvider = "Users")
    public void rewriteUserPersonalInfoAndCheckIt(User user) {
        AuthenticationPage auth = new AuthenticationPage(driver);

        log.info("Open authentication page.");
        auth
                .openPage();

        log.info("Authorize user.");
        auth
                .authorizeUser(user);

        log.info("Open personal info page.");
        auth.personalInfoPage
                .openPage();

        log.info("Change user gender.");
        auth.personalInfoPage
                .changeUserGender("female");

        log.info("Confirm old password.");
        auth.personalInfoPage
                .confirmPassword(user);

        log.info("Click on save button.");
        auth.personalInfoPage
                .clickSave();

        log.info("Verify success of procedure.");
        Assert.assertTrue
                (auth.personalInfoPage.verifyAlertSuccess());
    }

//    @Test(dataProvider = "Users")
//    public void rewriteUserAddressAndCheckIt(User user) {
//
//    }
}
