package com.automationpractice.Tests.Positive;

import Models.User.User;
import com.automationpractice.Data.Data;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.CreateAccountPage;
import com.automationpractice.Pages.HomePage.HomePage;
import com.automationpractice.Tests.TestBase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Log4j2
public class AccountCreationAndVerifyingTests extends TestBase {

    private static final String USERS_VALID_PATH =
            "./src/main/resources/UsersProfiles/Valid/UsersProfiles.json";

    private Data data = new Data();

    @DataProvider(name = "User")
    public Object[][] getUser() {
        return new Object[][]{
                {data.getData("Alex", User.class, USERS_VALID_PATH)}
        };
    }

    @DataProvider(name = "Users")
    public Object[][] getUsers() {
        return new Object[][]{
                {data.getData
                        ("Alex", User.class, USERS_VALID_PATH),
                        data.getData("John", User.class, USERS_VALID_PATH)},
        };
    }

    @Test(dataProvider = "User")
    public void creationAnAccount(User user) {
        AuthenticationPage authenticationPage =
                new AuthenticationPage(driver);

        authenticationPage
                .navigate();

        CreateAccountPage createAccountPage =
                authenticationPage
                        .setEmail(user)
                        .clickSubmitCreate();

        createAccountPage
                .setFieldsUserData(user)
                .clickRegister()
                .clickSignOutBtn();

        //Or this:
//        HomePage home = new HomePage(driver);
//        home.navigate();
//        home
//                .clickSignInBtn()
//                .createAccount(user)
//                .clickSignOutBtn();
    }

    @Test(dataProvider = "User")
    public void verifyUserPersonalInfo(User user) {
        AuthenticationPage authenticationPage =
                new AuthenticationPage(driver);

        authenticationPage
                .navigate();

        AccountPage account =
                authenticationPage
                        .authorizeUser(user);

        account
                .clickMyAccountInfoPage()
                .verifyPersonalInfo(user)
                .assertAll();
    }

    @Test(dataProvider = "User")
    public void verifyUserAddress(User user) {
        AuthenticationPage authenticationPage =
                new AuthenticationPage(driver);

        authenticationPage
                .navigate();

        AccountPage account =
                authenticationPage
                        .authorizeUser(user);

        account
                .clickMyAddressPage()
                .clickUpdate()
                .verifyUserAddress(user)
                .assertAll();
    }

    @Test(dataProvider = "Users")
    public void rewriteUserPersonalInfo(User user, User otherUser) {
        HomePage home =
                new HomePage(driver);
        home.navigate();

        home.clickSignInBtn();

        AccountPage account =
                new AuthenticationPage(driver)
                        .authorizeUser(user);

        account
                .clickMyAccountInfoPage()
                .rewriteAll(otherUser)
                .verifyPersonalInfo(user)
                .assertAll();
    }

    @Test(dataProvider = "Users")
    public void rewriteUserAddress(User user, User otherUser) {
        HomePage home =
                new HomePage(driver);
        home.navigate();

        home.clickSignInBtn();

        AccountPage account =
                new AuthenticationPage(driver)
                        .authorizeUser(user);

        account
                .clickMyAddressPage()
                .clickUpdate()
                .rewriteAll(otherUser)
                .verifyUserAddress(user)
                .assertAll();
    }
}
