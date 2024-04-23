package basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import configurationReader.ConfigurationReader;
import driverfactory.DriverManager;
import pages.RegistrationPage;

public class BaseTest {

	DriverManager driverManager;
	WebDriver driver;
	ConfigurationReader configReader;
	Properties properties;
	protected RegistrationPage registrationPage;
	
	@BeforeTest
	public void setup() {
		configReader = new ConfigurationReader();
		properties = configReader.initProperties();
		driverManager = new DriverManager();
		driver = driverManager.initDriver(properties);
		registrationPage = new RegistrationPage(driver);
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
