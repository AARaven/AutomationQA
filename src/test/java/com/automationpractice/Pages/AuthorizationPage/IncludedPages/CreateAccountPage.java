package com.automationpractice.Pages.AuthorizationPage.IncludedPages;

import Models.User.User;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.HomePage.HomePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class CreateAccountPage extends HomePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl(getClass().getSimpleName()));
        log.debug("Creating an instance CreateAccountPage");
    }

    @FindBy(id = "submitAccount")
    private WebElement buttonRegister;

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
}
