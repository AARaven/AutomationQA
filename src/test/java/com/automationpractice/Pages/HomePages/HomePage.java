package com.automationpractice.Pages.HomePages;

import Models.WebPage.BasePage;
import com.automationpractice.Forms.NavigationForms.AccountRowForm;
import com.automationpractice.Forms.NavigationForms.SearchFieldForm;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    
    public HomePage( WebDriver driver ) {
        super( driver );
    }
    
    public AccountRowForm getAccountRow() {
        return new AccountRowForm( getDriver() );
    }
    
    public SearchFieldForm getSearchField() {
        return new SearchFieldForm( getDriver() );
    }
}
