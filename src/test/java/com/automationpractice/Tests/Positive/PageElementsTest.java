package com.automationpractice.Tests.Positive;

import com.automationpractice.Pages.AuthorizationPage.AuthenticationPage;
import com.automationpractice.Pages.AuthorizationPage.IncludedPages.CreateAccountPage;
import com.automationpractice.Tests.TestBase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class PageElementsTest extends TestBase {

    @Test
    public void verifyingElementsOnPageIsEnabled() {
        AuthenticationPage authentication = new AuthenticationPage(driver);
        authentication.navigate();

        CreateAccountPage create =
                authentication
                        .setEmail("asasdfdf@asdf.ru")
                        .clickSubmitCreate();

        create
                .verifyingInputElementsOnPageIsEnabled()
                .assertAll();

        create
                .verifyingSelectElementsOnPageIsEnabled()
                .assertAll();

        create
                .verifyingTextAreaElementsOnPageIsEnabled()
                .assertAll();
    }
}
