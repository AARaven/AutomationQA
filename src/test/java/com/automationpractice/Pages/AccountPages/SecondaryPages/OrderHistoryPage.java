package com.automationpractice.Pages.AccountPages.SecondaryPages;

import com.automationpractice.Pages.AccountPages.AccountPage;
import com.automationpractice.Pages.HomePages.HomePage;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHistoryPage extends HomePage {
    
    
    @FindBy( xpath = "//span[contains(text(),'Home')]" )
    private WebElement buttonHome;
    
    @FindBy( xpath = "//ul[@class='footer_links clearfix']//li[1]//a[1]//span[1]" )
    private WebElement buttonBack;
    
    @FindBy( className = "link-button" )
    private WebElement linkPdf;
    
    private WebElement getButtonHome() {
        return this.buttonHome;
    }
    
    private WebElement getButtonBack() {
        return this.buttonBack;
    }
    
    public HomePage clickHome() {
        this.getButtonHome().click();
        return new HomePage( getDriver() );
    }
    
    public AccountPage clickBack() {
        this.getButtonBack().click();
        return new AccountPage( getDriver() );
    }
    
    public OrderHistoryPage( WebDriver driver ) {
        super( driver );
    }
    
//    public OrderHistoryPage downloadOrderAsPdf() {
//
//        this.driver.findElements( By.tagName( "a" ) ).stream()
//                   .filter( element -> element.getAttribute( "target" )
//                                              .contains( "_blank" ) )
//                   .findFirst().ifPresent( WebElement::click );
//
//        return this;
//    }
//
//    public boolean isDownloaded() {
//        return takeListFileFromDownloadFolderWithPdfSuffix().isEmpty();
//    }
//
//    @SneakyThrows
//    private List < String > takeListFileFromDownloadFolderWithPdfSuffix() {
//
//        File path = new File( "D:\\Загрузки" );
//
//        return Arrays.stream( path.list() )
//                     .filter( s -> s.endsWith( ".pdf" ) )
//                     .collect( Collectors.toList() );
//    }
//
//    public String getDownloadFileName() {
//
//        File path = new File( "D:\\Загрузки" );
//        String filename = Arrays.stream( path.list() )
//                                .filter( s -> s.endsWith( ".pdf" ) )
//                                .findFirst().get();
//        return filename;
//    }
}