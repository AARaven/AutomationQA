package com.automationpractice.Tests.Positive;

import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.AccountCreationPage;
import com.automationpractice.Tests.BaseTest;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageElementsTest extends BaseTest {
    
    @Test( description = "A test that implements " +
                         "the verification of elements on the creation an account page." )
    @Step( "Verifying that elements on creation an account page is enabled." )
    public void verifyingElementsIsEnabled() {
        
        AuthenticationPage  authentication = new AuthenticationPage( getDriver() );
        AccountCreationPage creation       = new AccountCreationPage( getDriver() );
        
        authentication.openPage();
        
        authentication
                .setEmail( "asd12fdVf@as2df.ru" )
                .clickSubmitCreate();
        
        creation
                .verifyInputElementsOnPageIsEnabled()
                .assertAll();
        
        creation
                .verifySelectElementsOnPageIsEnabled()
                .assertAll();
        
        creation
                .verifyTextAreaElementsOnPageIsEnabled()
                .assertAll();
    }
    
    @Test( description = "REST API / GET" )
    public void exampleGETCapitalOfRussia() {
        Response response = RestAssured.get(
                "https://restcountries.eu/rest/v1/name/United Kingdom" );
        JSONArray jsonArray = new JSONArray( response.asString() );
        String    capital   = jsonArray.getJSONObject( 0 ).getString( "capital" );
        Assert.assertEquals( capital, "London" );
        System.out.println( capital );
    }
    
    @Test( description = "REST API / GET" )
    public void exampleGETDetailsOfRussia() {
        Response response = RestAssured.get(
                "https://restcountries.eu/rest/v1/name/russia" );
        JSONArray jsonArray = new JSONArray( response.asString().split( "[,]" ) );
        jsonArray.forEach( System.out::println );
    }
}
