//package SeleniumTest;
//
//import net.bytebuddy.utility.RandomString;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//public class SiteDowner {
//    private WebDriver driver;
//    private String registrationTitle;
//
//    private String accountEmailGenerator() {
//        RandomString randomFirstPice = new RandomString(5);
//        RandomString randomSecondPice = new RandomString(5);
//        RandomString randomDomen = new RandomString(3);
//        return String.format("%s" + "@" + "%s" + "." + "%s",
//                randomFirstPice.nextString(),
//                randomSecondPice.nextString(),
//                randomDomen.nextString());
//    }
//
//    private String passwordGenerator() {
//        RandomString passwd = new RandomString(10);
//        return passwd.nextString();
//    }
//
//    private String stringDataGenerator() {
//        RandomString randomData = new RandomString(10);
//        return randomData.nextString().replaceAll("\\d*", "");
//    }
//
//    private String numberDataGenerator() {
//        Random randomNumberData = new Random();
//        return String.valueOf(randomNumberData.nextInt(1000000));
//    }
//
//    @BeforeClass
//    public void startDriver() {
//        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
//        this.driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(this.driver, 7);
//        this.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//        this.driver.manage().window().maximize();
//        String startPage = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
//        this.registrationTitle = "My account - My Store";
//        this.driver.get(startPage);
//    }
//
//    @AfterClass
//    public void quitDriver() {
//        driver.close();
//        driver.quit();
//        System.gc();
//    }
//
//    @Test
//    public void spamTestAccount() {
//
//        while (true) {
//
//            //get REGISTRATION PAGE:
//            //send email:
//            String tempEmail = accountEmailGenerator();
//            this.driver.findElement(By.id("email_create"))
//                    .sendKeys(tempEmail);
//
//            // press submit Btn:
//            this.driver.findElement(By.name("SubmitCreate"))
//                    .click();
//
//            //push YOUR PERSONAL INFORMATION:
//            // find and press RadioBtn Sex:
//            this.driver.findElement(By.id("id_gender1"))
//                    .click();
//
//            //find and send first name:
//            this.driver.findElement(By.id("customer_firstname"))
//                    .sendKeys(stringDataGenerator());
//
//            // find and send second name:
//            this.driver.findElement(By.id("customer_lastname"))
//                    .sendKeys(stringDataGenerator());
//
//            // find and press password:
//            String tempPassword = passwordGenerator();
//            this.driver.findElement(By.id("passwd"))
//                    .sendKeys(tempPassword);
//
//            // find and choice day of birth:
//            Select days = new Select(this.driver.findElement(By.id("days")));
//            days.selectByIndex(20);
//
//            // find and choice month of birth:
//            Select months = new Select(this.driver.findElement(By.id("months")));
//            months.selectByIndex(5);
//
//            // find and choice year of birth:
//            Select years = new Select(this.driver.findElement(By.id("years")));
//            years.selectByValue("2018");
//
//            // press checkbox submit newsletter:
//            this.driver.findElement(By.id("newsletter"))
//                    .click();
//
//            // press checkbox special offer from partners:
//            this.driver.findElement(By.id("optin"))
//                    .click();
//
//            //push YOUR ADDRESS:
//            //find and send first name:
//            this.driver.findElement(By.id("firstname"))
//                    .sendKeys(stringDataGenerator());
//
//            //find and send last name:
//            this.driver.findElement(By.id("lastname"))
//                    .sendKeys(stringDataGenerator());
//
//            //find and send company:
//            this.driver.findElement(By.id("company"))
//                    .sendKeys(stringDataGenerator());
//
//            //find and send address:
//            this.driver.findElement(By.id("address1"))
//                    .sendKeys(stringDataGenerator()
//                            + numberDataGenerator()
//                            + stringDataGenerator());
//
//            //find and send address:
//            this.driver.findElement(By.id("address2"))
//                    .sendKeys("10");
//
//            //find and send city:
//            this.driver.findElement(By.id("city"))
//                    .sendKeys(stringDataGenerator());
//
//            //find and choice state:
//
//            Select state = new Select(this.driver.findElement(By.id("id_state")));
//            state.selectByValue("2");
//
//            //find and send ZIP Postal Code:
//            this.driver.findElement(By.id("postcode"))
//                    .sendKeys("12345");
//
//            //find and choice Country:
//            Select country = new Select(this.driver.findElement(By.id("id_country")));
//            country.selectByVisibleText("United States");
//
//            //find and push additional information:
//            this.driver.findElement(By.id("other"))
//                    .sendKeys(stringDataGenerator());
//
//            //find and send phone number:
//            this.driver.findElement(By.id("phone"))
//                    .sendKeys(numberDataGenerator());
//
//            //find and push mobile phone number:
//            this.driver.findElement(By.id("phone_mobile"))
//                    .sendKeys(numberDataGenerator());
//
//            //find and click submitBtn:
//            this.driver.findElement(By.id("submitAccount"))
//                    .click();
//
//            //Equalize both title:
//            Assert.assertEquals(this.driver.getTitle(), this.registrationTitle);
//
//            //find and click SignOut:
//            this.driver.findElement(By.className("logout"))
//                    .click();
//        }
//    }
//}
