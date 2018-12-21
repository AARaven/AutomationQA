package com.automationpractice.Pages.AccountPage.IncludedPages;

import com.automationpractice.Pages.AccountPage.AccountPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@Log4j2
public class OrderHistoryPage extends AccountPage {

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl(getClass().getSimpleName()));
        log.debug("Creating an instance OrderHistoryPage");
    }

    public OrderHistoryPage clickOnPdfFile() {

        WebElement elementPdf = this.driver.findElements(By.tagName("a")).stream()
                .filter(element -> element.getAttribute("target").contains("_blank"))
                .findFirst()
                .get();

        elementPdf.click();
        return this;
    }
}
