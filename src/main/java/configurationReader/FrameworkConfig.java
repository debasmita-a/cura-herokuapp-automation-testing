package configurationReader;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ "file:${user.dir}/src/test/resources/config/config.properties"})
public interface FrameworkConfig extends Config {

	String browser();

	String url();

	String isRemote();

	String hubUrl();

	String isHeadless();

	String isIncognito();

}
