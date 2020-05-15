package com.qa.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@id=\"nav-link-accountList\"]/span[1]")
	WebElement currentUser;

	@FindBy(xpath = "//a[@tabindex=26]")
	WebElement amazonPayLink;

	@FindBy(xpath = "//a[@tabindex=28]")
	WebElement mobilesLink;

	@FindBy(xpath = "//a[@tabindex=29]")
	WebElement customerServiceLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getCurrentUser() {
		String user = currentUser.getText();
		return user;
	}

	public boolean verifyAmazonPayLink() {
		return amazonPayLink.isDisplayed();
	}

	public AmazonPay clickOnAmazonPay() {
		amazonPayLink.click();
		return new AmazonPay();

	}

}
