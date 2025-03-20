package basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import configurationReader.ConfigurationPropReader;
import driverfactory.DriverManager;
import pages.AppointmentConfirmationPage;
import pages.AppointmentPage;
import pages.LandingPage;
import pages.LoginPage;

public class BaseTest {

	protected DriverManager driverManager;
	protected WebDriver driver;
	protected ConfigurationPropReader configReader;
	protected Properties properties;
	protected LandingPage landingPage;
	protected LoginPage loginPage;
	protected AppointmentPage appointmentPage;
	protected AppointmentConfirmationPage appointmentConfirmPage;

	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName) {
		configReader = new ConfigurationPropReader();
		properties = configReader.initProperties();
		if(browserName!=null) {
			properties.setProperty("browser", browserName);
		}
		driverManager = new DriverManager();
		driver = driverManager.initDriver();
		landingPage = new LandingPage(driver);
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
