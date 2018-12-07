package SeleniumTest.com.automationpractice.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class Page implements PageNavigation {

    private String url;
    private String title;
    private WebDriver driver;

    public String getUrl() {
        return this.url;
    }

    public String getTitle() {
        return this.title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void pressContactUsBtn() {
        this.contactUsBtn.click();
    }

    public void pressSignInBtn() {
        this.signInBtn.click();
    }

    public void open() {
        this.driver.navigate().to(this.getUrl());
    }

    public void openUrl(String url) {
        this.driver.navigate().to(url);
    }

    public void openPage(Page page) {
        this.driver.get(page.getUrl());
    }

    public void next() {
        this.driver.navigate().forward();
    }

    public void back() {
        this.driver.navigate().back();
    }

    public void refresh() {
        this.driver.navigate().refresh();
    }

    Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Button contact us:
    @FindBy(id = "contact-link")
    private WebElement contactUsBtn;

    //Button sign in:
    @FindBy(className = "login")
    private WebElement signInBtn;

    public <T extends Page> T getInstance(Class<T> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }
}
