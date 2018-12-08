package SeleniumTest.com.automationpractice.Tests;

import SeleniumTest.com.automationpractice.Models.User;
import SeleniumTest.com.automationpractice.Page.AccountCreationPage;
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
        AccountCreationPage a = new AccountCreationPage(this.driver);
        a.open();
        a.registerAccount(user);
        a.verifyAccount();
    }
}
