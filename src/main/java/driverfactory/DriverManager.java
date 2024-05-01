package driverfactory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private WebDriver driver;
	private static ThreadLocal<WebDriver> tl_driver = new ThreadLocal<>();

	public WebDriver initDriver(Properties properties) {

		String browser = properties.getProperty("browser");
		System.out.println("Launching browser... " + browser);
		switch (browser.toLowerCase()) {
		case "chrome":
			//driver = new ChromeDriver();
			tl_driver.set(new ChromeDriver());
			break;
		case "edge":
			//driver = new EdgeDriver();
			tl_driver.set(new EdgeDriver());
			break;
		case "firefox":
			//driver = new FirefoxDriver();
			tl_driver.set(new FirefoxDriver());
			break;

		default:
			System.out.println("Please provide a correct browser name..");
			break;
		}

		get_tlDriver().get(properties.getProperty("url"));
		get_tlDriver().manage().window().maximize();
		get_tlDriver().manage().deleteAllCookies();

		return get_tlDriver();
	}
	
	public WebDriver get_tlDriver() {
		return tl_driver.get();
	}
}
