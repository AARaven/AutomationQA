package SeleniumTest.com.automationpractice.User;

public class ValidUser extends User {

    ValidUser() {
        this.tempUserEmail = accountEmailGenerator();
        this.userEmail = this.tempUserEmail;
        this.tempUserPassword = passwordGenerator();
        this.userPassword = this.tempUserPassword;
    }


}

