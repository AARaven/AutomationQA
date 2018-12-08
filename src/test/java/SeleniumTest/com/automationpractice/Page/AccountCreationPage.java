package SeleniumTest.com.automationpractice.Page;

import SeleniumTest.com.automationpractice.Models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AccountCreationPage extends AuthorizationPage {

    public AccountCreationPage(WebDriver driver) {
        super(driver);
        this.setUrl(parseJsonData("AccountCreation"));
    }

    public void registerAccount(User user) {
        sendCreationEmail(user.getEmail());
        pushCreateAccBtn();
        pushDataIntoFields(user);
    }

    public void verifyAccount() {
        String expectedTitle = "My account - My Store";
        Assert.assertEquals(expectedTitle,this.getTitle(),"The account has not verify!");
    }

    private void pushDataIntoFields(User user) {
        //gender:
        if (user.getSex().equals("male")) {
            choiceMale();
        } else if (user.getSex().equals("female")) choiceFemale();

        //other:
        choiceCustomerFirstName(user.getFirstName());
        choiceCustomerLastName(user.getLastName());
        choicePassword(user.getPassword());
        choiceDateOfBirth(user.getDayOfBirth(), user.getMonthOfBirth(), user.getYearOfBirth());
        choiceNewsLetter();
        choiceOptin();
        choiceFirstName(user.getFirstName());
        choiceLastName(user.getLastName());
        choiceCompany(user.getCompany());
        choiceFirstAddress(user.getAddress());
        choiceSecondAddress(user.getAddressSecLine());
        choiceCity(user.getCity());
        choiceState(user.getState());
        choicePostCode(user.getZip());
        choiceCountry(user.getCountry());
        sendAddInfo(user.getAdditionalInfo());
        choicePhone(user.getHomePhone());
        choiceMobilePhone(user.getMobilePhone());
        pushSubmitAccoutnBtn();
    }

    //Pre page methods:
    private void sendEmail(String email) {
        this.email.sendKeys(email);
    }

    private void sendCreationEmail(String email) {
        this.emailCreate.sendKeys(email);
    }

    private void pushCreateAccBtn() {
        this.submitCreateAccount.click();
    }

    private void sendPassword(String password) {
        this.password.sendKeys(password);
    }

    private void pushSignBtn() {
        this.submitLoginAccount.click();
    }

    //Creation account page methods:
    private void choiceMale() {
        this.genderSexMale.click();
    }

    private void choiceFemale() {
        this.genderSexFemale.click();
    }

    private void choiceNewsLetter() {
        this.newsLetter.click();
    }

    private void choiceOptin() {
        this.optin.click();
    }

    private void choiceDayOfBirth(String day) {
        new Select(this.days).selectByValue(day);
//        this.days.selectByValue(day);
    }

    private void choiceMonthOfBirth(String month) {
        new Select(this.months).selectByValue(month);
//        this.months.selectByValue(month);
    }

    private void choiceYearOfBirth(String year) {
        new Select(this.years).selectByValue(year);
//        this.years.selectByValue(year);
    }

    private void choiceDateOfBirth(String day, String month, String year) {
        choiceDayOfBirth(day);
        choiceMonthOfBirth(month);
        choiceYearOfBirth(year);
    }

    private void choiceCountry(String country) {
        new Select(this.country).selectByVisibleText(country);
//        this.country.selectByVisibleText(country);
    }

    private void choiceCustomerFirstName(String customerFirstname) {
        this.customerFirstName.sendKeys(customerFirstname);
    }

    private void choiceCustomerLastName(String customerLastname) {
        this.customerLastName.sendKeys(customerLastname);
    }

    private void choiceFirstName(String firstname) {
        this.firstName.sendKeys(firstname);
    }

    private void choiceLastName(String lastname) {
        this.lastName.sendKeys(lastname);
    }

    private void choicePassword(String password) {
        this.passWord.sendKeys(password);
    }

    private void choiceCompany(String company) {
        this.company.sendKeys(company);
    }

    private void choiceFirstAddress(String address1) {
        this.adress1.sendKeys(address1);
    }

    private void choiceSecondAddress(String address2) {
        this.address2.sendKeys(address2);
    }

    private void choiceCity(String city) {
        this.city.sendKeys(city);
    }

    private void choiceState(String state) {
        new Select(this.state).selectByVisibleText(state);
//        this.state.selectByVisibleText(state);
    }

    private void choicePostCode(String zip) {
        this.postCode.sendKeys(zip);
    }

    private void sendAddInfo(String additional) {
        this.other.sendKeys(additional);
    }

    private void choicePhone(String phone) {
        this.phone.sendKeys(phone);
    }

    private void choiceMobilePhone(String phoneMobile) {
        this.phoneMobile.sendKeys(phoneMobile);
    }

    private void pushSubmitAccoutnBtn() {
        this.submitAccountBtn.click();
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
    private WebElement days;

    //Selection dropDown month of birth:
    @FindBy(id = "months")
    private WebElement months;

    //Selection dropDown year of birth:
    @FindBy(id = "years")
    private WebElement years;

    //Selection dropDown country (1 option):
    @FindBy(id = "id_country")
    private WebElement country;

    //Selection dropDown state:
    @FindBy(id = "id_state")
    private WebElement state;

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
