package pages;

import org.openqa.selenium.By;

import fixtures.AppointmentData;
import frameworkConstants.FrameworkConstants;
import reports.ExtentLogger;

import static utilities.ElementUtil.*;

public class AppointmentPage {
	
	private static final By FACILITY_DROPDOWN = By.id("combo_facility");
	private static final By IS_READMISSION_CHECKBOX = By.id("chk_hospotal_readmission");
	private static final By DATE_TEXT = By.id("txt_visit_date");
	private static final By COMMENTS_TEXT = By.id("txt_comment");
	private static final By BOOK_APPOINTMENT_BTN = By.id("btn-book-appointment");

	public boolean getAppointmentPageUrl(){
		return getCurrentUrlWithWait(FrameworkConstants.APPOINTMENT_PAGE_URL);
	}

	private AppointmentPage enterFacility(String facilityName){
		elementSelectWithWait(FACILITY_DROPDOWN, 5, e->e.selectByVisibleText(facilityName));
		ExtentLogger.pass(facilityName);
		return this;
	}

	private AppointmentPage isReadmissionCheck(boolean isAdmission){
		if(isAdmission) {
			doClickWithWait(IS_READMISSION_CHECKBOX, 5, "Hospital Readmission");
		}
		return this;
	}
//TODO : Make a resuable utility method 
	private AppointmentPage selectHealthProgram(String program){
		String xpath = "//input[@type='radio' and @value='" + program + "']";
		doClickWithWait(By.xpath(xpath), 5, "Healthcare Program");
		return this;
	}

	private AppointmentPage fillDate(String date){
		doSendKeys(DATE_TEXT, date, "Visit Date");
		return this;
	}

	private AppointmentPage fillComments(String comments){
		doSendKeys(COMMENTS_TEXT, comments, "Comments");
		return this;
	}

	private AppointmentPage clickBookAppointmentBtn(){
		doClickWithWait(BOOK_APPOINTMENT_BTN, 5, "Book Appointment button");
		return this;
	}

	public ConfirmationPage fillAppointmentDetails(AppointmentData appointmentData){
		enterFacility(appointmentData.getFacility())
		.isReadmissionCheck(appointmentData.isReadmission())
		.selectHealthProgram(appointmentData.getHealthCareProgram())
		.fillDate(appointmentData.getDateOfVisit())
		.fillComments(appointmentData.getComments())
		.clickBookAppointmentBtn();

		return new ConfirmationPage();
	}
	
}
