package UtilityFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadfromProperties {
public static String readproperty(String key) throws IOException {
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Amazondata.properties");
	prop.load(fis);
	String dta = prop.getProperty(key);
	return dta;
	
}
}
