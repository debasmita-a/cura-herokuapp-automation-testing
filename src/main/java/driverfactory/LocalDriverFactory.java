package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LocalDriverFactory implements IDriver{

    @Override
    public WebDriver getDriver(DriverData driverData) {
        if(driverData.getBrowser().equals("chrome")){
            return new ChromeDriver();
        }else {
            return new EdgeDriver();
        }
    }

}
