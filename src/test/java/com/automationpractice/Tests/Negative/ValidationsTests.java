package com.automationpractice.Tests.Negative;

import Models.User.User;
import com.automationpractice.Data.Data;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.CreateAccountPage;
import com.automationpractice.Tests.TestBase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Log4j2
public class ValidationsTests extends TestBase {

    private static final String USERS_INVALID_PATH =
            "./src/main/resources/UsersProfiles/Invalid/UsersProfiles.json";

    private Data data = new Data();

    @DataProvider(name = "InvalidUser")
    public Object[][] getInvalidUser() {
        return new Object[][]{
                {data.getData("InvalidAlex", User.class, USERS_INVALID_PATH)}
        };
    }

    @Test(dataProvider = "InvalidUser")
    public void creationAnAccountWithEmptyUserData(User user) {
        AuthenticationPage authentication =
                new AuthenticationPage(driver);
        authentication.navigate();

        authentication
                .setEmail(user.getEmail())
                .clickSubmitCreate();

        CreateAccountPage creation =
                new CreateAccountPage(driver);

        creation
                .setFieldsUserEmptyData()
                .clickRegister();

        creation.verifyUserEmptyDataAlert().assertAll();
    }

    @Test(dataProvider = "InvalidUser")
    public void creationAnAccountWithInvalidUserData(User user) {
        AuthenticationPage authentication =
                new AuthenticationPage(driver);
        authentication.navigate();

        CreateAccountPage creation =
                authentication
                        .setEmail(user.getEmail())
                        .clickSubmitCreate();

        creation
                .setFieldsUserInvalidData(user)
                .setEmail("!@#$!%")
                .clickRegister();

        creation
                .verifyUserInvalidDataAlert()
                .assertAll();

    }
}
