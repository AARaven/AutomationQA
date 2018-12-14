package com.automationpractice.Pages.AuthenticationPage.SplitedPages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class MyCreditSlipsPage extends NavigationForMyAccountPages {

    public MyCreditSlipsPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("MyCreditSlipsPage"));
        log.debug("creating an object MyCreditSlipsPage");
    }
}
