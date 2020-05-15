package com.qa.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.amazon.util.WebEventListener;
import com.qa.amazon.util.TestUtil;

public class TestBase {

	public static Properties prop;
	protected static WebDriver driver;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Work\\Eclipse Workspace\\FreeCRMTest\\src\\main\\java\\com\\qa\\amazon\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--incognito");
			System.setProperty("webdriver.chrome.driver", "C:\\Work\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		WebEventListener eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;

		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}
}
