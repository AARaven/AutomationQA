package com.automationpractice.Tests;

import Models.User.User;
import com.automationpractice.Data.Data;
import com.automationpractice.Pages.AuthenticationPage.AuthenticationPage;
import com.automationpractice.Pages.StartPage.StartPage;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Log4j2
public class AuthTest extends TestBase {
    Data data = new Data();

    //    @Parameters("Path")
    @DataProvider(name = "Users")
    public Object[][] getUser() {
        return data.getData();
    }

    @Test/*(dataProvider = "ValidUsers", dataProviderClass = Data.class)*/
            (dataProvider = "Users")
    public void createAnAccount(User user) {
        StartPage st = new StartPage(driver);
        AuthenticationPage auth = new AuthenticationPage(this.driver);
        auth.openPage();
        auth.createAccount(user);
        st.clickSignOutBtn();
    }

    @Test/*(dataProvider = "ValidUsers", dataProviderClass = Data.class)*/
            (dataProvider = "Users")
    public void verifyPersonalInfo(User user) {
        AuthenticationPage auth = new AuthenticationPage(driver);
        auth.openPage();
        auth.authorizeUser(user);
        auth.clickMyPersonalInfo();

        softAssert.assertTrue(auth.personalInfo.isUserGender(user),
                "gender is not correct");
        softAssert.assertTrue(auth.personalInfo.isUserFirstName(user),
                "User first name is not correct");
        softAssert.assertTrue(auth.personalInfo.isUserLastName(user),
                "User last name is not correct");
        softAssert.assertTrue(auth.personalInfo.isUserEmail(user),
                "User email is not correct");
        softAssert.assertTrue(auth.personalInfo.isUserDayOfBirth(user),
                "User day of birth is not correct");
        softAssert.assertTrue(auth.personalInfo.isUserMonthOfBirth(user),
                "User month of birth is not correct");
        softAssert.assertTrue(auth.personalInfo.isUserYearOfBirth(user),
                "User year of birth is not correct");

        if (auth.personalInfo.isNewsLetter(user)) {
            softAssert.assertTrue(auth.personalInfo.isNewsLetter(user),
                    "checkbox is not selected!");
        } else if (!auth.personalInfo.isNewsLetter(user)) {
            softAssert.assertFalse(auth.personalInfo.isNewsLetter(user),
                    "checkbox is selected!");
        }

        if (auth.personalInfo.isSpecialOffers(user)) {
            softAssert.assertTrue(auth.personalInfo.isSpecialOffers(user),
                    "checkbox is not selected!");
        } else if (!auth.personalInfo.isSpecialOffers(user)) {
            softAssert.assertFalse(auth.personalInfo.isSpecialOffers(user),
                    "checkbox is selected!");
        }
        softAssert.assertAll();
    }

    @Test/*(dataProvider = "ValidUsers", dataProviderClass = Data.class)*/
            (dataProvider = "Users")
    public void verifyUserAddress(User user) {
        AuthenticationPage auth = new AuthenticationPage(driver);
        auth.openPage();
        auth.authorizeUser(user);
        auth.clickMyAddress();
        auth.address.clickUpdate();

        softAssert.assertTrue(auth.address.isUserFirstName(user),
                "User first name is not correct");
        softAssert.assertTrue(auth.address.isUserLastName(user),
                "User last name is not correct");
        softAssert.assertTrue(auth.address.isUserCompany(user),
                "User company is not correct");
        softAssert.assertTrue(auth.address.isUserAddress(user),
                "User address is not correct");
        softAssert.assertTrue(auth.address.isUserAddressSecondLine(user),
                "User address second line is not correct");
        softAssert.assertTrue(auth.address.isUserCity(user),
                "User city is not correct");
        softAssert.assertTrue(auth.address.isUserState(user),
                "User state is not correct");
        softAssert.assertTrue(auth.address.isUserZip(user),
                "User zip code is not correct");
        softAssert.assertTrue(auth.address.isUserCountry(user),
                "User country is not correct");
        softAssert.assertTrue(auth.address.isUserHomePhone(user),
                "User home phone is not correct");
        softAssert.assertTrue(auth.address.isUserMobilePhone(user),
                "User mobile phone is not correct");
        softAssert.assertTrue(auth.address.isUserAdditionalInfo(user),
                "User additional info is not correct");
        softAssert.assertTrue(auth.address.isUserAlias(user),
                "User alias is not correct");
        softAssert.assertAll();
    }

    @Test(dataProvider = "ValidUsers", dataProviderClass = Data.class)
    public void SimpleCodeOfNavigation(User user) {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.clickSignInBtn();
        startPage.authentication.authorizeUser(user);
        startPage.authentication.clickMyAddress();
        startPage.authentication.address.clickUpdate();
        softAssert.assertTrue(startPage.authentication.address.isUserAddress(user));
        System.out.println(startPage.getTitle());
        startPage.authentication.address.clickBackToYourAddresses();
        startPage.authentication.address.clickBackToYourAccount();
        startPage.authentication.clickMyWishList();
        startPage.authentication.address.clickBackToYourAccount();
        startPage.clickSignOutBtn();
        softAssert.assertAll();

    }
}
