package Models.User;

import lombok.Data;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

@Data
public class User {

    private static final String  USER_SAVING_PATH = "./src/main/resources/UsersProfiles/SavedProfiles/lastProfile.json";

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

    public User() {
        saveUserProfile(this);
    }

//    public User(String name) {
//        this.gender = parseUserData(name, "gender");
//        this.firstName = parseUserData(name, "firstName");
//        this.lastName = parseUserData(name, "lastName");
//        this.email = parseUserData(name, "email");
//        this.password = parseUserData(name, "password");
//        this.dayOfBirth = parseUserData(name, "dayOfBirth");
//        this.monthOfBirth = parseUserData(name, "monthOfBirth");
//        this.yearOfBirth = parseUserData(name, "yearOfBirth");
//        this.company = parseUserData(name, "company");
//        this.address = parseUserData(name, "address");
//        this.addressSecondLine = parseUserData(name, "addressSecondLine");
//        this.city = parseUserData(name, "city");
//        this.state = parseUserData(name, "state");
//        this.zipCode = parseUserData(name, "zipCode");
//        this.country = parseUserData(name, "country");
//        this.additionalInfo = parseUserData(name, "additionalInfo");
//        this.homePhone = parseUserData(name, "homePhone");
//        this.mobilePhone = parseUserData(name, "mobilePhone");
//        this.additionalEmail = parseUserData(name, "additionalEmail");
//        saveUserProfile(this);
//    }

    private void saveUserProfile(User user) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(USER_SAVING_PATH), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}