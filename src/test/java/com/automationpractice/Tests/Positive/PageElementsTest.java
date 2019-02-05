package com.automationpractice.Tests.Positive;

import Models.User.User;
import com.automationpractice.Data.UserData;
import com.automationpractice.Pages.AuthorizationPages.AuthenticationPage;
import com.automationpractice.Pages.AuthorizationPages.SecondaryPages.CreateAccountPage;
import com.automationpractice.Pages.HomePages.HomePage;
import com.automationpractice.Tests.BaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class PageElementsTest extends BaseTest {
    
    @Test( description = "A test that implements " +
                         "the verification of elements on the creation an account page." )
    @Step( "Verifying that elements on creation an account page is enabled." )
    public void verifyingElementsIsEnabled() {
        
        AuthenticationPage authentication = new AuthenticationPage( getDriver() );
        CreateAccountPage  creation       = new CreateAccountPage( getDriver() );
        
        authentication
                .openPage();
        
        authentication
                .getCreateAccountForm()
                .sendEmail( "string@string.domain" )
                .clickSubmit();

//        creation
//                .verifyInputElementsOnPageIsEnabled()
//                .assertAll();
//
//        creation
//                .verifySelectElementsOnPageIsEnabled()
//                .assertAll();
//
//        creation
//                .verifyTextAreaElementsOnPageIsEnabled()
//                .assertAll();
    }
//
//    @Test( description = "REST API / GET" )
//    public void exampleGETCapitalOfRussia() {
//        Response response = RestAssured.get(
//                "https://restcountries.eu/rest/v1/name/United Kingdom" );
//        JSONArray jsonArray = new JSONArray( response.asString() );
//        String    capital   = jsonArray.getJSONObject( 0 ).getString( "capital" );
//        Assert.assertEquals( capital, "London" );
//        System.out.println( capital );
//    }
//
//    @Test( description = "REST API / GET" )
//    public void exampleGETDetailsOfRussia() {
//        Response response = RestAssured.get(
//                "https://restcountries.eu/rest/v1/name/russia" );
//        JSONArray jsonArray = new JSONArray( response.asString().split( "[,]" ) );
//        jsonArray.forEach( System.out::println );
//    }
//
    
    @Test( dataProvider = "Users", dataProviderClass = UserData.class )
    public void testTest( User user, User user1 ) {
        HomePage homePage = new HomePage( getDriver() );
        
        homePage
                .openPage();
        
        homePage.getAccountRow()
                .clickSignIn()
                .getLoginForm()
                .sendEmail( user.getEmail() )
                .sendPassword( user.getPassword() )
                .clickSignIn();
    }
}
