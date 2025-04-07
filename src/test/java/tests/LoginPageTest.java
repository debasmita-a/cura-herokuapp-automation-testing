package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basetest.BaseTest;
import frameworkConstants.FrameworkConstants;
import pages.AppointmentPage;
import pages.HeaderComponent;
import pages.LoginPage;

public final class LoginPageTest extends BaseTest {

	private LoginPageTest() {
	}

	@Test
	public void getLoginPageLeadTextTest() {
		String actual = headerComponent.navigateToLoginPage().getLoginPageLeadText();
		Assert.assertTrue(actual.equals(FrameworkConstants.LOGIN_LEAD_TEXT));
	}

	@Test(dataProvider = "getData")
	public void userLoginTest(String username, String password, boolean flag) {
		loginPage = headerComponent.navigateToLoginPage();
		appointmentPage = loginPage.doLogin(username, password);
		if (flag) {
			Assert.assertTrue(appointmentPage.getAppointmentPageUrl());
		} else {
			String error_msg = loginPage.getErrorMessage();
			Assert.assertTrue(error_msg.equals(FrameworkConstants.ERROR_MSG));
		}

	}

	@DataProvider(parallel = true)
	public Object[][] getData() {
		return new Object[][] { 
			{ "John Doe", "ThisIsNotAPassword", true },
			{ "John Doe1", "ThisIsNotAPassword1", false }, 
			{ "", "ThisIsNotAPassword", false },
			{ "John Doe", "", false } };
	}

}
