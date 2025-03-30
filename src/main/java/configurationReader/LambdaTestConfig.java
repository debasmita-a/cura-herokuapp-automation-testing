package configurationReader;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ "file:${user.dir}/src/test/resources/config/lambdaTestConfig.properties"})
public interface LambdaTestConfig extends Config {

	String LT_username();

	String accesskey();

	String lambdaTestUrl();

}
