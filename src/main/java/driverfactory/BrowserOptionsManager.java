package driverfactory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserOptionsManager {

	private ChromeOptions co;
	private EdgeOptions eo;
	private Properties properties;
	
	public BrowserOptionsManager(Properties prop) {
		this.properties = prop;
	}
	
	public ChromeOptions setChromeOptions() {
		co = new ChromeOptions();
		
		
		if(Boolean.parseBoolean(properties.getProperty("remote")))
			co.setCapability("browsername", "chrome");
		
		return co;
	}
	
	public EdgeOptions setEdgeOptions() {
		eo = new EdgeOptions();
		
		
		if(Boolean.parseBoolean(properties.getProperty("remote")))
			eo.setCapability("browsername", "edge");
		
		return eo;
	}
}
