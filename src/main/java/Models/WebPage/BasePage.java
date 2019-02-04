package Models.WebPage;

import lombok.SneakyThrows;
import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

public abstract class BasePage implements WebPage {
    
    protected WebDriver driver;
    protected URL url;
    
    private void setDriver( WebDriver driver ) {
        this.driver = driver;
    }
    
    private void setUrl( URL url ) {
        this.url = url;
    }
    
    protected WebDriver getDriver() {
        return this.driver;
    }
    
    @SneakyThrows
    protected BasePage( WebDriver driver ) {
        this.setDriver( driver );
        this.setUrl( new URL( getWebPageProperty( getClass().getSimpleName() ) ) );
        PageFactory.initElements(
                new AjaxElementLocatorFactory( driver, 5 ), this );
    }
    
    @SneakyThrows
    protected String[] getJsonAsStringArray( String key, String path ) {
        ObjectMapper mapper  = new ObjectMapper();
        String[]     strings;
        HashMap      hashMap = mapper.readValue( new File( path ), HashMap.class );
        strings = mapper.convertValue( hashMap.get( key ), String[].class );
        return strings;
    }
    
    public URL getUrl() {
        return this.url;
    }
    
    public String getTitle() {
        return this.getDriver().getTitle();
    }
    
    @Override
    public void nextPage() {
        this.getDriver().navigate().forward();
    }
    
    @Override
    public void previousPage() {
        this.getDriver().navigate().back();
    }
    
    @Override
    public void refreshPage() {
        this.getDriver().navigate().refresh();
    }
    
    @Override
    public void openPage() {
        this.getDriver().navigate().to( this.getUrl() );
    }
    
    @Override
    public void openPage( URL url ) {
        this.getDriver().navigate().to( getUrl() );
    }
    
    @Override
    public void closePage() {
        this.getDriver().close();
    }
    
    @Override
    public void navigateToElement( WebElement element ) {
        new Actions( getDriver() )
                .moveToElement( element )
                .build()
                .perform();
    }
}
