package com.automationpractice.Pages.HomePage;

import Models.Page.BasePage;
import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.HomePage.IncludedPages.ContactUsPage;
import com.automationpractice.Pages.HomePage.IncludedPages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage( WebDriver driver ) {
		super( driver );
	}
	
	@FindBy( id = "search_query_top" )
	private WebElement inputSearch;
	
	@FindBy( id = "contact-link" )
	private WebElement buttonContactUs;
	
	@FindBy( className = "logout" )
	private WebElement buttonSignOut;
	
	@FindBy( className = "account" )
	private WebElement buttonAccount;
	
	@FindBy( css = "a[class=login]" )
	private WebElement buttonSignIn;
	
	public HomePage clickSignOut() {
		this.buttonSignOut.click();
		return new HomePage( driver );
	}
	
	public ContactUsPage clickContactUs() {
		this.buttonContactUs.click();
		return new ContactUsPage( driver );
	}
	
	public AuthenticationPage clickSignIn() {
		this.buttonSignIn.click();
		return new AuthenticationPage( driver );
	}
	
	public SearchPage typeToSearchField( String text ) {
		this.inputSearch.sendKeys( text );
		this.inputSearch.submit();
		return new SearchPage( driver );
	}
}
