package SeleniumTest.com.automationpractice.Page;

import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

class Page implements PageNavigation {

    private String url;
    private String title;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public void pressContactUsBtn() {
        this.contactUsBtn.click();
    }

    public void pressSignInBtn() {
        this.signInBtn.click();
    }

    public void pressSignOutBtn() {
        this.signOutBtn.click();
    }

    public void open() {
        this.driver.get(this.getUrl());
    }

    public void openUrl(String url) {
        this.driver.get(url);
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

    public <T extends Page> T getInstance(Class<T> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }

    //CONSTRUCTOR:
    protected Page(WebDriver driver) {
        this.driver = driver;
        this.title = this.driver.getTitle();
        PageFactory.initElements(driver, this);
    }

    protected String getUrl() {
        return this.url;
    }

    protected String getTitle() {
        return this.driver.getTitle();
    }

    protected void setUrl(String url) {
        this.url = url;
    }

    protected void setTitle(String title) {
        this.title = this.driver.getTitle();
    }

    protected String parseJsonUrl(String key) {
        File file = new File("./src/main/resources/PropertyFiles/url.json");
        ObjectMapper mapper = new ObjectMapper();
        HashMap map = null;
        try {
            map = mapper.readValue(file, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map.get(key).toString();
    }

    protected String getPropertyUrl(String key) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("./src/main/resources/PropertyFiles/url.properties");
            prop.load(input);
            return prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    //Button contact us:
    @FindBy(id = "contact-link")
    private WebElement contactUsBtn;

    //Button sign in:
    @FindBy(className = "login")
    private WebElement signInBtn;

    //Button sign out:
    @FindBy(className = "logout")
    private WebElement signOutBtn;
}
