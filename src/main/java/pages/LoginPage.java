package pages;

import org.openqa.selenium.By;

import utilities.ElementUtil;

public class LoginPage {

	private static final By LEAD_TEXT = By.className("lead");
	private static final By USERNAME_TEXT = By.id("txt-username");
	private static final By PASSWORD_TEXT = By.id("txt-password");
	private static final By LOGIN_BTN = By.id("btn-login");

	//TODO : -ve login

	public String getLoginPageLeadText(){
		return ElementUtil.getElementText(LEAD_TEXT);
	}

	private LoginPage enterUserName(String userName){
		ElementUtil.doSendKeys(USERNAME_TEXT, userName);
		return this;
	}

	private LoginPage enterPassword(String password){
		ElementUtil.doSendKeys(PASSWORD_TEXT, password);
		return this;
	}

	private AppointmentPage clickLoginBtn(){
		ElementUtil.doClick(LOGIN_BTN);
		return new AppointmentPage();
	}

	public AppointmentPage doLogin(String userName, String password){
		return enterUserName(userName).enterPassword(password).clickLoginBtn();
	}


}
