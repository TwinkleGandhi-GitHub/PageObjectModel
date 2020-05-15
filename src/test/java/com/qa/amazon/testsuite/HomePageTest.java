package com.qa.amazon.testsuite;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.amazon.base.TestBase;
import com.qa.amazon.pages.AmazonPay;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage lp;
	HomePage hp;
	AmazonPay ap;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		lp.goToLoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String homePageTitle = hp.getHomePageTitle();
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	@Test(priority = 2)
	public void verifyUser() {
		Assert.assertTrue(hp.getCurrentUser().contentEquals(prop.getProperty("currentuser")));
	}
	
	@Test(priority = 3)
	public void verifyAmazonPay() {
		Assert.assertTrue(hp.verifyAmazonPayLink());
	}
	
	@Test(priority = 4)
	public void goToAmazonPay() {
		ap=hp.clickOnAmazonPay();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
