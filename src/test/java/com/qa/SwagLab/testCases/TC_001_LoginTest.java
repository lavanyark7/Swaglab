package com.qa.SwagLab.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.SwagLab.pageObjects.HomePage;
import com.qa.SwagLab.pageObjects.LoginPage;
import com.qa.SwagLab.pageObjects.ProductListingPage;
import com.qa.SwagLab.testBase.BaseClass;
import com.qa.SwagLab.utilities.DataProvidersutility;
import com.qa.SwagLab.utilities.GenericUtility;

public class TC_001_LoginTest extends BaseClass{
	
	GenericUtility genutil=new GenericUtility();

	@Test(groups= {"Sanity","Master"}) 
	public void getValidCredentials()
	{
		logger.info("***** String TC_001_LoginTest ****");
		//LoginPage-->email & password then click
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		//lp.setPassword(p.getProperty("xyz"));
		lp.ClickLogin();
		
		//Check MyAccount label is present
		ProductListingPage page=new ProductListingPage(driver);
		boolean targetpage=page.ProductListingpageExist();
		
		Assert.assertEquals(targetpage,true);
		lp.ClickMenu();
		lp.ClickLogout();
		}
			
	@Test(groups= {"Sanity","Master"})
	public void getInvalidCredentials()
	{
		logger.info("***** String TC_001_LoginTest ****");
	
		
		
		//LoginPage-->email & password then click
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(p.getProperty("email"));
		lp.setPassword(genutil.randomeString());
		lp.ClickLogin();
		
		Assert.assertTrue(lp.IsDisplayedErrormessage());
		}
	
	@Test(dataProvider="testData", dataProviderClass=DataProvidersutility.class,groups= {"datadriven"})
	public void getSetofUsers(String email, String pwd)
	{
		logger.info("***** String TC_001_LoginDataDrivenTest ****");
		//LoginPage-->email & password then click
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(email);
		lp.setPassword(pwd);
		lp.ClickLogin();
		
		
		ProductListingPage page=new ProductListingPage(driver);
		boolean targetpage=page.ProductListingpageExist();
		
		Assert.assertEquals(targetpage,true);
		lp.ClickMenu();
		lp.ClickLogout();

				
		logger.info("**** Finished TC_001_LoginDataDrivenTest  ***** ");
	}
	
			
}
