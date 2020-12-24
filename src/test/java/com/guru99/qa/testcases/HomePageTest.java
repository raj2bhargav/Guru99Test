package com.guru99.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.base.TestBase;
import com.guru99.qa.pages.DeleteAccountPage;
import com.guru99.qa.pages.HomePage;
import com.guru99.qa.pages.LoginPage;
import com.guru99.qa.pages.NewCustomerPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	NewCustomerPage newCustomerPage;
	DeleteAccountPage deleteAccountPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();

		loginPage = new LoginPage();
		newCustomerPage = new NewCustomerPage();
		deleteAccountPage = new DeleteAccountPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();//
		Assert.assertEquals(homePageTitle, "GTPL Bank Manager HomePage", "Home Page Title Didn't Matched");
	}

	@Test(priority = 2)
	public void verifyHomePageImageTest() {
		Assert.assertTrue(homePage.homePageImage());
	}

	@Test(priority = 3)
	public void verifyNewCustomerLinkTest() {
		newCustomerPage = homePage.clickOnNewCustomer();
	}

	@Test(priority = 4)
	public void verifyDeleteAccountLinkTest() {
		deleteAccountPage = homePage.clickOnDeleteAccountLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
