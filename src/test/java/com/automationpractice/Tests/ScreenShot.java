package com.automationpractice.Tests;

import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Files;

public class ScreenShot implements ITestListener {
    
    @Override
    public void onTestStart( ITestResult iTestResult ) {
    
    }
    
    @Override
    public void onTestSuccess( ITestResult iTestResult ) {
    
    }
    
    @Override
    @SneakyThrows
    public void onTestFailure( ITestResult iTestResult ) {
        Object    currentClass = iTestResult.getInstance();
        WebDriver driver       = ( ( BaseTest ) currentClass ).getDriver();
        
        if ( driver != null ) {
            File f = ( ( TakesScreenshot ) driver ).getScreenshotAs( OutputType.FILE );
            FileUtils.copyFile( f, new File( "./src/test/testFailure.jpeg" ) );
            byte[] fileContent = Files.readAllBytes( f.toPath() );
            saveScreenshotJPG( fileContent );
            
        }
    }
    
    @Attachment( value = "WebPage screenshot", type = "image/jpg" )
    private byte[] saveScreenshotJPG( byte[] screenShot ) {
        return screenShot;
    }
    
    @Override
    public void onTestSkipped( ITestResult iTestResult ) {
    
    }
    
    @Override
    public void onTestFailedButWithinSuccessPercentage( ITestResult iTestResult ) {
    
    }
    
    @Override
    public void onStart( ITestContext iTestContext ) {
    
    }
    
    @Override
    public void onFinish( ITestContext iTestContext ) {
    
    }
}
