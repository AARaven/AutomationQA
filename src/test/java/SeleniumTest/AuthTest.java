package SeleniumTest;

import SeleniumTest.com.automationpractice.Page.MainPage;
import org.testng.annotations.Test;

public class AuthTest {


    @Test
    public void getStart() {
        MainPage startPage = new MainPage();
        startPage.goToUrl();
        startPage.pressSignIn();

    }
}
