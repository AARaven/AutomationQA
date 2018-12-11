package com.automationpractice.Data;

import Models.User.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Data {

    Collection<User> userCollection;

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
                {new User("Alex")},
//                {new User("Peter")},
//                {new User("Jack")},
//                {new User("John")},
//                {new User()}
        };
    }

    // TODO: download user from json using username ----->
    private User parseUserFromJson() {
        File file = new File("./src/main/resources/UsersProfiles/UsersProfiles.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(file, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
