package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readPropFile {
	public static  String GetObject(String ObjectName) throws IOException {
	Properties obj = new Properties();
	FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\application.properties");
	obj.load(objfile);
	String b = obj.getProperty(ObjectName);
	return b;
	
	}
}
