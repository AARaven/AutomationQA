package com.automationpractice.Pages.AuthenticationPage.SplitedPages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class MyWishListPage extends NavigationForMyAccountPages {

    public MyWishListPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("MyWishListPage"));
        log.debug("creating an object MyWishListPage");
    }
}
