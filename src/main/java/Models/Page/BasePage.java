package Models.Page;

import lombok.SneakyThrows;
import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class BasePage implements PageNavigation {
	
	private static final String PROPERTIES_PAGES_PATH =
			"./src/main/resources/PropertyFiles/pages.properties";
	
	private String url;
	
	protected WebDriver driver;
	
	@Override
	public void navigate() {
		driver.get( this.url );
	}
	
	@Override
	public void next() {
		this.driver.navigate().forward();
	}
	
	@Override
	public void back() {
		this.driver.navigate().back();
	}
	
	@Override
	public void refresh() {
		this.driver.navigate().refresh();
	}
	
	protected String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}
	
	protected BasePage( WebDriver driver ) {
		this.url = getPropertyUrl( getClass().getSimpleName() );
		this.driver = driver;
		PageFactory.initElements( new AjaxElementLocatorFactory
				( driver, 5 ), this );
	}
	
	protected String getTitle() {
		return this.driver.getTitle();
	}
	
	protected void setUrl( String url ) {
		this.url = url;
	}
	
	protected void moveToElement( WebElement element ) {
		new Actions( driver )
				.moveToElement( element )
				.build()
				.perform();
	}
	
	@SneakyThrows
	private String getPropertyUrl( String key ) {
		Properties prop = new Properties();
		InputStream input = new FileInputStream( PROPERTIES_PAGES_PATH );
		prop.load( input );
		return prop.getProperty( key );
	}
	
	@SneakyThrows
	protected String[] getJsonData( String value, String path ) {
		File file = new File( path );
		ObjectMapper mapper = new ObjectMapper();
		String[] strings;
		HashMap map;
		map = mapper.readValue( file, HashMap.class );
		strings = mapper.convertValue( map.get( value ), String[].class );
		return strings;
	}
}
