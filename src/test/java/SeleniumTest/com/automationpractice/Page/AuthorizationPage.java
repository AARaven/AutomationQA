package SeleniumTest.com.automationpractice.Page;

import SeleniumTest.com.automationpractice.Models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AuthorizationPage extends Page {

    // CONSTRUCTOR:
    public AuthorizationPage(WebDriver driver) {
        super(driver);
        this.setUrl(parseJsonUrl("Authorization"));
//        this.setUrl(getPropertyUrl("AuthorizationUrl"));
    }

    // Method which send an email and click
    // on Create_An_Account button:
    public void createAnAccount(User user) {
        this.emailCreateField.sendKeys(user.getEmail());
        this.createAnAccountBtn.click();
        fillAllFields(user);
        this.submitAccountBtn.click();
        pressSignOutBtn();
    }

    // Method which open a resent account:
    public void openUserAccount(User user) {
        this.emailTextField.sendKeys(user.getEmail());
        this.passwordTextField.sendKeys(user.getPassword());
        this.submitLoginAccountBtn.click();
    }

    public void verifyUserAccount(User user) {
        openUserAccount(user);
        Assert.assertEquals("My account - My Store", getTitle(), "The titles is not equals!");
        pressSignOutBtn();
    }

    // CREATE ACCOUNT AREA:

    // Text area enter email for registration:
    @FindBy(id = "email_create")
    private WebElement emailCreateField;

    // Create an account Button:
    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountBtn;

    // LOGIN AREA:

    // Text area email:
    @FindBy(id = "email")
    private WebElement emailTextField;

    // Text area password:
    @FindBy(id = "passwd")
    private WebElement passwordTextField;

    //  SignIn Button:
    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginAccountBtn;

    // forgot your password link:
    @FindBy(className = "lost_password from_group")
    private WebElement forgotYourPasswordLink;

    // REGISTER AREA:

    // BUTTONS:

    // Button submit account:
    @FindBy(id = "submitAccount")
    private WebElement submitAccountBtn;

    // RADIO BUTTONS:

    // RadioBtn sex male:
    @FindBy(id = "id_gender1")
    private WebElement genderSexMaleRadio;

    // RadioBtn sex female:
    @FindBy(id = "id_gender2")
    private WebElement genderSexFemaleRadio;

    // CHECKBOXES:

    // CheckBox submit newsletter:
    @FindBy(id = "newsletter")
    private WebElement newsLetterCheckBox;

    // CheckBox special offer from partners:
    @FindBy(id = "optin")
    private WebElement specialOffersCheckBox;

    // SELECTIONS:

    // DROPDOWN SELECTION DATE OF BIRTH:
    // Selection dropDown day of birth:
    @FindBy(id = "days")
    private WebElement daysSelect;

    // Selection dropDown month of birth:
    @FindBy(id = "months")
    private WebElement monthsSelect;

    // Selection dropDown year of birth:
    @FindBy(id = "years")
    private WebElement yearsSelect;

    // Selection dropDown country (1 option):
    @FindBy(id = "id_country")
    private WebElement countrySelect;

    // Selection dropDown state:
    @FindBy(id = "id_state")
    private WebElement stateSelect;

    // TEXT AREAS:

    // Text area customer firstname:
    @FindBy(id = "customer_firstname")
    private WebElement customerFirstNameTextField;

    // Text area customer lastname:
    @FindBy(id = "customer_lastname")
    private WebElement customerLastNameTextField;

    // Text area password:
    //Duplicate a passwordField on login page

    // Text area firstname:
    @FindBy(id = "firstname")
    private WebElement firstNameTextField;

    // Text area lastname:
    @FindBy(id = "lastname")
    private WebElement lastNameTextField;

    // Text area company:
    @FindBy(id = "company")
    private WebElement companyTextField;

    // Text area address1:
    @FindBy(id = "address1")
    private WebElement adress1TextField;

    // Text area address2:
    @FindBy(id = "address2")
    private WebElement address2TextField;

    // Text area city:
    @FindBy(id = "city")
    private WebElement cityTextField;

    // Text area postcode (5 digits):
    @FindBy(id = "postcode")
    private WebElement postCodeTextField;

    // Text area additional information:
    @FindBy(id = "other")
    private WebElement otherTextField;

    // Text area phone number:
    @FindBy(id = "phone")
    private WebElement phoneTextField;

    // Text area phone mobile phone number:
    @FindBy(id = "phone_mobile")
    private WebElement phoneMobileTextField;

    //Text area additional email:
    @FindBy(id = "alias")
    private WebElement additionalEmail;

    // Section Your Personal Information:

    private void choiceGender(String sex) {
        if (sex.equals("male")) {
            this.genderSexMaleRadio.click();
        } else if (sex.equals("female")) {
            this.genderSexFemaleRadio.click();
        }
    }

    private void fillCustomerFirstName(String firstname) {
        this.customerFirstNameTextField.sendKeys(firstname);
    }

    private void fillCustomerLastName(String lastname) {
        this.customerLastNameTextField.sendKeys(lastname);
    }

    private void fillPassword(String password) {
        this.passwordTextField.sendKeys(password);
    }

    private void selectDateOfBirth(String day, String month, String year) {
        new Select(this.daysSelect).selectByValue(day);
        new Select(this.monthsSelect).selectByValue(month);
        new Select(this.yearsSelect).selectByValue(year);
    }

    private void choiceNewsLetter() {
        this.newsLetterCheckBox.click();
    }

    private void choiceSpecialOffers() {
        this.specialOffersCheckBox.click();
    }

    // Section Your Address:

    private void fillFirstName(String firstname) {
        this.firstNameTextField.sendKeys(firstname);
    }

    private void fillLastName(String lastname) {
        this.lastNameTextField.sendKeys(lastname);
    }

    private void fillCompany(String company) {
        this.companyTextField.sendKeys(company);
    }

    private void fillFirstAddressField(String address) {
        this.adress1TextField.sendKeys(address);
    }

    private void fillSecondAddressField(String address) {
        this.address2TextField.sendKeys(address);
    }

    private void fillCity(String city) {
        this.cityTextField.sendKeys(city);
    }

    private void selectState(String state) {
        new Select(this.stateSelect).selectByVisibleText(state);
    }

    private void fillZipCode(String zipcode) {
        this.postCodeTextField.sendKeys(zipcode);
    }

    private void selectCountry(String country) {
        new Select(this.countrySelect).selectByVisibleText(country);
    }

    private void fillAdditionalInfo(String additionalInfo) {
        this.otherTextField.sendKeys(additionalInfo);
    }

    private void fillHomePhone(String homePhone) {
        this.phoneTextField.sendKeys(homePhone);
    }

    private void fillMobilePhone(String mobilePhone) {
        this.phoneMobileTextField.sendKeys(mobilePhone);
    }

    private void fillAdditionalEmail(String additionalEmail) {
        this.additionalEmail.sendKeys(additionalEmail);
    }

    private void fillAllFields(User user) {
        choiceGender(user.getSex());
        fillCustomerFirstName(user.getFirstName());
        fillCustomerLastName(user.getLastName());
        fillPassword(user.getPassword());
        selectDateOfBirth(user.getDayOfBirth(), user.getMonthOfBirth(), user.getYearOfBirth());
        choiceNewsLetter();
        choiceSpecialOffers();
        fillFirstName(user.getFirstName());
        fillLastName(user.getLastName());
        fillCompany(user.getCompany());
        fillFirstAddressField(user.getAddress());
        fillSecondAddressField(user.getAddressSecLine());
        fillCity(user.getCity());
        selectState(user.getState());
        fillZipCode(user.getZip());
        selectCountry(user.getCountry());
        fillAdditionalInfo(user.getAdditionalInfo());
        fillHomePhone(user.getHomePhone());
        fillMobilePhone(user.getMobilePhone());
        fillAdditionalEmail(user.getAdditionalEmail());
    }
}
