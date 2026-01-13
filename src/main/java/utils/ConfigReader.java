package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;
	// Static block ensures properties are loaded once when the class is first used

	static {
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties file.");
		}
	}

	// Method to fetch property by key
	public static String getProperty(String key) {
		{
			String value = properties.getProperty(key);
			if (value == null) {
				throw new RuntimeException("Property '" + key + "' not found in config.properties file.");
			}
			return value;
		}
	}
}