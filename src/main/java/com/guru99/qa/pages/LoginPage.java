package com.guru99.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory -- Object Repository
	@FindBy(name = "uid")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit' and @name='btnLogin']")
	WebElement loginBtn;

	@FindBy(xpath = "//input[contains(text(),'RESET')]")
	WebElement resetBtn;

	@FindBy(xpath = "//div[@class='logo']")
	WebElement guru99Logo;

	@FindBy(xpath = "//a[contains(text(),'here')]")
	WebElement hereLink;

	// Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyGuru99Image() {
		return guru99Logo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {

		username.sendKeys(un);

		password.sendKeys(pwd);

		loginBtn.click();

		return new HomePage();
	}

	public boolean hereLink() {
		return hereLink.isDisplayed();
	}

}
