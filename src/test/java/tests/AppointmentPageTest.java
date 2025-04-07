package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basetest.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import fixtures.AppointmentData;

public final class AppointmentPageTest extends BaseTest {

	private AppointmentPageTest() {
	}

	@DataProvider
	public Object[][] getAppointmentData() {
		AppointmentData data1 = Fixture.from(AppointmentData.class).gimme("valid");
		AppointmentData data2 = Fixture.from(AppointmentData.class).gimme("valid");

		return new Object[][] { { data1 }, { data2 } };
	}

	@Test(dataProvider="getAppointmentData")
	public void fillAppointmentDetailsTest(AppointmentData data) {
		appointmentPage = headerComponent.navigateToLoginPage().doLogin("John Doe", "ThisIsNotAPassword");
		appointmentPage.fillAppointmentDetails(data);
	}

}
