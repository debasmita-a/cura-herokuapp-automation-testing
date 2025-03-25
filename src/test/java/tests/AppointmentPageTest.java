package tests;

import org.testng.annotations.Test;

import basetest.BaseTest;
import pages.AppointmentData;
import pages.AppointmentPage;
import pages.HeaderComponent;

public final class AppointmentPageTest extends BaseTest{

    private AppointmentPageTest(){}
    
    @Test
    public void fillAppointmentDetailsTest(){
    	AppointmentPage appointmentPage = new HeaderComponent().navigateToLoginPage().doLogin("John Doe", "ThisIsNotAPassword");
        AppointmentData appointmentData = new AppointmentData("Tokyo CURA Healthcare Center", 
        false, 
        "Medicare", 
        "25/03/2025", 
        "Test comments");
        appointmentPage.fillAppointmentDetails(appointmentData);
    }


}
