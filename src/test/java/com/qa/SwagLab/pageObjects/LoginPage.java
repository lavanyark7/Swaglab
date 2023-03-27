package com.qa.SwagLab.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	 WebElement password;
	
	@FindBy(id="login-button")
	WebElement Login;
	
	@FindBy(xpath="//div[@class='app_logo']")
	WebElement Logo;
	
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement Errormessage;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement menu;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement Logout;
	
	


	public void setUsername(String uname) {
		 username.sendKeys(uname);
		 }

	  public void setPassword(String pwd) {
		  password.sendKeys(pwd);

		}
	  public void ClickLogin() {
		  Login.click();
		}
	  public boolean IsDisplayedLogo() {
		  return Logo.isDisplayed();
		}
	  
	  public boolean IsDisplayedErrormessage() {
		  return Errormessage.isDisplayed();
		}
	  
	  public void ClickMenu() {
		  menu.click();
		}
	  
	  public void ClickLogout() {
		  Logout.click();
		}

	

}
