package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pages.AppointmentData;
import pages.HeaderComponent;

public final class AppointmentPageTest extends BaseTest{

    private AppointmentPageTest(){}
     
    @BeforeMethod
    public void setupAppointmentPage(){
        appointmentPage = new HeaderComponent().navigateToLoginPage().doLogin("John Doe", "ThisIsNotAPassword");
    }

    @Test
    public void fillAppointmentDetailsTest(){
        AppointmentData appointmentData = new AppointmentData("Tokyo CURA Healthcare Center", 
        false, 
        "Medicare", "25/03/2025", "Test comments");
        appointmentPage.fillAppointmentDetails(appointmentData);
    }


}
