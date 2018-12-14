package com.automationpractice.Pages.AuthenticationPage.SplitedPages;

import Models.User.User;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

@Log4j2
public class MyAccountInfoPage extends NavigationForMyAccountPages {

    public MyAccountInfoPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("PersonalInfoPage"));
        log.debug("creating an object MyAccountInfoPage");
    }

    @FindBy(name = "submitIdentity")
    private WebElement buttonSave;

    @FindBy(id = "id_gender1")
    private WebElement radioGenderMale;

    @FindBy(id = "id_gender2")
    private WebElement radioGenderFemale;

    @FindBy(id = "firstname")
    private WebElement inputFirstName;

    @FindBy(id = "lastname")
    private WebElement inputLastName;

    @FindBy(id = "newsletter")
    private WebElement checkboxNewsLetter;

    @FindBy(id = "optin")
    private WebElement checkboxSpecialOffers;

    @FindBy(id = "days")
    private WebElement selectDays;

    @FindBy(id = "months")
    private WebElement selectMonths;

    @FindBy(id = "years")
    private WebElement selectYears;

    @FindBy(id = "email")
    private WebElement inputCurrentEmail;

    @FindBy(className = "alert alert-success")
    private WebElement alertSuccess;

    @FindBy(id = "old_passwd")
    private WebElement inputOldPassword;

    private boolean isUserGender(User user) {
        if (user.getGender().equals("male")) {
            return this.radioGenderMale.isSelected();
        } else if ((user.getGender().equals("female"))) {
            return this.radioGenderFemale.isSelected();
        }
        return false;
    }

    private boolean isUserFirstName(User user) {
        return user.getFirstName().equals(this.inputFirstName.getAttribute("value"));
    }

    private boolean isUserLastName(User user) {
        return user.getLastName().equals(this.inputLastName.getAttribute("value"));
    }

    private boolean isUserEmail(User user) {
        return user.getEmail().equals(this.inputCurrentEmail.getAttribute("value"));
    }

    private boolean isUserDayOfBirth(User user) {
        return user.getDayOfBirth().equals(this.selectDays.getAttribute("value"));
    }

    private boolean isUserMonthOfBirth(User user) {
        return user.getMonthOfBirth().equals(this.selectMonths.getAttribute("value"));
    }

    private boolean isUserYearOfBirth(User user) {
        return user.getYearOfBirth().equals(this.selectYears.getAttribute("value"));
    }

    private boolean isNewsLetter(User user) {
        if (user.isNewsLetter()) {
            return this.checkboxNewsLetter.isSelected();
        }
        return false;
    }

    private boolean isSpecialOffers(User user) {
        if (user.isSpecialOffers()) {
            return this.checkboxSpecialOffers.isSelected();
        }
        return false;
    }

    public SoftAssert verifyPersonalInfo(User user) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isUserGender(user), "User gender is not correct.");
        softAssert.assertTrue(isUserFirstName(user), "User first name is not correct.");
        softAssert.assertTrue(isUserLastName(user), "User last name is not correct.");
        softAssert.assertTrue(isUserEmail(user), "User email is not correct.");
        softAssert.assertTrue(isUserDayOfBirth(user), "User day of birth is not correct.");
        softAssert.assertTrue(isUserMonthOfBirth(user), "User month of birth is not correct.");
        softAssert.assertTrue(isUserYearOfBirth(user), "User year of birth is not correct.");
        if (isNewsLetter(user)) {
            softAssert.assertTrue(isNewsLetter(user), "NewsLetter checkbox is not selected.");
        } else if (!isNewsLetter(user)) {
            softAssert.assertFalse(isNewsLetter(user), "NewsLetter checkbox is selected.");
        }
        if (isSpecialOffers(user)) {
            softAssert.assertTrue(isSpecialOffers(user), "SpecialOffers checkbox is not selected.");
        } else if (!isSpecialOffers(user)) {
            softAssert.assertFalse(isSpecialOffers(user), "SpecialOffers checkbox is selected.");
        }
        return softAssert;
    }

    public boolean verifyAlertSuccess() {
        return this.alertSuccess.getText().contains("Your personal information has been successfully updated.");
    }

    public void confirmPassword(User user) {
        this.inputOldPassword.sendKeys(user.getPassword());
    }

    public void changeUserGender(String gender) {
        if (gender.equals("male")) {
            this.radioGenderMale.click();
        } else if (gender.equals("female")) {
            this.radioGenderFemale.click();
        } else throw new IllegalArgumentException("Your gender is not available.");
    }

    public void clickSave() {
        this.buttonSave.click();
    }
}
