package driverfactory;

import org.openqa.selenium.WebDriver;

public interface IDriver {

    public WebDriver getDriver(DriverData driverData);

}
