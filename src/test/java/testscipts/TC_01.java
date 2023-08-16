package testscipts;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;


public class TC_01 extends BaseClass {
	
	@Test
	public void LoginTest() throws Throwable {
		
//		driver.get(pu.getPropertyKeyValue(null));
		
		LoginPage lp = new LoginPage(driver);
		lp.usser(pu.getPropertyKeyValue("Username"));
		logger.info("Entered the Username");
		
		lp.upass(pu.getPropertyKeyValue("Password"));
		logger.info("Entered the Password");
		
		lp.Ulogin();
		logger.info("Clicked on login button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Login Test Failedss");
		}
		
	}

}
