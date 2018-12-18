package Models.User;

import lombok.Data;
import lombok.SneakyThrows;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;

@Data
public class User {

    private static final String USER_SAVING_PATH =
            "./src/main/resources/UsersProfiles/SavedProfiles/lastProfile.json";

    private Gender gender;
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
    private String alias;
    private boolean newsLetter;
    private boolean specialOffers;

    public enum Gender {
        MALE("male"),
        FEMALE("female");

        private String gender;

        Gender(String gender) {
            this.gender = gender;
        }

        public String getGender() {
            return this.gender;
        }
    }

    public User() {
        saveUserProfile(this);
    }

    @SneakyThrows
    private void saveUserProfile(User user) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(USER_SAVING_PATH), user);
    }
}