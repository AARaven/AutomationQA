package SeleniumTest.com.automationpractice.Page;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class StartPage extends Page {

    public StartPage(WebDriver driver) throws IOException {
        super(driver);
        this.setUrl(parseJsonData("BaseUrl"));
    }
}
