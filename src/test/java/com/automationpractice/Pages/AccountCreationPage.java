package com.automationpractice.Pages;

import Models.User.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage extends AuthorizationPage {

    public AccountCreationPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("AccountCreationPage"));
    }

    @FindBy(id = "submitAccount")
    private WebElement buttonSubmitAccount;

    @FindBy(id = "id_gender1")
    protected WebElement radioGenderMale;

    @FindBy(id = "id_gender2")
    protected WebElement radioGenderFemale;

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

    @FindBy(id = "id_country")
    protected WebElement selectCountry;

    @FindBy(id = "id_state")
    protected WebElement selectState;

    @FindBy(id = "customer_firstname")
    protected WebElement inputCustomerFirstName;

    @FindBy(id = "customer_lastname")
    protected WebElement inputCustomerLastName;

    @FindBy(id = "firstname")
    protected WebElement inputFirstName;

    @FindBy(id = "lastname")
    protected WebElement inputLastName;

    @FindBy(id = "company")
    protected WebElement inputCompany;

    @FindBy(id = "address1")
    protected WebElement inputAdress1;

    @FindBy(id = "address2")
    protected WebElement inputAddress2;

    @FindBy(id = "city")
    protected WebElement inputCity;

    @FindBy(id = "postcode")
    protected WebElement inputZipCode;

    @FindBy(id = "other")
    protected WebElement inputAdditionalInfo;

    @FindBy(id = "phone")
    protected WebElement inputPhone;

    @FindBy(id = "phone_mobile")
    protected WebElement inputPhoneMobile;

    @FindBy(id = "alias")
    protected WebElement inputAlias;

    private void setGender(User user) {
        if (user.getGender().equals("male")) {
            this.radioGenderMale.click();
        } else if (user.getGender().equals("female")) {
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

    private void setAlias(String additionalEmail) {
        this.inputAlias.sendKeys(additionalEmail);
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

    public void setAllFields(User user) {
        setGender(user);
        setCustomerFirstName(user.getFirstName());
        setCustomerLastName(user.getLastName());
        setPassword(user.getPassword());
        setDateOfBirth(user.getDayOfBirth(), user.getMonthOfBirth(), user.getYearOfBirth());
        setNewsLetter(user);
        setSpecialOffers(user);
//        setFirstName(user.getFirstName());
//        setLastName(user.getLastName());
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
        setAlias(user.getAlias());
    }

    public void pushSubmitAnAccount() {
        this.buttonSubmitAccount.click();
    }
}
