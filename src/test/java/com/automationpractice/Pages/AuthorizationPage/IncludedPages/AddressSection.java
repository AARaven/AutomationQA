package com.automationpractice.Pages.AuthorizationPage.IncludedPages;

import Models.User.User;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressSection {

    public AddressSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Getter
    @FindBy(how = How.ID, using = "firstname")
    private WebElement inputFirstName;

    @Getter
    @FindBy(how = How.ID, using = "lastname")
    private WebElement inputLastName;

    @Getter
    @FindBy(how = How.ID, using = "company")
    private WebElement inputCompany;

    @Getter
    @FindBy(how = How.ID, using = "address1")
    private WebElement inputAddress1;

    @Getter
    @FindBy(how = How.ID, using = "address2")
    private WebElement inputAddress2;

    @Getter
    @FindBy(how = How.ID, using = "city")
    private WebElement inputCity;

    @Getter
    @FindBy(how = How.ID, using = "postcode")
    private WebElement inputZipCode;

    @Getter
    @FindBy(how = How.ID, using = "other")
    private WebElement inputAdditionalInfo;

    @Getter
    @FindBy(how = How.ID, using = "phone")
    private WebElement inputPhone;

    @Getter
    @FindBy(how = How.ID, using = "phone_mobile")
    private WebElement inputPhoneMobile;

    @Getter
    @FindBy(how = How.ID, using = "alias")
    private WebElement inputAlias;

    @Getter
    @FindBy(how = How.ID, using = "id_country")
    private WebElement selectCountry;

    @Getter
    @FindBy(how = How.ID, using = "id_state")
    private WebElement selectState;

    void fillAddressSection(User user) {
        setDataFields
                (inputFirstName, user.getFirstName());
        setDataFields
                (inputLastName, user.getLastName());
        setDataFields
                (inputAddress1, user.getAddress());
        setDataFields
                (inputAddress2, user.getAddressSecondLine());
        setDataFields
                (inputCity, user.getCity());
        setState
                (user.getState());
        setDataFields
                (inputZipCode, user.getZipCode());
        setCountry
                (user.getCountry());
        setDataFields
                (inputAdditionalInfo, user.getAdditionalInfo());
        setDataFields
                (inputPhone, user.getHomePhone());
        setDataFields
                (inputPhoneMobile, user.getMobilePhone());
        setDataFields
                (inputAlias, user.getAlias());
    }

    private void setState(String state) {
        new Select(this.selectState).selectByVisibleText(state);
    }

    private void setCountry(String country) {
        new Select(this.selectCountry).selectByVisibleText(country);
    }

    private void setDataFields(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
}
