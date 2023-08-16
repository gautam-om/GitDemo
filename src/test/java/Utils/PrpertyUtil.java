package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PrpertyUtil {

	Properties ps;
	public String getPropertyKeyValue(String Key) throws Throwable {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\chand_000\\eclipse-workspace\\Demo_Framework\\Data\\CommonData.properties");
		ps= new Properties();
		ps.load(fis);
		return ps.getProperty(Key);
	}
}
