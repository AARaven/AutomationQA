package Models.WebPage;

import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public interface WebPage {
    
    String PROPERTIES_WEB_PAGES_PATH =
            "./src/main/resources/PropertyFiles/pages.properties";
    
    @SneakyThrows
    default String getWebPageProperty( String key ) {
        Properties prop = new Properties();
        prop.load( new FileInputStream( PROPERTIES_WEB_PAGES_PATH ) );
        return prop.getProperty( key );
    }
    
    void nextPage();
    
    void previousPage();
    
    void refreshPage();
    
    void openPage();
    
    void openPage( URL url );
    
    void closePage();
    
    void navigateToElement( WebElement webElement );
}
