package com.automationpractice.Tests.Positive;

import Models.User.User;
import com.automationpractice.Data.Data;
import com.automationpractice.Pages.HomePage.HomePage;
import com.automationpractice.Tests.TestBase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Log4j2
public class AccountCreationTest extends TestBase {

    private static final String USERS_VALID_PATH =
            "./src/main/resources/UsersProfiles/Valid/UsersProfiles.json";

    private Data data = new Data();

    @DataProvider(name = "Users")
    public Object[][] getUser() {
        return new Object[][]{
                {data.getData
                        ("Alex", User.class, USERS_VALID_PATH)},
        };
    }

//    @Test(dataProvider = "Users")
//    public void creationAnAccountAndVerifyThatAccountCreated(User user) {
//        String expectedTitle = "My account - My Store";
//        AuthenticationPage auth =
//                new AuthenticationPage(driver);
//
//        auth.navigate();
//
//        auth
//                .setEmail(user)
//                .clickSubmitCreate()
//                .setFieldsUserData(user)
//                .clickRegister();
//
//        Assert.assertEquals
//                (driver.getTitle(), expectedTitle, "Wrong title.");
//    }
//
//    @Test(dataProvider = "Users")
//    public void logInUserAndVerifyUserAddress(User user) {
//        AuthenticationPage auth =
//                new AuthenticationPage(driver);
//
//        auth.navigate();
//
//        auth
//                .authorizeUser(user)
//                .clickMyAddressPage()
//                .verifyUserAddress(user)
//                .assertAll();
//    }
//
//    @Test(dataProvider = "Users")
//    public void logInUserVerifyUserPersonalInfo(User user) {
//        AuthenticationPage auth =
//                new AuthenticationPage(driver);
//
//        auth.navigate();
//
//        auth
//                .authorizeUser(user)
//                .clickMyAccountInfoPage()
//                .verifyPersonalInfo(user)
//                .assertAll();
//    }

    @Test(dataProvider = "Users")
    public void logInUserVerifyUserPersonalInfo(User user) {
        HomePage home = new HomePage(driver);
        home.navigate();

        home
                .clickSignInBtn()
                .setEmail(user)
                .clickSubmitCreate()
                .setFieldsUserData(user)
                .clickRegister();

    }
}
