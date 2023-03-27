package com.qa.SwagLab.testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.SwagLab.utilities.WaitTimeUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // for logger

public class BaseClass {

public WebDriver driver;
public Logger logger;
public ResourceBundle rb;
public Properties p;
	
	@BeforeClass(groups= {"Master","Sanity","Regression","datadriven"})
	
	public void setup() throws IOException
	{
		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
		//log4j code
		logger=LogManager.getLogger(this.getClass());
		String browserName = p.getProperty("browser");
		
		if(browserName.equals("chrome")){
			ChromeOptions ops= new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(ops); 
		}
		else if(browserName.equals("FF")){
			FirefoxOptions fr= new FirefoxOptions();
			fr.addArguments("--remote-allow-origins=*");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(fr); 
		}
		else if(browserName.equals("Edge")){
			EdgeOptions e= new EdgeOptions();
			e.addArguments("--remote-allow-origins=*");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(e); 
		}
		else if(browserName.equals("safari")){
			driver=new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitTimeUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitTimeUtil.IMPLICIT_WAIT));
		
		//driver.get(rb.getString("appURL"));   // local app URL
		driver.get(p.getProperty("appURL"));   // local app URL  // getting URL from properties file
		
		
		//driver.get("https://demo.opencart.com/index.php");   // remote App URL
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression","datadriven"})
	public void tearDown()
	{
		driver.quit();
	}


	
	
	
}