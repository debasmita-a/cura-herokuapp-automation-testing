package tests;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basetest.BaseTest;
import frameworkConstants.FrameworkConstants;
import pages.HeaderComponent;

public final class LoginPageTest extends BaseTest{

    private LoginPageTest(){}

    @BeforeMethod
    public void setupLoginPage(){
        loginPage = new HeaderComponent().navigateToLoginPage();
    }

    @Test
    public void getLoginPageLeadTextTest(){
        String actual = loginPage.getLoginPageLeadText();
        Assert.assertTrue(actual.equals(FrameworkConstants.LOGIN_LEAD_TEXT));
    }

    @Test(description="user login with correct username and password")
    public void userLoginTest(){
        appointmentPage = loginPage.doLogin("John Doe", "ThisIsNotAPassword");
        Assert.assertTrue(appointmentPage.getAppointmentPageTitle());
    }


}
