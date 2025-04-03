package driverfactory;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import static configurationReader.ConfigFactory.*;

/**
 * <p>
 * Driver class is responsible for initializing WebDriver instance and
 * closing the browser.<p>
 *
 * Mar 31, 2025
 * @author Debasmita A
 * 
 * @see DriverManager
 * @see basetest.BaseTest
 * 
 */
public final class Driver {
	
	/**
	 * Private constructor to avoid external instantiation.
	 */
	private Driver() {}

	/**
	 * 
	 * @author Debasmita A
	 * Mar 31, 2025
	 * 
	 * @param browser value will be passed from BaseTest. Values could be Chrome or Edge.
	 */
    public static void initDriver() {
        if (Objects.isNull(DriverManager.getDriver())) {
            DriverData driverData = new DriverData(getConfig().browser(), getConfig().hubUrl());
            WebDriver driver = DriverFactory.getDriver().getDriver(driverData);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().get(getConfig().url());
            DriverManager.getDriver().manage().window().maximize();
        }

    }

    public static void teardown(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
