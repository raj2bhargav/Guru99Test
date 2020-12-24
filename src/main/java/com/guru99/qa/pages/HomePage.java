package com.guru99.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//table[@class='layout']//img[1]")
	WebElement homePageImage;
	
	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement newCustomerLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Account')]")
	WebElement newAccountLink;
	
	
	@FindBy(xpath = "//a[contains(text(),'Edit Account')]")
	WebElement editAccountLink;
	
	@FindBy(xpath = "//a[contains(text(),'Delete Account')]")
	WebElement deleteAccountLink;
	
	
	
	//Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean homePageImage() {
		return homePageImage.isDisplayed();
	}
	
	
	public NewCustomerPage clickOnNewCustomer() {
		newCustomerLink.click();
		
		return new NewCustomerPage();
	}
	
	public EditAccountPage clickOnEditAccountLink() {
		editAccountLink.click();
		
		return new EditAccountPage();
	}
	
	public NewAccountPage clickOnNewAccountLink() {
		newAccountLink.click();
		
		return new NewAccountPage();
	}
	
	public DeleteAccountPage clickOnDeleteAccountLink() {
		deleteAccountLink.click();
		
		return new DeleteAccountPage();
	}
	

}
