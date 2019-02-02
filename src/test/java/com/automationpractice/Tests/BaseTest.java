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

@Listeners( { ScreenShot.class } )
@Log4j2
public class BaseTest {
    
    private static final String WEBDRIVER_PROPERTIES_PATH =
            "./src/main/resources/PropertyFiles/webdriver.properties";
    
    private static ThreadLocal <WebDriver> DRIVER_BOX = new ThreadLocal <>();
    
    public WebDriver getDriver() {
        WebDriver driverThreadSafety = DRIVER_BOX.get();
        
        if ( driverThreadSafety == null ) {
            log.debug( "Thread-safety webdriver initialization." );
            setProperty( "chrome" );
            driverThreadSafety = new ChromeDriver();
            driverThreadSafety.manage()
                    .timeouts()
                    .implicitlyWait( 7, TimeUnit.SECONDS );
            driverThreadSafety.manage()
                    .window()
                    .maximize();
            DRIVER_BOX.set( driverThreadSafety );
        }
        log.debug( "Return thread-safety webdriver." );
        
        return driverThreadSafety;
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
        Properties prop = new Properties();
        InputStream input;
        input = new FileInputStream( WEBDRIVER_PROPERTIES_PATH );
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
}
