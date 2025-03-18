package driverfactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverFactory implements IDriver{

    @Override
    public WebDriver getDriver(DriverData driverData) {
        WebDriver driver = null;
        try{
            ChromeOptions options = new ChromeOptions();
            options. setCapability("browserName", "chrome");
            EdgeOptions options2 = new EdgeOptions();
            options2. setCapability("browserName", "edge");
    
            if(driverData.getBrowser().equals("chrome")){
                driver = new RemoteWebDriver(new URI(driverData.getHubUrl()).toURL(), options);
            }else{
                driver = new RemoteWebDriver(new URI(driverData.getHubUrl()).toURL(), options2);
            }
        }catch(URISyntaxException e){
            e.printStackTrace();
        }catch(MalformedURLException e){
            e.printStackTrace();
        }
        return driver;
    }

}
