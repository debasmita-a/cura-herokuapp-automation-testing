package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class LandingPage {

	public WebDriver driver;
	public ElementUtil util;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	//private By locators:
	private By makeAppointmentBtn = By.id("btn-make-appointment");
	private By menu = By.id("menu-toggle");
	private By loginLink = By.linkText("Login");
	
	//public page actions
	public LoginPage doClickMakeAppointmentBtn() {
		util.doClick(makeAppointmentBtn);
		return new LoginPage(driver);
	}
}
