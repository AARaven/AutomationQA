package com.automationpractice.Pages.AuthorizationPage.IncludedPages;

import Models.User.User;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class PersonalInfoSection {

    public PersonalInfoSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Getter
    @FindBy(id = "id_gender1")
    private WebElement radioGenderMale;

    @Getter
    @FindBy(id = "id_gender2")
    private WebElement radioGenderFemale;

    @Getter
    @FindBy(id = "newsletter")
    private WebElement checkboxNewsLetter;

    @Getter
    @FindBy(id = "optin")
    private WebElement checkboxSpecialOffers;

    @Getter
    @FindBy(id = "days")
    private WebElement selectDays;

    @Getter
    @FindBy(id = "months")
    private WebElement selectMonths;

    @Getter
    @FindBy(id = "years")
    private WebElement selectYears;

    @Getter
    @FindBy(id = "customer_firstname")
    private WebElement inputCustomerFirstName;

    @Getter
    @FindBy(id = "customer_lastname")
    private WebElement inputCustomerLastName;

    @Getter
    @FindBy(id = "passwd")
    private WebElement inputPassword;

    @Getter
    @FindBy(id = "email")
    private WebElement inputEmail;

    void fillPersonalInfoSection(User user) {
        setGender(user);
        setCustomerFirstName
                (user.getFirstName());
        setCustomerLastName
                (user.getLastName());
        setPassword
                (user.getPassword());
        setEmail
                (user.getEmail());
        setDateOfBirth(
                user.getDayOfBirth(),
                user.getMonthOfBirth(),
                user.getYearOfBirth()
        );
        setNewsLetter(user);
        setSpecialOffers(user);
    }

    private void setGender(User user) {
        switch (user.getGender()) {
            case "male":
                this.radioGenderMale
                        .click();
                break;
            case "female":
                this.radioGenderFemale
                        .click();
                break;
            default:
                throw new IllegalArgumentException
                        ("Current gender is not available.");
        }
    }

    private void setCustomerFirstName(String firstname) {
        this.inputCustomerFirstName.sendKeys(firstname);
    }

    private void setCustomerLastName(String lastname) {
        this.inputCustomerLastName.sendKeys(lastname);
    }

    private void setPassword(String password) {
        this.inputPassword.sendKeys(password);
    }

    private void setEmail(String email) {
        this.inputEmail.clear();
        this.inputEmail.sendKeys(email);
    }

    private void setDateOfBirth(String day, String month, String year) {
        log.debug("set day of birth");
        new Select(this.selectDays).selectByValue(day);
        log.debug("set month of birth");
        new Select(this.selectMonths).selectByValue(month);
        log.debug("set year of birth");
        new Select(this.selectYears).selectByValue(year);
    }

    private void setNewsLetter(User user) {
        if (user.isNewsLetter()) {
            this.checkboxNewsLetter.click();
        }
    }

    private void setSpecialOffers(User user) {
        if (user.isSpecialOffers()) {
            this.checkboxSpecialOffers.click();
        }
    }
}
