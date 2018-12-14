package com.automationpractice.Pages.AuthenticationPage.SplitedPages;

import Models.Page.Page;
import Models.User.User;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class CreateAccountStep extends Page {

    public CreateAccountStep(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("CreateAccountStep"));
        log.debug("creating an object CreateAccountStep");
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

    @FindBy(id = "passwd")
    private WebElement inputPassword;

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
    private WebElement inputAlias;

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

    private void setDateOfBirth(String day, String month, String year) {
        log.debug("set day of birth");
        new Select(this.selectDays).selectByValue(day);
        log.debug("set month of birth");
        new Select(this.selectMonths).selectByValue(month);
        log.debug("set year of birth");
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

    public void fillAllFields(User user) {
        log.debug("set gender");
        setGender(user);
        log.debug("set customer first name");
        setCustomerFirstName(user.getFirstName());
        log.debug("set customer last name");
        setCustomerLastName(user.getLastName());
        log.debug("set password");
        setPassword(user.getPassword());
        log.debug("set date of birth");
        setDateOfBirth(user.getDayOfBirth(), user.getMonthOfBirth(), user.getYearOfBirth());
        log.debug("set newsletter");
        setNewsLetter(user);
        log.debug("set special offers");
        setSpecialOffers(user);
//        log.debug("set first name");
//        setFirstName(user.getFirstName());
//        log.debug("set last name");
//        setLastName(user.getLastName());
        log.debug("set company");
        setCompany(user.getCompany());
        log.debug("set address first line");
        setFirstAddressField(user.getAddress());
        log.debug("set address second line");
        setSecondAddressField(user.getAddressSecondLine());
        log.debug("set city");
        setCity(user.getCity());
        log.debug("set state");
        setState(user.getState());
        log.debug("set zip code");
        setZipCode(user.getZipCode());
        log.debug("set country");
        setCountry(user.getCountry());
        log.debug("set additional information");
        setAdditionalInfo(user.getAdditionalInfo());
        log.debug("set home phone");
        setHomePhone(user.getHomePhone());
        log.debug("set mobile phone");
        setMobilePhone(user.getMobilePhone());
        log.debug("set alias");
        setAlias(user.getAlias());
    }

    public void clickSubmitAnAccount() {
        this.buttonSubmitAccount.click();
    }
}
