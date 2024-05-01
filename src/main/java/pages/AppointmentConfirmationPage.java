package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class AppointmentConfirmationPage {

	private WebDriver driver;
	private ElementUtil util;
	
	public AppointmentConfirmationPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	//private By locators :
	
	private By confirmationMsg = By.xpath("//h2");
	private By facilityValue = By.id("facility");
	//private By menu = By.id("menu-toggle");
	//private By logoutLink = By.linkText("Logout");
	private By goToHomePage = By.linkText("Go to Homepage");
	
	//public page actions:
	
	public String getPageUrl() {
		String url = util.getCurrentUrl();
		util.doClick(goToHomePage);
		return url;
	}
	
	public String getConfirmationMsg() {
		String confirmationMessage = util.getElementText(confirmationMsg);
		util.doClick(goToHomePage);
		return confirmationMessage;
	}
	
	public String getFacilityValue() {
		String facility = util.getElementText(facilityValue);
		util.doClick(goToHomePage);
		return facility;
	}

}
