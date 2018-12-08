package SeleniumTest.com.automationpractice.Tests;

import SeleniumTest.com.automationpractice.Models.User;
import SeleniumTest.com.automationpractice.Page.AuthorizationPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthTest extends TestBase {

//    @DataProvider(name = "UserEmail")
//    public Object[][] userEmail() {
//        return new Object[][]{
//                {"conflict@gmail.com"},
//                {"soBakA@mail.ru"},
//                {"Spoke11@yandex.ru"},
//                {"newTone@rambler.ru"},
//                {"Krakazya6ra@zya6ra.org"}
//        };
//    }

    @DataProvider(name = "Users")
    public Object[][] userPassword() {
        return new Object[][]{
                {new User()},
//                {new User()},
//                {new User()},
//                {new User()},
//                {new User()}
        };
    }

    @Test(dataProvider = "Users")
    public void createAndVerifyAccount(User user) {
        AuthorizationPage a = new AuthorizationPage(this.driver);
        LOGGER.info("Starting new page");
        a.open();
        a.createAnAccount(user);
//        a.verifyUserAccount(user);
//        a.openUserAccount(user);
    }

    @Test(dataProvider = "Users")
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
