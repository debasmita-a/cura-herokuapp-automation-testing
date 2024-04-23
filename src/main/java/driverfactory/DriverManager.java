package driverfactory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private WebDriver driver;

	public WebDriver initDriver(Properties properties) {

		String browser = properties.getProperty("browser");
		System.out.println("Launching browser... " + browser);
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Please provide a correct browser name..");
			break;
		}

		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		return driver;
	}
}
