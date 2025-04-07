package dataproviders;

import org.testng.annotations.DataProvider;

import br.com.six2six.fixturefactory.Fixture;
import fixtures.AppointmentData;

public class DataProviderClass {

	
	@DataProvider
	public static Object[][] getAppointmentData() {
		AppointmentData data1 = Fixture.from(AppointmentData.class).gimme("valid");
		AppointmentData data2 = Fixture.from(AppointmentData.class).gimme("valid");
		return new Object[][] { {data1}, {data2} };
	}
	
	@DataProvider
	public static Object[][] getAppointmentDataValid() {
		AppointmentData data = Fixture.from(AppointmentData.class).gimme("valid");
		return new Object[][] { {data} };
	}
}
