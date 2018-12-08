package SeleniumTest.com.automationpractice.Models;

import lombok.Data;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Data
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

    private String parseUserData(String user) {
        File file = new File("./src/main/resources/UserProfiles/UserProfile.json");
        ObjectMapper mapper = new ObjectMapper();
        HashMap map = null;
        try {
            map = mapper.readValue(file, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map != null ? map.get(user).toString() : null;
    }
}