package tests;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import basetest.BaseTest;
import dataproviders.DataProviderClass;
import fixtures.AppointmentData;
import frameworkConstants.FrameworkConstants;

public final class ConfirmationPageTest extends BaseTest{
	
	private ConfirmationPageTest() {}

	SoftAssertions softAssert = new SoftAssertions();
	
	@Test(dataProvider= "getAppointmentDataValid", dataProviderClass= DataProviderClass.class)
	public void getConfirmationPageUrlTest(AppointmentData data) {
		confirmationPage = headerComponent.navigateToLoginPage().doLogin("John Doe", "ThisIsNotAPassword").fillAppointmentDetails(data);
		softAssert.assertThat(confirmationPage.getConfirmationPageUrl());
		softAssert.assertThat(confirmationPage.getConfirmationText().equals(FrameworkConstants.CONFIRMATION));
		softAssert.assertThat(confirmationPage.getFacilityValue().equals(data.getFacility()));
	}
	
	@Test(dataProvider= "getAppointmentDataValid", dataProviderClass= DataProviderClass.class)
	public void navigateToHomePageTest(AppointmentData data) {
		confirmationPage = headerComponent.navigateToLoginPage().doLogin("John Doe", "ThisIsNotAPassword").fillAppointmentDetails(data);
		confirmationPage.navigateToHomePage();
		Assertions.assertThat(headerComponent.isMakeAppointmentBtnAvailable());
	}
}
