package utilities;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverfactory.DriverManager;
import reports.ExtentLogger;

public class ElementUtil {

	//element utilities :
	
	public static WebElement getElement(By locator) {
		return DriverManager.getDriver().findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator){
		return DriverManager.getDriver().findElements(locator);
	}
	
	public static void doClick(By locator, String elementName) {
		getElement(locator).click();
		ExtentLogger.pass(elementName + " is clicked");
	}
	
	public static void doSendKeys(By locator, String value, String elementName) {
		getElement(locator).sendKeys(value);
		ExtentLogger.pass(value + " is entered in the field " + elementName);
	}
	
	public static boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
		
	public static String getElementText(By locator) {
		return getElement(locator).getText();
	}
	
	public static String getElementTextWithWait(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}
	// select utils:
	
	public static void elementSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public static void elementSelect(By locator, Consumer<Select> consumer){
		consumer.accept(new Select(getElement(locator)));
		
	}
	
	//browser utilities :
	
	public static String getCurrentUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}
	
	public static boolean getCurrentUrlWithWait(String text) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.urlContains(text));
	}

	public static String getCurrentPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
