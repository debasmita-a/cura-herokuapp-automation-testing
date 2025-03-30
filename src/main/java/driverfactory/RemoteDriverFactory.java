package driverfactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import configurationReader.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverFactory implements IDriver {

	@Override
	public WebDriver getDriver(DriverData driverData) {
		WebDriver driver = null;
		String lt_url = "https://" + ConfigFactory.getLTConfig().LT_username()+ ":" + ConfigFactory.getLTConfig().accesskey() + ConfigFactory.getLTConfig().lambdaTestUrl();
		try {
			if (driverData.getBrowser().equals("chrome")) {
				driver = new RemoteWebDriver(new URI(lt_url).toURL(),
						new ChromeDriverManager().setCapabilities());
			} else {							
				driver = new RemoteWebDriver(new URI(lt_url).toURL(),
						new EdgeDriverManager().setCapabilities());
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

}
