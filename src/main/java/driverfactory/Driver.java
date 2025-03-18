package driverfactory;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import static configurationReader.ConfigFactory.*;

public class Driver {

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
