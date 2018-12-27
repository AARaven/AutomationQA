package com.automationpractice.Data;

import Models.User.User;
import org.testng.annotations.DataProvider;

public class UserData extends Data {
	
	@DataProvider( name = "ValidUser" )
	public Object[][] getUser() {
		return new Object[][]{
				{ getData( "Mario", User.class, USERS_VALID_PATH ) },
				{ getData( "Gene", User.class, USERS_VALID_PATH ) },
				{ getData( "Glenda", User.class, USERS_VALID_PATH ) },
				{ getData( "Hedwig", User.class, USERS_VALID_PATH ) },
		};
	}
	
	@DataProvider( name = "InvalidUser" )
	public Object[][] getInvalidUser() {
		return new Object[][]{
				{ getData( "InvalidUser", User.class, USERS_INVALID_PATH ) }
		};
	}
	
	@DataProvider( name = "Users" )
	public Object[][] getUsers() {
		return new Object[][]{
				{ getData
						( "Mario", User.class, USERS_VALID_PATH ),
						getData( "Gene", User.class, USERS_VALID_PATH ) },
		};
	}
}
