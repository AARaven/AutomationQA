package com.automationpractice.Tests;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	
	protected WebDriver driver;
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	@BeforeSuite
	protected void beforeSuiteMethod() {
		startDriver( "chrome" );
	}
	
	@AfterSuite
	protected void afterSuiteMethod() {
		this.driver.quit();
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
	
	private WebDriver startDriver( String driver ) {
		switch ( driver ) {
			case ( "chrome" ):
				setProperty( "chrome" );
				this.driver = new ChromeDriver();
				ChromeOptions options = new ChromeOptions();
				new WebDriverWait( this.driver, 7 );
				this.driver.manage().timeouts().implicitlyWait( 7, TimeUnit.SECONDS );
				this.driver.manage().window().maximize();
				return this.driver;
			
			case ( "firefox" ):
				setProperty( "firefox" );
				this.driver = new FirefoxDriver();
				new WebDriverWait( this.driver, 5 );
				this.driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
				this.driver.manage().window().maximize();
				return this.driver;
			
			default:
				throw new NullPointerException( "Wrong browser name!" );
		}
	}
}
