package basetest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driverfactory.Driver;

public class BaseTest {
	
	@BeforeMethod
	public void setup(){
		Driver.initDriver(); 
	}

	@AfterMethod
	public void teardown(){
		//Driver.teardown();
	}

}	
	

