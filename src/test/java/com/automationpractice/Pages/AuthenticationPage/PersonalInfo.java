package com.automationpractice.Pages.AuthenticationPage;

import Models.User.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfo {

    PersonalInfo(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "id_gender1")
    protected WebElement radioGenderMale;

    @FindBy(id = "id_gender2")
    protected WebElement radioGenderFemale;

    @FindBy(id = "firstname")
    protected WebElement inputFirstName;

    @FindBy(id = "lastname")
    protected WebElement inputLastName;

    @FindBy(id = "newsletter")
    protected WebElement checkboxNewsLetter;

    @FindBy(id = "optin")
    protected WebElement checkboxSpecialOffers;

    @FindBy(id = "days")
    protected WebElement selectDays;

    @FindBy(id = "months")
    protected WebElement selectMonths;

    @FindBy(id = "years")
    protected WebElement selectYears;

    @FindBy(id = "email")
    protected WebElement inputCurrentEmail;

    public boolean isUserGender(User user) {
        if (user.getGender().equals("male")) {
            return this.radioGenderMale.isSelected();
        } else if ((user.getGender().equals("female"))) {
            this.radioGenderFemale.isSelected();
        }
        return false;
    }

    public boolean isUserFirstName(User user) {
        return user.getFirstName().equals(this.inputFirstName.getAttribute("value"));
    }

    public boolean isUserLastName(User user) {
        return user.getLastName().equals(this.inputLastName.getAttribute("value"));
    }

    public boolean isUserEmail(User user) {
        return user.getEmail().equals(this.inputCurrentEmail.getAttribute("value"));
    }

    public boolean isUserDayOfBirth(User user) {
        return user.getDayOfBirth().equals(this.selectDays.getAttribute("value"));
    }

    public boolean isUserMonthOfBirth(User user) {
        return user.getMonthOfBirth().equals(this.selectMonths.getAttribute("value"));
    }

    public boolean isUserYearOfBirth(User user) {
        return user.getYearOfBirth().equals(this.selectYears.getAttribute("value"));
    }

    public boolean isNewsLetter(User user) {
        if (user.isNewsLetter()) {
            return this.checkboxNewsLetter.isSelected();
        }
        return false;
    }

    public boolean isSpecialOffers(User user) {
        if (user.isSpecialOffers()) {
            return this.checkboxSpecialOffers.isSelected();
        }
        return false;
    }
}
