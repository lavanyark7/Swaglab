package com.qa.SwagLab.testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.SwagLab.pageObjects.BasePage;
import com.qa.SwagLab.pageObjects.LoginPage;
import com.qa.SwagLab.pageObjects.ProductListingPage;
import com.qa.SwagLab.testBase.BaseClass;
import com.qa.SwagLab.utilities.GenericUtility;

public class TC_002_ProductListingPageTestcases extends BaseClass {
	
	
	GenericUtility genutil=new GenericUtility();
	@Test(groups= {"Sanity","Master"}) 
	@Parameters({"zipcode"})
	public void Addtocart(String zipcode) throws InterruptedException
	{
		logger.info("***** String TC_001_LoginTest ****");
		//LoginPage-->email & password then click
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.ClickLogin();
		ProductListingPage pl=new ProductListingPage(driver);
		pl.Clickitem();
		pl.ClickAddtocart();
		pl.Clickshoppingcart();
		pl.Clickcheckout();
		pl.setFirstname(genutil.randomeString());
		pl.setFirstLastname("lname");
		pl.setZipcode(zipcode);
		}
			

}
