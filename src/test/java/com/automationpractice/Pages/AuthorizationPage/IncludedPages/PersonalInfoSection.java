package com.automationpractice.Pages.AuthorizationPage.IncludedPages;

import Models.User.User;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class PersonalInfoSection {

    public PersonalInfoSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Getter
    @FindBy(how = How.ID, using = "id_gender1")
    private WebElement radioGenderMale;

    @Getter
    @FindBy(how = How.ID, using = "id_gender2")
    private WebElement radioGenderFemale;

    @Getter
    @FindBy(how = How.ID, using = "newsletter")
    private WebElement checkboxNewsLetter;

    @Getter
    @FindBy(how = How.ID, using = "optin")
    private WebElement checkboxSpecialOffers;

    @Getter
    @FindBy(how = How.ID, using = "days")
    private WebElement selectDays;

    @Getter
    @FindBy(how = How.ID, using = "months")
    private WebElement selectMonths;

    @Getter
    @FindBy(how = How.ID, using = "years")
    private WebElement selectYears;

    @Getter
    @FindBy(how = How.ID, using = "customer_firstname")
    private WebElement inputCustomerFirstName;

    @Getter
    @FindBy(how = How.ID, using = "customer_lastname")
    private WebElement inputCustomerLastName;

    @Getter
    @FindBy(how = How.ID, using = "passwd")
    private WebElement inputPassword;

    @Getter
    @FindBy(how = How.ID, using = "email")
    private WebElement inputEmail;

    @FindBy(how = How.CLASS_NAME, using = "is_required validate form-control")
    private WebElement reqEmail;

    void fillPersonalInfoSection(User user) {
        setGender(user);
        setDataFields
                (inputCustomerFirstName, user.getFirstName());
        setDataFields
                (inputCustomerLastName, user.getLastName());
        setDataFields
                (inputPassword, user.getPassword());
        setDataFields
                (inputEmail, user.getEmail());

        setDateOfBirth(
                user.getDayOfBirth(),
                user.getMonthOfBirth(),
                user.getYearOfBirth()
        );
        setNewsLetter(user);
        setSpecialOffers(user);
    }

    void unfilledPersonalInfoSection() {
     setDataFields(inputEmail,"");
    }

    void fillPersonalInfoSectionInvalidData(User user) {
        setGender(user);
        setDataFields
                (inputCustomerFirstName, user.getFirstName());
        setDataFields
                (inputCustomerLastName, user.getLastName());
        setDataFields
                (inputPassword, user.getPassword());
        setNewsLetter(user);
        setSpecialOffers(user);
    }

    private void setGender(User user) {
        if (user.getGender().name().equals("MALE")) this.radioGenderMale.click();
        else if (user.getGender().name().equals("FEMALE")) this.radioGenderFemale.click();
        else throw new IllegalArgumentException("Current gender is not available.");
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

    private void setDataFields(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
}
