package GenricLib;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility {
	
	Properties ps;
	
	public String getPropertyKeyValue(String Key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("");
		ps = new Properties();
		ps.load(fis);
		return ps.getProperty(Key);	
		
	}	

}
