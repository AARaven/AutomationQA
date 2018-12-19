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

    @DataProvider(name = "User")
    public Object[][] getUser() {
        return new Object[][]{
                {data.getData("Alex", User.class, USERS_INVALID_PATH)}
        };
    }

    @Test(dataProvider = "User")
    public void negativeCreationUser(User user) {
        AuthenticationPage authentication = new AuthenticationPage(driver);
        authentication.navigate();

        authentication
                .setEmail("asdf@asdf.tu")
                .clickSubmitCreate();

        CreateAccountPage creation =
                new CreateAccountPage(driver);

        creation
                .setFieldsUserInvalidData()
                .clickRegister();

        creation.verifyAlert().assertAll();

    }
}
