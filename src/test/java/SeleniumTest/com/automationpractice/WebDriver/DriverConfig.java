//package SeleniumTest.com.automationpractice.WebDriver;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.opera.OperaDriver;
//import org.openqa.selenium.opera.OperaDriverService;
//import org.openqa.selenium.opera.OperaOptions;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//
//public class DriverConfig {
//
//    private WebDriver driver;
//
//
//    @Parameters("browser")
//    @BeforeSuite
//    public void getDriver() {
//        setDriver("browser");
//    }
//
//    @AfterSuite
//    protected void quitWebDriver() {
//        this.driver.quit();
//    }
//
//
//
//    public void setDriver(String browser) {
//
//        if ("chrome".equals(browser)) {
//            setProperty("chrome");
//            this.driver = new ChromeDriver();
//            this.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//            this.driver.manage().window().maximize();
//
//        } else if ("firefox".equals(browser)) {
//            setProperty("firefox");
//            FirefoxOptions options = new FirefoxOptions();
//            this.driver = new FirefoxDriver(options);
//            this.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//            this.driver.manage().window().maximize();
//
//        } else if ("opera".equals(browser)) {
//            setProperty("opera");
//            OperaOptions options = new OperaOptions();
//            OperaDriverService service = OperaDriverService.createDefaultService();
//            options.setBinary("C:\\Program Files (x86)\\Opera\\launcher.exe");
//            this.driver = new OperaDriver(service, options);
//            this.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//            this.driver.manage().window().maximize();
//        }
//    }
//
//    private void setProperty(String driver) {
//        if (driver.equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
//        } else if (driver.equals("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
//        } else if (driver.equals("opera")) {
//            System.setProperty("webdriver.opera.driver", "./src/main/resources/operadriver.exe");
//        }
//    }
//
//
//    @Test
//    public void getUrl() {
//        this.driver.get("http://automationpractice.com");
//    }
//}
