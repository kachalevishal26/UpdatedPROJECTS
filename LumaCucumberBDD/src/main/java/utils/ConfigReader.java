package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

	public Properties initProp() {
		prop = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream(
					"C:\\Users\\Asus\\eclipse-workspace\\LumaCucumberBDD\\src\\test\\resources\\config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
