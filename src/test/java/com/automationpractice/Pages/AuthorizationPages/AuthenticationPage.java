package com.automationpractice.Pages.AuthorizationPages;

import Models.User.User;
import com.automationpractice.Forms.LoginForms.CreateAccountForm;
import com.automationpractice.Forms.LoginForms.LoginForm;
import com.automationpractice.Pages.AccountPages.AccountPage;
import com.automationpractice.Pages.HomePages.HomePage;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends HomePage {
    
    public AuthenticationPage( WebDriver driver ) {
        super( driver );
    }
    
    public CreateAccountForm getCreateAccountForm() {
        return new CreateAccountForm( getDriver() );
    }
    
    public LoginForm getLoginForm() {
        return new LoginForm( getDriver() );
    }
    
    public AccountPage authorizeUser( User user ) {
        return this.getLoginForm()
                   .sendEmail( user.getEmail() )
                   .sendPassword( user.getPassword() )
                   .clickSignIn();
    }
}
