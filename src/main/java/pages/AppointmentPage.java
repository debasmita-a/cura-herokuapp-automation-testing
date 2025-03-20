package pages;

import org.openqa.selenium.By;

import utilities.ElementUtil;

public class AppointmentPage {
	
	private static final By FACILITY_DROPDOWN = By.id("combo_facility");
	private static final By IS_READMISSION_CHECKBOX = By.id("chk_hospotal_readmission");
	private static final By RADIO_BUTTONS = By.xpath("//input[@type='radio' and @value='%s']");
	private static final By DATE_TEXT = By.id("txt_visit_date");
	private static final By COMMENTS_TEXT = By.id("txt_comment");

	public AppointmentPage enterFacility(String facilityName){
		ElementUtil.elementSelect(FACILITY_DROPDOWN, e->e.selectByVisibleText(facilityName));
		return this;
	}

	public AppointmentPage isReadmissionCheck(boolean isAdmission){
		if(isAdmission) {
			ElementUtil.doClick(IS_READMISSION_CHECKBOX);
		}
		return this;
	}
	
}
