package GenricLib;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;


public class JsonDataUtility {
	
	public String readDataFromJSON(String key) throws Throwable
	{
		FileReader inputFile= new FileReader("./Data/common.properties");
		
		//parse the json object into java
		JSONParser parser=new JSONParser();
		Object object = parser.parse(inputFile); 
		
		HashMap jobject=(HashMap)object;
		String value = jobject.get(key).toString();
		return value;
	}

}
