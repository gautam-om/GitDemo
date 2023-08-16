package GenricLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleGettiltepage {
	
	@Test
	public void titlePage() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/v4/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("uid")).sendKeys("mngr521222");
		driver.findElement(By.name("password")).sendKeys("qYpavUd");
		driver.findElement(By.name("btnLogin")).click();
		System.out.println(driver.getTitle());
		
	}

}
