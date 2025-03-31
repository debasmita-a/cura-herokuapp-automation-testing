package pages;

import org.openqa.selenium.By;

import frameworkConstants.FrameworkConstants;
import utilities.ElementUtil;

public class AppointmentPage {
	
	private static final By FACILITY_DROPDOWN = By.id("combo_facility");
	private static final By IS_READMISSION_CHECKBOX = By.id("chk_hospotal_readmission");
	private static final String PROGRAM_RADIO_BUTTONS = "//input[@type='radio' and @value='%s']";
	private static final By DATE_TEXT = By.id("txt_visit_date");
	private static final By COMMENTS_TEXT = By.id("txt_comment");
	private static final By BOOK_APPOINTMENT_BTN = By.id("btn-book-appointment");

	public boolean getAppointmentPageUrl(){
		return ElementUtil.getCurrentUrlWithWait(FrameworkConstants.APPOINTMENT_PAGE_URL);
	}

	private AppointmentPage enterFacility(String facilityName){
		ElementUtil.elementSelect(FACILITY_DROPDOWN, e->e.selectByVisibleText(facilityName));
		return this;
	}

	private AppointmentPage isReadmissionCheck(boolean isAdmission){
		if(isAdmission) {
			ElementUtil.doClick(IS_READMISSION_CHECKBOX, "Hospital Readmission");
		}
		return this;
	}

	private AppointmentPage selectHealthProgram(String program){
		String xpath = String.format(program, PROGRAM_RADIO_BUTTONS);
		ElementUtil.doClick(By.xpath(xpath), "Healthcare Program");
		return this;
	}

	private AppointmentPage fillDate(String date){
		ElementUtil.doSendKeys(DATE_TEXT, date, "Visit Date");
		return this;
	}

	private AppointmentPage fillComments(String comments){
		ElementUtil.doSendKeys(COMMENTS_TEXT, comments, "Comments");
		return this;
	}

	private AppointmentPage clickBookAppointmentBtn(){
		ElementUtil.doClick(BOOK_APPOINTMENT_BTN, "Book Appointment button");
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
