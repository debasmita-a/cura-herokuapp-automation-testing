package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {

	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	//element utilities :
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public String getElementAttributeByValue(By locator, String value) {
		return getElement(locator).getAttribute(value);
	}
	
	public String getElementText(By locator) {
		return getElement(locator).getText();
	}
	// select utilis:
	
	public void elementSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	//browser utilities :
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
}
