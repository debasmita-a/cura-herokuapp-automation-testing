package pages;

import org.openqa.selenium.By;

import utilities.ElementUtil;

public class LandingPage {

	private static final By MAKE_APPOINTMENT_BTN = By.id("btn-make-appointment");
	private static final By MENU_TOGGLE_BTN = By.id("menu-toggle");
	

	public LoginPage navigateToLoginPage(){
		ElementUtil.doClick(MAKE_APPOINTMENT_BTN);
		return new LoginPage();
	}
}
