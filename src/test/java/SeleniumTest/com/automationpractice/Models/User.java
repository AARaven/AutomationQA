package SeleniumTest.com.automationpractice.Models;

public class User {

    private String Sex;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
    private String company;
    private String address;
    private String addressSecLine;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String additionalInfo;
    private String homePhone;
    private String mobilePhone;

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressSecLine() {
        return addressSecLine;
    }

    public void setAddressSecLine(String addressSecLine) {
        this.addressSecLine = addressSecLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public User() {
        this.Sex = "male";
        this.firstName = "John";
        this.lastName = "Smith";
        this.email = "JohN@SmIth.jo";
        this.password = "SeCrEtWoRd123";
        this.dayOfBirth = "5";
        this.monthOfBirth = "7";
        this.yearOfBirth = "1993";
        this.company = "Coca-Cola co.";
        this.address = "st. Omen street";
        this.addressSecLine = "666";
        this.city = "Des Moines";
        this.state = "Iowa";
        this.zip = "666666";
        this.country = "United States";
        this.additionalInfo = "bla bla bla";
        this.homePhone = "666666";
        this.mobilePhone = "88006666666";
    }
}