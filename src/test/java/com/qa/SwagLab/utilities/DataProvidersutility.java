package com.qa.SwagLab.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvidersutility {

	//DataProvider 1
	
	@DataProvider(name="testData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\login.xlsx";
		
		XLUtility xlutil=new XLUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  
		{		
			for(int j=0;j<totalcols;j++)  
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  
			}
		}
	return logindata;
				
	}
	
	
}
