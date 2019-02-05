package com.automationpractice.Forms.TextForms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageForm {
    
    private WebDriver driver;
    
    @FindBy( css = "textarea[id=message]" )
    private WebElement inputMessage;
    
    private WebDriver getDriver() {
        return this.driver;
    }
    
    private void setDriver( WebDriver driver ) {
        this.driver = driver;
    }
    
    private WebElement getInputMessage() {
        return this.inputMessage;
    }
    
    public MessageForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public MessageForm sendText( String text ) {
        this.getInputMessage().clear();
        this.getInputMessage().sendKeys( text );
        return this;
    }
}
