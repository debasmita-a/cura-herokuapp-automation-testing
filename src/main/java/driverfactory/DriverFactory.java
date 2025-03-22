package driverfactory;
import configurationReader.ConfigFactory;

public class DriverFactory {

    public static IDriver getDriver(){
        if(ConfigFactory.getConfig().isRemote().equals("false")){
            return new LocalDriverFactory();
        }else{
            return new RemoteDriverFactory();
        }
    }
}
