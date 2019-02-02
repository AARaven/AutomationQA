package Models.User;

import lombok.Data;

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
	private Month monthOfBirth;
	private String yearOfBirth;
	private Address address;
	private String additionalInfo;
	private String homePhone;
	private String mobilePhone;
	private String alias;
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
		JANUARY( "January" ), FEBRUARY( "February" ), MARCH( "March" ),
		APRIL( "April" ), MAY( "May" ), JUNE( "June" ),
		JULY( "July" ), AUGUST( "August" ), SEPTEMBER( "September" ),
		OCTOBER( "October" ), NOVEMBER( "November" ), DECEMBER( "December" ),
		;
		
		
		private String name;
		private int number;
		
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


//	@SneakyThrows
//	private void saveUserProfile( User user ) {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValue( new File( USER_SAVING_PATH ), user );
//	}
}