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
                    .assertTrue
                            (isSpecialOffers(user),
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
        personalInfo.getInputPassword()
                .sendKeys(user.getPassword());
        return this;
    }

    public AccountInfoPage changeUserGender(String gender) {
        switch (gender) {
            case "male":
                personalInfo.getRadioGenderMale()
                        .click();
                break;
            case "female":
                personalInfo.getRadioGenderFemale()
                        .click();
                break;
            default:
                throw new IllegalArgumentException("Your gender is not available.");
        }
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
            personalInfo.getRadioGenderFemale().click();
        } else if (user.getGender().equals("female")) {
            personalInfo.getRadioGenderMale();
        }
        return this;
    }

    private AccountInfoPage rewriteUserFirstName(User user) {
        rewriteElement(inputFirstName,user.getFirstName());
        return this;
    }

    private AccountInfoPage rewriteUserLastName(User user) {
        rewriteElement(inputLastName,user.getLastName());
        return this;
    }

    private AccountInfoPage rewriteUserEmail(User user) {
        rewriteElement(personalInfo.getInputEmail(),user.getEmail());
        return this;
    }

    private AccountInfoPage rewriteUserDayOfBirth(User user) {
        new Select(personalInfo.getSelectDays()).selectByValue(user.getDayOfBirth());
        return this;
    }

    private AccountInfoPage rewriteUserMonthOfBirth(User user) {
        new Select(personalInfo.getSelectMonths()).selectByValue(user.getMonthOfBirth());
        return this;
    }

    private AccountInfoPage rewriteUserYearOfBirth(User user) {
        new Select(personalInfo.getSelectYears()).selectByValue(user.getYearOfBirth());
        return this;
    }

    private AccountInfoPage rewriteUserNewsLetter(User user) {
        personalInfo.getCheckboxNewsLetter().click();
        return this;
    }

    private AccountInfoPage rewriteUserSpecialOffers(User user) {
        personalInfo.getCheckboxSpecialOffers().click();
        return this;
    }

    private boolean isUserGender(User user) {
        if (user.getGender().equals("male")) {
            return personalInfo.getRadioGenderMale()
                    .isSelected();
        } else if ((user.getGender().equals("female"))) {
            return personalInfo.getRadioGenderFemale()
                    .isSelected();
        }
        return false;
    }

    private boolean isUserFirstName(User user) {
        return user.getFirstName()
                .equals(inputFirstName
                        .getAttribute("value"));
    }

    private boolean isUserLastName(User user) {
        return user.getLastName()
                .equals(inputLastName
                        .getAttribute("value"));
    }

    private boolean isUserEmail(User user) {
        return user.getEmail()
                .equals(personalInfo.getInputEmail()
                        .getAttribute("value"));
    }

    private boolean isUserDayOfBirth(User user) {
        return user.getDayOfBirth()
                .equals(personalInfo.getSelectDays()
                        .getAttribute("value"));
    }

    private boolean isUserMonthOfBirth(User user) {
        return user.getMonthOfBirth()
                .equals(personalInfo.getSelectMonths()
                        .getAttribute("value"));
    }

    private boolean isUserYearOfBirth(User user) {
        return user.getYearOfBirth()
                .equals(personalInfo.getSelectYears()
                        .getAttribute("value"));
    }

    private boolean isNewsLetter(User user) {
        if (user.isNewsLetter()) {
            return personalInfo.getCheckboxNewsLetter()
                    .isSelected();
        }
        return false;
    }

    private boolean isSpecialOffers(User user) {
        if (user.isSpecialOffers()) {
            return personalInfo.getCheckboxSpecialOffers()
                    .isSelected();
        }
        return false;
    }
}
