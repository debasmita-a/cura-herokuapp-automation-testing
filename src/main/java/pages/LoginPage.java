package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil util;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	//private By locators:
	private By username = By.id("txt-username");
	private By password = By.id("txt-password");
	private By loginBtn = By.id("btn-login");
}
