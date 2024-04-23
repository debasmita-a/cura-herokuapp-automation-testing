package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;

public class RegistrationPageTest extends BaseTest{

	@Test
	public void registrationTest() {
		Assert.assertTrue(registrationPage.isRegisterLinkAvailable());
	}
}
