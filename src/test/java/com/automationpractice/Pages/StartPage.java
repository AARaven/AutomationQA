package com.automationpractice.Pages;

import Models.Page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends Page {

    //HEADER:____

    //BANNER:


    //BUTTONS:
    //Button contact us:
    @FindBy(id = "contact-link")
    private WebElement buttonContactUs;

    //Button sign in:
    @FindBy(className = "login")
    private WebElement buttonSignIn;

    //Button sign out:
    @FindBy(className = "logout")
    protected WebElement buttonSignOut;

    //CONTENT:____

    //search area:
    @FindBy(id = "search_query_top")
    private WebElement inputSearch;

    //search button:
    @FindBy(className = "btn btn-default button-search")
    private WebElement buttonSearch;

    //img logo:
    @FindBy(className = "logo img-responsive")
    private WebElement imgLogo;

    //span phone:
    @FindBy(className = "shop-phone")
    private WebElement textShopPhone;

    //container cart(with ajax):
    @FindBy(partialLinkText = "View my shopping cart")
    private WebElement containerCart;

    //homeSLIDER:
    @FindBy(className = "homeslider-description")
    private WebElement sliderHomeSlider;

    //righ images :
    @FindBy(className = "item-img")
    private WebElement imgRighUp;


    //FOOTER:____

    //


    //CONSTRUCTOR:
    public StartPage(WebDriver driver) {
        super(driver);
        this.setUrl(getPropertyUrl("BaseUrl"));
//        this.setUrl(getJsonUrl("BaseUrl"));
    }

    protected void clickContactUsBtn() {
        this.buttonContactUs.click();
    }

    protected void clickSignInBtn() {
        this.buttonSignIn.click();
    }

    protected void clickSignOutBtn() {
        this.buttonSignOut.click();
    }
}
