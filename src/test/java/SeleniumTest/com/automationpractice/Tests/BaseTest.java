package SeleniumTest.com.automationpractice.Tests;

import SeleniumTest.com.automationpractice.Page.AuthPage;
import SeleniumTest.com.automationpractice.Page.MainPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class BaseTest {

    Logger logger;

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

    @DataProvider(name = "UserPassword")
    public Object[][] userPassword() {
        return new Object[][]{
                {},
                {},
                {},
                {},
                {}
        };
    }

    @Test
    public void getMainPageAndClickButtons() {
        MainPage main = new MainPage();
        main.open();
        main.pressSignInBtn();
        main.back();
        main.pressContactUsBtn();
        main.close();
    }

    @Test(dataProvider = "UserEmail")
    public void getAuthPageAndPushAnEmail(String email) throws Exception {
        AuthPage auth = new AuthPage();
        auth.open();
        auth.sendEmailAndPushSubmit(email);
        auth.close();
    }
}
