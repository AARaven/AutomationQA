package com.automationpractice.Forms.NavigationForms;

import com.automationpractice.Pages.HomePages.SecondaryPages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFieldForm {
    
    private WebDriver driver;
    
    @FindBy( css = "input[id=search_query_top]" ) private WebElement inputSearch;
    @FindBy( css = "button[name=submit_search]" ) private WebElement buttonSubmit;
    
    private WebDriver getDriver() {
        return this.driver;
    }
    
    private void setDriver( WebDriver driver ) {
        this.driver = driver;
    }
    
    private WebElement getInputSearch() {
        return this.inputSearch;
    }
    
    private WebElement getButtonSubmit() {
        return this.buttonSubmit;
    }
    
    public SearchFieldForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public SearchPage sendText( String text ) {
        this.getInputSearch().clear();
        this.getInputSearch().sendKeys( text );
        this.getButtonSubmit().click();
        return new SearchPage( getDriver() );
    }
}
