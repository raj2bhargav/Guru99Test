package com.guru99.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.base.TestBase;
import com.guru99.qa.pages.HomePage;
import com.guru99.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();

		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "GTPL Bank Home Page");
	}

	@Test(priority = 2)
	public void guru99LogoImageTest() {
		boolean image = loginPage.verifyGuru99Image();
		Assert.assertTrue(image);
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 4)
	public void hereLinkTest() {
		Assert.assertTrue(loginPage.hereLink());
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
