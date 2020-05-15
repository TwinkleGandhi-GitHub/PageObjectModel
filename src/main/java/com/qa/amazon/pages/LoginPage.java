package com.qa.amazon.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//a[@id=\"nav-link-accountList\"]")
	WebElement goToLoginBtn;
	
	@FindBy(id="ap_email")
	WebElement userName;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signInBtn;
	
	@FindBy(xpath="//i[@class=\"a-icon a-icon-logo\"]")
	WebElement amazonLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void goToLoginPage() {
		goToLoginBtn.click();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateAmazonLogo() {
		return amazonLogo.isDisplayed();
	}
	
	public HomePage login(String username, String pwd) {
		
		userName.sendKeys(username);
		continueBtn.click();
		password.sendKeys(pwd);
		signInBtn.click();
		
		return new HomePage();
		
	}

}
