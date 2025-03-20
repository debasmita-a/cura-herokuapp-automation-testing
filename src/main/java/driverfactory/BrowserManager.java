package driverfactory;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public interface BrowserManager {

    public WebDriver getDriver();
    public Capabilities setCapabilities();

}
