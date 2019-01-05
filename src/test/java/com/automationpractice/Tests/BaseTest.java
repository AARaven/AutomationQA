package com.automationpractice.Tests;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Listeners( { ScreenShot.class } )
public class BaseTest {
	
	private static final String PROPERTIES_WEBDRIVER_PATH =
			"./src/main/resources/PropertyFiles/webdriver.properties";
	
	private static ThreadLocal <WebDriver> driverBox = new ThreadLocal <>();
	
	public WebDriver getDriver() {
		WebDriver current = driverBox.get();
		if ( current == null ) {
			setProperty( "chrome" );
			current = new ChromeDriver();
			current.manage().timeouts().implicitlyWait( 7, TimeUnit.SECONDS );
			new WebDriverWait( current, 7 );
			current.manage().window().maximize();
			driverBox.set( current );
		}
		return current;
	}
	
	private void quiteDriver() {
		driverBox.get().quit();
		driverBox.remove();
	}
	
	@BeforeSuite
	protected void beforeSuiteMethod() {
		getDriver();
	}
	
	@AfterSuite
	protected void afterSuiteMethod() {
		quiteDriver();
	}
	
	@BeforeClass
	protected void beforeClassMethod() {
	}
	
	@AfterClass
	protected void afterClassMethod() {
	}
	
	@BeforeGroups
	protected void beforeGroupsMethod() {
	}
	
	@AfterGroups
	protected void afterGroupsMethod() {
	}
	
	@BeforeTest
	protected void beforeTestMethod() {
	}
	
	@AfterTest
	protected void afterTestMethod() {
	}
	
	@BeforeMethod
	protected void beforeMethod() {
	}
	
	@AfterMethod
	protected void afterMethod() {
	}
	
	@SneakyThrows
	private String getDriverProperties( String config ) {
		Properties prop = new Properties();
		InputStream input;
		input = new FileInputStream( PROPERTIES_WEBDRIVER_PATH );
		prop.load( input );
		return prop.getProperty( config );
	}
	
	private void setProperty( String driver ) {
		switch ( driver ) {
			case ( "chrome" ):
				System.setProperty
						( getDriverProperties( "chromeDriverName" ),
								getDriverProperties( "chromeDriverPath" ) );
				break;
			case ( "firefox" ):
				System.setProperty
						( getDriverProperties( "firefoxDriverName" ),
								getDriverProperties( "firefoxDriverPath" ) );
				break;
		}
	}

//	private WebDriver startDriver( String driver ) {
//		switch ( driver ) {
//			case ( "chrome" ):
//				setProperty( "chrome" );
//				ChromeOptions options = new ChromeOptions();
//				this.driver = new ChromeDriver();
//				new WebDriverWait( this.driver, 7 );
//				this.driver.manage().timeouts().implicitlyWait( 7, TimeUnit.SECONDS );
//				this.driver.manage().window().maximize();
//				return this.driver;
//
//			case ( "firefox" ):
//				setProperty( "firefox" );
//				this.driver = new FirefoxDriver();
//				new WebDriverWait( this.driver, 5 );
//				this.driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
//				this.driver.manage().window().maximize();
//				return this.driver;
//
//			default:
//				throw new NullPointerException( "Wrong browser name!" );
//		}
//	}
}
