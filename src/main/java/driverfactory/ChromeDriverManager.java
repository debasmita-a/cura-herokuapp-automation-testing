package driverfactory;

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
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", "Chrome");
        return options;
    }

}
