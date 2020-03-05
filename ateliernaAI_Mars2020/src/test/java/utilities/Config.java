package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	public static  String GetParam(String ObjectName) throws IOException {
	Properties obj = new Properties();
	FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\Config.properties");
	obj.load(objfile);
	String b = obj.getProperty(ObjectName);
	return b;
	
	}
}
