package Models.Page;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Page implements PageNavigation {

    private static final String PROPERTIES_PATH = "./src/main/resources/PropertyFiles/url.properties";

    private String url;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public void navigate() {
        this.driver.get(this.url);
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

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    protected Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 5), this);
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    protected void setUrl(String url) {
        this.url = url;
    }

    @SneakyThrows
    protected String getPropertyUrl(String key) {
        Properties prop = new Properties();
        InputStream input = null;
        input = new FileInputStream(PROPERTIES_PATH);
        prop.load(input);
        return prop.getProperty(key);
    }
}
