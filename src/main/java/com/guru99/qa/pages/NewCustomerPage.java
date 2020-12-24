package com.guru99.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.base.TestBase;

public class NewCustomerPage extends TestBase{
	
	public NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//p[@class='heading3']")
	WebElement addNewCustomerImage;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement customerName;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@name='sub']")
	WebElement submitBtnInNewAccountPage;
	
	@FindBy(xpath = "//input[@name='res']")
	WebElement resetBtnInNewAccountPage;
	
	
	
	public boolean verifyAddNewCustomerImage() {
		return addNewCustomerImage.isDisplayed();
	}
	
	
	public void customerName(String name) {
		customerName.sendKeys(name);
	}
	
	
	public void verifyCity(String cityName) {
		city.sendKeys(cityName);
	}
	
	public boolean verifySubmitBtnInNewAccountPage() {
		return submitBtnInNewAccountPage.isDisplayed();
	}
	
	
	public boolean verifyResetBtnInNewAccountPage() {
		return resetBtnInNewAccountPage.isDisplayed();
	}

}
