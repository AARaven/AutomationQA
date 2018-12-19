package com.automationpractice.Pages.AuthorizationPage.IncludedPages;

import Models.User.User;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.HomePage.HomePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.asserts.SoftAssert;

@Log4j2
public class CreateAccountPage extends HomePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl(getClass().getSimpleName()));
        log.debug("Creating an instance CreateAccountPage");
    }

    @FindBy(how = How.ID, using = "submitAccount")
    private WebElement buttonRegister;

    @FindBy(how = How.CSS, using = "div.alert.alert-danger")
    private WebElement alertDiv;

    public AccountPage clickRegister() {
        this.buttonRegister.click();
        return new AccountPage(driver);
    }

    public CreateAccountPage setFieldsUserData(User user) {
        new PersonalInfoSection(driver)
                .fillPersonalInfoSection(user);
        new AddressSection(driver)
                .fillAddressSection(user);
        return this;
    }

    public CreateAccountPage setFieldsUserEmptyData() {
        new PersonalInfoSection(driver)
                .unfilledPersonalInfoSection();
        new AddressSection(driver)
                .unfilledAddressSection();
        return this;
    }

    public CreateAccountPage setFieildsUserInvalidData(User user) {
        new PersonalInfoSection(driver)
                .fillPersonalInfoSectionInvalidData(user);
        new AddressSection(driver)
                .fillAddressSectionInvalidUserData(user);
        return this;
    }

    public SoftAssert verifyUserEmptyDataAlert() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue
                (alertDiv.isDisplayed(), "Alert message is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("You must register at least one phone number."),
                        "Alert message 'You must register at least one phone number.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("lastname is required."),
                        "Alert message 'lastname is required.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("firstname is required."),
                        "Alert message 'firstname is required.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("email is required."),
                        "Alert message 'email is required.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("passwd is required."),
                        "Alert message 'passwd is required.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("id_country is required."),
                        "Alert message 'id_country is required.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("alias is required."),
                        "Alert message 'alias is required.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("address1 is required."),
                        "Alert message 'address1 is required.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("city is required."),
                        "Alert message 'city is required.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("Country cannot be loaded with address->id_country"),
                        "Alert message 'Country cannot be loaded with address->id_country' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("Country is invalid"),
                        "Alert message 'Country is invalid' is not displayed.");
        log.info(alertDiv.getText());
        return softAssert;
    }

    public SoftAssert verifyUserInvalidDataAlert() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue
                (alertDiv.isDisplayed(), "Alert message is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("firstname is invalid."),
                        "Alert message 'firstname is invalid.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("lastname is invalid."),
                        "Alert message 'lastname is invalid.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("email is invalid"),
                        "Alert message 'email is invalid.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("address1 is invalid."),
                        "Alert message 'address1 is invalid.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("address2 is invalid."),
                        "Alert message 'address2 is invalid.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("postcode is invalid."),
                        "Alert message 'postcode is invalid.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("city is invalid."),
                        "Alert message 'city is invalid.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("phone is invalid."),
                        "Alert message 'phone is invalid.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("phone_mobile is invalid."),
                        "Alert message 'phone_mobile is invalid.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("The Zip/Postal code you've entered is invalid. " +
                                "It must follow this format: 00000"),
                        "Alert message 'The Zip/Postal code you've entered is invalid." +
                                " It must follow this format: 00000' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("passwd is invalid."),
                        "Alert message 'email is invalid.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("This country requires you to choose a State."),
                        "Alert message 'email is invalid.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("This country requires you to choose a State."),
                        "Alert message 'email is invalid.' is not displayed.");
        softAssert.assertTrue
                (alertDiv.getText().contains("other is too long. Maximum length: 300"),
                        "Alert message 'other is too long. Maximum length: 300' is not displayed.");
        log.info(alertDiv.getText());
        return softAssert;
    }

    public CreateAccountPage setEmail(String email) {
        new PersonalInfoSection(driver).getInputEmail().clear();
        new PersonalInfoSection(driver).getInputEmail().sendKeys(email);
        return this;
    }
}
