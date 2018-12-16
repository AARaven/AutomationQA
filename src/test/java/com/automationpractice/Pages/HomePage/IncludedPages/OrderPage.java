package com.automationpractice.Pages.HomePage.IncludedPages;

import com.automationpractice.Pages.HomePage.HomePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class OrderPage extends HomePage {

    public OrderPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl(getClass().getSimpleName()));
        log.debug("Creating an instance OrderPage");
    }
}
