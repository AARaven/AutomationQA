package com.automationpractice.Pages;

import Models.User.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AuthorizationPage extends StartPage {

    // CREATE ACCOUNT AREA:

    // Text area enter email for registration:
    @FindBy(id = "email_create")
    private WebElement inputEmail;

    // Create an account Button:
    @FindBy(id = "SubmitCreate")
    private WebElement buttonCreate;

    // LOGIN AREA:

    // Text area email:
    @FindBy(id = "email")
    private WebElement inputCurrentEmail;

    // Text area password:
    @FindBy(id = "passwd")
    private WebElement inputPassword;

    //  SignIn Button:
    @FindBy(id = "SubmitLogin")
    private WebElement buttonSubmitLogin;

    // forgot your password link:
    @FindBy(className = "lost_password from_group")
    private WebElement linkForgotYourPassword;

    // REGISTER AREA:

    // BUTTONS:

    // Button submit account:
    @FindBy(id = "submitAccount")
    private WebElement buttonSubmitAccount;

    // RADIO BUTTONS:

    // RadioBtn sex male:
    @FindBy(id = "id_gender1")
    private WebElement radioGenderMale;

    // RadioBtn sex female:
    @FindBy(id = "id_gender2")
    private WebElement radioGenderFemale;

    // CHECKBOXES:

    // CheckBox submit newsletter:
    @FindBy(id = "newsletter")
    private WebElement checkboxNewsLetter;

    // CheckBox special offer from partners:
    @FindBy(id = "optin")
    private WebElement checkboxSpecialOffers;

    // SELECTIONS:

    // DROPDOWN SELECTION DATE OF BIRTH:
    // Selection dropDown day of birth:
    @FindBy(id = "days")
    private WebElement selectDays;

    // Selection dropDown month of birth:
    @FindBy(id = "months")
    private WebElement selectMonths;

    // Selection dropDown year of birth:
    @FindBy(id = "years")
    private WebElement selectYears;

    // Selection dropDown country (1 option):
    @FindBy(id = "id_country")
    private WebElement selectCountry;

    // Selection dropDown state:
    @FindBy(id = "id_state")
    private WebElement selectState;

    // TEXT AREAS:

    // Text area customer firstname:
    @FindBy(id = "customer_firstname")
    private WebElement inputCustomerFirstName;

    // Text area customer lastname:
    @FindBy(id = "customer_lastname")
    private WebElement inputCustomerLastName;

    // Text area password:
    //!!!Duplicate a inputPassword on login page!!!

    // Text area firstname:
    @FindBy(id = "firstname")
    private WebElement inputFirstName;

    // Text area lastname:
    @FindBy(id = "lastname")
    private WebElement inputLastName;

    // Text area company:
    @FindBy(id = "company")
    private WebElement inputCompany;

    // Text area address1:
    @FindBy(id = "address1")
    private WebElement inputAdress1;

    // Text area address2:
    @FindBy(id = "address2")
    private WebElement inputAddress2;

    // Text area city:
    @FindBy(id = "city")
    private WebElement inputCity;

    // Text area postcode (5 digits):
    @FindBy(id = "postcode")
    private WebElement inputZipCode;

    // Text area additional information:
    @FindBy(id = "other")
    private WebElement inputAdditionalInfo;

    // Text area phone number:
    @FindBy(id = "phone")
    private WebElement inputPhone;

    // Text area phone mobile phone number:
    @FindBy(id = "phone_mobile")
    private WebElement inputPhoneMobile;

    //Text area additional email:
    @FindBy(id = "alias")
    private WebElement inputAdditionalEmail;

    // CONSTRUCTOR:
    public AuthorizationPage(WebDriver driver) {
        super(driver);
        this.setUrl(getJsonUrl("Authorization"));
//        this.setUrl(getPropertyUrl("AuthorizationUrl"));
    }

    // Method which send an email and click
    // on Create_An_Account button:
    public void createAnAccountAndSignOut(User user) {
        this.inputEmail.sendKeys(user.getEmail());
        this.buttonCreate.click();
        setAllFields(user);
        this.buttonSubmitAccount.click();
        clickSignOutBtn();
    }

    // Method which open a resent account:
    public void openUserAccount(User user) {
        this.inputCurrentEmail.sendKeys(user.getEmail());
        this.inputPassword.sendKeys(user.getPassword());
        this.buttonSubmitLogin.click();
    }

    // Method which close an account:
    public void closeUserAccount() {
        clickSignOutBtn();
    }

    // Method which verify user account:
    public void verifyUserAccount(User user) {
        openUserAccount(user);
        Assert.assertEquals("My account - My Store", getTitle(), "The titles is not equals!");
        closeUserAccount();
    }

    // SECTION YOUR PERSONAL INFORMATION:

    private void checkGender(String sex) {
        if (sex.equals("male")) {
            this.radioGenderMale.click();
        } else if (sex.equals("female")) {
            this.radioGenderFemale.click();
        } else {
            throw new IllegalArgumentException("Current gender is not available.");
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

    private void setDateOfBirth(String day, String month, String year) {
        new Select(this.selectDays).selectByValue(day);
        new Select(this.selectMonths).selectByValue(month);
        new Select(this.selectYears).selectByValue(year);
    }

    private void setNewsLetter() {
        this.checkboxNewsLetter.click();
    }

    private void setSpecialOffers() {
        this.checkboxSpecialOffers.click();
    }

    // SECTION YOUR ADDRESS:

    private void setFirstName(String firstname) {
        this.inputFirstName.sendKeys(firstname);
    }

    private void setLastName(String lastname) {
        this.inputLastName.sendKeys(lastname);
    }

    private void setCompany(String company) {
        this.inputCompany.sendKeys(company);
    }

    private void setFirstAddressField(String address) {
        this.inputAdress1.sendKeys(address);
    }

    private void setSecondAddressField(String address) {
        this.inputAddress2.sendKeys(address);
    }

    private void setCity(String city) {
        this.inputCity.sendKeys(city);
    }

    private void setState(String state) {
        new Select(this.selectState).selectByVisibleText(state);
    }

    private void setZipCode(String zipcode) {
        this.inputZipCode.sendKeys(zipcode);
    }

    private void setCountry(String country) {
        new Select(this.selectCountry).selectByVisibleText(country);
    }

    private void setAdditionalInfo(String additionalInfo) {
        this.inputAdditionalInfo.sendKeys(additionalInfo);
    }

    private void setHomePhone(String homePhone) {
        this.inputPhone.sendKeys(homePhone);
    }

    private void setMobilePhone(String mobilePhone) {
        this.inputPhoneMobile.sendKeys(mobilePhone);
    }

    private void setAdditionalEmail(String additionalEmail) {
        this.inputAdditionalEmail.sendKeys(additionalEmail);
    }

    private void setAllFields(User user) {
        checkGender(user.getGender());
        setCustomerFirstName(user.getFirstName());
        setCustomerLastName(user.getLastName());
        setPassword(user.getPassword());
        setDateOfBirth(user.getDayOfBirth(), user.getMonthOfBirth(), user.getYearOfBirth());
        setNewsLetter();
        setSpecialOffers();
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setCompany(user.getCompany());
        setFirstAddressField(user.getAddress());
        setSecondAddressField(user.getAddressSecondLine());
        setCity(user.getCity());
        setState(user.getState());
        setZipCode(user.getZipCode());
        setCountry(user.getCountry());
        setAdditionalInfo(user.getAdditionalInfo());
        setHomePhone(user.getHomePhone());
        setMobilePhone(user.getMobilePhone());
        setAdditionalEmail(user.getAdditionalEmail());
    }
}
