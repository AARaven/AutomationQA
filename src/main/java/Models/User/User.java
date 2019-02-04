package Models.User;

import lombok.Data;

@Data
public class User {
    
    private static final String USER_SAVING_PATH =
            "./src/main/resources/UsersProfiles/SavedProfiles/lastProfile.json";
    
    private Gender  gender;
    private String  firstName;
    private String  lastName;
    private String  email;
    private String  password;
    private String  dayOfBirth;
    private Month   monthOfBirth;
    private String  yearOfBirth;
    private Address address;
    private String  additionalInfo;
    private String  homePhone;
    private String  mobilePhone;
    private String  alias;
    private boolean newsLetter;
    private boolean specialOffers;
    
    public enum Gender {
        MALE( "male" ),
        FEMALE( "female" );
        
        private String gender;
        
        Gender( String gender ) {
            this.gender = gender;
        }
        
        public String getGender() {
            return this.gender;
        }
    }
    
    public enum Month {
        
        DEFAULT( "-" ),
        DECEMBER( "December" ),   JUNE( "June" ),
        JANUARY( "January" ),     JULY( "July" ),
        FEBRUARY( "February" ),   AUGUST( "August" ),
        MARCH( "March" ),         SEPTEMBER( "September" ),
        APRIL( "April" ),         OCTOBER( "October" ),
        MAY( "May" ),             NOVEMBER( "November" ),;
    
        private int    number;
        private String name;
        
        public String getName() {
            return this.name;
        }
        
        public int getNumber() {
            return this.number;
        }
        
        Month( String name ) {
            this.name = name;
            this.number = ordinal();
        }
    }
}