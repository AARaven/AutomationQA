package Models.Page;

import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class Page implements PageNavigation {

    private String url;
    private WebDriver driver;
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

    protected Page(WebDriver driver) {
        this.driver = driver;
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

    protected String getJsonUrl(String key) {
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
}
