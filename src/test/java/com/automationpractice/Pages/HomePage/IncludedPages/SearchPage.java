package com.automationpractice.Pages.HomePage.IncludedPages;

import com.automationpractice.Pages.HomePage.HomePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.asserts.SoftAssert;

@Log4j2
public class SearchPage extends HomePage {


    public SearchPage(WebDriver driver) {
        super(driver);
        setUrl(getPropertyUrl(getClass().getSimpleName()));
    }

    @FindBy(how = How.NAME, using = "processAddress")
    private WebElement buttonSubmitAddressToOrder;

    @FindBy(how = How.ID, using = "cgv")
    private WebElement checkboxAgree;

    @FindBy(how = How.NAME, using = "processCarrier")
    private WebElement buttonProcessCarier;

    @FindBy(how = How.CLASS_NAME, using = "bankwire")
    private WebElement buttonBankWire;

    @FindBy(how = How.CLASS_NAME, using = "cheque-indent")
    private WebElement textOrderIsComplete;

    public SearchPage chooseTShirt(String title) {
        this.driver.findElements(By.className("product-name")).stream()
                .filter(element -> element.getAttribute("title").contains(title))
                .findFirst()
                .get()
                .click();
        return this;
    }

    public SearchPage clickAddToCart() {
        this.driver.findElements(By.tagName("button")).stream()
                .filter(element -> element.getAttribute("name").contains("Submit"))
                .findFirst()
                .get()
                .click();
        return this;
    }

    public SearchPage clickSubmitSummary() {
        this.driver.findElements(By.tagName("a")).stream()
                .filter(element -> element.getAttribute("title")
                        .contains("Proceed to checkout"))
                .findFirst()
                .get()
                .click();
        return this;
    }

    public SearchPage clickSubmitSignIn() {
        this.driver.findElements(By.tagName("a")).stream()
                .filter(element -> element.getAttribute("class")
                        .contains("button btn btn-default standard-checkout button-medium"))
                .findFirst()
                .get()
                .click();
        return this;
    }

    public SearchPage clickSubmitAddress() {
        this.buttonSubmitAddressToOrder.click();
        return this;
    }

    public SearchPage clickCheckBoxAgree() {
        this.checkboxAgree.click();
        return this;
    }

    public SearchPage clickProcessCarier() {
        this.buttonProcessCarier.click();
        return this;
    }

    public SearchPage clickBankWire() {
        this.buttonBankWire.click();
        return this;
    }

    public SearchPage clickConfirmMyOrder() {
        this.driver.findElements(By.tagName("button")).stream()
                .filter(element -> element.getAttribute("type")
                        .contains("submit")).filter(element -> element.getText().contains("I confirm my order"))
                .findFirst()
                .get()
                .click();
        return this;
    }

    public SoftAssert verifyOrderIsComplete() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(this.textOrderIsComplete.getText()
                        .contains("Your order on My Store is complete."),
                "Your order is not complete.");
        return softAssert;
    }
}

