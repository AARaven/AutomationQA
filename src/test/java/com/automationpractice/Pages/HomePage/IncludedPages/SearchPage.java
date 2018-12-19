package com.automationpractice.Pages.HomePage.IncludedPages;

import com.automationpractice.Pages.HomePage.HomePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class SearchPage extends HomePage {


    public SearchPage(WebDriver driver) {
        super(driver);
        setUrl(getPropertyUrl(getClass().getSimpleName()));
    }

    @FindBy(how = How.CLASS_NAME, using = "product_img_link")
    private WebElement linkProduct;

    @FindBy(how = How.CLASS_NAME, using = "exclusive")
    private WebElement buttonAddToCart;

    @FindBy(how = How.CLASS_NAME, using = "pb-right-column col-xs-12 col-sm-4 col-md-3")
    private WebElement containerTShirt;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[3]/div[1]/p[1]/button[1]/span[1]")
    private WebElement getButtonAddToCart;

    public SearchPage clickOnProduct() {
        this.linkProduct.click();
        return this;
    }

    public SearchPage clickAddToCart() {
        WebElement element = new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[3]/div[1]/p[1]/button[1]/span[1]")));
        element.click();
        return this;
    }
}

