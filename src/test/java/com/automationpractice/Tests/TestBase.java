package com.automationpractice.Tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

@Log4j2
class TestBase {

    protected SoftAssert softAssert = new SoftAssert();
    WebDriver driver;

    @BeforeSuite
    protected void beforeSuiteMethod() {
        log.debug("Before suite method:");
        log.debug("Starting webdriver...");
        startDriver("chrome");
        log.debug("Webdriver started.");
    }

    @AfterSuite
    protected void afterSuiteMethod() {
        log.debug("After suite method:");
        log.debug("Stopping webdriver...");
        this.driver.quit();
        log.debug("Webdriver stopped.");
    }

    @BeforeClass
    protected void beforeClassMethod() {
        log.debug("beforeClassMethod:");
    }

    @AfterClass
    protected void afterClassMethod() {
        log.debug("afterClassMethod:");
    }

    @BeforeGroups
    protected void beforeGroupsMethod() {
        log.debug("beforeGroupsMethod:");
    }

    @AfterGroups
    protected void afterGroupsMethod() {
        log.debug("afterGroupsMethod:");
    }

    @BeforeTest
    protected void beforeTestMethod() {
        log.debug("beforeTestMethod:");
    }

    @AfterTest
    protected void afterTestMethod() {
        log.debug("afterTestMethod:");
    }

    @BeforeMethod
    protected void beforeMethod() {
        log.debug("beforeMethod:");
    }

    @AfterMethod
    protected void afterMethod() {
        log.debug("afterMethod:");
    }

    private WebDriver startDriver(String driver) {
        switch (driver) {
            case ("chrome"):
                setProperty("chrome");
                this.driver = new ChromeDriver();
                new WebDriverWait(this.driver, 10);
                this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                this.driver.manage().window().maximize();
                return this.driver;

            case ("firefox"):
                setProperty("firefox");
                this.driver = new FirefoxDriver();
                new WebDriverWait(this.driver, 3);
                this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                this.driver.manage().window().maximize();
                return this.driver;
        }
        throw new NullPointerException("Browser is not available!");
    }

    private void setProperty(String driver) {
        switch (driver) {
            case ("chrome"):
                log.debug("Set driver property : webdriver.chrome.driver," +
                        " ./src/main/resources/WebDrivers/chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/WebDrivers/chromedriver.exe");
                break;
            case ("firefox"):
                log.debug("Set driver property : webdriver.gecko.driver," +
                        " ./src/main/resources/WebDrivers/geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", "./src/main/resources/WebDrivers/geckodriver.exe");
                break;
        }
    }
}
