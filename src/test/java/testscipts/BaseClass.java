package testscipts;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utils.PrpertyUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
//	public String urls= "https://demo.guru99.com/v4/";//config.getApplicationURL(); 
//	public String usernames= "mngr521222";//config.getUserName(); //"mngr521222";
//	public String passwords= "qYpavUd";//config.getPassWord(); //"qYpavUd";
	public static WebDriver driver;
	public static Logger logger;
	PrpertyUtil pu = new PrpertyUtil();
	
	@Parameters("Browser")
	@BeforeClass
	public void setup(String br) throws Throwable {
	
		logger=Logger.getLogger("SampleProject");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get(pu.getPropertyKeyValue("url"));
     	logger.info("URL is Open");
		
		}else if(br.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get(pu.getPropertyKeyValue("url"));
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}
	
	public String getScreenshort(String testCaseName, WebDriver driver) throws Throwable {
		
		 TakesScreenshot ts=(TakesScreenshot)driver; // type casting
		  File src=ts.getScreenshotAs(OutputType.FILE);
		  File dest=new File(System.getProperty("user.dir") + "//screenshort//" +testCaseName +".png");
		  FileUtils.copyFile(src, dest);
		  return System.getProperty("user.dir") + "//screenshort//" +testCaseName +".png";
		
	}

}
