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
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

public class BasePage {
	
	private static final String PAGE_PATH =
			"./src/main/resources/PropertyFiles/pages.properties";
	
	protected WebDriver driver;
	protected URL url;
	
	public void navigate() {
		this.driver.navigate().to( this.url );
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
	
	protected String getTitle() {
		return this.driver.getTitle();
	}
	
	protected String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}
	
	@SneakyThrows
	protected BasePage( WebDriver driver ) {
		this.driver = driver;
		this.url = new URL( getProperty( getClass().getSimpleName() ) );
		PageFactory.initElements( new AjaxElementLocatorFactory
				( driver, 5 ), this );
	}
	
	protected void moveToElement( WebElement element ) {
		new Actions( driver )
				.moveToElement( element )
				.build()
				.perform();
	}
	
	@SneakyThrows
	private String getProperty( String key ) {
		Properties prop = new Properties();
		prop.load( new FileInputStream( PAGE_PATH ) );
		return prop.getProperty( key );
	}
	
	@SneakyThrows
	protected String[] getStringArrayFromJson( String key, String path ) {
		ObjectMapper mapper = new ObjectMapper();
		String[] strings;
		HashMap hashMap = mapper.readValue( new File( path ), HashMap.class );
		strings = mapper.convertValue( hashMap.get( key ), String[].class );
		return strings;
	}
}
