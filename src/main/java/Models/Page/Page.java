package Models.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Page implements PageNavigation {

    private static final String PROPERTIES_PATH = "./src/main/resources/PropertyFiles/url.properties";

    private String url;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public void openPage() {
        this.driver.get(this.getUrl());
    }

    public void openUrl(String url) {
        this.driver.get(url);
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
        PageFactory.initElements(driver, this);

    }

    public String getUrl() {
        return this.url;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    protected void setUrl(String url) {
        this.url = url;
    }

    protected String getPropertyUrl(String key) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(PROPERTIES_PATH);
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
}
