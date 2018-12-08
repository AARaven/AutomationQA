package SeleniumTest.com.automationpractice.Page;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class MainPage extends Page {

    public MainPage(WebDriver driver) throws IOException {
        super(driver);
        this.setUrl(parseJsonData("./src/main/resources/PropertyFiles/baseUrl.json","BaseUrl"));
        this.setTitle("My Store");
    }
}
