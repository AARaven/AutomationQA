package SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    protected void startWebDriver(String browser) {
        setDriver(browser);
    }

    @AfterClass
    protected void quitWebDriver() {
        this.driver.quit();
    }

    private void setDriver(String browser) {

        if ("chrome".equals(browser)) {
            setProperty("chrome");
            this.driver = new ChromeDriver();
            this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            this.driver.manage().window().maximize();

        } else if ("firefox".equals(browser)) {
            setProperty("firefox");
            FirefoxOptions options = new FirefoxOptions();
            this.driver = new FirefoxDriver(options);
            this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            this.driver.manage().window().maximize();

        } else if ("opera".equals(browser)) {
            setProperty("opera");
            this.driver = new OperaDriver();
            this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            this.driver.manage().window().maximize();
        }
    }

    private void setProperty(String driver) {
        if (driver.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        } else if (driver.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
        } else if (driver.equals("opera")) {
            System.setProperty("webdriver.opera.driver", "./src/main/resources/operadriver.exe");
        }
    }
}
