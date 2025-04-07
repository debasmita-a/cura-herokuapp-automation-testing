package tests;

import org.testng.annotations.Test;

import basetest.BaseTest;
import dataproviders.DataProviderClass;
import fixtures.AppointmentData;

public final class AppointmentPageTest extends BaseTest {

	private AppointmentPageTest() {
	}

	@Test(dataProvider="getAppointmentData", dataProviderClass= DataProviderClass.class)
	public void fillAppointmentDetailsTest(AppointmentData data) {
		appointmentPage = headerComponent.navigateToLoginPage().doLogin("John Doe", "ThisIsNotAPassword");
		appointmentPage.fillAppointmentDetails(data);
	}

}
