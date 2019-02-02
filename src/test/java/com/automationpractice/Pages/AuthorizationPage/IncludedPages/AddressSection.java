package com.automationpractice.Pages.AuthorizationPage.IncludedPages;

import Models.User.User;
import lombok.Getter;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressSection {
	
	public AddressSection( WebDriver driver ) {
		PageFactory.initElements( driver, this );
	}
	
	@Getter
	@FindBy( id = "firstname" )
	private WebElement inputFirstName;
	
	@Getter
	@FindBy( id = "lastname" )
	private WebElement inputLastName;
	
	@Getter
	@FindBy( id = "company" )
	private WebElement inputCompany;
	
	@Getter
	@FindBy( id = "address1" )
	private WebElement inputAddress1;
	
	@Getter
	@FindBy( id = "address2" )
	private WebElement inputAddress2;
	
	@Getter
	@FindBy( id = "city" )
	private WebElement inputCity;
	
	@Getter
	@FindBy( id = "postcode" )
	private WebElement inputZipCode;
	
	@Getter
	@FindBy( id = "other" )
	private WebElement inputAdditionalInfo;
	
	@Getter
	@FindBy( id = "phone" )
	private WebElement inputPhone;
	
	@Getter
	@FindBy( id = "phone_mobile" )
	private WebElement inputPhoneMobile;
	
	@Getter
	@FindBy( id = "alias" )
	private WebElement inputAlias;
	
	@Getter
	@FindBy( id = "id_country" )
	private WebElement selectCountry;
	
	@Getter
	@FindBy( id = "id_state" )
	private WebElement selectState;
	
	void fillAddressSection( User user ) {
		setDataFields
				( inputFirstName, user.getFirstName() );
		setDataFields
				( inputLastName, user.getLastName() );
		setDataFields
				( inputCompany, user.getAddress().getCompany() );
		setDataFields
				( inputAddress1, user.getAddress().getAddress() );
		setDataFields
				( inputAddress2, user.getAddress().getAddressSecondLine() );
		setDataFields
				( inputCity, user.getAddress().getCity() );
		setState
				( user.getAddress().getState().getName() );
		setDataFields
				( inputZipCode, user.getAddress().getZipCode() );
		setCountry
				( user.getAddress().getCountry() );
		setDataFields
				( inputAdditionalInfo, user.getAdditionalInfo() );
		setDataFields
				( inputPhone, user.getHomePhone() );
		setDataFields
				( inputPhoneMobile, user.getMobilePhone() );
		setDataFields
				( inputAlias, user.getAlias() );
	}
	
	void unfilledAddressSection() {
		this.inputAlias.clear();
		new Select( this.selectCountry ).selectByVisibleText( "-" );
	}
	
	void fillAddressSectionInvalidUserData( User user ) {
		setDataFields
				( inputFirstName, user.getFirstName() );
		setDataFields
				( inputLastName, user.getLastName() );
		setDataFields
				( inputCompany, user.getAddress().getCompany() );
		setDataFields
				( inputAddress1, user.getAddress().getAddress() );
		setDataFields
				( inputAddress2, user.getAddress().getAddressSecondLine() );
		setDataFields
				( inputCity, user.getAddress().getCity() );
		setDataFields
				( inputZipCode, user.getAddress().getZipCode() );
		setDataFields
				( inputAdditionalInfo, new RandomString( 500 ).nextString() );
		setDataFields
				( inputPhone, user.getHomePhone() );
		setDataFields
				( inputPhoneMobile, user.getMobilePhone() );
		setDataFields
				( inputAlias, user.getAlias() );
		
	}
	
	private void setState( String state ) {
		new Select( this.selectState ).selectByVisibleText( state );
	}
	
	private void setCountry( String country ) {
		new Select( this.selectCountry ).selectByVisibleText( country );
	}
	
	private void setDataFields( WebElement element, String value ) {
		element.clear();
		element.sendKeys( value );
	}
}
