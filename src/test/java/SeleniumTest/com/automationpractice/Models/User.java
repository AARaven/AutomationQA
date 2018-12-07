package SeleniumTest.com.automationpractice.Models;

import net.bytebuddy.utility.RandomString;

import java.util.Random;

public class User {

    protected String userEmail;
    protected String tempUserEmail;
    protected String userPassword;
    protected String tempUserPassword;

    User() {
    }

    User(String email, String password) {
    }

    protected String accountEmailGenerator() {
        RandomString randomFirstPice = new RandomString(5);
        RandomString randomSecondPice = new RandomString(5);
        RandomString randomDomen = new RandomString(3);
        return String.format("%s" + "@" + "%s" + "." + "%s",
                randomFirstPice.nextString(),
                randomSecondPice.nextString(),
                randomDomen.nextString());
    }

    protected String passwordGenerator() {
        RandomString passwd = new RandomString(10);
        return passwd.nextString();
    }

    protected String stringDataGenerator() {
        RandomString randomData = new RandomString(10);
        return randomData.nextString().replaceAll("\\d*", "");
    }

    protected String numberDataGenerator() {
        Random randomNumberData = new Random();
        return String.valueOf(randomNumberData.nextInt(1000000));
    }
}
