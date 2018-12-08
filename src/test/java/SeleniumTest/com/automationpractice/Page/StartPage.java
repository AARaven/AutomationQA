package SeleniumTest.com.automationpractice.Page;

import org.openqa.selenium.WebDriver;

public class StartPage extends Page {

    //CONSTRUCTOR:
    public StartPage(WebDriver driver){
        super(driver);
        this.setUrl(getPropertyUrl("BaseUrl"));
//        this.setUrl(parseJsonUrl("BaseUrl"));
    }
}
