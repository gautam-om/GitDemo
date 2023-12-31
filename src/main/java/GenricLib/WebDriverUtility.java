package GenricLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	/**
	  * This method will wait for 20 sec for page loading
	  * @param driver
	  */
	 public void waitUntilPageLoad(WebDriver driver)
	 {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }	
	 
	 /**
	  * This method will maximize page
	  * @param driver
	  */
	 public void pageMaximize(WebDriver driver)
	 {
		 driver.manage().window().maximize();
	 }
	 
	 /**
	  * This method wait for the element to be visible
	  * @param driver
	  * @param element
	  */
	 public void waitForElementVisibility(WebDriver driver, WebElement element)
	 {
	  WebDriverWait wait=new WebDriverWait(driver,10);
	  wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 
	 /**
	  * This method will wait for given time and click
	  * @param element
	  * @throws InterruptedException
	  */
	 public void waitAndClick(WebElement element) throws InterruptedException
	 {
	  int count=0;
	  while(count<50)
	  {
	   try {
	    element.click();
	    break;
	   }
	   catch(Throwable e)
	   {
	    Thread.sleep(5000);
	    count++;
	   }
	  }
	 }
	 
	 /**
	  * This method will select on the basis of Visible text
	  * @param element
	  * @param option
	  */
	 public void selectOption(WebElement element, String option)
	 {
	  Select sel=new Select(element);
	  sel.selectByVisibleText(option);
	 }
	 
	 /**
	  * This method enable user to handle dropdown using index
	  * @param element
	  * @param index
	  */
	 public void selectOption(WebElement element, int index)
	 {
	  Select sel=new Select(element);
	  sel.selectByIndex(index);
	 }
	 /**
	  * 
	  * @param element
	  * @param value
	  */
	 public void selectOtion(WebElement element,String value)
	 {
		 Select sel=new Select(element);
		 sel.selectByValue(value);
	 }
	 
	 /**
	  * This method will perform mouse over action
	  * @param driver
	  * @param element
	  */
	 public void mouseOver(WebDriver driver, WebElement element)
	 {
	  Actions act=new Actions(driver);
	  act.moveToElement(element).perform();
	 }
	 
	 /**  
	  * This method perform right click
	  * @param driver
	  * @param element
	  */
	 public void rightClick(WebDriver driver, WebElement element)
	 {
	  Actions act=new Actions(driver);
	  act.moveToElement(element).perform();
	 }
	 
	 /**
	  * This method will switch the window
	  * @param driver
	  * @param partialWinTitle
	  */
	 public void switchToWindow(WebDriver driver, String partialWinTitle )
	 {
	  Set<String> window=driver.getWindowHandles();
	  Iterator<String> it=window.iterator();
	  while(it.hasNext())
	  {
	   String winId=it.next();
	   String title=driver.switchTo().window(winId).getTitle();
	   if(title.contains(partialWinTitle))
	   {
	    break;
	   }
	  }
	 }
	 /**
	  * 
	  * @param driver
	  */
	 
	 public void switchToWindow(WebDriver driver)
	 {
		 Set<String> window=driver.getWindowHandles();
		  Iterator<String> it=window.iterator();
		  String parent=it.next();
		  String chparent=it.next();
		  driver.switchTo().window(chparent);
		 
	 }
	 
	 /**
	  * This method will accept the popup
	  * @param driver
	  */
	 public void acceptAlert(WebDriver driver)
	 {
	  driver.switchTo().alert().accept();
	 }
	 
	 /**
	  * This method will cancel the popup
	  * @param driver
	  */
	 public void cancelAlert(WebDriver driver)
	 {
	  driver.switchTo().alert().dismiss();
	 }
	 
	 /**
	  * This method used for scrolling action
	  * @param driver
	  * @param element
	  */
	 public void scrollToWebElement(WebDriver driver, WebElement element)
	 {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  int y=element.getLocation().getY();
	  js.executeScript("window.scrollBy(0,"+y+")", element);
	 }
	 
	 public void switchToFrame(WebDriver driver, int index)
	 {
	  driver.switchTo().frame(index);
	 }
	 
	 public void switchToFrame(WebDriver driver, WebElement element)
	 {
	  driver.switchTo().frame(element);
	 }

	 public void pressEnterKey(KeyEvent key) throws AWTException
	 {
	  Robot r=new Robot();
	  r.keyPress(KeyEvent.VK_ENTER);
	  r.keyRelease(KeyEvent.VK_ENTER);
	 }
	 
	 public void takeScreenshot(WebDriver driver, String screenshotName) throws IOException
	 {
	  TakesScreenshot ts=(TakesScreenshot)driver; // type casting
	  File src=ts.getScreenshotAs(OutputType.FILE);
	  File dest=new File("./screenshot/"+screenshotName+".PNG");
	  Files.copy(src, dest);
	  
	 }

	}

