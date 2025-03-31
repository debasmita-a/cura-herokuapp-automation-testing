package pages;

import org.openqa.selenium.By;

import reports.ExtentLogger;
import utilities.ElementUtil;

public class LoginPage {

	private static final By LEAD_TEXT = By.className("lead");
	private static final By USERNAME_TEXT = By.id("txt-username");
	private static final By PASSWORD_TEXT = By.id("txt-password");
	private static final By LOGIN_BTN = By.id("btn-login");
	private static final By ERROR_MSG = By.xpath("//p[contains(@class,'text-danger')]");

	public String getLoginPageLeadText(){
		return ElementUtil.getElementText(LEAD_TEXT);
	}

	private LoginPage enterUserName(String userName){
		ElementUtil.doSendKeys(USERNAME_TEXT, userName, "Username");
		return this;
	}

	private LoginPage enterPassword(String password){
		ElementUtil.doSendKeys(PASSWORD_TEXT, password, "Password");
		return this;
	}

	private AppointmentPage clickLoginBtn(){
		ElementUtil.doClick(LOGIN_BTN, "Login button");
		return new AppointmentPage();
	}
	
	public String getErrorMessage() {
		return ElementUtil.getElementTextWithWait(ERROR_MSG, 2);
	}

	public AppointmentPage doLogin(String userName, String password){
		return enterUserName(userName).enterPassword(password).clickLoginBtn();
	}


}
