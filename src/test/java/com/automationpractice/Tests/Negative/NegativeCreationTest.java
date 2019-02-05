package com.automationpractice.Tests.Negative;

import Models.User.User;
import com.automationpractice.Data.UserData;
import com.automationpractice.Pages.AuthorizationPages.AuthenticationPage;
import com.automationpractice.Pages.AuthorizationPages.SecondaryPages.CreateAccountPage;
import com.automationpractice.Tests.BaseTest;
import org.testng.annotations.Test;

public class NegativeCreationTest extends BaseTest {

    @Test( dataProvider = "InvalidUser", dataProviderClass = UserData.class )
    public void creationWithEmptyData( User user ) {

        AuthenticationPage  authentication = new AuthenticationPage( getDriver() );
        CreateAccountPage creation       = new CreateAccountPage( getDriver() );

        authentication.openPage();

        authentication
                .getCreateAccountForm()
                .sendEmail( user.getEmail() )
                .clickSubmit();
    
        creation
                .fillPersonalInfoForm( user )
                .fillAddressForm( user )
                .clickSubmit();
//
//        creation
//                .verifyThatAlertDivShowEmptyDataErrors()
//                .assertAll();
    }

    @Test( dataProvider = "InvalidUser", dataProviderClass = UserData.class )
    public void creationWithInvalidData( User user ) {

        AuthenticationPage  authentication = new AuthenticationPage( getDriver() );
        CreateAccountPage creation       = new CreateAccountPage( getDriver() );

        authentication.openPage();

        authentication
                .getCreateAccountForm()
                .sendEmail( user.getEmail() )
                .clickSubmit();

//        creation
//                .fillUserDataInvalidValues( user )
//                .typeEmail( "!@#$!%" )
//                .clickRegister();
//        creation
//                .verifyThatAlertDivShowInvalidDataErrors()
//                .assertAll();
    }
}
