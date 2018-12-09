package Models.User;

import lombok.Data;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Data
public class User {

    private String gender;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
    private String company;
    private String address;
    private String addressSecondLine;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String additionalInfo;
    private String homePhone;
    private String mobilePhone;
    private String additionalEmail;

    //CONSTRUCTOR:
    public User(String name) {
        this.gender = parseUserData(name, "gender");
        this.firstName = parseUserData(name, "firstName");
        this.lastName = parseUserData(name, "lastName");
        this.email = parseUserData(name, "email");
        this.password = parseUserData(name, "password");
        this.dayOfBirth = parseUserData(name, "dayOfBirth");
        this.monthOfBirth = parseUserData(name, "monthOfBirth");
        this.yearOfBirth = parseUserData(name, "yearOfBirth");
        this.company = parseUserData(name, "company");
        this.address = parseUserData(name, "address");
        this.addressSecondLine = parseUserData(name, "addressSecondLine");
        this.city = parseUserData(name, "city");
        this.state = parseUserData(name, "state");
        this.zipCode = parseUserData(name, "zipCode");
        this.country = parseUserData(name, "country");
        this.additionalInfo = parseUserData(name, "additionalInfo");
        this.homePhone = parseUserData(name, "homePhone");
        this.mobilePhone = parseUserData(name, "mobilePhone");
        this.additionalEmail = parseUserData(name, "additionalEmail");
        saveUserProfile(this);
    }

    private String parseUserData(String user, String key) {
        File file = new File("./src/main/resources/UsersProfiles/UsersProfiles.json");
        ObjectMapper mapper = new ObjectMapper();
        HashMap temp = null;
        HashMap result = null;
        try {
            temp = mapper.readValue(file, HashMap.class);
            result = (HashMap) temp.get(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result != null ? result.get(key).toString() : null;
    }

    private void saveUserProfile(User user) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("./src/main/resources/UsersProfiles/SavedProfiles/lastProfile.json"), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}