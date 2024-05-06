package driverfactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

	// private WebDriver driver;
	private static ThreadLocal<WebDriver> tl_driver = new ThreadLocal<>();
	private BrowserOptionsManager browserOptions;
	private Properties prop;

	public WebDriver initDriver(Properties prop) {

		this.prop = prop;
		String browsername = prop.getProperty("browser");
		System.out.println("Launching browser... " + browsername);
		
		browserOptions = new BrowserOptionsManager(prop);

		switch (browsername.toLowerCase()) {
		case "chrome":
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("chrome");
			} else {
				// driver = new ChromeDriver();
				tl_driver.set(new ChromeDriver(browserOptions.setChromeOptions()));
			}
			break;
		case "edge":
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("edge");
			} else {
				// driver = new EdgeDriver();
				tl_driver.set(new EdgeDriver(browserOptions.setEdgeOptions()));
			}
			break;

		default:
			System.out.println("Please provide a correct browser name..");
			break;
		}

		get_tlDriver().get(prop.getProperty("url"));
		get_tlDriver().manage().window().maximize();
		get_tlDriver().manage().deleteAllCookies();

		return get_tlDriver();
	}

	public WebDriver get_tlDriver() {
		return tl_driver.get();
	}

	private void init_remoteDriver(String browser) {
		System.out.println("Running tests on grid server :: " + browser);
		try {
			switch (browser) {
			case "chrome":
				tl_driver.set(
						new RemoteWebDriver(new URL(prop.getProperty("huburl")), browserOptions.setChromeOptions()));
				break;
			case "edge":
				tl_driver
						.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), browserOptions.setEdgeOptions()));
				break;
			default:
				System.out.println("Please provide a correct browser name..");
				break;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}
}
