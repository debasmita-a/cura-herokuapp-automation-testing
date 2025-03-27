package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import frameworkConstants.FrameworkConstants;

public final class PropertyUtil {

	private PropertyUtil() {
	}

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIG_MAP = new HashMap<>();

	static {
		try {
			FileInputStream configFile = new FileInputStream(FrameworkConstants.CONFIF_FILE_PATH);
			property.load(configFile);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIG_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) throws Exception {
		if (Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key))) {
			throw new Exception("Property name " + key + " could not be found. Please check again.");
		}
		System.out.println(CONFIG_MAP); 
		return CONFIG_MAP.get(key);

	}
}
