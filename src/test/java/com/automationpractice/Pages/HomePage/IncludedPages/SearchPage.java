package com.automationpractice.Pages.HomePage.IncludedPages;

import com.automationpractice.Pages.HomePage.HomePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class SearchPage extends HomePage {
    
    public SearchPage( WebDriver driver ) {
        super( driver );
    }
    
    @Getter @FindBy( id = "cgv" )
    private WebElement checkboxAgree;
    
    @Getter @FindBy( name = "processAddress" )
    private WebElement buttonSubmitAddressToOrder;
    
    @Getter @FindBy( name = "processCarrier" )
    private WebElement buttonProcessCarrier;
    
    @Getter @FindBy( className = "bankwire" )
    private WebElement buttonBankWire;
    
    @Getter @FindBy( className = "cheque-indent" )
    private WebElement textOrderIsComplete;
    
    @Getter @FindBy( className = "product-container" )
    private WebElement productContainers;
    
    public SearchPage chooseProduct( String title ) {
        WebElement productContainer =
                this.driver
                        .findElements( By.className( "product-name" ) )
                        .stream()
                        .filter( WebElement::isDisplayed )
                        .filter( element -> element
                                .getAttribute( "title" )
                                .contains( title ) )
                        .findFirst()
                        .get();
        
        navigateToElement( productContainer );
        return this;
    }
    
    public SearchPage clickAddToCart() {
        WebElement buttonAddToCart =
                this.driver
                        .findElements( By.className( "button" ) )
                        .stream()
                        .filter( WebElement::isDisplayed )
                        .filter( element -> element
                                .getAttribute( "title" )
                                .contains( "Add to cart" ) )
                        .findFirst()
                        .get();
        buttonAddToCart.click();
        return this;
    }
    
    public SearchPage clickSubmitSummary() {
        this.driver
                .findElements( By.tagName( "a" ) )
                .stream()
                .filter( element -> element
                        .getAttribute( "title" )
                        .contains( "Proceed to checkout" ) )
                .findFirst()
                .ifPresent( WebElement::click );
        return this;
    }
    
    public SearchPage clickSubmitSignIn() {
        this.driver
                .findElements( By.tagName( "a" ) )
                .stream()
                .filter( element -> element
                        .getAttribute( "class" )
                        .contains( "button btn btn-default standard-checkout button-medium" ) )
                .findFirst()
                .ifPresent( WebElement::click );
        return this;
    }
    
    public SearchPage clickSubmitAddress() {
        this.buttonSubmitAddressToOrder.click();
        return this;
    }
    
    public SearchPage clickCheckBoxAgree() {
        this.checkboxAgree.click();
        return this;
    }
    
    public SearchPage clickProcessCarrier() {
        this.buttonProcessCarrier.click();
        return this;
    }
    
    public SearchPage clickBankWire() {
        this.buttonBankWire.click();
        return this;
    }
    
    public SearchPage clickConfirmMyOrder() {
        
        this.driver
                .findElements( By.tagName( "button" ) )
                .stream()
                .filter( element -> element.getAttribute( "type" )
                                           .contains( "submit" ) )
                .filter( element -> element.getText()
                                           .contains( "I confirm my order" ) )
                .findFirst()
                .ifPresent( WebElement::click );
        
        return this;
    }
    
    public SoftAssert verifyOrderIsComplete() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue( this.textOrderIsComplete
                                       .getText()
                                       .contains( "Your order on My Store is complete." ),
                               "Your order is not complete." );
        return softAssert;
    }
}

