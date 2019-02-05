package com.automationpractice.Pages.AuthorizationPages.SecondaryPages;

import com.automationpractice.Forms.LoginForms.RetrievePasswordForm;
import com.automationpractice.Pages.AuthorizationPages.AuthenticationPage;
import com.automationpractice.Pages.HomePages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordRecoverPage extends HomePage {
    
    @FindBy( css = "a[title='Back to LoginForm']" )
    private WebElement buttonBackToLogin;
    
    private WebElement getButtonBackToLogin() {
        return this.buttonBackToLogin;
    }
    
    public PasswordRecoverPage( WebDriver driver ) {
        super( driver );
    }
    
    public RetrievePasswordForm getRetrievePasswordForm() {
        return new RetrievePasswordForm( getDriver() );
    }
    
    public AuthenticationPage clickBack() {
        this.getButtonBackToLogin().click();
        return new AuthenticationPage( getDriver() );
    }
}
