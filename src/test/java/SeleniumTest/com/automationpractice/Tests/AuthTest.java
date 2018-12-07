package SeleniumTest.com.automationpractice.Tests;

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
    public void getTest() {
        CreateAnAccPage create = new CreateAnAccPage();
        create.open();
        create.sendCreationEmail("asdf@adf.asdf");
        create.pushCreateAccBtn();
        create.choiceMale();
        create.choiceCustomerFirstName("asdf");
        create.choiceCustomerLastName("asdfasd");
        create.choiceFirstName("asdfasdf");
        create.choiceLastName("lasdjkf");
        create.choiceCity("fasdlfh");
        create.choiceCompany("falsdifh");
        create.close();
    }
}
