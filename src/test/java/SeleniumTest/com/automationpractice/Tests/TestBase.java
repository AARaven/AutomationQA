package SeleniumTest.com.automationpractice.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

class TestBase {

    protected SoftAssert softAssert;
    protected Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver;

    @BeforeSuite
    protected void beforeSuiteMethod() {

        LOGGER.info("Setting webdriver properties...");
        setProperty("chrome");
        LOGGER.info("Starting webdriver...");
        startDriver("chrome");
        LOGGER.info("Webdriver started.");
    }

    @AfterSuite
    protected void afterSuiteMethod() {
        LOGGER.info("Webdriver stopped.");
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

            case ("opera"):
                setProperty("opera");
                OperaOptions options = new OperaOptions();
                options.setBinary("C:\\Program Files (x86)\\Opera\\launcher.exe");
                this.driver = new OperaDriver(OperaDriverService.createDefaultService(), options);
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
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
                break;
            case ("firefox"):
                System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
                break;
            case ("opera"):
                System.setProperty("webdriver.opera.driver", "./src/main/resources/operadriver.exe");
                break;
        }
    }
}
