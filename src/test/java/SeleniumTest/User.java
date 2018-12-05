package SeleniumTest;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

public class User {

    private String userEmail;
    private String userPassword;
    private String validEmail;
    private String invalidEmail;
    private String validPassword;
    private String invalidPassword;

    @DataProvider
    public Object[][] getUser() {
        return new Object[][]
                {{}, {}, {}, {}, {}, {}, {}, {}};
    }




    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private String getValidEmail() {
        return this.validEmail;
    }

    private void setValidEmail(String validEmail) {
        this.validEmail = validEmail;
    }

    private String getInvalidEmail() {
        return this.invalidEmail;
    }

    private void setInvalidEmail(String invalidEmail) {
        this.invalidEmail = invalidEmail;
    }

    private String getValidPassword() {
        return this.validPassword;
    }

    private void setValidPassword(String validPassword) {
        this.validPassword = validPassword;
    }

    private String getInvalidPassword() {
        return this.invalidPassword;
    }

    private void setInvalidPassword(String invalidPassword) {
        this.invalidPassword = invalidPassword;
    }

    private void setValidEmail() {
        this.userEmail = accountEmailGenerator();
    }

    private void setInvalidEmail() {
        this.userEmail = new RandomString(10).nextString();
    }

    private void setValidPassword() {
        this.userPassword = passwordGenerator();
    }

    private void setInvalidPassword() {
        this.userPassword = "asdf";
    }

    private String accountEmailGenerator() {
        RandomString randomFirstPice = new RandomString(5);
        RandomString randomSecondPice = new RandomString(5);
        RandomString randomDomen = new RandomString(3);
        return String.format("%s" + "@" + "%s" + "." + "%s",
                randomFirstPice.nextString(),
                randomSecondPice.nextString(),
                randomDomen.nextString());
    }

    private String passwordGenerator() {
        RandomString passwd = new RandomString(10);
        return passwd.nextString();
    }

}
