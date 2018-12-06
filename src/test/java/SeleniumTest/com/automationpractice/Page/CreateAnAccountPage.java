package SeleniumTest.com.automationpractice.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountPage extends Page {

    //Button submit account:
    @FindBy(id = "submitAccount")
    private WebElement submitAccountBtn;

    //RadioBtn sex male:
    @FindBy(id = "id_gender1")
    private WebElement genderSexMale;

    //RadioBtn sex female:
    @FindBy(id = "id_gender2")
    private WebElement genderSexFemale;

    //CheckBox submit newsletter:
    @FindBy(id = "newsletter")
    private WebElement newsLetter;

    //CheckBox special offer from partners:
    @FindBy(id = "optin")
    private WebElement optin;

    //Selection dropDown day of birth:
    @FindBy(id = "days")
    private Select days;

    //Selection dropDown month of birth:
    @FindBy(id = "months")
    private Select month;

    //Selection dropDown year of birth:
    @FindBy(id = "years")
    private Select years;

    //Selection dropDown country (1 option):
    @FindBy(id = "id_country")
    private Select country;

    //Text area customer firstname:
    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    //Text area customer lastname:
    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    //Text area password:
    @FindBy(id = "passwd")
    private WebElement passWord;

    //Text area firstname:
    @FindBy(id = "firstname")
    private WebElement firstName;

    //Text area lastname:
    @FindBy(id = "lastname")
    private WebElement lastName;

    //Text area company:
    @FindBy(id = "company")
    private WebElement company;

    //Text area address1:
    @FindBy(id = "address1")
    private WebElement adress1;

    //Text area address2:
    @FindBy(id = "address2")
    private WebElement address2;

    //Text area city:
    @FindBy(id = "city")
    private WebElement city;

    //Selection dropDown state:
    @FindBy(id = "id_state")
    private Select state;

    //Text area postcode (5 digits):
    @FindBy(id = "postcode")
    private WebElement postCode;

    //Text area additional information:
    @FindBy(id = "other")
    private WebElement other;

    //Text area phone number:
    @FindBy(id = "phone")
    private WebElement phone;

    //Text area phone mobile phone number:
    @FindBy(id = "phone_mobile")
    private WebElement phoneMobile;

    public CreateAnAccountPage() {
        this.pageURL = "http://automationpractice.com/index.php?" +
                "controller=authentication&back=my-account#account-creation";
        this.pageTitle = "Login - My Store";
    }

}
