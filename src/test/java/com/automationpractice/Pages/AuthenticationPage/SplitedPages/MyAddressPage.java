package com.automationpractice.Pages.AuthenticationPage.SplitedPages;

import Models.User.User;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

@Log4j2
public class MyAddressPage extends NavigationForMyAccountPages {

    public MyAddressPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("MyAddressPage"));
        log.debug("creating an object MyAddressPage");
    }

    @FindBy(linkText = "Update")
    private WebElement buttonUpdate;

    @FindBy(linkText = "Delete")
    private WebElement buttonDelete;

    @FindBy(id = "submitAddress")
    private WebElement buttonSubmitAddress;

    @FindBy(linkText = "Add an address")
    private WebElement buttonAddAddress;

    @FindBy(xpath = "//a[@class='btn btn-defaul button button-small']")
    private WebElement buttonBackToYourAddresses;

    //Info:

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

    @FindBy(id = "id_state")
    private WebElement selectState;

    @FindBy(id = "postcode")
    private WebElement inputZipCode;

    @FindBy(id = "id_country")
    private WebElement selectCountry;

    @FindBy(id = "phone")
    private WebElement inputPhone;

    @FindBy(id = "phone_mobile")
    private WebElement inputPhoneMobile;

    @FindBy(id = "other")
    private WebElement inputAdditionalInfo;

    @FindBy(id = "alias")
    private WebElement inputAlias;

    public void clickUpdate() {
        this.buttonUpdate.click();
    }

    public void clickDelete() {
        this.buttonDelete.click();
    }

    public void clickSubmitAddress() {
        this.buttonSubmitAddress.click();
    }

    public void clickAddAddress() {
        this.buttonAddAddress.click();
    }

    public void clickBackToYourAddresses() {
        this.buttonBackToYourAddresses.click();
    }

    public boolean isUserFirstName(User user) {
        return user.getFirstName().equals(this.inputFirstName.getAttribute("value"));
    }

    public boolean isUserLastName(User user) {
        return user.getLastName().equals(this.inputLastName.getAttribute("value"));
    }

    public boolean isUserCompany(User user) {
        return user.getCompany().equals(this.inputCompany.getAttribute("value"));
    }

    public boolean isUserAddress(User user) {
        return user.getAddress().equals(this.inputAdress1.getAttribute("value"));
    }

    public boolean isUserAddressSecondLine(User user) {
        return user.getAddressSecondLine().equals(this.inputAddress2.getAttribute("value"));
    }

    public boolean isUserCity(User user) {
        return user.getCity().equals(this.inputCity.getAttribute("value"));
    }

    public boolean isUserState(User user) {
        return user.getState().equals(new Select(this.selectState).getFirstSelectedOption().getText());
    }

    public boolean isUserZip(User user) {
        return user.getZipCode().equals(this.inputZipCode.getAttribute("value"));
    }

    public boolean isUserCountry(User user) {
        return user.getCountry().equals(new Select(this.selectCountry).getFirstSelectedOption().getText());
    }

    public boolean isUserHomePhone(User user) {
        return user.getHomePhone().equals(this.inputPhone.getAttribute("value"));
    }

    public boolean isUserMobilePhone(User user) {
        return user.getMobilePhone().equals(this.inputPhoneMobile.getAttribute("value"));
    }

    public boolean isUserAdditionalInfo(User user) {
        return user.getAdditionalInfo().equals(this.inputAdditionalInfo.getAttribute("value"));
    }

    public boolean isUserAlias(User user) {
        if (user.getAlias().equals("")) {
            return true;
        }
        return user.getAlias().equals(this.inputAlias.getAttribute("value"));
    }

    public SoftAssert verifyUserAddress(User user) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isUserFirstName(user),"User first name is not correct");
        softAssert.assertTrue(isUserLastName(user),"User last name is not correct");
        softAssert.assertTrue(isUserCompany(user),"User company is not correct");
        softAssert.assertTrue(isUserAddress(user),"User address is not correct");
        softAssert.assertTrue(isUserAddressSecondLine(user),"User address second line is not correct");
        softAssert.assertTrue(isUserCity(user),"User city is not correct");
        softAssert.assertTrue(isUserState(user),"User state is not correct");
        softAssert.assertTrue(isUserZip(user),"User zip is not correct");
        softAssert.assertTrue(isUserCountry(user),"User country is not correct");
        softAssert.assertTrue(isUserHomePhone(user),"User home phone is not correct");
        softAssert.assertTrue(isUserMobilePhone(user),"User mobile phone is not correct");
        softAssert.assertTrue(isUserAdditionalInfo(user),"User additional information is not correct");
        softAssert.assertTrue(isUserAlias(user),"User alias is not correct");
        return softAssert;
    }
}
