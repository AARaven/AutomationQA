package SeleniumTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

public class Page {

    private String siteURL;
    private WebElement webElement;
    private Select select;

    Page() {
        this.siteURL = "http://automationpractice.com";
    }

    public String getSiteURL() {
        return siteURL;
    }

    @DataProvider
    public Object[][] siteURL() {
        return new Object[][]
                {{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};
    }

    @FindBy(id = "id_gender1")
    private WebElement genderSexMale;

    @FindBy(id = "id_gender2")
    private WebElement genderSexFemale;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "newsletter")
    private WebElement newsLetter;

    @FindBy(id = "optin")
    private WebElement optin;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "address2")
    private WebElement address2;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "other")
    private WebElement other;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "phone_mobile")
    private WebElement phone_mobile;

    @FindBy(id = "submitAccount")
    private WebElement submit_account;

    @FindBy(id = "logout")
    private WebElement logOut;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin;


}
