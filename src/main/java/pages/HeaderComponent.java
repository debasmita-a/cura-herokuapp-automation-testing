package pages;

import org.openqa.selenium.By;

import frameworkConstants.FrameworkConstants;
import static utilities.ElementUtil.*;

public class HeaderComponent {

	private static final By HEADER_TEXT = By.xpath("//h1");
	private static final By MAKE_APPOINTMENT_BTN = By.id("btn-make-appointment");
	private static final By MENU_TOGGLE_BTN = By.id("menu-toggle");

    	
	public boolean getHeaderText(){
		return getElementText(HEADER_TEXT).equals(FrameworkConstants.HEADER_TEXT);
	}

	public boolean isMakeAppointmentBtnAvailable(){
		return isElementDisplayed(MAKE_APPOINTMENT_BTN);
	}

	public LoginPage navigateToLoginPage(){
		doClick(MAKE_APPOINTMENT_BTN, "Make Appointment button");
		return new LoginPage();
	}
	
}
