package SeleniumTest.com.automationpractice.Tests;

import SeleniumTest.com.automationpractice.Models.User;
import SeleniumTest.com.automationpractice.Page.CreateAnAccPage;
import SeleniumTest.com.automationpractice.Page.MainPage;
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
        MainPage main = new MainPage(driver);
        CreateAnAccPage create = new CreateAnAccPage(driver);
        main.open();
        main.pressSignInBtn();
        create.getInstance(MainPage.class);
        create.sendCreationEmail(user.getEmail());
        create.pushCreateAccBtn();
        create.choiceMale();
        create.choiceCustomerFirstName(user.getFirstName());
        create.choiceFirstName(user.getFirstName());
        create.choiceCustomerLastName(user.getLastName());
        create.choiceLastName(user.getLastName());
        create.choiceCompany(user.getCompany());
        create.choiceCity(user.getCity());
//        create.choiceDayOfBirth(user.getDayOfBirth());
//        create.choiceMonthOfBirth(user.getMonthOfBirth());
//        create.choiceYearOfBirth(user.getYearOfBirth());
        create.choiceNewsLetter();
        create.choiceOptin();
        create.choicePhone(user.getHomePhone());
        create.choiceMobilePhone(user.getMobilePhone());
        create.choicePostCode(user.getZip());
//        create.choiceState(user.getState());
    }
}
