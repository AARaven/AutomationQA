package com.automationpractice.Pages.AccountPage.IncludedPages;

import Models.User.User;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.PersonalInfoSection;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

@Log4j2
public class AccountInfoPage extends AccountPage {

    private PersonalInfoSection personalInfo =
            new PersonalInfoSection(driver);

    public AccountInfoPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl(getClass().getSimpleName()));
        log.debug("Creating an instance AccountInfoPage");
    }

    @FindBy(name = "submitIdentity")
    private WebElement buttonSave;

    @FindBy(id = "firstname")
    private WebElement inputFirstName;

    @FindBy(id = "lastname")
    private WebElement inputLastName;

    public SoftAssert verifyPersonalInfo(User user) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue
                        (isUserGender(user),
                                "User gender is not correct.");
        softAssert.assertTrue
                        (isUserFirstName(user),
                                "User first name is not correct.");
        softAssert.assertTrue
                        (isUserLastName(user),
                                "User last name is not correct.");
        softAssert.assertTrue
                        (isUserEmail(user),
                                "User email is not correct.");
        softAssert.assertTrue
                        (isUserDayOfBirth(user),
                                "User day of birth is not correct.");
        softAssert.assertTrue
                        (isUserMonthOfBirth(user),
                                "User month of birth is not correct.");
        softAssert.assertTrue
                        (isUserYearOfBirth(user),
                                "User year of birth is not correct.");

        if (isNewsLetter(user)) {
            softAssert
                    .assertTrue
                            (isNewsLetter(user),
                                    "NewsLetter checkbox is not selected.");
        } else if (!isNewsLetter(user)) {
            softAssert
                    .assertFalse
                            (isNewsLetter(user),
                                    "NewsLetter checkbox is selected.");
        }
        if (isSpecialOffers(user)) {
            softAssert
                    .assertTrue(isSpecialOffers(user),
                            "SpecialOffers checkbox is not selected.");
        } else if (!isSpecialOffers(user)) {
            softAssert
                    .assertFalse
                            (isSpecialOffers(user),
                                    "SpecialOffers checkbox is selected.");
        }
        return softAssert;
    }

    public AccountInfoPage confirmPassword(User user) {
        this.personalInfo.getInputPassword()
                .sendKeys(user.getPassword());
        return this;
    }

    public AccountInfoPage changeUserGender(String gender) {
        if (gender.equals("male")) {
            this.personalInfo.getRadioGenderMale()
                    .click();
        } else if (gender.equals("female")) {
            this.personalInfo.getRadioGenderFemale()
                    .click();
        } else throw new IllegalArgumentException("Your gender is not available.");
        return this;
    }

    public AccountInfoPage clickSave() {
        this.buttonSave.click();
        return this;
    }

    public AccountInfoPage rewriteAll(User user) {
        rewriteUserGender(user);
        rewriteUserFirstName(user);
        rewriteUserLastName(user);
        rewriteUserEmail(user);
        rewriteUserDayOfBirth(user);
        rewriteUserMonthOfBirth(user);
        rewriteUserYearOfBirth(user);
        rewriteUserNewsLetter(user);
        rewriteUserSpecialOffers(user);
        return this;
    }

    private AccountInfoPage rewriteUserGender(User user) {
        if (user.getGender().equals("male")) {
            this.personalInfo.getRadioGenderFemale().click();
        } else if (user.getGender().equals("female")) {
            this.personalInfo.getRadioGenderMale();
        }
        return this;
    }

    private AccountInfoPage rewriteUserFirstName(User user) {
        this.inputFirstName.clear();
        this.inputFirstName.sendKeys(user.getFirstName());
        return this;
    }

    private AccountInfoPage rewriteUserLastName(User user) {
        this.inputLastName.clear();
        this.inputLastName.sendKeys(user.getLastName());
        return this;
    }

    private AccountInfoPage rewriteUserEmail(User user) {
        this.personalInfo.getInputEmail().clear();
        this.personalInfo.getInputEmail().sendKeys(user.getEmail());
        return this;
    }

    private AccountInfoPage rewriteUserDayOfBirth(User user) {
        new Select(this.personalInfo.getSelectDays()).selectByValue(user.getDayOfBirth());
        return this;
    }

    private AccountInfoPage rewriteUserMonthOfBirth(User user) {
        new Select(this.personalInfo.getSelectMonths()).selectByValue(user.getMonthOfBirth());
        return this;
    }

    private AccountInfoPage rewriteUserYearOfBirth(User user) {
        new Select(this.personalInfo.getSelectYears()).selectByValue(user.getYearOfBirth());
        return this;
    }

    private AccountInfoPage rewriteUserNewsLetter(User user) {
            this.personalInfo.getCheckboxNewsLetter().click();
        return this;
    }

    private AccountInfoPage rewriteUserSpecialOffers(User user) {
            this.personalInfo.getCheckboxSpecialOffers().click();
        return this;
    }

    private boolean isUserGender(User user) {
        if (user.getGender().equals("male")) {
            return this.personalInfo.getRadioGenderMale()
                    .isSelected();
        } else if ((user.getGender().equals("female"))) {
            return this.personalInfo.getRadioGenderFemale()
                    .isSelected();
        }
        return false;
    }

    private boolean isUserFirstName(User user) {
        return user.getFirstName()
                .equals(this.inputFirstName
                        .getAttribute("value"));
    }

    private boolean isUserLastName(User user) {
        return user.getLastName()
                .equals(this.inputLastName
                        .getAttribute("value"));
    }

    private boolean isUserEmail(User user) {
        return user.getEmail()
                .equals(this.personalInfo.getInputEmail()
                .getAttribute("value"));
    }

    private boolean isUserDayOfBirth(User user) {
        return user.getDayOfBirth()
                .equals(this.personalInfo.getSelectDays()
                        .getAttribute("value"));
    }

    private boolean isUserMonthOfBirth(User user) {
        return user.getMonthOfBirth()
                .equals(this.personalInfo.getSelectMonths()
                        .getAttribute("value"));
    }

    private boolean isUserYearOfBirth(User user) {
        return user.getYearOfBirth()
                .equals(this.personalInfo.getSelectYears()
                        .getAttribute("value"));
    }

    private boolean isNewsLetter(User user) {
        if (user.isNewsLetter()) {
            return this.personalInfo.getCheckboxNewsLetter()
                    .isSelected();
        }
        return false;
    }

    private boolean isSpecialOffers(User user) {
        if (user.isSpecialOffers()) {
            return this.personalInfo.getCheckboxSpecialOffers()
                    .isSelected();
        }
        return false;
    }
}
