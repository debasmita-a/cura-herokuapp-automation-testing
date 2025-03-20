package driverfactory;

import org.openqa.selenium.WebDriver;

public class LocalDriverFactory implements IDriver{

    @Override
    public WebDriver getDriver(DriverData driverData) {
        if(driverData.getBrowser().equals("chrome")){
            return new ChromeDriverManager().getDriver();
        }else {
            return new EdgeDriverManager().getDriver();
        }
    }

}
