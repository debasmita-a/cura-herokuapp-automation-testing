package tests;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pages.HeaderComponent;

public final class HeaderComponentTest extends BaseTest{

    private HeaderComponentTest(){}

    @BeforeMethod
    public void setupHeaderComponentPage(){
        header = new HeaderComponent();
    }
    
    @Test
    public void getHeaderTextText(){
        Assert.assertTrue(header.getHeaderText());
    }

    @Test
    public void isMakeAppointmentBtnAvailableTest(){
        Assert.assertTrue(header.isMakeAppointmentBtnAvailable());
    }

}
