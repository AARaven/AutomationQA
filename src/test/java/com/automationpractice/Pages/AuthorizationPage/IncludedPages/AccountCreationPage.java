package com.automationpractice.Pages.AuthorizationPage.IncludedPages;

import Models.User.User;
import com.automationpractice.Pages.AccountPage.AccountPage;
import com.automationpractice.Pages.HomePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class AccountCreationPage extends HomePage {
	
	private static final String ERROR_LIST_PATH =
			"./src/main/resources/ErrorsList/errors.json";
	
	public AccountCreationPage( WebDriver driver ) {
		super( driver );
	}
	
	@FindBy( id = "submitAccount" )
	private WebElement buttonRegister;
	
	@FindBy( css = "div.alert.alert-danger" )
	private WebElement alertDiv;
	
	public AccountCreationPage fillUserData( User user ) {
		new PersonalInfoSection( driver )
				.fillPersonalInfoSection( user );
		new AddressSection( driver )
				.fillAddressSection( user );
		return this;
	}
	
	public AccountCreationPage fillUserDataEmptyValues() {
		new PersonalInfoSection( driver )
				.unfilledPersonalInfoSection();
		new AddressSection( driver )
				.unfilledAddressSection();
		return this;
	}
	
	public AccountCreationPage fillUserDataInvalidValues( User user ) {
		new PersonalInfoSection( driver )
				.fillPersonalInfoSectionInvalidData( user );
		new AddressSection( driver )
				.fillAddressSectionInvalidUserData( user );
		return this;
	}
	
	public AccountCreationPage typeEmail( String email ) {
		new PersonalInfoSection( driver ).getInputEmail().clear();
		new PersonalInfoSection( driver ).getInputEmail().sendKeys( email );
		return this;
	}
	
	public AccountPage clickRegister() {
		this.buttonRegister.click();
		return new AccountPage( driver );
	}
	
	public SoftAssert verifyThatAlertDivShowEmptyDataErrors() {
		SoftAssert softAssert = new SoftAssert();
		WebElement errorContainer = alertDiv.findElement( By.tagName( "ol" ) );
		String[] actualErrors = errorContainer.getText().split( "\\n" );
		String[] expectedErrors = getJsonData( "requiredErrors", ERROR_LIST_PATH );
		softAssert.assertTrue
				( alertDiv.isDisplayed(), "Alert message is not displayed." );
		
		for ( int i = 0; i < actualErrors.length; i++ ) {
			softAssert.assertTrue( actualErrors[ i ].contains( expectedErrors[ i ] ),
					"The alert message {'" + expectedErrors[ i ] + "'} is not displayed." );
		}
		return softAssert;
	}
	
	public SoftAssert verifyThatAlertDivShowInvalidDataErrors() {
		SoftAssert softAssert = new SoftAssert();
		WebElement errorContainer = alertDiv.findElement( By.tagName( "ol" ) );
		String[] actualErrors = errorContainer.getText().split( "\\n" );
		String[] expectedErrors = getJsonData( "invalidErrors", ERROR_LIST_PATH );
		softAssert.assertTrue
				( alertDiv.isDisplayed(),
						"Alert message is not displayed." );
		
		for ( int i = 0; i < actualErrors.length; i++ ) {
			softAssert.assertTrue
					( actualErrors[ i ].contains( expectedErrors[ i ] ),
							"The alert message {'" + expectedErrors[ i ] + "'} is not displayed." );
		}
		return softAssert;
	}
	
	public SoftAssert verifyInputElementsOnPageIsEnabled() {
		SoftAssert softAssert = new SoftAssert();
		this.driver.findElements( By.tagName( "input" ) )
				.forEach( element -> softAssert.assertTrue
						( element.isEnabled(), element.getAttribute( "name" ) ) );
		return softAssert;
	}
	
	public SoftAssert verifySelectElementsOnPageIsEnabled() {
		SoftAssert softAssert = new SoftAssert();
		this.driver.findElements( By.tagName( "select" ) )
				.forEach( element -> softAssert.assertTrue
						( element.isEnabled(), element.getAttribute( "name" ) + " is disabled." ) );
		return softAssert;
	}
	
	public SoftAssert verifyTextAreaElementsOnPageIsEnabled() {
		SoftAssert softAssert = new SoftAssert();
		this.driver.findElements( By.tagName( "textarea" ) )
				.forEach( element -> softAssert.assertTrue
						( element.isEnabled(), element.getAttribute( "name" ) + " is disabled." ) );
		return softAssert;
	}
}
