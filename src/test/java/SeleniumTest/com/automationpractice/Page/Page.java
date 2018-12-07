package SeleniumTest.com.automationpractice.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

class Page implements PageNavigation {

    String url;
    String title;
    private WebDriver driver;

    //Button contact us:
    @FindBy(id = "contact-link")
    private WebElement contactUsBtn;

    //Button sign in:
    @FindBy(className = "login")
    private WebElement signInBtn;

    Page() {
        PageFactory.initElements(startDriver("chrome"), this);
    }

    public String getUrl() {
        return this.url;
    }

    public String getTitle() {
        return this.title;
    }

    public void pressContactUsBtn() {
        this.contactUsBtn.click();
    }

    public void pressSignInBtn() {
        this.signInBtn.click();
    }

    public void open() {
        this.driver.navigate().to(this.url);
    }

    public void close() {
        this.driver.quit();
    }

    public void next() {
        this.driver.navigate().forward();
    }

    public void back() {
        this.driver.navigate().back();
    }

    public void refresh() {
        this.driver.navigate().refresh();
    }

    private WebDriver startDriver(String driver) {
        switch (driver) {
            case ("chrome"):
                setProperty("chrome");
                this.driver = new ChromeDriver();
                new WebDriverWait(this.driver, 5);
                this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
        throw new NullPointerException();
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
