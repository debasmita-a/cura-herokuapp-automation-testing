package basetest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import driverfactory.Driver;
import pages.AppointmentPage;
import pages.HeaderComponent;
import pages.LoginPage;

public class BaseTest {

	@BeforeTest
	public void setup(){
		Driver.initDriver(); 
	}

	@AfterTest
	public void teardown(){
		//Driver.teardown();
	}

}	
	

