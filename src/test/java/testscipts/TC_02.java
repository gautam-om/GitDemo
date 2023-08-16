package testscipts;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import Utils.Retry;

public class TC_02 extends BaseClass  {
	
	@Test(retryAnalyzer=Retry.class)
	public void LoginTestwithFail() throws Throwable {
		
		LoginPage lp = new LoginPage(driver);
		lp.usser(pu.getPropertyKeyValue("Username1"));
		logger.info("Entered the Username1");
		
		lp.upass(pu.getPropertyKeyValue("Password1"));
		logger.info("Entered the Password2");
		
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
