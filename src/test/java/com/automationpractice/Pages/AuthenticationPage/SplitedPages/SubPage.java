package com.automationpractice.Pages.AuthenticationPage.SplitedPages;

import Models.Page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubPage extends Page {

    SubPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='footer_links clearfix']//li[1]//a[1]")
    private WebElement buttonBactToYourAccount;

    @FindBy(xpath = "//ul[@class='footer_links clearfix']//li[2]//a[1]")
    private WebElement buttonHome;

    @FindBy(linkText = "Home")
    private WebElement buttonMainHome;

    public void clickBackToYourAccount() {
        this.buttonBactToYourAccount.click();
    }

    public void clickHome() {
        if (this.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) {
            this.buttonMainHome.click();
        }else this.buttonHome.click();
    }
}
