package com.qa.SwagLab.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.SwagLab.testBase.BaseClass;


public class WaitTimeUtil extends BaseClass {
	
	
	
	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 30;
	
	
	
	public void Explicitwait(WebDriver driver) {

		this.driver=driver;
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(50));
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='app_logo']"))));
		
	}

	
	
	
	
	

}
