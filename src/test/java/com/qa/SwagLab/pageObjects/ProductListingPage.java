package com.qa.SwagLab.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ProductListingPage extends BasePage {

	public ProductListingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[contains(text(),'Products')]")
	WebElement productListingpage;
	
	@FindBys({
	    @FindBy(xpath="//div[@class='inventory_list']//div[@class='inventory_item']"),})
		 List<WebElement>items;
	
	@FindBys({
	    @FindBy(xpath="//button[contains(text(),'Add to cart')]"),})
		 List<WebElement>Addtocart;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	 WebElement shoppingcart;
	
	@FindBy(xpath="//button[@id='checkout']")
	 WebElement checkout;

	@FindBy(xpath="//input[@id='first-name']")
	 WebElement firstname;
	
	@FindBy(xpath="//input[@id='last-name']")
	 WebElement lastname;
	
	@FindBy(xpath="//input[@id='postal-code']")
	 WebElement zipcode;
	
	
	  public boolean ProductListingpageExist() {
		  return productListingpage.isDisplayed();
		} 
	  
	  public void Clickitem() {
		  items.get(0).click();
		}
	  public void Clickshoppingcart() {
		  shoppingcart.click();
		}
	  public void ClickAddtocart() {
		  Addtocart.get(0).click();
		}
	  
	  public void Clickcheckout() {
		  checkout.click();
		}
	  
	  public void setFirstname(String fname) {
		  firstname.sendKeys(fname);

		}
	  
	  public void setFirstLastname(String lname) {
		  lastname.sendKeys(lname);

		}
	  public void setZipcode(String zip) {
		  zipcode.sendKeys(zip);

		}
	


}
