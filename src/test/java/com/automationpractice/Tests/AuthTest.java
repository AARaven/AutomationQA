package com.automationpractice.Tests;

import Models.User.User;
import com.automationpractice.Data.Data;
import com.automationpractice.Pages.*;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class AuthTest extends TestBase {

//    @Test(dataProvider = "ValidUsers", dataProviderClass = Data.class)
//    public void createAnAccountAndVerifyCreation(User user) {
//        AuthorizationPage auth = new AuthorizationPage(this.driver);
//        AccountCreationPage create = new AccountCreationPage(this.driver);
//        auth.openPage();
//        auth.fillCreationEmail(user);
//        create.setAllFields(user);
//        create.pushSubmitAnAccount();
//        Assert.assertTrue(auth.isLoginEqualSpanText(user), "Wrong account data.");
//        auth.clickSignOutBtn();
//    }


//    @Test(dataProvider = "ValidUsers", dataProviderClass = Data.class)
//    public void verifyAnAccountWhichWasCreated(User user) {
//        AuthorizationPage auth = new AuthorizationPage(this.driver);
//        auth.openPage();
//        auth.authorizeAccount(user);
//        Assert.assertTrue(auth.isLoginEqualSpanText(user), "Wrong account data.");
//        auth.clickSignOutBtn();
//    }

    @Test(dataProvider = "ValidUsers", dataProviderClass = Data.class)
    public void verifyingPersonalInfo(User user) {
        AccountPage ac = new AccountPage(this.driver);
        AuthorizationPage auth = new AuthorizationPage(this.driver);
        YourPersonalInfoPage per = new YourPersonalInfoPage(this.driver);
        auth.openPage();
        auth.authorizeAccount(user);

        Assert.assertTrue(ac.verifyTextInfoAccount
                ("Welcome to your account. Here you can manage all of your personal information and orders."));

        ac.clickMyPersonalInfo();

        //Verifying personal information:
        Assert.assertTrue(per.isUserGender(user),
                "gender is not correct");
        Assert.assertTrue(per.isUserFirstName(user),
                "user first name is not correct");
        Assert.assertTrue(per.isUserLastName(user),
                "user last name is not correct");
        Assert.assertTrue(per.isUserEmail(user),
                "user email is not correct");
        Assert.assertTrue(per.isUserDayOfBirth(user),
                "user day of birth is not correct");
        Assert.assertTrue(per.isUserMonthOfBirth(user),
                "user month of birth is not correct");
        Assert.assertTrue(per.isUserYearOfBirth(user),
                "user year of birth is not correct");

        if (user.isNewsLetter()) {
            Assert.assertTrue(per.isNewsLetter(user),
                    "checkbox is not selected!");
        } else if (!user.isNewsLetter()) {
            Assert.assertFalse(per.isNewsLetter(user),
                    "checkbox is selected!");
        }
        if (user.isSpecialOffers()) {
            Assert.assertTrue(per.isSpecialOffers(user),
                    "checkbox is not selected!");
        } else if (!user.isSpecialOffers()) {
            Assert.assertFalse(per.isSpecialOffers(user),
                    "checkbox is selected!");
        }
        per.clickSignOutBtn();
    }


    @Test(dataProvider = "ValidUsers", dataProviderClass = Data.class)
    public void verifyingUserAddress(User user) {
        AccountPage ac = new AccountPage(this.driver);
        AuthorizationPage auth = new AuthorizationPage(this.driver);
        YourPersonalInfoPage per = new YourPersonalInfoPage(this.driver);
        AddressPage add = new AddressPage(this.driver);
        auth.openPage();
        auth.authorizeAccount(user);
        ac.clickMyAddresses();
        add.clickUpdate();

        Assert.assertTrue(add.isUserFirstName(user),
                "User first name is not correct");
        Assert.assertTrue(add.isUserLastName(user),
                "User last name is not correct");
        Assert.assertTrue(add.isUserCompany(user),
                "User country is not correct");
        Assert.assertTrue(add.isUserAddress(user),
                "User address is not correct");
        Assert.assertTrue(add.isUserAddressSecondLine(user),
                "User address second line is not correct");
        Assert.assertTrue(add.isUserCity(user),
                "User city is not correct");
        Assert.assertTrue(add.isUserState(user),
                "User state is not correct");
        Assert.assertTrue(add.isUserZip(user),
                "User zipcode is not correct");
        Assert.assertTrue(add.isUserCountry(user),
                "User country is not correct");
        Assert.assertTrue(add.isUserHomePhone(user),
                "User home phone is not correct");
        Assert.assertTrue(add.isUserMobilePhone(user),
                "User mobile phone is not correct");
        Assert.assertTrue(add.isUserAdditionalInfo(user),
                "User additional info is not correct");
        Assert.assertTrue(add.isUserAlias(user),
                "User alias is not correct");
        add.clickSubmitAddress();

        add.clickSignOutBtn();
    }

}
