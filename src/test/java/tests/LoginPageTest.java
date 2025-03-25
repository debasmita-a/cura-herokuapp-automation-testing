package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import frameworkConstants.FrameworkConstants;
import pages.AppointmentPage;
import pages.HeaderComponent;

public final class LoginPageTest extends BaseTest{

    private LoginPageTest(){}

    @Test
    public void getLoginPageLeadTextTest(){
        String actual = new HeaderComponent().navigateToLoginPage().getLoginPageLeadText();
        Assert.assertTrue(actual.equals(FrameworkConstants.LOGIN_LEAD_TEXT));
    }

    @Test()
    public void userLoginTest(){
    	AppointmentPage appointmentPage = new HeaderComponent().navigateToLoginPage().doLogin("John Doe", "ThisIsNotAPassword");
        Assert.assertTrue(appointmentPage.getAppointmentPageTitle());
    }


}
