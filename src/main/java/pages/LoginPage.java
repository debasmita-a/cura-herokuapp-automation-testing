package pages;

import org.openqa.selenium.By;

import static utilities.ElementUtil.*;

public class LoginPage {

	private static final By LEAD_TEXT = By.className("lead");
	private static final By USERNAME_TEXT = By.id("txt-username");
	private static final By PASSWORD_TEXT = By.id("txt-password");
	private static final By LOGIN_BTN = By.id("btn-login");
	private static final By ERROR_MSG = By.xpath("//p[contains(@class,'text-danger')]");

	public String getLoginPageLeadText(){
		return getElementText(LEAD_TEXT);
	}

	private LoginPage enterUserName(String userName){
		doSendKeys(USERNAME_TEXT, userName, "Username");
		return this;
	}

	private LoginPage enterPassword(String password){
		doSendKeys(PASSWORD_TEXT, password, "Password");
		return this;
	}

	private AppointmentPage clickLoginBtn(){
		doClick(LOGIN_BTN, "Login button");
		return new AppointmentPage();
	}
	
	public String getErrorMessage() {
		return getElementTextWithWait(ERROR_MSG, 2);
	}

	public AppointmentPage doLogin(String userName, String password){
		return enterUserName(userName).enterPassword(password).clickLoginBtn();
	}


}
