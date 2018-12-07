package SeleniumTest.com.automationpractice.Page;

import org.openqa.selenium.WebDriver;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
        this.setUrl("http://automationpractice.com");
        this.setTitle("My Store");
    }
}
