package SeleniumTest.com.automationpractice.Tests;

import SeleniumTest.com.automationpractice.Models.User;
import SeleniumTest.com.automationpractice.Page.CreateAnAccPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthTest extends TestBase {

    @DataProvider(name = "UserEmail")
    public Object[][] userEmail() {
        return new Object[][]{
                {"conflict@gmail.com"},
//                {"soBakA@mail.ru"},
//                {"Spoke11@yandex.ru"},
//                {"newTone@rambler.ru"},
//                {"Krakazya6ra@zya6ra.org"}
        };
    }

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
    public void getTest(User user) throws Exception {
        CreateAnAccPage create = new CreateAnAccPage(this.driver);
        create.open();
        create.registerAccount(user);
    }
}
