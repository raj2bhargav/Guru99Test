package com.guru99.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.base.TestBase;
import com.guru99.qa.pages.HomePage;
import com.guru99.qa.pages.LoginPage;
import com.guru99.qa.pages.NewCustomerPage;

public class NewCustomerPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	NewCustomerPage newCustomerPage;

	public NewCustomerPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();

		loginPage = new LoginPage();
		newCustomerPage = new NewCustomerPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		newCustomerPage = homePage.clickOnNewCustomer();
	}
	
	
	
	@Test(priority = 1)
	public void verifyAddNewCustomerImageTest() {
		Assert.assertTrue(newCustomerPage.verifyAddNewCustomerImage(), "Add New Customer Image is not Displayed");
	}
	
	
	@Test(priority = 2)
	public void customerNameTest() throws InterruptedException {
		newCustomerPage.customerName(prop.getProperty("name"));
		Thread.sleep(2000);
	}
	
	
	@Test(priority = 3)
	public void verifyCityTest() throws InterruptedException {
		newCustomerPage.verifyCity(prop.getProperty("cityName"));
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void verifySubmitButtonInNewAccountPageTest() {
		Assert.assertTrue(newCustomerPage.verifySubmitBtnInNewAccountPage());
	}
	
	/*
	@Test(priority = 5)
	public void verifyResetButtonInNewAccountPageTest() {
		Assert.assertTrue(newCustomerPage.verifyResetBtnInNewAccountPage());
	}*/
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
