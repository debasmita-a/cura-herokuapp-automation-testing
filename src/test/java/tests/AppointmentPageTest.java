package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basetest.BaseTest;
import frameworkConstants.FrameworkConstants;

public class AppointmentPageTest extends BaseTest{

	@BeforeClass
	public void appointmentPage_setup() {
		appointmentPage = landingPage.doClickMakeAppointmentBtn().doLogin(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	@Test
	public void getPageUrlTest() {
		Assert.assertTrue(appointmentPage.getPageUrl().contains(FrameworkConstants.APPOINTMENT_PAGE_URL));
	}
}
