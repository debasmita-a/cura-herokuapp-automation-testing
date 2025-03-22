package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pages.HeaderComponent;

public class HeaderComponentTest extends BaseTest{

    @Test
    public void getHeaderTextText(){
        Assert.assertTrue(HeaderComponent.getHeaderText());
    }
}
