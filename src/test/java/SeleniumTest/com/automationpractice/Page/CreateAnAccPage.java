package SeleniumTest.com.automationpractice.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccPage extends AuthPage {

    public CreateAnAccPage(WebDriver driver) {
        super(driver);
        this.setUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        this.setTitle("Login - My Store");
    }

    //Pre page methods:
    public void sendCreationEmail(String email) {
        this.emailCreate.sendKeys(email);
    }

    public void sendEmail(String email) {
        this.email.sendKeys(email);
    }

    public void sendPassword(String password) {
        this.password.sendKeys(password);
    }

    public void pushCreateAccBtn() {
        this.submitCreateAccount.click();
    }

    public void pushSignBtn() {
        this.submitLoginAccount.click();
    }

    //Creation account page methods:
    public void choiceMale() {
        this.genderSexMale.click();
    }

    public void choiceFemale() {
        this.genderSexFemale.click();
    }

    public void choiceNewsLetter() {
        this.newsLetter.click();
    }

    public void choiceOptin() {
        this.optin.click();
    }

    public void choiceDayOfBirth(String day) {
        this.days.selectByIndex(Integer.parseInt(day));
    }

    public void choiceMonthOfBirth(String month) {
        this.month.selectByIndex(Integer.parseInt(month));
    }

    public void choiceYearOfBirth(String year) {
        this.years.selectByValue(year);
    }

    public void choiceCountry() {
        this.country.selectByVisibleText("United States");
    }

    public void choiceCustomerFirstName(String customerFirstname) {
        this.customerFirstName.sendKeys(customerFirstname);
    }

    public void choiceCustomerLastName(String customerLastname) {
        this.customerLastName.sendKeys(customerLastname);
    }

    public void choiceFirstName(String firstname) {
        this.firstName.sendKeys(firstname);
    }

    public void choiceLastName(String lastname) {
        this.lastName.sendKeys(lastname);
    }

    public void choicePassword(String password) {
        this.passWord.sendKeys(password);
    }

    public void choiceCompany(String company) {
        this.company.sendKeys(company);
    }

    public void choiceFirstAddress(String address1) {
        this.adress1.sendKeys(address1);
    }

    public void choiceSecondAddress(String address2) {
        this.address2.sendKeys(address2);
    }

    public void choiceCity(String city) {
        this.city.sendKeys(city);
    }

    public void choiceState(String state) {
        this.state.selectByVisibleText(state);
    }

    public void choicePostCode(String zip) {
        this.postCode.sendKeys(zip);
    }

    public void sendAddInfo(String additional) {
        this.other.sendKeys(additional);
    }

    public void choicePhone(String phone) {
        this.phone.sendKeys(phone);
    }

    public void choiceMobilePhone(String phoneMobile) {
        this.phoneMobile.sendKeys(phoneMobile);
    }

    //BUTTONS:

    //Button submit account:
    @FindBy(id = "submitAccount")
    private WebElement submitAccountBtn;

    //RADIO BUTTONS:

    //RadioBtn sex male:
    @FindBy(id = "id_gender1")
    private WebElement genderSexMale;

    //RadioBtn sex female:
    @FindBy(id = "id_gender2")
    private WebElement genderSexFemale;

    //CHECKBOXES:

    //CheckBox submit newsletter:
    @FindBy(id = "newsletter")
    private WebElement newsLetter;
    //CheckBox special offer from partners:

    @FindBy(id = "optin")
    private WebElement optin;

    //SELECTIONS:

    //DROPDOWN SELECTION DATE OF BIRTH:
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

    //Selection dropDown state:
    @FindBy(id = "id_state")
    private Select state;

    //TEXT AREAS:

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

    //PRE PAGE ELEMENTS:
    //REGISTER AREA:

    //Text area enter email for registration:
    @FindBy(id = "email_create")
    private WebElement emailCreate;

    //Create an account Button:
    @FindBy(id = "SubmitCreate")
    private WebElement submitCreateAccount;

    //LOGIN AREA:

    //Text area email:
    @FindBy(id = "email")
    private WebElement email;

    //Text area password:
    @FindBy(id = "passwd")
    private WebElement password;

    //SignIn Button:
    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginAccount;

    //forgot your password link:
    @FindBy(className = "lost_password from_group")
    private WebElement forgotYourPassword;
}
