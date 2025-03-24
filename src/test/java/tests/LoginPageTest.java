package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import frameworkConstants.FrameworkConstants;
import pages.AppointmentPage;
import pages.HeaderComponent;
import pages.LoginPage;

public final class LoginPageTest extends BaseTest{

    private LoginPageTest(){}

    @Test
    public void getLoginPageLeadTextTest(){
        String actual = new HeaderComponent().navigateToLoginPage().getLoginPageLeadText();
        Assert.assertTrue(actual.equals(FrameworkConstants.LOGIN_LEAD_TEXT));
    }

    @Test(description="user login with correct username and password")
    public void userLoginTest(){
        LoginPage loginPage = new HeaderComponent().navigateToLoginPage();
        AppointmentPage appointmentPage = loginPage.doLogin("John Doe", "ThisIsNotAPassword");
        Assert.assertTrue(appointmentPage.getAppointmentPageTitle());
    }


}
