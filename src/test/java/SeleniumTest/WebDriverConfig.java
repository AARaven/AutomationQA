package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriverConfig {

    private WebDriver driver;
    private String startPage;
    private String registrationTitle;

    @BeforeClass
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.startPage = "http://automationpractice.com";
        this.registrationTitle = "My account - My Store";

    }

    @AfterClass
    public void quitDriver() {
        driver.close();
        driver.quit();
        startPage = "";
        System.gc();
    }

    @Test
    public void pushRegistrationData() {

        //get START PAGE:
        this.driver.get(this.startPage);

        //find and press Btn SignIn
        this.driver.findElement(By.className("login"))
                .click();

        //get REGISTRATION PAGE:

        //send email:
        this.driver.findElement(By.id("email_create"))
                .sendKeys("tro2@lolo.lo");

        // press submit Btn:
        this.driver.findElement(By.name("SubmitCreate"))
                .click();

        //push YOUR PERSONAL INFORMATION:

        // find and press RadioBtn Sex:
        this.driver.findElement(By.id("id_gender1")).click();

        //find and send first name:
        this.driver.findElement(By.id("customer_firstname")).sendKeys("Tro");

        // find and send second name:
        this.driver.findElement(By.id("customer_lastname")).sendKeys("Lolo");

        // find and press password:
        this.driver.findElement(By.id("passwd")).sendKeys("TroLoLoLIIe4kaLoLo");

        // find and choice day of birth:
        Select days = new Select(this.driver.findElement(By.id("days")));
        days.selectByIndex(20);

        // find and choice month of birth:
        Select months = new Select(this.driver.findElement(By.id("months")));
        months.selectByIndex(5);

        // find and choice year of birth:
        Select years = new Select(this.driver.findElement(By.id("years")));
        years.selectByValue("2018");

        // press checkbox submit newsletter:
        this.driver.findElement(By.id("newsletter"))
                .click();

        // press checkbox special offer from partners:
        this.driver.findElement(By.id("optin"))
                .click();

        //push YOUR ADDRESS:

        //find and send first name:
        this.driver.findElement(By.id("firstname")).sendKeys("Tro");

        //find and send last name:
        this.driver.findElement(By.id("lastname")).sendKeys("Lolo");

        //find and send company:
        this.driver.findElement(By.id("company")).sendKeys("ColhoznikRoom");

        //find and send address:
        this.driver.findElement(By.id("address1")).sendKeys("st.Bobruyskaya,400021,ColhoznikRoom co.");

        //find and send address:
        this.driver.findElement(By.id("address2")).sendKeys("10");

        //find and send city:
        this.driver.findElement(By.id("city")).sendKeys("Minsk");

        //find and choice state:

        Select state = new Select(this.driver.findElement(By.id("id_state")));
        state.selectByValue("2");

        //find and send ZIP Postal Code:
        this.driver.findElement(By.id("postcode")).sendKeys("12345");

        //find and choice Country:
        Select country = new Select(this.driver.findElement(By.id("id_country")));
        country.selectByVisibleText("United States");

        //find and push additional information:
        this.driver.findElement(By.id("other")).sendKeys("asdfghkljj");
        //find and send phone number:
        this.driver.findElement(By.id("phone")).sendKeys("89 27 92");
        //find and push mobile phone number:
        this.driver.findElement(By.id("phone_mobile")).sendKeys("89279279279");
        //find and click submitBtn:
        this.driver.findElement(By.id("submitAccount")).click();
        System.out.println(this.driver.getTitle());
        System.out.println(this.driver.getCurrentUrl());
        Assert.assertEquals(this.driver.getTitle(),this.registrationTitle);
    }
}
