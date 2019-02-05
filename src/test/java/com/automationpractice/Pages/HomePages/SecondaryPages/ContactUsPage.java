package com.automationpractice.Pages.HomePages.SecondaryPages;

import com.automationpractice.Forms.TextForms.MessageForm;
import com.automationpractice.Pages.HomePages.HomePage;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends HomePage {
    
    public ContactUsPage( WebDriver driver ) {
        super( driver );
    }
    
    public MessageForm getMessage() {
        return new MessageForm( getDriver() );
    }
}
