package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class ConfigReader {

	Properties prop;

	public Properties read_prop() throws IOException {
		prop = new Properties();

		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\test\\resources"+"\\config.properties");

		prop.load(fs);
		
		return prop;
		
	}

}
