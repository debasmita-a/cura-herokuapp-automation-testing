package configurationReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationPropReader {

	private Properties properties;
	
	public Properties initProperties() {
		properties = new Properties();
		try {
			FileInputStream input = new FileInputStream("./src/test/resources/config/config.properties");
			properties.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}
}
