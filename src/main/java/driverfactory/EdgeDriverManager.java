package driverfactory;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager implements BrowserManager{

    @Override
    public WebDriver getDriver() {
        return new EdgeDriver();
    }

    @Override
    public Capabilities setCapabilities() {
        EdgeOptions options = new EdgeOptions();
        options.setCapability("browserName", "Edge");
        return options;
    }

}
