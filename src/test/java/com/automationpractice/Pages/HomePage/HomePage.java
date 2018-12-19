package com.automationpractice.Pages.HomePage;

import Models.Page.Page;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.HomePage.IncludedPages.ContactUsPage;
import com.automationpractice.Pages.HomePage.IncludedPages.SearchPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Log4j2
public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl(getClass().getSimpleName()));
        log.debug("Creating an instance HomePage");
    }

    @FindBy(how = How.ID, using = "search_query_top")
    private WebElement inputSearch;

    @FindBy(how = How.ID, using = "contact-link")
    private WebElement buttonContactUs;

    @FindBy(how = How.CLASS_NAME, using = "login")
    private WebElement buttonSignIn;

    @FindBy(how = How.CLASS_NAME, using = "logout")
    private WebElement buttonSignOut;

    @FindBy(how = How.CLASS_NAME, using = "account")
    private WebElement buttonAccount;

    public HomePage clickSignOutBtn() {
        this.buttonSignOut.click();
        return new HomePage(driver);
    }

    public ContactUsPage clickContactUsBtn() {
        this.buttonContactUs.click();
        return new ContactUsPage(driver);
    }

    public AuthenticationPage clickSignInBtn() {
        this.buttonSignIn.click();
        return new AuthenticationPage(driver);
    }

    public SearchPage searchText(String text) {
        this.inputSearch.sendKeys(text);
        this.inputSearch.submit();
        return new SearchPage(driver);
    }


}
