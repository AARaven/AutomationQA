package com.automationpractice.Pages.HomePage.IncludedPages;

import com.automationpractice.Pages.HomePage.HomePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Log4j2
public class SearchPage extends HomePage {


    public SearchPage(WebDriver driver) {
        super(driver);
        setUrl(getPropertyUrl(getClass().getSimpleName()));
    }

    @FindBy(how = How.CLASS_NAME, using = "product_img_link")
    private WebElement linkProduct;

    @FindBy(how = How.XPATH, using = "//button[@name='Submit']")
    private WebElement buttonAddToCart;

    public SearchPage clickOnProduct() {
        this.linkProduct.click();
        return this;
    }

    public SearchPage clickAddToCart() {
        this.buttonAddToCart.click();
        return this;
    }
}

