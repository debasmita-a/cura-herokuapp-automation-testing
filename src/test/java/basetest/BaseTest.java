package basetest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import driverfactory.Driver;
import pages.AppointmentPage;
import pages.ConfirmationPage;
import pages.FooterComponent;
import pages.HeaderComponent;
import pages.LoginPage;

public class BaseTest {
	
	protected HeaderComponent headerComponent;
	protected LoginPage loginPage;
	protected AppointmentPage appointmentPage;
	protected ConfirmationPage confirmationPage;
	protected FooterComponent footerComponent;
	
	
	@BeforeSuite
	public void loadFixtures() {
		FixtureFactoryLoader.loadTemplates("fixtures");
	}
	
	@BeforeMethod
	public void setup(){
		Driver.initDriver(); 
		headerComponent = new HeaderComponent();
	}

	@AfterMethod
	public void teardown(){
		Driver.teardown();
	}

}	
	

