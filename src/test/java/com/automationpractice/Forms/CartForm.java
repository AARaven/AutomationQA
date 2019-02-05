package com.automationpractice.Forms;

import com.automationpractice.Pages.HomePages.SecondaryPages.OrderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartForm {
    
    private WebDriver driver;
    
    @FindBy( css = "a[title='View my shopping cart']" ) private WebElement linkCart;
    
    private WebDriver getDriver() {
        return this.driver;
    }
    
    private void setDriver( WebDriver driver ) {
        this.driver = driver;
    }
    
    private WebElement getLinkCart() {
        return this.linkCart;
    }
    
    public CartForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public OrderPage clickCart() {
        this.getLinkCart().click();
        return new OrderPage( getDriver() );
    }
}
