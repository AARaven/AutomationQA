package com.automationpractice.Pages;

import Models.User.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage extends AuthorizationPage {

    private static final String ACCOUNT_CREATION_PAGE_URL =
            "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";

    public AccountCreationPage(WebDriver driver) {
        super(driver);
        this.setUrl(ACCOUNT_CREATION_PAGE_URL);
    }

    @FindBy(id = "submitAccount")
    private WebElement buttonSubmitAccount;

    @FindBy(id = "id_gender1")
    private WebElement radioGenderMale;

    @FindBy(id = "id_gender2")
    private WebElement radioGenderFemale;

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

    @FindBy(id = "id_country")
    private WebElement selectCountry;

    @FindBy(id = "id_state")
    private WebElement selectState;

    @FindBy(id = "customer_firstname")
    private WebElement inputCustomerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement inputCustomerLastName;

    @FindBy(id = "firstname")
    private WebElement inputFirstName;

    @FindBy(id = "lastname")
    private WebElement inputLastName;

    @FindBy(id = "company")
    private WebElement inputCompany;

    @FindBy(id = "address1")
    private WebElement inputAdress1;

    @FindBy(id = "address2")
    private WebElement inputAddress2;

    @FindBy(id = "city")
    private WebElement inputCity;

    @FindBy(id = "postcode")
    private WebElement inputZipCode;

    @FindBy(id = "other")
    private WebElement inputAdditionalInfo;

    @FindBy(id = "phone")
    private WebElement inputPhone;

    @FindBy(id = "phone_mobile")
    private WebElement inputPhoneMobile;

    @FindBy(id = "alias")
    private WebElement inputAdditionalEmail;

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

    public void setPassword(String password) {
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

    public void setAllFields(User user) {
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

    public void pushSubmitAnAccount() {
        this.buttonSubmitAccount.click();
    }
}
