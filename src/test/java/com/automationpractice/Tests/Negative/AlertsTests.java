package com.automationpractice.Tests.Negative;

import Models.User.User;
import com.automationpractice.Data.Data;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Tests.TestBase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Log4j2
public class AlertsTests extends TestBase {

    private static final String USERS_VALID_PATH =
            "./src/main/resources/UsersProfiles/Valid/UsersProfiles.json";

    private Data data = new Data();

    @DataProvider(name = "User")
    public Object[][] getUser() {
        return new Object[][]{
                {data.getData("Alex", User.class, USERS_VALID_PATH)}
        };
    }

    @Test
    public void negativeCreationUser() {
        AuthenticationPage authentication = new AuthenticationPage(driver);
        authentication.navigate();

        authentication
                .setEmail("asdf@asdf")
                .clickSubmitCreate();

        authentication
                .verifyAlertMessage()
                .assertAll();
    }
}
