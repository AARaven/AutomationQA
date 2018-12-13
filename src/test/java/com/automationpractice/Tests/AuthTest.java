package com.automationpractice.Tests;

import Models.User.User;
import com.automationpractice.Data.Data;
import com.automationpractice.Pages.AuthenticationPage.AuthenticationPage;
import com.automationpractice.Pages.AuthenticationPage.MyAddress;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class AuthTest extends TestBase {

//    @Test(dataProvider = "ValidUsers", dataProviderClass = Data.class)
//    public void createAnAccount(User user) {
//        AuthenticationPage auth = new AuthenticationPage(this.driver);
//        auth.openPage();
//        auth.createAccount(user);
//    }


    @Test(dataProvider = "ValidUsers", dataProviderClass = Data.class)
    public void verifyPersonalInfo(User user) {
        AuthenticationPage auth = new AuthenticationPage(this.driver);
        auth.openPage();
        auth.authorizeUser(user);
        auth.clickMyPersonalInfo();

        Assert.assertTrue(auth.personalInfo.isUserGender(user),
                "gender is not correct");
        Assert.assertTrue(auth.personalInfo.isUserFirstName(user),
                "User first name is not correct");
        Assert.assertTrue(auth.personalInfo.isUserLastName(user),
                "User last name is not correct");
        Assert.assertTrue(auth.personalInfo.isUserEmail(user),
                "User email is not correct");
        Assert.assertTrue(auth.personalInfo.isUserDayOfBirth(user),
                "User day of birth is not correct");
        Assert.assertTrue(auth.personalInfo.isUserMonthOfBirth(user),
                "User month of birth is not correct");
        Assert.assertTrue(auth.personalInfo.isUserYearOfBirth(user),
                "User year of birth is not correct");

        if (auth.personalInfo.isNewsLetter(user)) {
            Assert.assertTrue(auth.personalInfo.isNewsLetter(user),
                    "checkbox is not selected!");
        } else if (!auth.personalInfo.isNewsLetter(user)) {
            Assert.assertFalse(auth.personalInfo.isNewsLetter(user),
                    "checkbox is selected!");
        }

        if (auth.personalInfo.isSpecialOffers(user)) {
            Assert.assertTrue(auth.personalInfo.isSpecialOffers(user),
                    "checkbox is not selected!");
        } else if (!auth.personalInfo.isSpecialOffers(user)) {
            Assert.assertFalse(auth.personalInfo.isSpecialOffers(user),
                    "checkbox is selected!");
        }
    }

    @Test(dataProvider = "ValidUsers", dataProviderClass = Data.class)
    public void verifyUserAddress(User user) {
        AuthenticationPage auth = new AuthenticationPage(this.driver);
        auth.openPage();
        auth.authorizeUser(user);
        auth.clickMyAddress();
        auth.address.clickUpdate();

        Assert.assertTrue(auth.address.isUserFirstName(user),
                "User first name is not correct");
        Assert.assertTrue(auth.address.isUserLastName(user),
                "User first name is not correct");
        Assert.assertTrue(auth.address.isUserCompany(user),
                "User first name is not correct");
        Assert.assertTrue(auth.address.isUserAddress(user),
                "User first name is not correct");
        Assert.assertTrue(auth.address.isUserAddressSecondLine(user),
                "User first name is not correct");
        Assert.assertTrue(auth.address.isUserCity(user),
                "User first name is not correct");
        Assert.assertTrue(auth.address.isUserState(user),
                "User first name is not correct");
        Assert.assertTrue(auth.address.isUserZip(user),
                "User first name is not correct");
        Assert.assertTrue(auth.address.isUserCountry(user),
                "User first name is not correct");
        Assert.assertTrue(auth.address.isUserHomePhone(user),
                "User first name is not correct");
        Assert.assertTrue(auth.address.isUserMobilePhone(user),
                "User first name is not correct");
        Assert.assertTrue(auth.address.isUserAdditionalInfo(user),
                "User first name is not correct");
        Assert.assertTrue(auth.address.isUserAlias(user),
                "User first name is not correct");
    }
}
