package com.automationpractice.Pages.AccountPage.IncludedPages;

import Models.User.User;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.AddressSection;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

@Log4j2
public class AddressPage extends AccountPage {

    private AddressSection userAddress =
            new AddressSection(driver);

    public AddressPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl(getClass().getSimpleName()));
        log.debug("Creating an instance AddressPage");
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

    public AddressPage clickUpdate() {
        this.buttonUpdate.click();
        return new AddressPage(driver);
    }

    public AddressPage clickDelete() {
        this.buttonDelete.click();
        return this;
    }

    public AddressPage clickSubmitAddress() {
        this.buttonSubmitAddress.click();
        return this;
    }

    public AddressPage clickAddAddress() {
        this.buttonAddAddress.click();
        return this;
    }

    public AddressPage clickBackToYourAddresses() {
        this.buttonBackToYourAddresses.click();
        return this;
    }

    public AddressPage rewriteAll(User user) {
        rewriteFirstName
                (user.getFirstName());
        rewriteLastName
                (user.getLastName());
        rewriteCompany
                (user.getCompany());
        rewriteAddress
                (user.getAddress());
        rewriteAddressSecondLine
                (user.getAddressSecondLine());
        rewriteCity
                (user.getCity());
//        rewriteState
//                (user.getState());
        rewriteZip
                (user.getZipCode());
//        rewriteCountry
//                (user.getCountry());
        rewriteHomePhone
                (user.getHomePhone());
        rewriteMobilePhone
                (user.getMobilePhone());
        rewriteAdditionalInfo
                (user.getAdditionalInfo());
        rewriteAlias
                (user.getAlias());
        return this;
    }

    public SoftAssert verifyUserAddress(User user) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue
                        (isUserFirstName(user),
                                "User first name is not correct");
        softAssert.assertTrue
                        (isUserLastName(user),
                                "User last name is not correct");
        softAssert.assertTrue
                        (isUserCompany(user),
                                "User company is not correct");
        softAssert.assertTrue
                        (isUserAddress(user),
                                "User address is not correct");
        softAssert.assertTrue
                        (isUserAddressSecondLine(user),
                                "User address second line is not correct");
        softAssert.assertTrue
                        (isUserCity(user),
                                "User city is not correct");
        softAssert.assertTrue
                        (isUserState(user),
                                "User state is not correct");
        softAssert.assertTrue
                        (isUserZip(user),
                                "User zip is not correct");
        softAssert.assertTrue
                        (isUserCountry(user),
                                "User country is not correct");
        softAssert.assertTrue
                        (isUserHomePhone(user),
                                "User home phone is not correct");
        softAssert.assertTrue
                        (isUserMobilePhone(user),
                                "User mobile phone is not correct");
        softAssert.assertTrue
                        (isUserAdditionalInfo(user),
                                "User additional information is not correct");
        softAssert.assertTrue
                        (isUserAlias(user),
                                "User alias is not correct");
        return softAssert;
    }

    private AddressPage rewriteFirstName(String firstname) {
        this.userAddress.getInputFirstName().clear();
        this.userAddress.getInputFirstName().sendKeys(firstname);
        return this;
    }

    private AddressPage rewriteLastName(String lastname) {
        this.userAddress.getInputLastName().clear();
        this.userAddress.getInputLastName().sendKeys(lastname);
        return this;
    }

    private AddressPage rewriteCompany(String company) {
        this.userAddress.getInputCompany().clear();
        this.userAddress.getInputCompany().sendKeys(company);
        return this;
    }

    private AddressPage rewriteAddress(String address) {
        this.userAddress.getInputAddress1().clear();
        this.userAddress.getInputAddress1().sendKeys(address);
        return this;
    }

    private AddressPage rewriteAddressSecondLine(String address2) {
        this.userAddress.getInputAddress2().clear();
        this.userAddress.getInputAddress2().sendKeys(address2);
        return this;
    }

    private AddressPage rewriteCity(String city) {
        this.userAddress.getInputCity().clear();
        this.userAddress.getInputCity().sendKeys(city);
        return this;
    }

    private AddressPage rewriteState(String state) {
        new Select(this.userAddress.getSelectState()).deselectAll();
        new Select(this.userAddress.getSelectState()).selectByValue(state);
        return this;
    }

    private AddressPage rewriteZip(String zip) {
        this.userAddress.getInputZipCode().clear();
        this.userAddress.getInputZipCode().sendKeys(zip);
        return this;
    }

    private AddressPage rewriteCountry(String country) {
        new Select(this.userAddress.getSelectCountry()).deselectAll();
        new Select(this.userAddress.getSelectCountry()).selectByValue(country);
        return this;
    }

    private AddressPage rewriteHomePhone(String homePhone) {
        this.userAddress.getInputPhone().clear();
        this.userAddress.getInputPhone().sendKeys(homePhone);
        return this;
    }

    private AddressPage rewriteMobilePhone(String mobilePhone) {
        this.userAddress.getInputPhoneMobile().clear();
        this.userAddress.getInputPhoneMobile().sendKeys(mobilePhone);
        return this;
    }

    private AddressPage rewriteAdditionalInfo(String info) {
        this.userAddress.getInputAdditionalInfo().clear();
        this.userAddress.getInputAdditionalInfo().sendKeys(info);
        return this;
    }

    private AddressPage rewriteAlias(String alias) {
        this.userAddress.getInputAlias().clear();
        this.userAddress.getInputAlias().sendKeys(alias);
        return this;
    }

    private boolean isUserFirstName(User user) {
        return user.getFirstName()
                .equals(this.userAddress
                        .getInputFirstName()
                        .getAttribute("value"));
    }

    private boolean isUserLastName(User user) {
        return user.getLastName()
                .equals(this.userAddress
                        .getInputLastName()
                        .getAttribute("value"));
    }

    private boolean isUserCompany(User user) {
        return user.getCompany()
                .equals(this.userAddress
                        .getInputCompany()
                        .getAttribute("value"));
    }

    private boolean isUserAddress(User user) {
        return user.getAddress()
                .equals(this.userAddress
                        .getInputAddress1()
                        .getAttribute("value"));
    }

    private boolean isUserAddressSecondLine(User user) {
        return user.getAddressSecondLine()
                .equals(this.userAddress
                        .getInputAddress2()
                        .getAttribute("value"));
    }

    private boolean isUserCity(User user) {
        return user.getCity()
                .equals(this.userAddress
                        .getInputCity()
                        .getAttribute("value"));
    }

    private boolean isUserState(User user) {
        return user.getState()
                .equals(new Select(this.userAddress.getSelectState())
                        .getFirstSelectedOption()
                        .getText());
    }

    private boolean isUserZip(User user) {
        return user.getZipCode()
                .equals(this.userAddress
                        .getInputZipCode()
                        .getAttribute("value"));
    }

    private boolean isUserCountry(User user) {
        return user.getCountry()
                .equals(new Select(this.userAddress.getSelectCountry())
                        .getFirstSelectedOption()
                        .getText());
    }

    private boolean isUserHomePhone(User user) {
        return user.getHomePhone()
                .equals(this.userAddress
                        .getInputPhone()
                        .getAttribute("value"));
    }

    private boolean isUserMobilePhone(User user) {
        return user.getMobilePhone()
                .equals(this.userAddress
                        .getInputPhoneMobile()
                        .getAttribute("value"));
    }

    private boolean isUserAdditionalInfo(User user) {
        return user.getAdditionalInfo()
                .equals(this.userAddress
                        .getInputAdditionalInfo()
                        .getAttribute("value"));
    }

    private boolean isUserAlias(User user) {
        if (user.getAlias().equals("")) {
            return true;
        }
        return user.getAlias()
                .equals(this.userAddress
                        .getInputAlias()
                        .getAttribute("value"));
    }
}
