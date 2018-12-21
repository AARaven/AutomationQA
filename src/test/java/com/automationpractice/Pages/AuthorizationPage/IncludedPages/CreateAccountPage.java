package com.automationpractice.Pages.AuthorizationPage.IncludedPages;

import Models.User.User;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.HomePage.HomePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
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

    public CreateAccountPage setFieldsUserInvalidData(User user) {
        new PersonalInfoSection(driver)
                .fillPersonalInfoSectionInvalidData(user);
        new AddressSection(driver)
                .fillAddressSectionInvalidUserData(user);
        return this;
    }

    public CreateAccountPage setEmail(String email) {
        new PersonalInfoSection(driver).getInputEmail().clear();
        new PersonalInfoSection(driver).getInputEmail().sendKeys(email);
        return this;
    }

    public SoftAssert verifyUserEmptyDataAlert() {
        SoftAssert softAssert = new SoftAssert();
        WebElement errorContainer = alertDiv.findElement(By.tagName("ol"));
        String[] strings = errorContainer.getText().split("\\n");
        String[] errors = {"You must register at least one phone number.",
                "lastname is required.",
                "firstname is required.",
                "passwd is required.",
                "id_country is required.",
                "aliasd is required.",
                "address1 is required.",
                "city is required.",
                "Country cannot be loaded with address->id_country",
                "Country is invalid"
        };
        softAssert.assertTrue
                (alertDiv.isDisplayed(),
                        "Alert message is not displayed.");

        for (int i = 0; i < strings.length; i++) {
            softAssert.assertTrue(strings[i].contains(errors[i]),
                    "The alert message {'" + errors[i] + "'} is not displayed.");
        }
        log.info(alertDiv.getText());
        return softAssert;
    }

    public SoftAssert verifyUserInvalidDataAlert() {
        SoftAssert softAssert = new SoftAssert();
        WebElement errorContainer = alertDiv.findElement(By.tagName("ol"));
        String[] strings = errorContainer.getText().split("\\n");
        String[] errors = {"lastname is invalid.",
                "firstname is invalid.",
                "email is invalid",
                "passwd is invalid.",
                "address1 is invalid.",
                "address2 is invalid.",
                "postcode is invalid.",
                "city is invalid.",
                "other is too long. Maximum length: 300",
                "phone is invalid.",
                "phone_mobile is invalid.",
                "The Zip/Postal code you've entered is invalid. It must follow this format: 00000",
                "This country requires you to choose a State.",
        };
        softAssert.assertTrue
                (alertDiv.isDisplayed(),
                        "Alert message is not displayed.");

        for (int i = 0; i < strings.length; i++) {
            softAssert.assertTrue
                    (strings[i].contains(errors[i]),
                            "The alert message {'" + errors[i] + "'} is not displayed.");
        }
        log.info(alertDiv.getText());
        return softAssert;
    }

    public SoftAssert verifyingInputElementsOnPageIsEnabled() {
        SoftAssert softAssert = new SoftAssert();
        this.driver.findElements(By.tagName("input"))
                .forEach(element -> softAssert.assertTrue
                        (element.isEnabled(), element.getAttribute("name")));
        return softAssert;
    }

    public SoftAssert verifyingSelectElementsOnPageIsEnabled() {
        SoftAssert softAssert = new SoftAssert();
        this.driver.findElements(By.tagName("select"))
                .forEach(element -> softAssert.assertTrue
                        (element.isEnabled(), element.getAttribute("name") +
                                " is disabled."));
        return softAssert;
    }

    public SoftAssert verifyingTextAreaElementsOnPageIsEnabled() {
        SoftAssert softAssert = new SoftAssert();
        this.driver.findElements(By.tagName("textarea"))
                .forEach(element -> softAssert.assertTrue
                        (element.isEnabled(), element.getAttribute("name") +
                                " is disabled."));
        return softAssert;
    }
}
