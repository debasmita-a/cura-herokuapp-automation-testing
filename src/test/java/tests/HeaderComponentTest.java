package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pages.HeaderComponent;

public final class HeaderComponentTest extends BaseTest{

    private HeaderComponentTest(){}
    
    @Test
    public void getHeaderTextTest(){
        Assert.assertTrue(headerComponent.getHeaderText());
    }

    @Test
    public void isMakeAppointmentBtnAvailableTest(){
        Assert.assertTrue(headerComponent.isMakeAppointmentBtnAvailable());
    }

}
