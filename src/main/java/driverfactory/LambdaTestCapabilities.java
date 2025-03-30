package driverfactory;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;

public class LambdaTestCapabilities {

	public static ChromeOptions setCapabilities() {
    	ChromeOptions browserOptions = new ChromeOptions();
    	browserOptions.setPlatformName("Windows 11");
    	browserOptions.setBrowserVersion("134.0");
    	HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    	ltOptions.put("username", "debasmitaA20");
    	ltOptions.put("accessKey", "LT_ggb3LsHgzwwgbCsdEU0BMZf079EhJcWasJAWgumuCZddXVP");
    	ltOptions.put("video", true);
    	ltOptions.put("build", "RegressionTests-run-01");
    	ltOptions.put("project", "CURA-APP-TESTS");
    	ltOptions.put("name", "Regression run 01");
    	ltOptions.put("w3c", true);
    	ltOptions.put("plugin", "java-testNG");
    	browserOptions.setCapability("LT:Options", ltOptions);
    	return browserOptions;
	}
	
}
