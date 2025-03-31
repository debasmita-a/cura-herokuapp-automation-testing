package driverfactory;

import java.util.HashMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements BrowserManager {

    @Override
    public WebDriver getDriver() {
        return new ChromeDriver();
    }

    @Override
    public Capabilities setCapabilities() {
    	
    	return LambdaTestCapabilities.setCapabilities();

		/*
		 * browserOptions.addArguments("--headless=new"); // Ensure new headless mode is
		 * used browserOptions.addArguments("--no-sandbox");
		 * browserOptions.addArguments("--disable-dev-shm-usage");
		 * browserOptions.addArguments("--disable-gpu");
		 * browserOptions.addArguments("--remote-allow-origins=*");
		 * browserOptions.setCapability("browserName", "Chrome");
		 */

    }

}
