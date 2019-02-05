package Models.User;

import Models.User.Enums.Genders;
import Models.User.Enums.Months;
import lombok.Data;

@Data
public class User {
    
    private static final String USER_SAVING_PATH =
            "./src/main/resources/UsersProfiles/SavedProfiles/lastProfile.json";
    
    private Genders gender;
    private String  firstName;
    private String  lastName;
    private String  email;
    private String  password;
    private String  day;
    private Months  months;
    private String  year;
    private Address address;
    private String  additionalInfo;
    private String  homePhone;
    private String  mobilePhone;
    private String  alias;
    
    private boolean newsLetter;
    private boolean specialOffers;
}