package driverfactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverFactory implements IDriver{

    @Override
    public WebDriver getDriver(DriverData driverData) {
        WebDriver driver = null;
        try{           
            if(driverData.getBrowser().equals("chrome")){
                driver = new RemoteWebDriver(new URI(driverData.getHubUrl()).toURL(), new ChromeDriverManager().setCapabilities());
            }else{
                driver = new RemoteWebDriver(new URI(driverData.getHubUrl()).toURL(), new EdgeDriverManager().setCapabilities());
            }
        }catch(URISyntaxException e){
            e.printStackTrace();
        }catch(MalformedURLException e){
            e.printStackTrace();
        }
        return driver;
    }

}
