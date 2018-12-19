package Models.Page;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@Log4j2
public class Page implements PageNavigation {

    private static final String PROPERTIES_PAGES_PATH =
            "./src/main/resources/PropertyFiles/pages.properties";

    private String url;
    protected WebDriver driver;

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
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 5), this);
        log.debug("Calling superclass constructor HomePage");
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
        InputStream input = new FileInputStream(PROPERTIES_PAGES_PATH);
        prop.load(input);
        return prop.getProperty(key);
    }
}
