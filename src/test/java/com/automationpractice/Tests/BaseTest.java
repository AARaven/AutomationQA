package com.automationpractice.Tests;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


@Log4j2 @Listeners( { ScreenShot.class } )
public class BaseTest {
    
    private static ThreadLocal < WebDriver > DRIVER_BOX = new ThreadLocal <>();
    
    private static final String WEBDRIVER_PROPERTIES_PATH =
            "./src/main/resources/PropertyFiles/webdriver.properties";
    
    
    public WebDriver getDriver() {
        
        WebDriver threadSafeDriver = DRIVER_BOX.get();
        
        if ( threadSafeDriver == null ) {
            setProperty();
            threadSafeDriver = new ChromeDriver();
            threadSafeDriver.manage()
                              .timeouts()
                              .implicitlyWait( 7, TimeUnit.SECONDS );
            threadSafeDriver.manage()
                              .window()
                              .maximize();
            DRIVER_BOX.set( threadSafeDriver );
        }
        return threadSafeDriver;
    }
    
    private void quiteDriver() {
        DRIVER_BOX.get().quit();
        DRIVER_BOX.remove();
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
        Properties  prop = new Properties();
        InputStream input;
        input = new FileInputStream( WEBDRIVER_PROPERTIES_PATH );
        prop.load( input );
        return prop.getProperty( config );
    }
    
    private void setProperty() {
        System.setProperty
                ( getDriverProperties( "chromeDriverName" ),
                  getDriverProperties( "chromeDriverPath" ) );
    }
}


