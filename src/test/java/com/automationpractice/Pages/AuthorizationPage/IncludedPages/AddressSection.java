package com.automationpractice.Pages.AuthorizationPage.IncludedPages;

import Models.User.User;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressSection {

    public AddressSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Getter
    @FindBy(id = "firstname")
    private WebElement inputFirstName;

    @Getter
    @FindBy(id = "lastname")
    private WebElement inputLastName;

    @Getter
    @FindBy(id = "company")
    private WebElement inputCompany;

    @Getter
    @FindBy(id = "address1")
    private WebElement inputAddress1;

    @Getter
    @FindBy(id = "address2")
    private WebElement inputAddress2;

    @Getter
    @FindBy(id = "city")
    private WebElement inputCity;

    @Getter
    @FindBy(id = "postcode")
    private WebElement inputZipCode;

    @Getter
    @FindBy(id = "other")
    private WebElement inputAdditionalInfo;

    @Getter
    @FindBy(id = "phone")
    private WebElement inputPhone;

    @Getter
    @FindBy(id = "phone_mobile")
    private WebElement inputPhoneMobile;

    @Getter
    @FindBy(id = "alias")
    private WebElement inputAlias;

    @Getter
    @FindBy(id = "id_country")
    private WebElement selectCountry;

    @Getter
    @FindBy(id = "id_state")
    private WebElement selectState;

    void fillAddressSection(User user) {
        setFirstName
                (user.getFirstName());
        setLastName
                (user.getLastName());
        setCompany
                (user.getCompany());
        setFirstAddressField
                (user.getAddress());
        setSecondAddressField
                (user.getAddressSecondLine());
        setCity(
                user.getCity());
        setState
                (user.getState());
        setZipCode
                (user.getZipCode());
        setCountry
                (user.getCountry());
        setAdditionalInfo
                (user.getAdditionalInfo());
        setHomePhone
                (user.getHomePhone());
        setMobilePhone
                (user.getMobilePhone());
        setAlias
                (user.getAlias());
    }

    private void setFirstName(String firstname) {
        this.inputFirstName.clear();
        this.inputFirstName.sendKeys(firstname);
    }

    private void setLastName(String lastname) {
        this.inputLastName.clear();
        this.inputLastName.sendKeys(lastname);
    }

    private void setCompany(String company) {
        this.inputCompany.sendKeys(company);
    }

    private void setFirstAddressField(String address) {
        this.inputAddress1.sendKeys(address);
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
        this.inputAlias.clear();
        this.inputAlias.sendKeys(additionalEmail);
    }
}
