package com.automationpractice.Data;

import Models.User.User;
import lombok.SneakyThrows;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Data {

    private static final String USERS_VALID_PATH = "./src/main/resources/UsersProfiles/Valid/UsersProfiles.json";
    private static final String USERS_INVALID_PATH = "./src/main/resources/UsersProfiles/Invalid/UsersProfiles.json";

    Collection<User> users;

    @SneakyThrows
    private void readDataFile(String path) {
        users = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        byte[] validUsers = Files.readAllBytes(Paths.get("./src/main/resources/UsersProfiles/Valid/valid.json"));
        users.add(mapper.readValue(validUsers, User.class));
    }

    @SneakyThrows
    public Object[][] getData() {
        readDataFile("./src/main/resources/UsersProfiles/Valid/valid.json");
        Object[][] data = new Object[users.size()][1];
        Iterator<User> it = users.iterator();
        int i = 0;
        while (it.hasNext()) {
            data[i][0] = it.next();
            i++;
        }
        return data;
    }

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
                {getValidUser("Peter")},
//                {},
//                {},
//                {},
//                {},
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
    @Parameters("ValidUserPath")
    public User getValidUser(String name) {
        File file = new File(USERS_VALID_PATH);
        ObjectMapper mapper = new ObjectMapper();
        User user;
        HashMap map;
        map = mapper.readValue(file, HashMap.class);
        user = mapper.convertValue(map.get(name), User.class);
        return user;
    }

    @SneakyThrows
    @Parameters("InvalidUserPath")
    private User getInvalidUser(String name) {
        File file = new File(USERS_INVALID_PATH);
        ObjectMapper mapper = new ObjectMapper();
        User user;
        HashMap map;
        map = mapper.readValue(file, HashMap.class);
        user = mapper.convertValue(map.get(name), User.class);
        return user;
    }
}
