package com.qa.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.TestBase;

public class AmazonPay extends TestBase{
	
	@FindBy(xpath="//div/span[@class=\"currency-green\"]")
	WebElement amazonPayBalance;
	
	// AmazonPay class constructor
	public AmazonPay() {
		PageFactory.initElements(driver, this);
	}
	
	public String getAmazonPayBalance() {
		return amazonPayBalance.getText();
	}

}
