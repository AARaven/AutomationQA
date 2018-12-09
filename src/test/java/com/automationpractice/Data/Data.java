package com.automationpractice.Data;

import Models.User.User;
import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "UserEmail")
    public Object[][] userEmail() {
        return new Object[][]{
                {"conflict@gmail.com"},
                {"soBakA@mail.ru"},
                {"Spoke11@yandex.ru"},
                {"newTone@rambler.ru"},
                {"Krakazya6ra@zya6ra.org"}
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
}
