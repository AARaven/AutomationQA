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
	
	public User() {
		this.gender = Gender.MALE;
		this.firstName = "asdfasdf";
		this.lastName = "asdfasdf";
		this.email = "asdfasfasdf@adfasdf.asdf";
		this.password = "asdfasdfwef2342fad";
		this.dayOfBirth = "5";
		this.monthOfBirth = "12";
		this.yearOfBirth = "1999";
		this.company = "asdfasf";
		this.address = "asdfasdf,66666,asdfaasdf";
		this.addressSecondLine = "20";
		this.city = "Minsk";
		this.state = "Alaska";
		this.zipCode = "00000";
		this.country = "United States";
		this.additionalInfo = "asdfasdf";
		this.homePhone = "5555555";
		this.mobilePhone = "55555555";
		this.alias = "James Bond";
		this.newsLetter = true;
		this.specialOffers = true;
		saveUserProfile( this );
	}
	
	@SneakyThrows
	private void saveUserProfile( User user ) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue( new File( USER_SAVING_PATH ), user );
	}
}