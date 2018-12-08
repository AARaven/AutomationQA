package SeleniumTest.com.automationpractice.Models;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

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

    public User() {
        this.Sex = parseUserData("sex");
        this.firstName = parseUserData("firstName");
        this.lastName = parseUserData("lastName");
        this.email = parseUserData("email");
        this.password = parseUserData("password");
        this.dayOfBirth = parseUserData("dayOfBirth");
        this.monthOfBirth = parseUserData("monthOfBirth");
        this.yearOfBirth = parseUserData("yearOfBirth");
        this.company = parseUserData("company");
        this.address = parseUserData("address");
        this.addressSecLine = parseUserData("addressSecLine");
        this.city = parseUserData("city");
        this.state = parseUserData("state");
        this.zip = parseUserData("zip");
        this.country = parseUserData("country");
        this.additionalInfo = parseUserData("additionalInfo");
        this.homePhone = parseUserData("homePhone");
        this.mobilePhone = parseUserData("mobilePhone");
    }

    public String getSex() {
        return this.Sex;
    }

    public void setSex(String sex) {
        this.Sex = sex;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDayOfBirth() {
        return this.dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getMonthOfBirth() {
        return this.monthOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public String getYearOfBirth() {
        return this.yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressSecLine() {
        return this.addressSecLine;
    }

    public void setAddressSecLine(String addressSecLine) {
        this.addressSecLine = addressSecLine;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getHomePhone() {
        return this.homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String parseUserData(String key) {
        File file = new File("./src/main/resources/UserProfiles/UserProfile.json");
        ObjectMapper mapper = new ObjectMapper();
        HashMap map = null;
        try {
            map = mapper.readValue(file, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map.get(key).toString();
    }
}