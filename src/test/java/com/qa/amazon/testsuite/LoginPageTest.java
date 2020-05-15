package com.qa.amazon.testsuite;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.amazon.base.TestBase;
import com.qa.amazon.pages.AmazonPay;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage lp;
	HomePage hp;
	AmazonPay ap;

	public LoginPageTest() {
		// TODO Auto-generated constructor stub
		super();
	} 

	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		lp.goToLoginPage();
	}

	@Test(priority = 1)
	public void checkTitle() {
		
		String pageTitle=lp.getPageTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Amazon Sign In");	
	}
	
	@Test(priority = 2)
	public void checkLogo() {
		Assert.assertTrue(lp.validateAmazonLogo());
	}
	
	@Test(priority = 3,dependsOnMethods = {"checkLogo","checkTitle"})
	public void login() {
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
