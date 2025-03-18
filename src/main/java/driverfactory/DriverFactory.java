package driverfactory;
import configurationReader.ConfigFactory;

public class DriverFactory {

    public static IDriver getDriver(){
        if(!Boolean.parseBoolean(ConfigFactory.getConfig().isRemote())){
            return new LocalDriverFactory();
        }else{
            return new RemoteDriverFactory();
        }
    }
}
