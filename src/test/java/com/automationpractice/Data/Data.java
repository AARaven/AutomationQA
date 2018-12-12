package com.automationpractice.Data;

import Models.User.User;
import lombok.SneakyThrows;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.HashMap;

public class Data {

    private static final String USERS_VALID_PATH = "./src/main/resources/UsersProfiles/Valid/UsersProfiles.json";
    private static final String USERS_INVALID_PATH = "./src/main/resources/UsersProfiles/Invalid/UsersProfiles.json";

    @DataProvider(name = "UserEmails")
    public Object[][] userEmail() {
        return new Object[][]{
                {"conflict@gmail.com"},
                {"soBakA@mail.ru"},
                {"Spoke11@yandex.ru"},
                {"newTone@rambler.ru"},
                {"Krakazya6ra@zya6ra.org"}
        };
    }

    @DataProvider(name = "ValidUsers")
    public Object[][] getValidUsers() {
        return new Object[][]{
                {getValidUser("Alex")},
                {},
                {},
                {},
                {}
        };
    }

    @DataProvider(name = "InvalidUsers")
    public Object[][] getInvalidUsers() {
        return new Object[][]{
                {getInvalidUser("Alex")},
                {},
                {},
                {},
                {}
        };
    }

    @SneakyThrows
    private User getValidUser(String name) {
        File file = new File(USERS_VALID_PATH);
        ObjectMapper mapper = new ObjectMapper();
        User user;
        HashMap map;
        map = mapper.readValue(file, HashMap.class);
        user = mapper.convertValue(map.get(name), User.class);
        return user;
    }

    @SneakyThrows
    private User getInvalidUser(String name) {
        File file = new File(USERS_INVALID_PATH);
        ObjectMapper mapper = new ObjectMapper();
        User user;
        HashMap map;
        map = mapper.readValue(file, HashMap.class);
        user = mapper.convertValue(map.get(name), User.class);
        return user;
    }

    private String getValidEmail() {
        return null;
    }

    private String getInvalidEmail(String name) {
        return null;
    }
}
