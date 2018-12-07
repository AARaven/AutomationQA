package SeleniumTest.com.automationpractice.Tests;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

class TestBase {

    protected Logger logger;
    protected SoftAssert softAssert;


    @BeforeSuite
    protected void beforeSuiteMethod() {

    }

    @AfterSuite
    protected void afterSuiteMethod() {

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
}
