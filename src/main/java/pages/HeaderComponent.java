package pages;

import org.openqa.selenium.By;

import frameworkConstants.FrameworkConstants;
import utilities.ElementUtil;

public class HeaderComponent {

	private static final By HEADER_TEXT = By.xpath("//h1");
	private static final By MAKE_APPOINTMENT_BTN = By.id("btn-make-appointment");
	private static final By MENU_TOGGLE_BTN = By.id("menu-toggle");

    	
	public static boolean getHeaderText(){
		return ElementUtil.getElementText(HEADER_TEXT).equals(FrameworkConstants.HEADER_TEXT);
	}

	public LoginPage navigateToLoginPage(){
		ElementUtil.doClick(MAKE_APPOINTMENT_BTN);
		return new LoginPage();
	}
}
