package com.automationpractice.Pages.AccountPage.IncludedPages;

import com.automationpractice.Pages.AccountPage.AccountPage;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHistoryPage extends AccountPage {
    
    
    @Getter @FindBy( className = "link-button" )
    private WebElement linkPdf;
    
    public OrderHistoryPage( WebDriver driver ) {
        super( driver );
    }
    
    public OrderHistoryPage downloadOrderAsPdf() {
        
        this.driver.findElements( By.tagName( "a" ) ).stream()
                   .filter( element -> element.getAttribute( "target" )
                                              .contains( "_blank" ) )
                   .findFirst().ifPresent( WebElement::click );
        
        return this;
    }
    
    public boolean isDownloaded() {
        return takeListFileFromDownloadFolderWithPdfSuffix().isEmpty();
    }
    
    @SneakyThrows
    private List < String > takeListFileFromDownloadFolderWithPdfSuffix() {
        
        File path = new File( "D:\\Загрузки" );
        
        return Arrays.stream( path.list() )
                     .filter( s -> s.endsWith( ".pdf" ) )
                     .collect( Collectors.toList() );
    }
    
    public String getDownloadFileName() {
        
        File path = new File( "D:\\Загрузки" );
        String filename = Arrays.stream( path.list() )
                                .filter( s -> s.endsWith( ".pdf" ) )
                                .findFirst().get();
        return filename;
    }
}