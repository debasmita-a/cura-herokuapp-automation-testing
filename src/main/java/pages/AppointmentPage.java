package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class AppointmentPage {

	private WebDriver driver;
	private ElementUtil util;
	
	public AppointmentPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	//private By locators:
	private By facilities = By.id("combo_facility");
	private By readmissionCheckbox = By.id("chk_hospotal_readmission");
	private By radioBtns = By.name("programs");
	private By visitDate = By.id("txt_visit_date");
	private By commentsTextbox = By.id("txt_comment");
	private By bookAppointmentBtn = By.id("btn-book-appointment");
	
	//public page actions :
	
	public String getPageUrl() {
		return util.getCurrentUrl();
	}
	
	public By checkProgram(String programName) {
		String xpath = "//input[@name='programs' and @value='" + programName + "']";
		return By.xpath(xpath);
	}
	
	public AppointmentConfirmationPage fillAppointmentForm(String facilityName, boolean readmission, String programName, String date, String comments) {
		util.elementSelectByValue(facilities, facilityName);
		if(readmission) {
			util.doClick(readmissionCheckbox);
		}
		util.doClick(checkProgram(programName));
		util.doSendKeys(visitDate, date);
		util.doSendKeys(commentsTextbox, comments);
		util.doClick(bookAppointmentBtn);
		
		return new AppointmentConfirmationPage(driver);
	}
}
