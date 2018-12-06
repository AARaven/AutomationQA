package SeleniumTest.com.automationpractice.Page;

import org.openqa.selenium.WebDriver;

public class MainPage extends Page {

    public void pressSignIn() {
        this.signInBtn.click();
    }

    public void perssContactUs() {
        this.contactUsBtn.click();
    }

    public String getUrl() {
        return this.pageURL;
    }

    public String  getTitle() {
        return this.pageTitle;
    }

    public MainPage() {
        this.pageTitle = "My Store";
        this.pageURL = "http://automationpractice.com";
    }

    public void goToUrl() {
        this.driver.get(this.getUrl());
    }
}
