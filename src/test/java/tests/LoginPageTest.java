package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basetest.BaseTest;
import frameworkConstants.FrameworkConstants;

public class LoginPageTest extends BaseTest{
	
	@BeforeClass
	public void loginPage_setup() {
		loginPage = landingPage.doClickMakeAppointmentBtn();
	}

	@Test
	public void getPageUrlTest() {
		Assert.assertTrue(loginPage.getPageUrl().contains(FrameworkConstants.LOGIN_PAGE_URL));
	}
	
	@Test
	public void loginTextExistsTest() {
		Assert.assertTrue(loginPage.loginTextExists());
	}

}
