package SeleniumTest.com.automationpractice.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

class Page {

    protected String pageURL;
    protected String pageTitle;

    //Button contact us:
    @FindBy(id = "contact_link")
    protected WebElement contactUsBtn;

    //Button sign in:
    @FindBy(className = "login")
    protected WebElement signInBtn;

    protected WebDriver driver;



    @BeforeSuite
    public WebDriver startDriver() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
       return this.driver;
    }

    @AfterSuite
    protected void quitWebDriver() {
        this.driver.quit();
    }



//    private void setProperty(String driver) {
//        if (driver.equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
//        } else if (driver.equals("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
//        } else if (driver.equals("opera")) {
//            System.setProperty("webdriver.opera.driver", "./src/main/resources/operadriver.exe");
//        }
//    }

    Page() {
        PageFactory.initElements(startDriver(),this);
    }
}
