package utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JSONFileReader {
	
	private JSONFileReader() {}
	
	private static Map<String, Object> CONFIG_MAP ;
	
	public Object[] getData() throws StreamReadException, DatabindException, IOException {
		HashMap<String, Object> map = new ObjectMapper().readValue(new File("./src/test/resources/config/userConfig.json"), new TypeReference<HashMap<String, Object>>() {});
		return new Object[] {map};
	}
	
	static {
		try {
			CONFIG_MAP = new ObjectMapper().readValue(new File("./src/test/resources/config/userConfig.json"),  new TypeReference<HashMap<String, Object>>() {});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getDataWithMap(String key){
		return String.valueOf(CONFIG_MAP.get(key));
	}
	
}
