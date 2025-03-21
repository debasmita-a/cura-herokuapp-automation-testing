package tests;

import org.junit.Test;
import org.testng.annotations.BeforeClass;

import basetest.BaseTest;
import pages.HeaderComponent;
import pages.LoginPage;

public class LoginPageTest extends BaseTest{

    LoginPage loginPage = null;

    @BeforeClass
    public void setupLoginPage(){
        HeaderComponent header = new HeaderComponent();
        loginPage = header.navigateToLoginPage();
    }

    @Test
    public void loginTest(){
        loginPage.enterUserName("John Doe")
        .enterPassword("ThisIsNotAPassword")
        .clickLoginBtn();
    }
}
