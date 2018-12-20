package com.automationpractice.Pages.AccountPage.IncludedPages;

import com.automationpractice.Pages.AccountPage.AccountPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Log4j2
public class OrderHistoryPage extends AccountPage {

    @FindBy(how = How.CLASS_NAME, using = "link-button")
    private WebElement pdfFile;

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl(getClass().getSimpleName()));
        log.debug("Creating an instance OrderHistoryPage");
    }

    public OrderHistoryPage clickOnPdfFile() {
        this.pdfFile.click();
        return this;
    }
}
