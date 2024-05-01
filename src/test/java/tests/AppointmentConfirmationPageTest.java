package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basetest.BaseTest;
import frameworkConstants.FrameworkConstants;

public class AppointmentConfirmationPageTest extends BaseTest{

	@BeforeClass
	public void appointmentConfirmPage_setup() {
		appointmentPage = landingPage.doClickMakeAppointmentBtn().doLogin(properties.getProperty("username"), properties.getProperty("password"));				                                  
	}
	
	@DataProvider
	public Object[][] appointmentDetails(){
		return new Object[][] {
			{"Tokyo CURA Healthcare Center", true, "Medicare", "06/06/2024", "Test Appointment 01"},
			{"Hongkong CURA Healthcare Center", false, "Medicaid", "18/07/2024", "Test Appointment 02"},
		};
	}
	
	@Test(dataProvider = "appointmentDetails")
	public void getPageUrlTest(String facilityValue, boolean readmissionValue, String programValue, String dateValue, String commentValue) {
		appointmentConfirmPage = appointmentPage.fillAppointmentForm(facilityValue, readmissionValue, programValue, dateValue, commentValue);
		Assert.assertTrue(appointmentConfirmPage.getPageUrl().contains(FrameworkConstants.CONFIRMATION_PAGE_URL));
	}
	
	@Test(dataProvider = "appointmentDetails")
	public void getConfirmationMsg(String facilityValue, boolean readmissionValue, String programValue, String dateValue, String commentValue) {
		appointmentConfirmPage = appointmentPage.fillAppointmentForm(facilityValue, readmissionValue, programValue, dateValue, commentValue);
		Assert.assertTrue(appointmentConfirmPage.getConfirmationMsg().contains(FrameworkConstants.CONFIRMATION));
	}
	
	@Test(dataProvider = "appointmentDetails")
	public void getFacilityValueTest(String facilityValue, boolean readmissionValue, String programValue, String dateValue, String commentValue) {
		appointmentConfirmPage = appointmentPage.fillAppointmentForm(facilityValue, readmissionValue, programValue, dateValue, commentValue);
		Assert.assertEquals(appointmentConfirmPage.getFacilityValue(), facilityValue);
	}
}
