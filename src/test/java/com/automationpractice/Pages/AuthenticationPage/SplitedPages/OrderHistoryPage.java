package com.automationpractice.Pages.AuthenticationPage.SplitedPages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class OrderHistoryPage extends NavigationForMyAccountPages {

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("OrderHistoryPage"));
        log.debug("creating an object OrderHistoryPage");
    }
}
