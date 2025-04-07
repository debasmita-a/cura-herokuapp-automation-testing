package pages;

import static utilities.ElementUtil.*;

import org.openqa.selenium.By;

import frameworkConstants.FrameworkConstants;

public class ConfirmationPage {

	private static final By CONFIRMATION_TEXT = By.xpath("//h2");
	private static final By FACTILITY_VALUE = By.xpath("//div[contains(@class,'col-xs-8')]/p[@id='facility']");
	private static final By GO_TO_HOMEPAGE_BTN = By.linkText("Go to Homepage");
	
	public boolean getConfirmationPageUrl(){
		return getCurrentUrlWithWait(FrameworkConstants.CONFIRMATION_PAGE_URL);
	}
	
	public String getConfirmationText() {
		return getElementText(CONFIRMATION_TEXT);
	}
	
	public String getFacilityValue() {
		return getElementText(FACTILITY_VALUE);
	}
	
	public HeaderComponent navigateToHomePage() {
		doClickWithWait(GO_TO_HOMEPAGE_BTN, 5, "Go to Homepage");
		return new HeaderComponent();
	}

}
