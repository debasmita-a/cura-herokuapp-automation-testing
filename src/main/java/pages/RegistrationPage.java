package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	public WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//private By locators:
	private By registrationLink = By.linkText("Register");
	
	//public page actions:
	public boolean isRegisterLinkAvailable() {
		return driver.findElement(registrationLink).isDisplayed();
	}
}
