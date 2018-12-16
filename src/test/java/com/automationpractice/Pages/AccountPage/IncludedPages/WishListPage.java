package com.automationpractice.Pages.AccountPage.IncludedPages;

import com.automationpractice.Pages.AccountPage.AccountPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WishListPage extends AccountPage {

    public WishListPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl(getClass().getSimpleName()));
        log.debug("Creating an instance WishListPage");
    }
}
