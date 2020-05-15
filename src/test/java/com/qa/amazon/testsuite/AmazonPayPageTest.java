package com.qa.amazon.testsuite;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.amazon.base.TestBase;
import com.qa.amazon.pages.AmazonPay;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.LoginPage;
import com.qa.amazon.util.TestUtil;

public class AmazonPayPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	AmazonPay ap;
	TestUtil utility;
	public AmazonPayPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp=new LoginPage();
		lp.goToLoginPage();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		ap=hp.clickOnAmazonPay();	
	}
	
	@Test
	public void checkAmazonPayBalance() throws IOException {
		System.out.println(ap.getAmazonPayBalance());	
		utility.takeScreenshotAtEnd();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
