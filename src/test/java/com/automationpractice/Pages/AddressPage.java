package com.automationpractice.Pages;

import Models.User.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressPage extends AccountCreationPage {

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Update")
    private WebElement buttonUpdate;

    @FindBy(linkText = "Delete")
    private WebElement buttonDelete;

    @FindBy(id = "submitAddress")
    private WebElement buttonSubmitAddress;

    public void clickUpdate() {
        this.buttonUpdate.click();
    }

    public void clickDelete() {
        this.buttonDelete.click();
    }

    public void clickSubmitAddress() {
        this.buttonSubmitAddress.click();
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
}
