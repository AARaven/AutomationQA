package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

public class SitePage {

    private String siteURL;
    private WebElement webElement;
    private WebDriver driver = new ChromeDriver();
    private Select select;


    @DataProvider
    public Object[][] siteURL() {
        return new Object[][]
                {{},{},{},{},{},{},{},{},{},{},{},{},{}};
    }

    @FindBy(id = "id_gender1")
    private WebElement genderSexMale;

    @FindBy(id = "id_gender2")
    private WebElement genderSexFemale;

    public void clickOnMale() {
        genderSexMale.click();
    }

}
