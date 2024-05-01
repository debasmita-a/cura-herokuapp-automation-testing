package basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import configurationReader.ConfigurationReader;
import driverfactory.DriverManager;
import pages.LandingPage;

public class BaseTest {

	protected DriverManager driverManager;
	protected WebDriver driver;
	protected ConfigurationReader configReader;
	protected Properties properties;
	protected LandingPage landingPage;

	@BeforeTest
	public void setup() {
		configReader = new ConfigurationReader();
		properties = configReader.initProperties();
		driverManager = new DriverManager();
		driver = driverManager.initDriver(properties);
		landingPage = new LandingPage(driver);
	}
	
	@AfterTest
	public void teardown() {
		//driver.quit();
	}
	
}
